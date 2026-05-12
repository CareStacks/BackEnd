package com.carestacks.careconnect.notifications.infrastructure.repositories;

import com.carestacks.careconnect.notifications.infrastructure.persistence.NotificationPreferenceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NotificationPreferenceJpaRepository extends JpaRepository<NotificationPreferenceJpaEntity, UUID> {

    Optional<NotificationPreferenceJpaEntity> findByRecipientId(UUID recipientId);
}
