package com.carestacks.careconnect.notifications.application.notifications.requests;

import com.carestacks.careconnect.notifications.domain.notifications.enums.DeliveryChannel;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public class ScheduleEventNotificationRequest {

    @NotNull
    private UUID recipientId;

    @NotNull
    private UUID healthEventId;

    @NotBlank
    @Size(max = 150)
    private String eventTitle;

    @NotNull
    @Future
    private LocalDateTime eventStartAt;

    @NotNull
    private DeliveryChannel deliveryChannel;

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

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public LocalDateTime getEventStartAt() {
        return eventStartAt;
    }

    public void setEventStartAt(LocalDateTime eventStartAt) {
        this.eventStartAt = eventStartAt;
    }

    public DeliveryChannel getDeliveryChannel() {
        return deliveryChannel;
    }

    public void setDeliveryChannel(DeliveryChannel deliveryChannel) {
        this.deliveryChannel = deliveryChannel;
    }
}
