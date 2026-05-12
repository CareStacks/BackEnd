package com.carestacks.careconnect.notifications.domain.notifications.entities;

import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationPriority;
import com.carestacks.careconnect.shared.domain.entities.AuditableEntity;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationPreference extends AuditableEntity {

    private final UUID recipientId;
    private boolean pushEnabled;
    private boolean emailEnabled;
    private boolean inAppEnabled;
    private NotificationPriority minimumPriority;

    public NotificationPreference(
            UUID id,
            UUID recipientId,
            boolean pushEnabled,
            boolean emailEnabled,
            boolean inAppEnabled,
            NotificationPriority minimumPriority,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        super(id, createdAt, updatedAt);
        if (recipientId == null) {
            throw new BusinessRuleException("recipientId is required");
        }
        this.recipientId = recipientId;
        this.pushEnabled = pushEnabled;
        this.emailEnabled = emailEnabled;
        this.inAppEnabled = inAppEnabled;
        this.minimumPriority = minimumPriority == null ? NotificationPriority.LOW : minimumPriority;
    }

    public static NotificationPreference defaultFor(UUID recipientId) {
        return new NotificationPreference(null, recipientId, true, true, true, NotificationPriority.LOW, null, null);
    }

    public void update(boolean pushEnabled, boolean emailEnabled, boolean inAppEnabled, NotificationPriority minimumPriority) {
        if (!pushEnabled && !emailEnabled && !inAppEnabled) {
            throw new BusinessRuleException("At least one notification channel must be enabled");
        }
        this.pushEnabled = pushEnabled;
        this.emailEnabled = emailEnabled;
        this.inAppEnabled = inAppEnabled;
        this.minimumPriority = minimumPriority == null ? NotificationPriority.LOW : minimumPriority;
        touch();
    }

    public UUID getRecipientId() {
        return recipientId;
    }

    public boolean isPushEnabled() {
        return pushEnabled;
    }

    public boolean isEmailEnabled() {
        return emailEnabled;
    }

    public boolean isInAppEnabled() {
        return inAppEnabled;
    }

    public NotificationPriority getMinimumPriority() {
        return minimumPriority;
    }
}
