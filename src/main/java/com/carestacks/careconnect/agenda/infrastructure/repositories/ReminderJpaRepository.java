package com.carestacks.careconnect.agenda.infrastructure.repositories;

import com.carestacks.careconnect.agenda.infrastructure.persistence.ReminderJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReminderJpaRepository extends JpaRepository<ReminderJpaEntity, UUID> {

    Optional<ReminderJpaEntity> findByHealthEventId(UUID healthEventId);

    void deleteByHealthEventId(UUID healthEventId);
}
