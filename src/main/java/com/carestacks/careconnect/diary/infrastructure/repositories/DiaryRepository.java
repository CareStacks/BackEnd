package com.carestacks.careconnect.diary.infrastructure.repositories;

import com.carestacks.careconnect.diary.domain.diary.entities.DiaryEntry;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DiaryRepository {

    DiaryEntry save(DiaryEntry diaryEntry);

    Optional<DiaryEntry> findById(Long id);

    List<DiaryEntry> findAll();

    List<DiaryEntry> findByPatientId(UUID patientId);

    void deleteById(Long id);
}
