package com.carestacks.careconnect.notifications.application.notifications.dtos;

import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationPriority;

import java.time.LocalDateTime;
import java.util.UUID;

public record AlertDto(
        UUID id,
        UUID recipientId,
        UUID notificationId,
        UUID healthEventId,
        String title,
        String message,
        NotificationPriority priority,
        boolean resolved,
        LocalDateTime triggeredAt,
        LocalDateTime resolvedAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
