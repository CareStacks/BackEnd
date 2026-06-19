package com.carestacks.careconnect.consents.application.invitations.dtos;

import com.carestacks.careconnect.consents.domain.consents.enums.ConsentView;
import com.carestacks.careconnect.consents.domain.invitations.enums.CaregiverInvitationStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record CaregiverInvitationDto(
        UUID id,
        UUID patientId,
        String patientFullName,
        String patientEmail,
        UUID caregiverId,
        String caregiverFullName,
        String caregiverEmail,
        Set<ConsentView> allowedViews,
        CaregiverInvitationStatus status,
        LocalDateTime expiresAt,
        LocalDateTime respondedAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
