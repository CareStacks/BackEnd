package com.carestacks.careconnect.agenda.application.agenda.requests;

import com.carestacks.careconnect.agenda.domain.agenda.enums.EventType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class UpdateHealthEventRequest {

    @NotBlank
    @Size(max = 150)
    private String title;

    @Size(max = 500)
    private String description;

    @NotNull
    private EventType type;

    @NotNull
    @FutureOrPresent
    private LocalDateTime startAt;

    @NotNull
    @Future
    private LocalDateTime endAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }
}
