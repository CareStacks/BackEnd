package com.carestacks.careconnect.agenda.interfaces;

import com.carestacks.careconnect.agenda.application.abstractions.AgendaService;
import com.carestacks.careconnect.agenda.application.agenda.dtos.HealthEventDto;
import com.carestacks.careconnect.agenda.application.agenda.requests.CreateHealthEventRequest;
import com.carestacks.careconnect.agenda.application.agenda.requests.RescheduleHealthEventRequest;
import com.carestacks.careconnect.agenda.application.agenda.requests.UpdateHealthEventRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/agenda")
@Tag(name = "Agenda", description = "Health event scheduling, calendar, reminder, and status endpoints")
public class AgendaController {

    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @Operation(summary = "Create a health event", description = "Registers a patient health event and creates a reminder 24 hours before the event when possible.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Health event created",
                    content = @Content(schema = @Schema(implementation = HealthEventDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid event data or schedule conflict")
    })
    @PostMapping
    public ResponseEntity<HealthEventDto> create(@Valid @RequestBody CreateHealthEventRequest request) {
        var event = agendaService.create(request);
        return ResponseEntity.created(URI.create("/api/agenda/" + event.id())).body(event);
    }

    @Operation(summary = "List health events", description = "Returns every health event ordered by start date.")
    @ApiResponse(responseCode = "200", description = "Health events returned")
    @GetMapping
    public ResponseEntity<List<HealthEventDto>> getAll() {
        return ResponseEntity.ok(agendaService.getAll());
    }

    @Operation(summary = "List health events by patient", description = "Returns the calendar of health events owned by a patient.")
    @ApiResponse(responseCode = "200", description = "Patient health events returned")
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<HealthEventDto>> getByPatient(
            @Parameter(description = "Patient identifier") @PathVariable UUID patientId
    ) {
        return ResponseEntity.ok(agendaService.getByPatient(patientId));
    }

    @Operation(summary = "List patient events by date", description = "Returns health events scheduled for a patient on a specific calendar date.")
    @ApiResponse(responseCode = "200", description = "Patient health events for the date returned")
    @GetMapping("/date")
    public ResponseEntity<List<HealthEventDto>> getByPatientAndDate(
            @Parameter(description = "Patient identifier") @RequestParam UUID patientId,
            @Parameter(description = "Calendar date in ISO format") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return ResponseEntity.ok(agendaService.getByPatientAndDate(patientId, date));
    }

    @Operation(summary = "Get a health event", description = "Returns a health event and its associated reminder metadata.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Health event returned"),
            @ApiResponse(responseCode = "404", description = "Health event not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<HealthEventDto> getById(
            @Parameter(description = "Health event identifier") @PathVariable UUID id
    ) {
        return ResponseEntity.ok(agendaService.getById(id));
    }

    @Operation(summary = "Update a health event", description = "Updates title, description, type, and schedule while preserving conflict validation.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Health event updated"),
            @ApiResponse(responseCode = "400", description = "Invalid event data or schedule conflict"),
            @ApiResponse(responseCode = "404", description = "Health event not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<HealthEventDto> update(
            @Parameter(description = "Health event identifier") @PathVariable UUID id,
            @Valid @RequestBody UpdateHealthEventRequest request
    ) {
        return ResponseEntity.ok(agendaService.update(id, request));
    }

    @Operation(summary = "Confirm a health event", description = "Marks a pending health event as confirmed.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Health event confirmed"),
            @ApiResponse(responseCode = "400", description = "Event cannot be confirmed"),
            @ApiResponse(responseCode = "404", description = "Health event not found")
    })
    @PatchMapping("/{id}/confirm")
    public ResponseEntity<HealthEventDto> confirm(
            @Parameter(description = "Health event identifier") @PathVariable UUID id
    ) {
        return ResponseEntity.ok(agendaService.confirm(id));
    }

    @Operation(summary = "Reschedule a health event", description = "Changes the event schedule and recalculates its reminder.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Health event rescheduled"),
            @ApiResponse(responseCode = "400", description = "Invalid schedule or schedule conflict"),
            @ApiResponse(responseCode = "404", description = "Health event not found")
    })
    @PatchMapping("/{id}/reschedule")
    public ResponseEntity<HealthEventDto> reschedule(
            @Parameter(description = "Health event identifier") @PathVariable UUID id,
            @Valid @RequestBody RescheduleHealthEventRequest request
    ) {
        return ResponseEntity.ok(agendaService.reschedule(id, request));
    }

    @Operation(summary = "Cancel a health event", description = "Marks a health event as cancelled without deleting its history.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Health event cancelled"),
            @ApiResponse(responseCode = "404", description = "Health event not found")
    })
    @PatchMapping("/{id}/cancel")
    public ResponseEntity<HealthEventDto> cancel(
            @Parameter(description = "Health event identifier") @PathVariable UUID id
    ) {
        return ResponseEntity.ok(agendaService.cancel(id));
    }

    @Operation(summary = "Delete a health event", description = "Deletes a health event and its associated reminder.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Health event deleted"),
            @ApiResponse(responseCode = "404", description = "Health event not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "Health event identifier") @PathVariable UUID id
    ) {
        agendaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
