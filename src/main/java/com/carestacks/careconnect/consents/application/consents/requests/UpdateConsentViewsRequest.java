package com.carestacks.careconnect.consents.application.consents.requests;

import com.carestacks.careconnect.consents.domain.consents.enums.ConsentView;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class UpdateConsentViewsRequest {

    @NotEmpty(message = "At least one visible view is required")
    private Set<@NotNull(message = "Visible view cannot be null") ConsentView> allowedViews;

    public Set<ConsentView> getAllowedViews() { return allowedViews; }
    public void setAllowedViews(Set<ConsentView> allowedViews) { this.allowedViews = allowedViews; }
}
