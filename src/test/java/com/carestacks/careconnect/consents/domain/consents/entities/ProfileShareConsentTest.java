package com.carestacks.careconnect.consents.domain.consents.entities;

import com.carestacks.careconnect.consents.domain.consents.enums.ConsentView;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProfileShareConsentTest {

    @Test
    void grantsOnlySelectedViewsAndUpdatesThem() {
        var patientId = UUID.randomUUID();
        var caregiverId = UUID.randomUUID();
        var consent = ProfileShareConsent.grant(patientId, caregiverId, Set.of(ConsentView.AGENDA));

        assertTrue(consent.allows(ConsentView.AGENDA));
        assertFalse(consent.allows(ConsentView.DIARY));

        consent.updateAllowedViews(Set.of(ConsentView.DIARY));
        assertFalse(consent.allows(ConsentView.AGENDA));
        assertTrue(consent.allows(ConsentView.DIARY));
    }

    @Test
    void rejectsSelfSharingAndEmptyPermissions() {
        var patientId = UUID.randomUUID();
        var caregiverId = UUID.randomUUID();

        assertThrows(BusinessRuleException.class,
                () -> ProfileShareConsent.grant(patientId, patientId, Set.of(ConsentView.PROFILE)));
        assertThrows(BusinessRuleException.class,
                () -> ProfileShareConsent.grant(patientId, caregiverId, Set.of()));
    }
}
