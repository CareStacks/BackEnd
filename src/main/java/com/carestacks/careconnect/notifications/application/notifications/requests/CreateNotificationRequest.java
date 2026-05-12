package com.carestacks.careconnect.notifications.application.notifications.requests;

import com.carestacks.careconnect.notifications.domain.notifications.enums.DeliveryChannel;
import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationPriority;
import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateNotificationRequest {

    @NotNull
    private UUID recipientId;

    private UUID healthEventId;

    @NotBlank
    @Size(max = 150)
    private String title;

    @NotBlank
    @Size(max = 500)
    private String message;

    @NotNull
    private NotificationType type;

    @NotNull
    private NotificationPriority priority;

    @NotNull
    private DeliveryChannel deliveryChannel;

    @NotNull
    @FutureOrPresent
    private LocalDateTime scheduledAt;

    public UUID getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(UUID recipientId) {
        this.recipientId = recipientId;
    }

    public UUID getHealthEventId() {
        return healthEventId;
    }

    public void setHealthEventId(UUID healthEventId) {
        this.healthEventId = healthEventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public NotificationPriority getPriority() {
        return priority;
    }

    public void setPriority(NotificationPriority priority) {
        this.priority = priority;
    }

    public DeliveryChannel getDeliveryChannel() {
        return deliveryChannel;
    }

    public void setDeliveryChannel(DeliveryChannel deliveryChannel) {
        this.deliveryChannel = deliveryChannel;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(LocalDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
    }
}
