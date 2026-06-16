package com.carestacks.careconnect.consents.domain.consents.entities;

import com.carestacks.careconnect.consents.domain.consents.enums.ConsentView;
import com.carestacks.careconnect.shared.domain.entities.AuditableEntity;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

public class ProfileShareConsent extends AuditableEntity {

    private final UUID patientId;
    private final UUID caregiverId;
    private Set<ConsentView> allowedViews;

    public ProfileShareConsent(
            UUID id,
            UUID patientId,
            UUID caregiverId,
            Set<ConsentView> allowedViews,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        super(id, createdAt, updatedAt);
        this.patientId = requireId(patientId, "patientId");
        this.caregiverId = requireId(caregiverId, "caregiverId");
        if (this.patientId.equals(this.caregiverId)) {
            throw new BusinessRuleException("Patient and caregiver must be different users");
        }
        this.allowedViews = requireAllowedViews(allowedViews);
    }

    public static ProfileShareConsent grant(UUID patientId, UUID caregiverId, Set<ConsentView> allowedViews) {
        return new ProfileShareConsent(null, patientId, caregiverId, allowedViews, null, null);
    }

    public void updateAllowedViews(Set<ConsentView> allowedViews) {
        this.allowedViews = requireAllowedViews(allowedViews);
        touch();
    }

    public boolean allows(ConsentView view) {
        if (view == null) {
            return false;
        }
        return allowedViews.contains(view);
    }

    private static UUID requireId(UUID value, String fieldName) {
        if (value == null) {
            throw new BusinessRuleException(fieldName + " is required");
        }
        return value;
    }

    private static Set<ConsentView> requireAllowedViews(Set<ConsentView> values) {
        if (values == null || values.isEmpty()) {
            throw new BusinessRuleException("At least one consent view is required");
        }

        var normalizedValues = new LinkedHashSet<ConsentView>();
        for (ConsentView value : values) {
            if (value == null) {
                throw new BusinessRuleException("Consent view cannot be null");
            }
            normalizedValues.add(value);
        }

        return normalizedValues;
    }

    public UUID getPatientId() { return patientId; }
    public UUID getCaregiverId() { return caregiverId; }
    public Set<ConsentView> getAllowedViews() { return Set.copyOf(allowedViews); }
}
