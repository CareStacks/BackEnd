package com.carestacks.careconnect.diary.application.diary.abstractions;

import com.carestacks.careconnect.diary.application.diary.dtos.DiaryEntryDto;
import com.carestacks.careconnect.diary.application.diary.requests.CreateDiaryEntryRequest;
import com.carestacks.careconnect.diary.application.diary.requests.UpdateDiaryEntryRequest;

import java.util.List;
import java.util.UUID;

public interface DiaryService {

    DiaryEntryDto createDiaryEntry(CreateDiaryEntryRequest request);

    DiaryEntryDto getDiaryEntryById(Long id);

    List<DiaryEntryDto> getAllDiaryEntries();

    List<DiaryEntryDto> getDiaryEntriesByPatient(UUID patientId);

    DiaryEntryDto updateDiaryEntry(Long id, UpdateDiaryEntryRequest request);

    void deleteDiaryEntry(Long id);
}
