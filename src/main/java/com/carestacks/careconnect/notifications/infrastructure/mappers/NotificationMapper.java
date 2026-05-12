package com.carestacks.careconnect.notifications.infrastructure.mappers;

import com.carestacks.careconnect.notifications.application.notifications.dtos.NotificationDto;
import com.carestacks.careconnect.notifications.domain.notifications.entities.Notification;
import com.carestacks.careconnect.notifications.infrastructure.persistence.NotificationJpaEntity;

public final class NotificationMapper {

    private NotificationMapper() {
    }

    public static Notification toDomain(NotificationJpaEntity entity) {
        return new Notification(
                entity.getId(),
                entity.getRecipientId(),
                entity.getHealthEventId(),
                entity.getTitle(),
                entity.getMessage(),
                entity.getType(),
                entity.getPriority(),
                entity.getStatus(),
                entity.getDeliveryChannel(),
                entity.getScheduledAt(),
                entity.getSentAt(),
                entity.getReadAt(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static NotificationJpaEntity toEntity(Notification notification) {
        return new NotificationJpaEntity(
                notification.getId(),
                notification.getRecipientId(),
                notification.getHealthEventId(),
                notification.getTitle(),
                notification.getMessage(),
                notification.getType(),
                notification.getPriority(),
                notification.getStatus(),
                notification.getDeliveryChannel(),
                notification.getScheduledAt(),
                notification.getSentAt(),
                notification.getReadAt(),
                notification.getCreatedAt(),
                notification.getUpdatedAt()
        );
    }

    public static void copyToEntity(Notification notification, NotificationJpaEntity entity) {
        entity.setStatus(notification.getStatus());
        entity.setSentAt(notification.getSentAt());
        entity.setReadAt(notification.getReadAt());
        entity.setUpdatedAt(notification.getUpdatedAt());
    }

    public static NotificationDto toDto(NotificationJpaEntity entity) {
        return new NotificationDto(
                entity.getId(),
                entity.getRecipientId(),
                entity.getHealthEventId(),
                entity.getTitle(),
                entity.getMessage(),
                entity.getType(),
                entity.getPriority(),
                entity.getStatus(),
                entity.getDeliveryChannel(),
                entity.getScheduledAt(),
                entity.getSentAt(),
                entity.getReadAt(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
