package com.carestacks.careconnect.consents.application.consents.requests;

import com.carestacks.careconnect.consents.domain.consents.enums.ConsentView;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.UUID;

public class GrantConsentRequest {

    private UUID caregiverId;

    @Email(message = "Invalid caregiver email format")
    private String caregiverEmail;

    @NotEmpty(message = "At least one visible view is required")
    private Set<@NotNull(message = "Visible view cannot be null") ConsentView> allowedViews;

    public UUID getCaregiverId() { return caregiverId; }
    public void setCaregiverId(UUID caregiverId) { this.caregiverId = caregiverId; }
    public String getCaregiverEmail() { return caregiverEmail; }
    public void setCaregiverEmail(String caregiverEmail) { this.caregiverEmail = caregiverEmail; }
    public Set<ConsentView> getAllowedViews() { return allowedViews; }
    public void setAllowedViews(Set<ConsentView> allowedViews) { this.allowedViews = allowedViews; }
}
