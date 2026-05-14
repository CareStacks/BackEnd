package com.carestacks.careconnect.diary.application.diary.dtos;

import java.time.LocalDateTime;

public class DiaryEntryDto {

    private Long id;
    private String content;
    private LocalDateTime entryDate;

    public DiaryEntryDto() {}

    public DiaryEntryDto(Long id, String content, LocalDateTime entryDate) {
        this.id = id;
        this.content = content;
        this.entryDate = entryDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
