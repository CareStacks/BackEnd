package com.carestacks.careconnect.diary.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiaryEntryJpaRepository extends JpaRepository<DiaryEntryJpaEntity, Long> {
    List<DiaryEntryJpaEntity> findAllByOrderByEntryDateDesc();

    List<DiaryEntryJpaEntity> findByPatientIdOrderByEntryDateDesc(UUID patientId);
}
