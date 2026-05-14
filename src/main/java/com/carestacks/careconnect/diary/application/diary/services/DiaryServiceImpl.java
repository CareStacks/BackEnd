package com.carestacks.careconnect.diary.application.diary.services;

import com.carestacks.careconnect.diary.application.diary.abstractions.DiaryService;
import com.carestacks.careconnect.diary.application.diary.dtos.DiaryEntryDto;
import com.carestacks.careconnect.diary.application.diary.requests.CreateDiaryEntryRequest;
import com.carestacks.careconnect.diary.domain.diary.entities.DiaryEntry;
import com.carestacks.careconnect.diary.infrastructure.mappers.DiaryMapper;
import com.carestacks.careconnect.diary.infrastructure.repositories.DiaryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Override
    public DiaryEntryDto createDiaryEntry(DiaryEntryDto diaryEntryDto) {
        DiaryEntry diaryEntry = new DiaryEntry(
                diaryEntryDto.getId(),
                diaryEntryDto.getContent(),
                diaryEntryDto.getEntryDate() != null ? diaryEntryDto.getEntryDate() : LocalDateTime.now()
        );
        DiaryEntry savedDiaryEntry = diaryRepository.save(diaryEntry);
        return DiaryMapper.toDto(savedDiaryEntry);
    }

    @Override
    public DiaryEntryDto getDiaryEntryById(Long id) {
        return diaryRepository.findById(id)
                .map(DiaryMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("Diary entry not found with id: " + id));
    }

    @Override
    public List<DiaryEntryDto> getAllDiaryEntries() {
        return DiaryMapper.toDtoListFromDomain(diaryRepository.findAll());
    }

    @Override
    public DiaryEntryDto updateDiaryEntry(Long id, DiaryEntryDto diaryEntryDto) {
        DiaryEntry existingDiaryEntry = diaryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Diary entry not found with id: " + id));

        existingDiaryEntry.setContent(diaryEntryDto.getContent());
        existingDiaryEntry.setEntryDate(diaryEntryDto.getEntryDate() != null ? diaryEntryDto.getEntryDate() : LocalDateTime.now());

        DiaryEntry updatedDiaryEntry = diaryRepository.save(existingDiaryEntry);
        return DiaryMapper.toDto(updatedDiaryEntry);
    }

    @Override
    public void deleteDiaryEntry(Long id) {
        if (!diaryRepository.findById(id).isPresent()) {
            throw new NoSuchElementException("Diary entry not found with id: " + id);
        }
        diaryRepository.deleteById(id);
    }
}
