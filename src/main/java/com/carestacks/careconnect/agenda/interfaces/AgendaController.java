package com.carestacks.careconnect.agenda.interfaces;

import com.carestacks.careconnect.agenda.application.abstractions.AgendaService;
import com.carestacks.careconnect.agenda.application.agenda.dtos.HealthEventDto;
import com.carestacks.careconnect.agenda.application.agenda.requests.CreateHealthEventRequest;
import com.carestacks.careconnect.agenda.application.agenda.requests.RescheduleHealthEventRequest;
import com.carestacks.careconnect.agenda.application.agenda.requests.UpdateHealthEventRequest;
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
public class AgendaController {

    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping
    public ResponseEntity<HealthEventDto> create(@Valid @RequestBody CreateHealthEventRequest request) {
        var event = agendaService.create(request);
        return ResponseEntity.created(URI.create("/api/agenda/" + event.id())).body(event);
    }

    @GetMapping
    public ResponseEntity<List<HealthEventDto>> getAll() {
        return ResponseEntity.ok(agendaService.getAll());
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<HealthEventDto>> getByPatient(@PathVariable UUID patientId) {
        return ResponseEntity.ok(agendaService.getByPatient(patientId));
    }

    @GetMapping("/date")
    public ResponseEntity<List<HealthEventDto>> getByPatientAndDate(
            @RequestParam UUID patientId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return ResponseEntity.ok(agendaService.getByPatientAndDate(patientId, date));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthEventDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(agendaService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthEventDto> update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateHealthEventRequest request
    ) {
        return ResponseEntity.ok(agendaService.update(id, request));
    }

    @PatchMapping("/{id}/confirm")
    public ResponseEntity<HealthEventDto> confirm(@PathVariable UUID id) {
        return ResponseEntity.ok(agendaService.confirm(id));
    }

    @PatchMapping("/{id}/reschedule")
    public ResponseEntity<HealthEventDto> reschedule(
            @PathVariable UUID id,
            @Valid @RequestBody RescheduleHealthEventRequest request
    ) {
        return ResponseEntity.ok(agendaService.reschedule(id, request));
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<HealthEventDto> cancel(@PathVariable UUID id) {
        return ResponseEntity.ok(agendaService.cancel(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        agendaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
