package com.carestacks.careconnect.diary.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryEntryJpaRepository extends JpaRepository<DiaryEntryJpaEntity, Long> {
}
