package com.carestacks.careconnect.diary.domain.diary.entities;

import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;

import java.time.LocalDateTime;
import java.util.UUID;

public class DiaryEntry {

    private Long id;
    private UUID patientId;
    private String content;
    private LocalDateTime entryDate;

    public DiaryEntry(Long id, UUID patientId, String content, LocalDateTime entryDate) {
        this.id = id;
        this.patientId = requirePatientId(patientId);
        this.content = requireContent(content);
        this.entryDate = entryDate == null ? LocalDateTime.now() : entryDate;
    }

    public static DiaryEntry create(UUID patientId, String content) {
        return new DiaryEntry(null, patientId, content, LocalDateTime.now());
    }

    public void updateContent(String content) {
        this.content = requireContent(content);
    }

    private static UUID requirePatientId(UUID patientId) {
        if (patientId == null) {
            throw new BusinessRuleException("patientId is required");
        }
        return patientId;
    }

    private static String requireContent(String content) {
        if (content == null || content.isBlank()) {
            throw new BusinessRuleException("Diary entry content is required");
        }
        var trimmed = content.trim();
        if (trimmed.length() > 2000) {
            throw new BusinessRuleException("Diary entry content must not exceed 2000 characters");
        }
        return trimmed;
    }

    public Long getId() {
        return id;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }
}
