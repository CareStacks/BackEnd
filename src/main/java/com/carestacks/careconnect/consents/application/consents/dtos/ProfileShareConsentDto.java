package com.carestacks.careconnect.consents.application.consents.dtos;

import com.carestacks.careconnect.consents.domain.consents.enums.ConsentView;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record ProfileShareConsentDto(
        UUID id,
        UUID patientId,
        String patientFullName,
        UUID caregiverId,
        String caregiverFullName,
        Set<ConsentView> allowedViews,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
