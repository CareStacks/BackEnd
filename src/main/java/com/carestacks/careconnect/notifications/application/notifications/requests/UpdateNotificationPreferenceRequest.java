package com.carestacks.careconnect.notifications.application.notifications.requests;

import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationPriority;
import jakarta.validation.constraints.NotNull;

public class UpdateNotificationPreferenceRequest {

    @NotNull
    private Boolean pushEnabled;

    @NotNull
    private Boolean emailEnabled;

    @NotNull
    private Boolean inAppEnabled;

    @NotNull
    private NotificationPriority minimumPriority;

    public Boolean getPushEnabled() {
        return pushEnabled;
    }

    public void setPushEnabled(Boolean pushEnabled) {
        this.pushEnabled = pushEnabled;
    }

    public Boolean getEmailEnabled() {
        return emailEnabled;
    }

    public void setEmailEnabled(Boolean emailEnabled) {
        this.emailEnabled = emailEnabled;
    }

    public Boolean getInAppEnabled() {
        return inAppEnabled;
    }

    public void setInAppEnabled(Boolean inAppEnabled) {
        this.inAppEnabled = inAppEnabled;
    }

    public NotificationPriority getMinimumPriority() {
        return minimumPriority;
    }

    public void setMinimumPriority(NotificationPriority minimumPriority) {
        this.minimumPriority = minimumPriority;
    }
}
