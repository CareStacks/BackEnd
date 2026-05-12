package com.carestacks.careconnect.notifications.infrastructure.repositories;

import com.carestacks.careconnect.notifications.infrastructure.persistence.AlertJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AlertJpaRepository extends JpaRepository<AlertJpaEntity, UUID> {

    List<AlertJpaEntity> findByRecipientIdAndResolvedFalseOrderByTriggeredAtDesc(UUID recipientId);
}
