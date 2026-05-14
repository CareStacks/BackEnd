package com.carestacks.careconnect.documents.application.documents.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class MedicalDocumentDto {

    private Long id;
    private UUID patientId;
    private List<DocumentItemDto> documentItems;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MedicalDocumentDto() {}

    public MedicalDocumentDto(Long id, UUID patientId, List<DocumentItemDto> documentItems, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.patientId = patientId;
        this.documentItems = documentItems;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public List<DocumentItemDto> getDocumentItems() {
        return documentItems;
    }

    public void setDocumentItems(List<DocumentItemDto> documentItems) {
        this.documentItems = documentItems;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
