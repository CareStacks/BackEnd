package com.carestacks.careconnect.diary.application.diary.services;

import com.carestacks.careconnect.diary.application.diary.abstractions.DiaryService;
import com.carestacks.careconnect.diary.application.diary.dtos.DiaryEntryDto;
import com.carestacks.careconnect.diary.application.diary.requests.CreateDiaryEntryRequest;
import com.carestacks.careconnect.diary.application.diary.requests.UpdateDiaryEntryRequest;
import com.carestacks.careconnect.diary.domain.diary.entities.DiaryEntry;
import com.carestacks.careconnect.diary.infrastructure.mappers.DiaryMapper;
import com.carestacks.careconnect.diary.infrastructure.repositories.DiaryRepository;
import com.carestacks.careconnect.shared.domain.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Override
    public DiaryEntryDto createDiaryEntry(CreateDiaryEntryRequest request) {
        var diaryEntry = DiaryEntry.create(request.getPatientId(), request.getContent());
        DiaryEntry savedDiaryEntry = diaryRepository.save(diaryEntry);
        return DiaryMapper.toDto(savedDiaryEntry);
    }

    @Override
    @Transactional(readOnly = true)
    public DiaryEntryDto getDiaryEntryById(Long id) {
        return diaryRepository.findById(id)
                .map(DiaryMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Diary entry not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiaryEntryDto> getAllDiaryEntries() {
        return DiaryMapper.toDtoListFromDomain(diaryRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiaryEntryDto> getDiaryEntriesByPatient(UUID patientId) {
        return DiaryMapper.toDtoListFromDomain(diaryRepository.findByPatientId(patientId));
    }

    @Override
    public DiaryEntryDto updateDiaryEntry(Long id, UpdateDiaryEntryRequest request) {
        DiaryEntry existingDiaryEntry = diaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diary entry not found"));

        existingDiaryEntry.updateContent(request.getContent());

        DiaryEntry updatedDiaryEntry = diaryRepository.save(existingDiaryEntry);
        return DiaryMapper.toDto(updatedDiaryEntry);
    }

    @Override
    public void deleteDiaryEntry(Long id) {
        diaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diary entry not found"));
        diaryRepository.deleteById(id);
    }
}
