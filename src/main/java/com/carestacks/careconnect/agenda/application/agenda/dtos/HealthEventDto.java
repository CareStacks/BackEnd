package com.carestacks.careconnect.agenda.application.agenda.dtos;

import com.carestacks.careconnect.agenda.domain.agenda.enums.EventStatus;
import com.carestacks.careconnect.agenda.domain.agenda.enums.EventType;

import java.time.LocalDateTime;
import java.util.UUID;

public record HealthEventDto(
        UUID id,
        UUID patientId,
        UUID caregiverId,
        String title,
        String description,
        EventType type,
        EventStatus status,
        LocalDateTime startAt,
        LocalDateTime endAt,
        LocalDateTime reminderAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
