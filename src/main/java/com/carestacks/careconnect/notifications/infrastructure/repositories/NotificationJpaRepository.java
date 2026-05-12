package com.carestacks.careconnect.notifications.infrastructure.repositories;

import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationStatus;
import com.carestacks.careconnect.notifications.infrastructure.persistence.NotificationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface NotificationJpaRepository extends JpaRepository<NotificationJpaEntity, UUID> {

    List<NotificationJpaEntity> findAllByOrderByCreatedAtDesc();

    List<NotificationJpaEntity> findByRecipientIdOrderByCreatedAtDesc(UUID recipientId);

    List<NotificationJpaEntity> findByRecipientIdAndStatusInOrderByCreatedAtDesc(UUID recipientId, Collection<NotificationStatus> statuses);
}
