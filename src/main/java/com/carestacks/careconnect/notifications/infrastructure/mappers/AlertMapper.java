package com.carestacks.careconnect.notifications.infrastructure.mappers;

import com.carestacks.careconnect.notifications.application.notifications.dtos.AlertDto;
import com.carestacks.careconnect.notifications.domain.notifications.entities.Alert;
import com.carestacks.careconnect.notifications.infrastructure.persistence.AlertJpaEntity;

public final class AlertMapper {

    private AlertMapper() {
    }

    public static Alert toDomain(AlertJpaEntity entity) {
        return new Alert(
                entity.getId(),
                entity.getRecipientId(),
                entity.getNotificationId(),
                entity.getHealthEventId(),
                entity.getTitle(),
                entity.getMessage(),
                entity.getPriority(),
                entity.isResolved(),
                entity.getTriggeredAt(),
                entity.getResolvedAt(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static AlertJpaEntity toEntity(Alert alert) {
        return new AlertJpaEntity(
                alert.getId(),
                alert.getRecipientId(),
                alert.getNotificationId(),
                alert.getHealthEventId(),
                alert.getTitle(),
                alert.getMessage(),
                alert.getPriority(),
                alert.isResolved(),
                alert.getTriggeredAt(),
                alert.getResolvedAt(),
                alert.getCreatedAt(),
                alert.getUpdatedAt()
        );
    }

    public static void copyToEntity(Alert alert, AlertJpaEntity entity) {
        entity.setResolved(alert.isResolved());
        entity.setResolvedAt(alert.getResolvedAt());
        entity.setUpdatedAt(alert.getUpdatedAt());
    }

    public static AlertDto toDto(AlertJpaEntity entity) {
        return new AlertDto(
                entity.getId(),
                entity.getRecipientId(),
                entity.getNotificationId(),
                entity.getHealthEventId(),
                entity.getTitle(),
                entity.getMessage(),
                entity.getPriority(),
                entity.isResolved(),
                entity.getTriggeredAt(),
                entity.getResolvedAt(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
