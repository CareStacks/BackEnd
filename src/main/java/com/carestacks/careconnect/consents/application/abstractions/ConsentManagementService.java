package com.carestacks.careconnect.consents.application.abstractions;

import com.carestacks.careconnect.consents.application.consents.dtos.CaregiverAccessDto;
import com.carestacks.careconnect.consents.application.consents.dtos.ProfileShareConsentDto;
import com.carestacks.careconnect.consents.application.consents.requests.GrantConsentRequest;
import com.carestacks.careconnect.consents.application.consents.requests.UpdateConsentViewsRequest;
import com.carestacks.careconnect.consents.domain.consents.enums.ConsentView;

import java.util.List;
import java.util.UUID;

public interface ConsentManagementService {

    ProfileShareConsentDto grantOrUpdateConsent(String token, GrantConsentRequest request);

    ProfileShareConsentDto updateAllowedViews(String token, UUID consentId, UpdateConsentViewsRequest request);

    void revokeConsent(String token, UUID consentId);

    List<ProfileShareConsentDto> getMyGrantedConsents(String token);

    ProfileShareConsentDto getMyCaregiverProfile(String token);

    CaregiverAccessDto validateCaregiverAccess(String token, UUID patientId, ConsentView view);

    boolean canCaregiverView(UUID caregiverId, UUID patientId, ConsentView view);
}
