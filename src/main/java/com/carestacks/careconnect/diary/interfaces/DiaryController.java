package com.carestacks.careconnect.diary.interfaces;

import com.carestacks.careconnect.diary.application.diary.abstractions.DiaryService;
import com.carestacks.careconnect.diary.application.diary.dtos.DiaryEntryDto;
import com.carestacks.careconnect.diary.application.diary.requests.CreateDiaryEntryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diary")
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping
    public ResponseEntity<DiaryEntryDto> createDiaryEntry(@RequestBody CreateDiaryEntryRequest request) {
        DiaryEntryDto diaryEntryDto = new DiaryEntryDto();
        diaryEntryDto.setContent(request.getContent());
        DiaryEntryDto createdDiaryEntry = diaryService.createDiaryEntry(diaryEntryDto);
        return ResponseEntity.ok(createdDiaryEntry);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaryEntryDto> getDiaryEntryById(@PathVariable Long id) {
        DiaryEntryDto diaryEntry = diaryService.getDiaryEntryById(id);
        return ResponseEntity.ok(diaryEntry);
    }

    @GetMapping
    public ResponseEntity<List<DiaryEntryDto>> getAllDiaryEntries() {
        List<DiaryEntryDto> diaryEntries = diaryService.getAllDiaryEntries();
        return ResponseEntity.ok(diaryEntries);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaryEntryDto> updateDiaryEntry(@PathVariable Long id, @RequestBody CreateDiaryEntryRequest request) {
        DiaryEntryDto diaryEntryDto = new DiaryEntryDto();
        diaryEntryDto.setContent(request.getContent());
        DiaryEntryDto updatedDiaryEntry = diaryService.updateDiaryEntry(id, diaryEntryDto);
        return ResponseEntity.ok(updatedDiaryEntry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiaryEntry(@PathVariable Long id) {
        diaryService.deleteDiaryEntry(id);
        return ResponseEntity.noContent().build();
    }
}
