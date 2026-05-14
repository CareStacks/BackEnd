package com.carestacks.careconnect.documents.infrastructure.persistence;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "medical_documents")
public class MedicalDocumentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id", nullable = false, updatable = false)
    private UUID patientId;

    @OneToMany(mappedBy = "medicalDocument", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocumentItemJpaEntity> documentItems = new ArrayList<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public MedicalDocumentJpaEntity() {}

    public MedicalDocumentJpaEntity(Long id, UUID patientId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.patientId = patientId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void prePersist() {
        var now = LocalDateTime.now();
        if (createdAt == null) createdAt = now;
        if (updatedAt == null) updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
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

    public List<DocumentItemJpaEntity> getDocumentItems() {
        return documentItems;
    }

    public void setDocumentItems(List<DocumentItemJpaEntity> documentItems) {
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

    public void addDocumentItem(DocumentItemJpaEntity documentItem) {
        documentItems.add(documentItem);
        documentItem.setMedicalDocument(this);
        updatedAt = LocalDateTime.now();
    }

    public void removeDocumentItem(DocumentItemJpaEntity documentItem) {
        documentItems.remove(documentItem);
        documentItem.setMedicalDocument(null);
        updatedAt = LocalDateTime.now();
    }
}
