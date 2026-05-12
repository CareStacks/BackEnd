package com.carestacks.careconnect.notifications.infrastructure.persistence;

import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationPriority;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "notification_preferences")
public class NotificationPreferenceJpaEntity {

    @Id
    private UUID id;
    @Column(nullable = false, unique = true)
    private UUID recipientId;
    @Column(nullable = false)
    private boolean pushEnabled;
    @Column(nullable = false)
    private boolean emailEnabled;
    @Column(nullable = false)
    private boolean inAppEnabled;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private NotificationPriority minimumPriority;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    protected NotificationPreferenceJpaEntity() {
    }

    public NotificationPreferenceJpaEntity(
            UUID id,
            UUID recipientId,
            boolean pushEnabled,
            boolean emailEnabled,
            boolean inAppEnabled,
            NotificationPriority minimumPriority,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.recipientId = recipientId;
        this.pushEnabled = pushEnabled;
        this.emailEnabled = emailEnabled;
        this.inAppEnabled = inAppEnabled;
        this.minimumPriority = minimumPriority;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void prePersist() {
        var now = LocalDateTime.now();
        if (id == null) {
            id = UUID.randomUUID();
        }
        if (createdAt == null) {
            createdAt = now;
        }
        if (updatedAt == null) {
            updatedAt = now;
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(UUID recipientId) {
        this.recipientId = recipientId;
    }

    public boolean isPushEnabled() {
        return pushEnabled;
    }

    public void setPushEnabled(boolean pushEnabled) {
        this.pushEnabled = pushEnabled;
    }

    public boolean isEmailEnabled() {
        return emailEnabled;
    }

    public void setEmailEnabled(boolean emailEnabled) {
        this.emailEnabled = emailEnabled;
    }

    public boolean isInAppEnabled() {
        return inAppEnabled;
    }

    public void setInAppEnabled(boolean inAppEnabled) {
        this.inAppEnabled = inAppEnabled;
    }

    public NotificationPriority getMinimumPriority() {
        return minimumPriority;
    }

    public void setMinimumPriority(NotificationPriority minimumPriority) {
        this.minimumPriority = minimumPriority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
