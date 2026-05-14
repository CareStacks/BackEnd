package com.carestacks.careconnect.diary.application.diary.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public class DiaryEntryDto {

    private Long id;
    private UUID patientId;
    private String content;
    private LocalDateTime entryDate;

    public DiaryEntryDto() {}

    public DiaryEntryDto(Long id, UUID patientId, String content, LocalDateTime entryDate) {
        this.id = id;
        this.patientId = patientId;
        this.content = content;
        this.entryDate = entryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }
}
