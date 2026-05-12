package com.carestacks.careconnect.notifications.domain.notifications.entities;

import com.carestacks.careconnect.notifications.domain.notifications.enums.DeliveryChannel;
import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationPriority;
import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationStatus;
import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationType;
import com.carestacks.careconnect.shared.domain.entities.AuditableEntity;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;

import java.time.LocalDateTime;
import java.util.UUID;

public class Notification extends AuditableEntity {

    private final UUID recipientId;
    private final UUID healthEventId;
    private final String title;
    private final String message;
    private final NotificationType type;
    private final NotificationPriority priority;
    private final DeliveryChannel deliveryChannel;
    private final LocalDateTime scheduledAt;
    private NotificationStatus status;
    private LocalDateTime sentAt;
    private LocalDateTime readAt;

    public Notification(
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
        super(id, createdAt, updatedAt);
        this.recipientId = requireId(recipientId, "recipientId");
        this.healthEventId = healthEventId;
        this.title = requireText(title, "title");
        this.message = requireText(message, "message");
        this.type = requireValue(type, "type");
        this.priority = requireValue(priority, "priority");
        this.status = requireValue(status, "status");
        this.deliveryChannel = requireValue(deliveryChannel, "deliveryChannel");
        this.scheduledAt = requireValue(scheduledAt, "scheduledAt");
        this.sentAt = sentAt;
        this.readAt = readAt;
    }

    public static Notification schedule(
            UUID recipientId,
            UUID healthEventId,
            String title,
            String message,
            NotificationType type,
            NotificationPriority priority,
            DeliveryChannel deliveryChannel,
            LocalDateTime scheduledAt
    ) {
        return new Notification(
                null,
                recipientId,
                healthEventId,
                title,
                message,
                type,
                priority,
                NotificationStatus.SCHEDULED,
                deliveryChannel,
                scheduledAt,
                null,
                null,
                null,
                null
        );
    }

    public void markAsSent() {
        ensureNotTerminal("send");
        this.status = NotificationStatus.SENT;
        this.sentAt = LocalDateTime.now();
        touch();
    }

    public void markAsRead() {
        if (status == NotificationStatus.READ) {
            return;
        }
        ensureNotTerminal("read");
        this.status = NotificationStatus.READ;
        this.readAt = LocalDateTime.now();
        touch();
    }

    public void cancel() {
        if (status == NotificationStatus.READ) {
            throw new BusinessRuleException("Read notifications cannot be cancelled");
        }
        this.status = NotificationStatus.CANCELLED;
        touch();
    }

    public void markAsFailed() {
        if (status == NotificationStatus.READ) {
            throw new BusinessRuleException("Read notifications cannot be marked as failed");
        }
        this.status = NotificationStatus.FAILED;
        touch();
    }

    private void ensureNotTerminal(String action) {
        if (status == NotificationStatus.CANCELLED || status == NotificationStatus.FAILED) {
            throw new BusinessRuleException("Cannot " + action + " a " + status.name().toLowerCase() + " notification");
        }
    }

    private static UUID requireId(UUID value, String fieldName) {
        if (value == null) {
            throw new BusinessRuleException(fieldName + " is required");
        }
        return value;
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new BusinessRuleException(fieldName + " is required");
        }
        return value.trim();
    }

    private static <T> T requireValue(T value, String fieldName) {
        if (value == null) {
            throw new BusinessRuleException(fieldName + " is required");
        }
        return value;
    }

    public UUID getRecipientId() {
        return recipientId;
    }

    public UUID getHealthEventId() {
        return healthEventId;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public NotificationType getType() {
        return type;
    }

    public NotificationPriority getPriority() {
        return priority;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public DeliveryChannel getDeliveryChannel() {
        return deliveryChannel;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public LocalDateTime getReadAt() {
        return readAt;
    }
}
