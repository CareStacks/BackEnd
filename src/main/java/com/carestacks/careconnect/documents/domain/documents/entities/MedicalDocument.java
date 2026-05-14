package com.carestacks.careconnect.documents.domain.documents.entities;

import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class MedicalDocument {

    private Long id;
    private UUID patientId;
    private List<DocumentItem> documentItems = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MedicalDocument(Long id, UUID patientId) {
        this(id, patientId, List.of(), LocalDateTime.now(), LocalDateTime.now());
    }

    public MedicalDocument(
            Long id,
            UUID patientId,
            List<DocumentItem> documentItems,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.patientId = requirePatientId(patientId);
        this.documentItems = new ArrayList<>(documentItems == null ? List.of() : documentItems);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
        this.updatedAt = updatedAt == null ? this.createdAt : updatedAt;
    }

    public static MedicalDocument createForPatient(UUID patientId) {
        return new MedicalDocument(null, patientId);
    }

    public void addDocumentItem(DocumentItem documentItem) {
        if (documentItem == null) {
            throw new BusinessRuleException("Document item is required");
        }
        documentItem.assignToMedicalDocument(id);
        documentItems.add(documentItem);
        touch();
    }

    public void removeDocumentItem(Long documentItemId) {
        var removed = documentItems.removeIf(item -> item.getId().equals(documentItemId));
        if (!removed) {
            throw new BusinessRuleException("Document item does not belong to this medical document");
        }
        touch();
    }

    private void touch() {
        this.updatedAt = LocalDateTime.now();
    }

    private static UUID requirePatientId(UUID patientId) {
        if (patientId == null) {
            throw new BusinessRuleException("patientId is required");
        }
        return patientId;
    }

    public Long getId() { return id; }
    public UUID getPatientId() { return patientId; }
    public List<DocumentItem> getDocumentItems() { return Collections.unmodifiableList(documentItems); }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
