package com.carestacks.careconnect.diary.application.diary.abstractions;

import com.carestacks.careconnect.diary.application.diary.dtos.DiaryEntryDto;
import java.util.List;

public interface DiaryService {

    DiaryEntryDto createDiaryEntry(DiaryEntryDto diaryEntryDto);

    DiaryEntryDto getDiaryEntryById(Long id);

    List<DiaryEntryDto> getAllDiaryEntries();

    DiaryEntryDto updateDiaryEntry(Long id, DiaryEntryDto diaryEntryDto);

    void deleteDiaryEntry(Long id);
}
