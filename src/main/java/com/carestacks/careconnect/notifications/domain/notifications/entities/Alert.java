package com.carestacks.careconnect.notifications.domain.notifications.entities;

import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationPriority;
import com.carestacks.careconnect.shared.domain.entities.AuditableEntity;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;

import java.time.LocalDateTime;
import java.util.UUID;

public class Alert extends AuditableEntity {

    private final UUID recipientId;
    private final UUID notificationId;
    private final UUID healthEventId;
    private final String title;
    private final String message;
    private final NotificationPriority priority;
    private final LocalDateTime triggeredAt;
    private boolean resolved;
    private LocalDateTime resolvedAt;

    public Alert(
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
        super(id, createdAt, updatedAt);
        this.recipientId = requireId(recipientId, "recipientId");
        this.notificationId = notificationId;
        this.healthEventId = healthEventId;
        this.title = requireText(title, "title");
        this.message = requireText(message, "message");
        this.priority = priority == null ? NotificationPriority.HIGH : priority;
        this.resolved = resolved;
        this.triggeredAt = triggeredAt == null ? LocalDateTime.now() : triggeredAt;
        this.resolvedAt = resolvedAt;
    }

    public static Alert trigger(UUID recipientId, UUID notificationId, UUID healthEventId, String title, String message, NotificationPriority priority) {
        return new Alert(null, recipientId, notificationId, healthEventId, title, message, priority, false, null, null, null, null);
    }

    public void resolve() {
        if (resolved) {
            return;
        }
        this.resolved = true;
        this.resolvedAt = LocalDateTime.now();
        touch();
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

    public UUID getRecipientId() {
        return recipientId;
    }

    public UUID getNotificationId() {
        return notificationId;
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

    public NotificationPriority getPriority() {
        return priority;
    }

    public boolean isResolved() {
        return resolved;
    }

    public LocalDateTime getTriggeredAt() {
        return triggeredAt;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }
}
