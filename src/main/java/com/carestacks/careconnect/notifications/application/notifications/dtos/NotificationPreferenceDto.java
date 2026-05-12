package com.carestacks.careconnect.notifications.application.notifications.dtos;

import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationPriority;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotificationPreferenceDto(
        UUID id,
        UUID recipientId,
        boolean pushEnabled,
        boolean emailEnabled,
        boolean inAppEnabled,
        NotificationPriority minimumPriority,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
