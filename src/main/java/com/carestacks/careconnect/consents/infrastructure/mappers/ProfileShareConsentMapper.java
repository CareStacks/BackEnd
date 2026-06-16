package com.carestacks.careconnect.consents.infrastructure.mappers;

import com.carestacks.careconnect.consents.application.consents.dtos.ProfileShareConsentDto;
import com.carestacks.careconnect.consents.domain.consents.entities.ProfileShareConsent;
import com.carestacks.careconnect.consents.infrastructure.persistence.ProfileShareConsentJpaEntity;
import com.carestacks.careconnect.iam.infrastructure.persistence.UserJpaEntity;

public class ProfileShareConsentMapper {

    public static ProfileShareConsent toDomain(ProfileShareConsentJpaEntity entity) {
        return new ProfileShareConsent(
                entity.getId(),
                entity.getPatientId(),
                entity.getCaregiverId(),
                entity.getAllowedViews(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static ProfileShareConsentJpaEntity toEntity(ProfileShareConsent consent) {
        return new ProfileShareConsentJpaEntity(
                consent.getId(),
                consent.getPatientId(),
                consent.getCaregiverId(),
                consent.getAllowedViews(),
                consent.getCreatedAt(),
                consent.getUpdatedAt()
        );
    }

    public static void copyToEntity(ProfileShareConsent consent, ProfileShareConsentJpaEntity entity) {
        entity.setAllowedViews(consent.getAllowedViews());
        entity.setUpdatedAt(consent.getUpdatedAt());
    }

    public static ProfileShareConsentDto toDto(
            ProfileShareConsentJpaEntity entity,
            UserJpaEntity patient,
            UserJpaEntity caregiver
    ) {
        return new ProfileShareConsentDto(
                entity.getId(),
                entity.getPatientId(),
                patient.getFullName(),
                entity.getCaregiverId(),
                caregiver.getFullName(),
                entity.getAllowedViews(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
