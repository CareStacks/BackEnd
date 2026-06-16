package com.carestacks.careconnect.consents.infrastructure.repositories;

import com.carestacks.careconnect.consents.infrastructure.persistence.ProfileShareConsentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileShareConsentJpaRepository extends JpaRepository<ProfileShareConsentJpaEntity, UUID> {

    List<ProfileShareConsentJpaEntity> findByPatientIdOrderByCreatedAtDesc(UUID patientId);

    Optional<ProfileShareConsentJpaEntity> findByCaregiverId(UUID caregiverId);

    Optional<ProfileShareConsentJpaEntity> findByCaregiverIdAndPatientId(UUID caregiverId, UUID patientId);

    Optional<ProfileShareConsentJpaEntity> findByIdAndPatientId(UUID id, UUID patientId);
}
