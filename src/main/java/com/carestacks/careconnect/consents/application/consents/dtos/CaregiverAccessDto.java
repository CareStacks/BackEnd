package com.carestacks.careconnect.consents.application.consents.dtos;

import com.carestacks.careconnect.consents.domain.consents.enums.ConsentView;

import java.util.Set;
import java.util.UUID;

public record CaregiverAccessDto(
        UUID patientId,
        UUID caregiverId,
        ConsentView requestedView,
        boolean allowed,
        Set<ConsentView> allowedViews
) {
}
