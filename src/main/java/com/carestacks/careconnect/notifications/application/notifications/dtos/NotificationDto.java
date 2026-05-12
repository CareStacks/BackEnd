package com.carestacks.careconnect.notifications.application.notifications.dtos;

import com.carestacks.careconnect.notifications.domain.notifications.enums.DeliveryChannel;
import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationPriority;
import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationStatus;
import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationType;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotificationDto(
        UUID id,
        UUID recipientId,
        UUID healthEventId,
        String title,
        String message,
        NotificationType type,
        NotificationPriority priority,
        NotificationStatus status,
        DeliveryChannel deliveryChannel,
        LocalDateTime scheduledAt,
        LocalDateTime sentAt,
        LocalDateTime readAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
