package com.carestacks.careconnect.consents.infrastructure;

import com.carestacks.careconnect.consents.application.abstractions.CaregiverInvitationService;
import com.carestacks.careconnect.consents.application.invitations.dtos.CaregiverInvitationDto;
import com.carestacks.careconnect.consents.application.invitations.requests.CreateCaregiverInvitationRequest;
import com.carestacks.careconnect.consents.domain.consents.entities.ProfileShareConsent;
import com.carestacks.careconnect.consents.domain.consents.enums.ConsentView;
import com.carestacks.careconnect.consents.domain.invitations.enums.CaregiverInvitationStatus;
import com.carestacks.careconnect.consents.infrastructure.mappers.ProfileShareConsentMapper;
import com.carestacks.careconnect.consents.infrastructure.persistence.CaregiverInvitationJpaEntity;
import com.carestacks.careconnect.consents.infrastructure.repositories.CaregiverInvitationJpaRepository;
import com.carestacks.careconnect.consents.infrastructure.repositories.ProfileShareConsentJpaRepository;
import com.carestacks.careconnect.iam.application.abstractions.AuthService;
import com.carestacks.careconnect.iam.domain.iam.enums.UserRole;
import com.carestacks.careconnect.iam.infrastructure.persistence.UserJpaEntity;
import com.carestacks.careconnect.iam.infrastructure.repositories.UserJpaRepository;
import com.carestacks.careconnect.notifications.application.abstractions.NotificationService;
import com.carestacks.careconnect.notifications.application.notifications.requests.CreateNotificationRequest;
import com.carestacks.careconnect.notifications.domain.notifications.enums.DeliveryChannel;
import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationPriority;
import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationType;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;
import com.carestacks.careconnect.shared.domain.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CaregiverInvitationServiceImpl implements CaregiverInvitationService {

    private static final int INVITATION_EXPIRATION_DAYS = 7;

    private final CaregiverInvitationJpaRepository invitationRepository;
    private final ProfileShareConsentJpaRepository consentRepository;
    private final UserJpaRepository userRepository;
    private final AuthService authService;
    private final NotificationService notificationService;

    public CaregiverInvitationServiceImpl(
            CaregiverInvitationJpaRepository invitationRepository,
            ProfileShareConsentJpaRepository consentRepository,
            UserJpaRepository userRepository,
            AuthService authService,
            NotificationService notificationService
    ) {
        this.invitationRepository = invitationRepository;
        this.consentRepository = consentRepository;
        this.userRepository = userRepository;
        this.authService = authService;
        this.notificationService = notificationService;
    }

    @Override
    @Transactional
    public CaregiverInvitationDto createInvitation(String token, CreateCaregiverInvitationRequest request) {
        var patientId = requireSessionUser(token, UserRole.PATIENT);
        var patient = requireActiveUserWithRole(getUserOrThrow(patientId, "Patient not found"), UserRole.PATIENT, "Patient");
        var caregiver = resolveCaregiver(request);

        if (patient.getId().equals(caregiver.getId())) {
            throw new BusinessRuleException("Patient and caregiver must be different users");
        }
        if (consentRepository.findByCaregiverIdAndPatientId(caregiver.getId(), patient.getId()).isPresent()) {
            throw new BusinessRuleException("This caregiver already has active access to this patient profile");
        }

        var allowedViews = normalizeAllowedViews(request.getAllowedViews());
        var existingPending = invitationRepository.findByPatientIdAndCaregiverIdAndStatus(
                patient.getId(),
                caregiver.getId(),
                CaregiverInvitationStatus.PENDING
        );

        var entity = existingPending.orElseGet(CaregiverInvitationJpaEntity::new);
        entity.setPatientId(patient.getId());
        entity.setCaregiverId(caregiver.getId());
        entity.setAllowedViews(allowedViews);
        entity.setStatus(CaregiverInvitationStatus.PENDING);
        entity.setRespondedAt(null);
        entity.setExpiresAt(LocalDateTime.now().plusDays(INVITATION_EXPIRATION_DAYS));

        var savedInvitation = invitationRepository.save(entity);
        notifyCaregiverInvitation(patient, caregiver, savedInvitation);
        return toDto(savedInvitation);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CaregiverInvitationDto> getMyPatientInvitations(String token) {
        var patientId = requireSessionUser(token, UserRole.PATIENT);
        return invitationRepository.findByPatientIdOrderByCreatedAtDesc(patientId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CaregiverInvitationDto> getMyCaregiverInvitations(String token) {
        var caregiverId = requireSessionUser(token, UserRole.CAREGIVER);
        return invitationRepository.findByCaregiverIdOrderByCreatedAtDesc(caregiverId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CaregiverInvitationDto> getMyPendingCaregiverInvitations(String token) {
        var caregiverId = requireSessionUser(token, UserRole.CAREGIVER);
        return invitationRepository.findByCaregiverIdAndStatusOrderByCreatedAtDesc(
                        caregiverId,
                        CaregiverInvitationStatus.PENDING
                )
                .stream()
                .filter(invitation -> !isExpired(invitation))
                .map(this::toDto)
                .toList();
    }

    @Override
    @Transactional
    public CaregiverInvitationDto acceptInvitation(String token, UUID invitationId) {
        var caregiverId = requireSessionUser(token, UserRole.CAREGIVER);
        var invitation = findCaregiverInvitation(invitationId, caregiverId);
        ensurePending(invitation);

        var patient = getUserOrThrow(invitation.getPatientId(), "Patient not found");
        var caregiver = getUserOrThrow(invitation.getCaregiverId(), "Caregiver not found");
        grantConsentFromInvitation(invitation);

        invitation.setStatus(CaregiverInvitationStatus.ACCEPTED);
        invitation.setRespondedAt(LocalDateTime.now());
        var savedInvitation = invitationRepository.save(invitation);
        notifyPatientInvitationResponse(patient, caregiver, "Invitación aceptada", caregiver.getFullName() + " aceptó tu invitación de cuidado.");
        return toDto(savedInvitation);
    }

    @Override
    @Transactional
    public CaregiverInvitationDto rejectInvitation(String token, UUID invitationId) {
        var caregiverId = requireSessionUser(token, UserRole.CAREGIVER);
        var invitation = findCaregiverInvitation(invitationId, caregiverId);
        ensurePending(invitation);

        var patient = getUserOrThrow(invitation.getPatientId(), "Patient not found");
        var caregiver = getUserOrThrow(invitation.getCaregiverId(), "Caregiver not found");

        invitation.setStatus(CaregiverInvitationStatus.REJECTED);
        invitation.setRespondedAt(LocalDateTime.now());
        var savedInvitation = invitationRepository.save(invitation);
        notifyPatientInvitationResponse(patient, caregiver, "Invitación rechazada", caregiver.getFullName() + " rechazó tu invitación de cuidado.");
        return toDto(savedInvitation);
    }

    private void grantConsentFromInvitation(CaregiverInvitationJpaEntity invitation) {
        var existingConsent = consentRepository.findByCaregiverIdAndPatientId(
                invitation.getCaregiverId(),
                invitation.getPatientId()
        );

        if (existingConsent.isPresent()) {
            var entity = existingConsent.get();
            var consent = ProfileShareConsentMapper.toDomain(entity);
            consent.updateAllowedViews(invitation.getAllowedViews());
            ProfileShareConsentMapper.copyToEntity(consent, entity);
            consentRepository.save(entity);
            return;
        }

        var consent = ProfileShareConsent.grant(
                invitation.getPatientId(),
                invitation.getCaregiverId(),
                invitation.getAllowedViews()
        );
        consentRepository.save(ProfileShareConsentMapper.toEntity(consent));
    }

    private CaregiverInvitationJpaEntity findCaregiverInvitation(UUID invitationId, UUID caregiverId) {
        return invitationRepository.findByIdAndCaregiverId(invitationId, caregiverId)
                .orElseThrow(() -> new ResourceNotFoundException("Invitation not found for current caregiver"));
    }

    private void ensurePending(CaregiverInvitationJpaEntity invitation) {
        if (invitation.getStatus() != CaregiverInvitationStatus.PENDING) {
            throw new BusinessRuleException("Invitation is already " + invitation.getStatus().name().toLowerCase());
        }
        if (isExpired(invitation)) {
            invitation.setStatus(CaregiverInvitationStatus.EXPIRED);
            invitation.setRespondedAt(LocalDateTime.now());
            invitationRepository.save(invitation);
            throw new BusinessRuleException("Invitation has expired");
        }
    }

    private boolean isExpired(CaregiverInvitationJpaEntity invitation) {
        return invitation.getExpiresAt() != null && invitation.getExpiresAt().isBefore(LocalDateTime.now());
    }

    private UserJpaEntity resolveCaregiver(CreateCaregiverInvitationRequest request) {
        var hasCaregiverId = request.getCaregiverId() != null;
        var hasCaregiverEmail = request.getCaregiverEmail() != null && !request.getCaregiverEmail().isBlank();

        if (!hasCaregiverId && !hasCaregiverEmail) {
            throw new BusinessRuleException("Caregiver id or email is required");
        }

        UserJpaEntity caregiver = null;
        if (hasCaregiverId) {
            caregiver = getUserOrThrow(request.getCaregiverId(), "Caregiver not found");
        }

        if (hasCaregiverEmail) {
            var normalizedEmail = request.getCaregiverEmail().trim().toLowerCase();
            var caregiverByEmail = userRepository.findByEmail(normalizedEmail)
                    .orElseThrow(() -> new ResourceNotFoundException("Caregiver not found"));
            if (caregiver != null && !caregiver.getId().equals(caregiverByEmail.getId())) {
                throw new BusinessRuleException("Caregiver id and email refer to different users");
            }
            caregiver = caregiverByEmail;
        }

        return requireActiveUserWithRole(caregiver, UserRole.CAREGIVER, "Caregiver");
    }

    private Set<ConsentView> normalizeAllowedViews(Set<ConsentView> values) {
        if (values == null || values.isEmpty()) {
            throw new BusinessRuleException("At least one consent view is required");
        }

        var normalizedValues = new LinkedHashSet<ConsentView>();
        normalizedValues.add(ConsentView.PROFILE);
        for (ConsentView value : values) {
            if (value == null) {
                throw new BusinessRuleException("Consent view cannot be null");
            }
            normalizedValues.add(value);
        }
        return normalizedValues;
    }

    private UUID requireSessionUser(String token, UserRole role) {
        return authService.validateSession(token, role).userId();
    }

    private UserJpaEntity requireActiveUserWithRole(UserJpaEntity user, UserRole role, String label) {
        if (user.getRole() != role) {
            throw new BusinessRuleException(label + " must have role " + role);
        }
        if (!user.isActive()) {
            throw new BusinessRuleException(label + " must be active");
        }
        return user;
    }

    private UserJpaEntity getUserOrThrow(UUID userId, String message) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(message));
    }

    private void notifyCaregiverInvitation(
            UserJpaEntity patient,
            UserJpaEntity caregiver,
            CaregiverInvitationJpaEntity invitation
    ) {
        createAndSendNotification(
                caregiver.getId(),
                "Invitación de cuidado",
                patient.getFullName() + " quiere compartir su perfil contigo. Invitación: " + invitation.getId(),
                NotificationType.INVITATION,
                NotificationPriority.HIGH
        );
    }

    private void notifyPatientInvitationResponse(
            UserJpaEntity patient,
            UserJpaEntity caregiver,
            String title,
            String message
    ) {
        createAndSendNotification(
                patient.getId(),
                title,
                message,
                NotificationType.INFO,
                NotificationPriority.MEDIUM
        );
    }

    private void createAndSendNotification(
            UUID recipientId,
            String title,
            String message,
            NotificationType type,
            NotificationPriority priority
    ) {
        var request = new CreateNotificationRequest();
        request.setRecipientId(recipientId);
        request.setTitle(title);
        request.setMessage(message);
        request.setType(type);
        request.setPriority(priority);
        request.setDeliveryChannel(DeliveryChannel.IN_APP);
        request.setScheduledAt(LocalDateTime.now());

        var notification = notificationService.create(request);
        notificationService.markAsSent(notification.id());
    }

    private CaregiverInvitationDto toDto(CaregiverInvitationJpaEntity entity) {
        var patient = getUserOrThrow(entity.getPatientId(), "Patient not found");
        var caregiver = getUserOrThrow(entity.getCaregiverId(), "Caregiver not found");
        return new CaregiverInvitationDto(
                entity.getId(),
                entity.getPatientId(),
                patient.getFullName(),
                patient.getEmail(),
                entity.getCaregiverId(),
                caregiver.getFullName(),
                caregiver.getEmail(),
                entity.getAllowedViews(),
                entity.getStatus(),
                entity.getExpiresAt(),
                entity.getRespondedAt(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
