package com.carestacks.careconnect.agenda.application.abstractions;

import com.carestacks.careconnect.agenda.application.agenda.dtos.HealthEventDto;
import com.carestacks.careconnect.agenda.application.agenda.requests.CreateHealthEventRequest;
import com.carestacks.careconnect.agenda.application.agenda.requests.RescheduleHealthEventRequest;
import com.carestacks.careconnect.agenda.application.agenda.requests.UpdateHealthEventRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AgendaService {

    HealthEventDto create(CreateHealthEventRequest request);

    HealthEventDto getById(UUID id);

    List<HealthEventDto> getAll();

    List<HealthEventDto> getByPatient(UUID patientId);

    List<HealthEventDto> getByPatientAndDate(UUID patientId, LocalDate date);

    HealthEventDto update(UUID id, UpdateHealthEventRequest request);

    HealthEventDto confirm(UUID id);

    HealthEventDto reschedule(UUID id, RescheduleHealthEventRequest request);

    HealthEventDto cancel(UUID id);

    void delete(UUID id);
}
