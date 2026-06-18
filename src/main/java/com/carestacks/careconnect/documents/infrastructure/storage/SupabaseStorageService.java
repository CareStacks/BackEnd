package com.carestacks.careconnect.documents.infrastructure.storage;

import com.carestacks.careconnect.documents.domain.documents.entities.DocumentItem;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SupabaseStorageService {

    private final SupabaseStorageProperties properties;
    private final HttpClient httpClient;

    public SupabaseStorageService(SupabaseStorageProperties properties) {
        this.properties = properties;
        this.httpClient = HttpClient.newHttpClient();
    }

    public StoredDocument uploadPatientDocument(
            UUID patientId,
            MultipartFile file,
            LocalDateTime uploadedAt
    ) {
        if (!properties.isConfigured()) {
            throw new BusinessRuleException("No se pudo conectar con el almacenamiento.");
        }

        if (file == null || file.isEmpty()) {
            throw new BusinessRuleException("Selecciona un archivo antes de continuar.");
        }

        if (file.getSize() > DocumentItem.MAX_FILE_SIZE_BYTES) {
            throw new BusinessRuleException("El archivo supera el tamaño permitido.");
        }

        var bucket = properties.bucketName();
        var storagePath = buildStoragePath(patientId, file.getOriginalFilename(), uploadedAt);
        var endpoint = URI.create(
                properties.normalizedUrl() + "/storage/v1/object/" + bucket + "/" + encodePath(storagePath)
        );

        try {
            var request = HttpRequest.newBuilder(endpoint)
                    .header("Authorization", "Bearer " + properties.serviceRoleKey())
                    .header("apikey", properties.serviceRoleKey())
                    .header("Content-Type", file.getContentType() == null ? "application/octet-stream" : file.getContentType())
                    .header("x-upsert", "false")
                    .PUT(HttpRequest.BodyPublishers.ofByteArray(file.getBytes()))
                    .build();

            var response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());
            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                return new StoredDocument(
                        bucket,
                        storagePath,
                        "supabase://" + bucket + "/" + storagePath
                );
            }

            if (response.statusCode() == 413) {
                throw new BusinessRuleException("El archivo supera el tamaño permitido.");
            }

            throw new BusinessRuleException("No se pudo subir el documento. Inténtalo nuevamente.");
        } catch (IOException exception) {
            throw new BusinessRuleException("No se pudo conectar con el almacenamiento.");
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new BusinessRuleException("No se pudo subir el documento. Inténtalo nuevamente.");
        }
    }

    private static String buildStoragePath(UUID patientId, String originalFileName, LocalDateTime uploadedAt) {
        var safeName = sanitizeFileName(originalFileName);
        var dateFolder = (uploadedAt == null ? LocalDateTime.now() : uploadedAt)
                .format(DateTimeFormatter.ofPattern("yyyy/MM"));

        return "patients/" + patientId + "/" + dateFolder + "/" + UUID.randomUUID() + "-" + safeName;
    }

    private static String sanitizeFileName(String originalFileName) {
        var fallback = "documento-medico";
        var value = originalFileName == null || originalFileName.isBlank() ? fallback : originalFileName.trim();
        var sanitized = value.replaceAll("[^A-Za-z0-9._-]", "-")
                .replaceAll("-+", "-");

        return sanitized.isBlank() ? fallback : sanitized;
    }

    private static String encodePath(String path) {
        return Stream.of(path.split("/"))
                .map(segment -> URLEncoder.encode(segment, StandardCharsets.UTF_8).replace("+", "%20"))
                .collect(Collectors.joining("/"));
    }
}
