package com.carestacks.careconnect.agenda.domain.agenda.entities;

import com.carestacks.careconnect.agenda.domain.agenda.enums.EventStatus;
import com.carestacks.careconnect.agenda.domain.agenda.enums.EventType;
import com.carestacks.careconnect.shared.domain.entities.AuditableEntity;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;

import java.time.LocalDateTime;
import java.util.UUID;

public class HealthEvent extends AuditableEntity {

    private final UUID patientId;
    private final UUID caregiverId;
    private String title;
    private String description;
    private EventType type;
    private EventStatus status;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    public HealthEvent(
            UUID id,
            UUID patientId,
            UUID caregiverId,
            String title,
            String description,
            EventType type,
            EventStatus status,
            LocalDateTime startAt,
            LocalDateTime endAt,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        super(id, createdAt, updatedAt);
        this.patientId = requireId(patientId, "patientId");
        this.caregiverId = caregiverId;
        this.title = requireText(title, "title");
        this.description = description == null ? "" : description.trim();
        this.type = requireValue(type, "type");
        this.status = requireValue(status, "status");
        setSchedule(startAt, endAt);
    }

    public static HealthEvent schedule(
            UUID patientId,
            UUID caregiverId,
            String title,
            String description,
            EventType type,
            LocalDateTime startAt,
            LocalDateTime endAt
    ) {
        return new HealthEvent(null, patientId, caregiverId, title, description, type, EventStatus.PENDING, startAt, endAt, null, null);
    }

    public void update(String title, String description, EventType type, LocalDateTime startAt, LocalDateTime endAt) {
        ensureEditable("update");
        this.title = requireText(title, "title");
        this.description = description == null ? "" : description.trim();
        this.type = requireValue(type, "type");
        setSchedule(startAt, endAt);
        touch();
    }

    public void confirm() {
        ensureEditable("confirm");
        this.status = EventStatus.CONFIRMED;
        touch();
    }

    public void reschedule(LocalDateTime startAt, LocalDateTime endAt) {
        ensureEditable("reschedule");
        setSchedule(startAt, endAt);
        this.status = EventStatus.PENDING;
        touch();
    }

    public void cancel() {
        if (status == EventStatus.CANCELLED) {
            return;
        }
        this.status = EventStatus.CANCELLED;
        touch();
    }

    public void markAsMissed() {
        ensureEditable("mark as missed");
        this.status = EventStatus.MISSED;
        touch();
    }

    private void setSchedule(LocalDateTime startAt, LocalDateTime endAt) {
        this.startAt = requireValue(startAt, "startAt");
        this.endAt = requireValue(endAt, "endAt");
        if (!endAt.isAfter(startAt)) {
            throw new BusinessRuleException("Event end date must be after start date");
        }
    }

    private void ensureEditable(String action) {
        if (status == EventStatus.CANCELLED || status == EventStatus.MISSED) {
            throw new BusinessRuleException("Cannot " + action + " a " + status.name().toLowerCase() + " event");
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

    public UUID getPatientId() {
        return patientId;
    }

    public UUID getCaregiverId() {
        return caregiverId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public EventType getType() {
        return type;
    }

    public EventStatus getStatus() {
        return status;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }
}
