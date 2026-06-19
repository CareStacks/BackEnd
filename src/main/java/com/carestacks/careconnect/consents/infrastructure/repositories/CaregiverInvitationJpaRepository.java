package com.carestacks.careconnect.consents.infrastructure.repositories;

import com.carestacks.careconnect.consents.domain.invitations.enums.CaregiverInvitationStatus;
import com.carestacks.careconnect.consents.infrastructure.persistence.CaregiverInvitationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CaregiverInvitationJpaRepository extends JpaRepository<CaregiverInvitationJpaEntity, UUID> {

    List<CaregiverInvitationJpaEntity> findByPatientIdOrderByCreatedAtDesc(UUID patientId);

    List<CaregiverInvitationJpaEntity> findByCaregiverIdOrderByCreatedAtDesc(UUID caregiverId);

    List<CaregiverInvitationJpaEntity> findByCaregiverIdAndStatusOrderByCreatedAtDesc(
            UUID caregiverId,
            CaregiverInvitationStatus status
    );

    Optional<CaregiverInvitationJpaEntity> findByPatientIdAndCaregiverIdAndStatus(
            UUID patientId,
            UUID caregiverId,
            CaregiverInvitationStatus status
    );

    Optional<CaregiverInvitationJpaEntity> findByIdAndCaregiverId(UUID id, UUID caregiverId);
}
