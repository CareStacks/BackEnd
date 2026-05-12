package com.carestacks.careconnect.agenda.infrastructure.repositories;

import com.carestacks.careconnect.agenda.domain.agenda.enums.EventStatus;
import com.carestacks.careconnect.agenda.infrastructure.persistence.HealthEventJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface HealthEventJpaRepository extends JpaRepository<HealthEventJpaEntity, UUID> {

    List<HealthEventJpaEntity> findAllByOrderByStartAtAsc();

    List<HealthEventJpaEntity> findByPatientIdOrderByStartAtAsc(UUID patientId);

    List<HealthEventJpaEntity> findByPatientIdAndStartAtBetweenOrderByStartAtAsc(UUID patientId, LocalDateTime from, LocalDateTime to);

    @Query("""
            select count(event) > 0
            from HealthEventJpaEntity event
            where event.patientId = :patientId
              and event.id <> :excludedId
              and event.status in :activeStatuses
              and event.startAt < :endAt
              and event.endAt > :startAt
            """)
    boolean existsOverlappingEvent(
            @Param("patientId") UUID patientId,
            @Param("excludedId") UUID excludedId,
            @Param("activeStatuses") Collection<EventStatus> activeStatuses,
            @Param("startAt") LocalDateTime startAt,
            @Param("endAt") LocalDateTime endAt
    );
}
