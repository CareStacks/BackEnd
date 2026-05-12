package com.carestacks.careconnect.agenda.infrastructure.mappers;

import com.carestacks.careconnect.agenda.application.agenda.dtos.HealthEventDto;
import com.carestacks.careconnect.agenda.domain.agenda.entities.HealthEvent;
import com.carestacks.careconnect.agenda.infrastructure.persistence.HealthEventJpaEntity;
import com.carestacks.careconnect.agenda.infrastructure.persistence.ReminderJpaEntity;

import java.time.LocalDateTime;

public final class HealthEventMapper {

    private HealthEventMapper() {
    }

    public static HealthEvent toDomain(HealthEventJpaEntity entity) {
        return new HealthEvent(
                entity.getId(),
                entity.getPatientId(),
                entity.getCaregiverId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getType(),
                entity.getStatus(),
                entity.getStartAt(),
                entity.getEndAt(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static HealthEventJpaEntity toEntity(HealthEvent event) {
        return new HealthEventJpaEntity(
                event.getId(),
                event.getPatientId(),
                event.getCaregiverId(),
                event.getTitle(),
                event.getDescription(),
                event.getType(),
                event.getStatus(),
                event.getStartAt(),
                event.getEndAt(),
                event.getCreatedAt(),
                event.getUpdatedAt()
        );
    }

    public static void copyToEntity(HealthEvent event, HealthEventJpaEntity entity) {
        entity.setTitle(event.getTitle());
        entity.setDescription(event.getDescription());
        entity.setType(event.getType());
        entity.setStatus(event.getStatus());
        entity.setStartAt(event.getStartAt());
        entity.setEndAt(event.getEndAt());
        entity.setUpdatedAt(event.getUpdatedAt());
    }

    public static HealthEventDto toDto(HealthEventJpaEntity entity, ReminderJpaEntity reminder) {
        LocalDateTime reminderAt = reminder == null ? null : reminder.getScheduledAt();
        return new HealthEventDto(
                entity.getId(),
                entity.getPatientId(),
                entity.getCaregiverId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getType(),
                entity.getStatus(),
                entity.getStartAt(),
                entity.getEndAt(),
                reminderAt,
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
