package com.carestacks.careconnect.consents.infrastructure.persistence;

import com.carestacks.careconnect.consents.domain.consents.enums.ConsentView;
import com.carestacks.careconnect.consents.domain.invitations.enums.CaregiverInvitationStatus;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(
        name = "caregiver_invitations",
        indexes = {
                @Index(name = "idx_caregiver_invitations_patient", columnList = "patient_id"),
                @Index(name = "idx_caregiver_invitations_caregiver", columnList = "caregiver_id"),
                @Index(name = "idx_caregiver_invitations_status", columnList = "status")
        }
)
public class CaregiverInvitationJpaEntity {

    @Id
    private UUID id;

    @Column(name = "patient_id", nullable = false)
    private UUID patientId;

    @Column(name = "caregiver_id", nullable = false)
    private UUID caregiverId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "caregiver_invitation_views",
            joinColumns = @JoinColumn(name = "invitation_id", nullable = false)
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "view_name", nullable = false, length = 40)
    private Set<ConsentView> allowedViews = new LinkedHashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private CaregiverInvitationStatus status = CaregiverInvitationStatus.PENDING;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime respondedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public CaregiverInvitationJpaEntity() {}

    public CaregiverInvitationJpaEntity(
            UUID id,
            UUID patientId,
            UUID caregiverId,
            Set<ConsentView> allowedViews,
            CaregiverInvitationStatus status,
            LocalDateTime expiresAt,
            LocalDateTime respondedAt,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.patientId = patientId;
        this.caregiverId = caregiverId;
        setAllowedViews(allowedViews);
        this.status = status == null ? CaregiverInvitationStatus.PENDING : status;
        this.expiresAt = expiresAt;
        this.respondedAt = respondedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void prePersist() {
        var now = LocalDateTime.now();
        if (id == null) id = UUID.randomUUID();
        if (createdAt == null) createdAt = now;
        if (updatedAt == null) updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getPatientId() { return patientId; }
    public void setPatientId(UUID patientId) { this.patientId = patientId; }
    public UUID getCaregiverId() { return caregiverId; }
    public void setCaregiverId(UUID caregiverId) { this.caregiverId = caregiverId; }
    public Set<ConsentView> getAllowedViews() { return allowedViews; }
    public void setAllowedViews(Set<ConsentView> allowedViews) {
        this.allowedViews = allowedViews == null ? new LinkedHashSet<>() : new LinkedHashSet<>(allowedViews);
    }
    public CaregiverInvitationStatus getStatus() { return status; }
    public void setStatus(CaregiverInvitationStatus status) { this.status = status; }
    public LocalDateTime getExpiresAt() { return expiresAt; }
    public void setExpiresAt(LocalDateTime expiresAt) { this.expiresAt = expiresAt; }
    public LocalDateTime getRespondedAt() { return respondedAt; }
    public void setRespondedAt(LocalDateTime respondedAt) { this.respondedAt = respondedAt; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
