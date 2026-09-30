package com.carestacks.careconnect;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CoreApiIntegrationTests {

    private static final ObjectMapper JSON = new ObjectMapper();
    private final HttpClient client = HttpClient.newHttpClient();

    @Value("${local.server.port}")
    private int port;

    @Test
    void agendaPersistsCreationConfirmationAndRescheduling() throws Exception {
        var patientId = UUID.randomUUID();
        var start = LocalDateTime.now().plusDays(10).withNano(0);
        var end = start.plusHours(1);
        var body = """
                {"patientId":"%s","title":"Control médico","type":"APPOINTMENT",
                 "startAt":"%s","endAt":"%s"}
                """.formatted(patientId, start, end);

        var created = request("POST", "/api/agenda", body, null);
        assertEquals(201, created.statusCode(), created.body());
        var eventId = UUID.fromString(json(created).get("id").asText());
        assertEquals("PENDING", json(created).get("status").asText());

        var fetched = request("GET", "/api/agenda/" + eventId, null, null);
        assertEquals(200, fetched.statusCode(), fetched.body());
        assertEquals(patientId.toString(), json(fetched).get("patientId").asText());

        var confirmed = request("PATCH", "/api/agenda/" + eventId + "/confirm", null, null);
        assertEquals(200, confirmed.statusCode(), confirmed.body());
        assertEquals("CONFIRMED", json(confirmed).get("status").asText());

        var newStart = start.plusDays(1);
        var newEnd = end.plusDays(1);
        var rescheduleBody = """
                {"startAt":"%s","endAt":"%s"}
                """.formatted(newStart, newEnd);
        var rescheduled = request("PATCH", "/api/agenda/" + eventId + "/reschedule", rescheduleBody, null);
        assertEquals(200, rescheduled.statusCode(), rescheduled.body());
        assertEquals("PENDING", json(rescheduled).get("status").asText());
        assertEquals(newStart.toString(), json(rescheduled).get("startAt").asText());

        var persisted = request("GET", "/api/agenda/" + eventId, null, null);
        assertEquals(200, persisted.statusCode(), persisted.body());
        assertEquals(newStart.toString(), json(persisted).get("startAt").asText());
    }

    @Test
    void diaryPersistsEntryAndReturnsItForPatient() throws Exception {
        var patientId = UUID.randomUUID();
        var body = """
                {"patientId":"%s","content":"  Dormí bien  "}
                """.formatted(patientId);

        var created = request("POST", "/api/diary", body, null);
        assertEquals(201, created.statusCode(), created.body());
        var entryId = json(created).get("id").asLong();

        var fetched = request("GET", "/api/diary/" + entryId, null, null);
        assertEquals(200, fetched.statusCode(), fetched.body());
        assertEquals(patientId.toString(), json(fetched).get("patientId").asText());
        assertEquals("Dormí bien", json(fetched).get("content").asText());

        var patientEntries = request("GET", "/api/diary/patient/" + patientId, null, null);
        assertEquals(200, patientEntries.statusCode(), patientEntries.body());
        assertEquals(entryId, json(patientEntries).get(0).get("id").asLong());
    }

    @Test
    void consentRestrictsViewsAndRevocationRemovesAccess() throws Exception {
        var patient = registerUser("PATIENT");
        var caregiver = registerUser("CAREGIVER");
        var patientToken = login(patient.email());
        var caregiverToken = login(caregiver.email());

        var grantBody = """
                {"caregiverId":"%s","allowedViews":["AGENDA"]}
                """.formatted(caregiver.id());
        var granted = request("POST", "/api/consents", grantBody, patientToken);
        assertEquals(201, granted.statusCode(), granted.body());
        var consentId = UUID.fromString(json(granted).get("id").asText());

        var accessPath = "/api/consents/me/caregiver/access?patientId=" + patient.id() + "&view=";
        var agendaAccess = request("GET", accessPath + "AGENDA", null, caregiverToken);
        assertEquals(200, agendaAccess.statusCode(), agendaAccess.body());
        assertTrue(json(agendaAccess).get("allowed").asBoolean());

        var diaryAccess = request("GET", accessPath + "DIARY", null, caregiverToken);
        assertEquals(200, diaryAccess.statusCode(), diaryAccess.body());
        assertFalse(json(diaryAccess).get("allowed").asBoolean());

        var revoked = request("DELETE", "/api/consents/" + consentId, null, patientToken);
        assertEquals(204, revoked.statusCode(), revoked.body());

        var afterRevocation = request("GET", accessPath + "AGENDA", null, caregiverToken);
        assertEquals(404, afterRevocation.statusCode(), afterRevocation.body());
    }

    private TestUser registerUser(String role) throws Exception {
        var email = "test-" + UUID.randomUUID() + "@example.test";
        var body = """
                {"email":"%s","password":"TestPass123","fullName":"Usuario de prueba","role":"%s"}
                """.formatted(email, role);
        var response = request("POST", "/api/auth/register", body, null);
        assertEquals(201, response.statusCode(), response.body());
        return new TestUser(UUID.fromString(json(response).get("id").asText()), email);
    }

    private String login(String email) throws Exception {
        var body = """
                {"email":"%s","password":"TestPass123"}
                """.formatted(email);
        var response = request("POST", "/api/auth/login", body, null);
        assertEquals(200, response.statusCode(), response.body());
        return json(response).get("token").asText();
    }

    private HttpResponse<String> request(String method, String path, String body, String token) throws Exception {
        var builder = HttpRequest.newBuilder(URI.create("http://127.0.0.1:" + port + path));
        if (body != null) {
            builder.header("Content-Type", "application/json");
        }
        if (token != null) {
            builder.header("Authorization", "Bearer " + token);
        }
        builder.method(method, body == null ? HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofString(body));
        return client.send(builder.build(), HttpResponse.BodyHandlers.ofString());
    }

    private JsonNode json(HttpResponse<String> response) {
        return JSON.readTree(response.body());
    }

    private record TestUser(UUID id, String email) {}
}
