package com.carestacks.careconnect.agenda.application.agenda.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReminderDto(
        UUID id,
        UUID healthEventId,
        LocalDateTime scheduledAt,
        boolean delivered,
        LocalDateTime deliveredAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
