package com.carestacks.careconnect.notifications.infrastructure.mappers;

import com.carestacks.careconnect.notifications.application.notifications.dtos.NotificationPreferenceDto;
import com.carestacks.careconnect.notifications.domain.notifications.entities.NotificationPreference;
import com.carestacks.careconnect.notifications.infrastructure.persistence.NotificationPreferenceJpaEntity;

public final class NotificationPreferenceMapper {

    private NotificationPreferenceMapper() {
    }

    public static NotificationPreference toDomain(NotificationPreferenceJpaEntity entity) {
        return new NotificationPreference(
                entity.getId(),
                entity.getRecipientId(),
                entity.isPushEnabled(),
                entity.isEmailEnabled(),
                entity.isInAppEnabled(),
                entity.getMinimumPriority(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static NotificationPreferenceJpaEntity toEntity(NotificationPreference preference) {
        return new NotificationPreferenceJpaEntity(
                preference.getId(),
                preference.getRecipientId(),
                preference.isPushEnabled(),
                preference.isEmailEnabled(),
                preference.isInAppEnabled(),
                preference.getMinimumPriority(),
                preference.getCreatedAt(),
                preference.getUpdatedAt()
        );
    }

    public static void copyToEntity(NotificationPreference preference, NotificationPreferenceJpaEntity entity) {
        entity.setPushEnabled(preference.isPushEnabled());
        entity.setEmailEnabled(preference.isEmailEnabled());
        entity.setInAppEnabled(preference.isInAppEnabled());
        entity.setMinimumPriority(preference.getMinimumPriority());
        entity.setUpdatedAt(preference.getUpdatedAt());
    }

    public static NotificationPreferenceDto toDto(NotificationPreferenceJpaEntity entity) {
        return new NotificationPreferenceDto(
                entity.getId(),
                entity.getRecipientId(),
                entity.isPushEnabled(),
                entity.isEmailEnabled(),
                entity.isInAppEnabled(),
                entity.getMinimumPriority(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
