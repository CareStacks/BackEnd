package com.carestacks.careconnect.diary.infrastructure.repositories;

import com.carestacks.careconnect.diary.domain.diary.entities.DiaryEntry;
import java.util.List;
import java.util.Optional;

public interface DiaryRepository {

    DiaryEntry save(DiaryEntry diaryEntry);

    Optional<DiaryEntry> findById(Long id);

    List<DiaryEntry> findAll();

    void deleteById(Long id);
}
