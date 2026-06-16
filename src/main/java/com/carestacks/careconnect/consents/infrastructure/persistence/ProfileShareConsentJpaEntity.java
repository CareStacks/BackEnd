package com.carestacks.careconnect.consents.infrastructure.persistence;

import com.carestacks.careconnect.consents.domain.consents.enums.ConsentView;
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
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(
        name = "profile_share_consents",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_profile_share_consents_caregiver", columnNames = "caregiver_id"),
                @UniqueConstraint(name = "uk_profile_share_consents_patient_caregiver", columnNames = {"patient_id", "caregiver_id"})
        },
        indexes = {
                @Index(name = "idx_profile_share_consents_patient", columnList = "patient_id"),
                @Index(name = "idx_profile_share_consents_caregiver", columnList = "caregiver_id")
        }
)
public class ProfileShareConsentJpaEntity {

    @Id
    private UUID id;

    @Column(name = "patient_id", nullable = false)
    private UUID patientId;

    @Column(name = "caregiver_id", nullable = false)
    private UUID caregiverId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "profile_share_consent_views",
            joinColumns = @JoinColumn(name = "consent_id", nullable = false)
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "view_name", nullable = false, length = 40)
    private Set<ConsentView> allowedViews = new LinkedHashSet<>();

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    protected ProfileShareConsentJpaEntity() {}

    public ProfileShareConsentJpaEntity(
            UUID id,
            UUID patientId,
            UUID caregiverId,
            Set<ConsentView> allowedViews,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.patientId = patientId;
        this.caregiverId = caregiverId;
        setAllowedViews(allowedViews);
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
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
