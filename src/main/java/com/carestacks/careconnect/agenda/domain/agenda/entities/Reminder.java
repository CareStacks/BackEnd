package com.carestacks.careconnect.agenda.domain.agenda.entities;

import com.carestacks.careconnect.shared.domain.entities.AuditableEntity;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reminder extends AuditableEntity {

    private final UUID healthEventId;
    private LocalDateTime scheduledAt;
    private boolean delivered;
    private LocalDateTime deliveredAt;

    public Reminder(
            UUID id,
            UUID healthEventId,
            LocalDateTime scheduledAt,
            boolean delivered,
            LocalDateTime deliveredAt,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        super(id, createdAt, updatedAt);
        if (healthEventId == null) {
            throw new BusinessRuleException("healthEventId is required");
        }
        this.healthEventId = healthEventId;
        this.scheduledAt = scheduledAt == null ? LocalDateTime.now() : scheduledAt;
        this.delivered = delivered;
        this.deliveredAt = deliveredAt;
    }

    public static Reminder schedule(UUID healthEventId, LocalDateTime eventStartAt) {
        var reminderAt = eventStartAt.minusHours(24);
        if (reminderAt.isBefore(LocalDateTime.now())) {
            reminderAt = LocalDateTime.now();
        }
        return new Reminder(null, healthEventId, reminderAt, false, null, null, null);
    }

    public void reschedule(LocalDateTime eventStartAt) {
        var reminderAt = eventStartAt.minusHours(24);
        this.scheduledAt = reminderAt.isBefore(LocalDateTime.now()) ? LocalDateTime.now() : reminderAt;
        this.delivered = false;
        this.deliveredAt = null;
        touch();
    }

    public void markAsDelivered() {
        if (delivered) {
            return;
        }
        this.delivered = true;
        this.deliveredAt = LocalDateTime.now();
        touch();
    }

    public UUID getHealthEventId() {
        return healthEventId;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public LocalDateTime getDeliveredAt() {
        return deliveredAt;
    }
}
