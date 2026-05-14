package com.carestacks.careconnect.documents.application.documents.requests;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class CreateMedicalDocumentRequest {

    @NotNull(message = "Patient id is required")
    private UUID patientId;

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }
}
