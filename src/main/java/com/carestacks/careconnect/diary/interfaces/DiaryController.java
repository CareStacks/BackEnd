package com.carestacks.careconnect.diary.interfaces;

import com.carestacks.careconnect.diary.application.diary.abstractions.DiaryService;
import com.carestacks.careconnect.diary.application.diary.dtos.DiaryEntryDto;
import com.carestacks.careconnect.diary.application.diary.requests.CreateDiaryEntryRequest;
import com.carestacks.careconnect.diary.application.diary.requests.UpdateDiaryEntryRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/diary")
@Tag(name = "Diary", description = "Patient diary entry creation, consultation, update, and deletion endpoints")
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @Operation(summary = "Create a diary entry", description = "Creates a patient diary entry with non-empty content and automatic timestamp.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Diary entry created",
                    content = @Content(schema = @Schema(implementation = DiaryEntryDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid diary entry data")
    })
    @PostMapping
    public ResponseEntity<DiaryEntryDto> createDiaryEntry(@Valid @RequestBody CreateDiaryEntryRequest request) {
        var createdDiaryEntry = diaryService.createDiaryEntry(request);
        return ResponseEntity.created(URI.create("/api/diary/" + createdDiaryEntry.getId())).body(createdDiaryEntry);
    }

    @Operation(summary = "Get a diary entry", description = "Returns a single diary entry by ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Diary entry returned"),
            @ApiResponse(responseCode = "404", description = "Diary entry not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<DiaryEntryDto> getDiaryEntryById(
            @Parameter(description = "Diary entry identifier") @PathVariable Long id
    ) {
        return ResponseEntity.ok(diaryService.getDiaryEntryById(id));
    }

    @Operation(summary = "List diary entries", description = "Returns all diary entries ordered by entry date descending.")
    @ApiResponse(responseCode = "200", description = "Diary entries returned")
    @GetMapping
    public ResponseEntity<List<DiaryEntryDto>> getAllDiaryEntries() {
        return ResponseEntity.ok(diaryService.getAllDiaryEntries());
    }

    @Operation(summary = "List patient diary entries", description = "Returns diary entries owned by a patient.")
    @ApiResponse(responseCode = "200", description = "Patient diary entries returned")
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<DiaryEntryDto>> getDiaryEntriesByPatient(
            @Parameter(description = "Patient identifier") @PathVariable UUID patientId
    ) {
        return ResponseEntity.ok(diaryService.getDiaryEntriesByPatient(patientId));
    }

    @Operation(summary = "Update a diary entry", description = "Updates the content of an existing diary entry.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Diary entry updated"),
            @ApiResponse(responseCode = "400", description = "Invalid diary entry data"),
            @ApiResponse(responseCode = "404", description = "Diary entry not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<DiaryEntryDto> updateDiaryEntry(
            @Parameter(description = "Diary entry identifier") @PathVariable Long id,
            @Valid @RequestBody UpdateDiaryEntryRequest request
    ) {
        return ResponseEntity.ok(diaryService.updateDiaryEntry(id, request));
    }

    @Operation(summary = "Delete a diary entry", description = "Deletes an existing diary entry.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Diary entry deleted"),
            @ApiResponse(responseCode = "404", description = "Diary entry not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiaryEntry(
            @Parameter(description = "Diary entry identifier") @PathVariable Long id
    ) {
        diaryService.deleteDiaryEntry(id);
        return ResponseEntity.noContent().build();
    }
}
