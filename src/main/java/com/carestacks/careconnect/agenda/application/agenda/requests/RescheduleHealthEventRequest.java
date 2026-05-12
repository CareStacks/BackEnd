package com.carestacks.careconnect.agenda.application.agenda.requests;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class RescheduleHealthEventRequest {

    @NotNull
    @FutureOrPresent
    private LocalDateTime startAt;

    @NotNull
    @Future
    private LocalDateTime endAt;

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
