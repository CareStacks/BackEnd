package com.carestacks.careconnect.agenda.infrastructure.mappers;

import com.carestacks.careconnect.agenda.application.agenda.dtos.ReminderDto;
import com.carestacks.careconnect.agenda.domain.agenda.entities.Reminder;
import com.carestacks.careconnect.agenda.infrastructure.persistence.ReminderJpaEntity;

public final class ReminderMapper {

    private ReminderMapper() {
    }

    public static Reminder toDomain(ReminderJpaEntity entity) {
        return new Reminder(
                entity.getId(),
                entity.getHealthEventId(),
                entity.getScheduledAt(),
                entity.isDelivered(),
                entity.getDeliveredAt(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static ReminderJpaEntity toEntity(Reminder reminder) {
        return new ReminderJpaEntity(
                reminder.getId(),
                reminder.getHealthEventId(),
                reminder.getScheduledAt(),
                reminder.isDelivered(),
                reminder.getDeliveredAt(),
                reminder.getCreatedAt(),
                reminder.getUpdatedAt()
        );
    }

    public static void copyToEntity(Reminder reminder, ReminderJpaEntity entity) {
        entity.setScheduledAt(reminder.getScheduledAt());
        entity.setDelivered(reminder.isDelivered());
        entity.setDeliveredAt(reminder.getDeliveredAt());
        entity.setUpdatedAt(reminder.getUpdatedAt());
    }

    public static ReminderDto toDto(ReminderJpaEntity entity) {
        return new ReminderDto(
                entity.getId(),
                entity.getHealthEventId(),
                entity.getScheduledAt(),
                entity.isDelivered(),
                entity.getDeliveredAt(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
