package com.carestacks.careconnect.consents.infrastructure;

import com.carestacks.careconnect.consents.application.abstractions.ConsentManagementService;
import com.carestacks.careconnect.consents.application.consents.dtos.CaregiverAccessDto;
import com.carestacks.careconnect.consents.application.consents.dtos.ProfileShareConsentDto;
import com.carestacks.careconnect.consents.application.consents.requests.GrantConsentRequest;
import com.carestacks.careconnect.consents.application.consents.requests.UpdateConsentViewsRequest;
import com.carestacks.careconnect.consents.domain.consents.entities.ProfileShareConsent;
import com.carestacks.careconnect.consents.domain.consents.enums.ConsentView;
import com.carestacks.careconnect.consents.infrastructure.mappers.ProfileShareConsentMapper;
import com.carestacks.careconnect.consents.infrastructure.persistence.ProfileShareConsentJpaEntity;
import com.carestacks.careconnect.consents.infrastructure.repositories.ProfileShareConsentJpaRepository;
import com.carestacks.careconnect.iam.application.abstractions.AuthService;
import com.carestacks.careconnect.iam.domain.iam.enums.UserRole;
import com.carestacks.careconnect.iam.infrastructure.persistence.UserJpaEntity;
import com.carestacks.careconnect.iam.infrastructure.repositories.UserJpaRepository;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;
import com.carestacks.careconnect.shared.domain.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ConsentManagementServiceImpl implements ConsentManagementService {

    private final ProfileShareConsentJpaRepository consentRepository;
    private final UserJpaRepository userRepository;
    private final AuthService authService;

    public ConsentManagementServiceImpl(
            ProfileShareConsentJpaRepository consentRepository,
            UserJpaRepository userRepository,
            AuthService authService
    ) {
        this.consentRepository = consentRepository;
        this.userRepository = userRepository;
        this.authService = authService;
    }

    @Override
    public ProfileShareConsentDto grantOrUpdateConsent(String token, GrantConsentRequest request) {
        var patientId = requireSessionUser(token, UserRole.PATIENT);
        var patient = getUserOrThrow(patientId, "Patient not found");
        var caregiver = resolveCaregiver(request);

        var existingConsent = consentRepository.findByCaregiverId(caregiver.getId());
        if (existingConsent.isPresent()) {
            var entity = existingConsent.get();
            if (!entity.getPatientId().equals(patientId)) {
                throw new BusinessRuleException("Caregiver already has a shared patient profile");
            }

            var consent = ProfileShareConsentMapper.toDomain(entity);
            consent.updateAllowedViews(request.getAllowedViews());
            ProfileShareConsentMapper.copyToEntity(consent, entity);
            return toDto(consentRepository.save(entity));
        }

        var consent = ProfileShareConsent.grant(patient.getId(), caregiver.getId(), request.getAllowedViews());
        try {
            return toDto(consentRepository.save(ProfileShareConsentMapper.toEntity(consent)));
        } catch (DataIntegrityViolationException exception) {
            throw new BusinessRuleException("Caregiver already has a shared patient profile");
        }
    }

    @Override
    public ProfileShareConsentDto updateAllowedViews(String token, UUID consentId, UpdateConsentViewsRequest request) {
        var patientId = requireSessionUser(token, UserRole.PATIENT);
        var entity = consentRepository.findByIdAndPatientId(consentId, patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Consent not found for current patient"));

        var consent = ProfileShareConsentMapper.toDomain(entity);
        consent.updateAllowedViews(request.getAllowedViews());
        ProfileShareConsentMapper.copyToEntity(consent, entity);

        return toDto(consentRepository.save(entity));
    }

    @Override
    public void revokeConsent(String token, UUID consentId) {
        var patientId = requireSessionUser(token, UserRole.PATIENT);
        var entity = consentRepository.findByIdAndPatientId(consentId, patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Consent not found for current patient"));
        consentRepository.delete(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfileShareConsentDto> getMyGrantedConsents(String token) {
        var patientId = requireSessionUser(token, UserRole.PATIENT);
        return consentRepository.findByPatientIdOrderByCreatedAtDesc(patientId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProfileShareConsentDto getMyCaregiverProfile(String token) {
        var caregiverId = requireSessionUser(token, UserRole.CAREGIVER);
        var entity = consentRepository.findByCaregiverId(caregiverId)
                .orElseThrow(() -> new ResourceNotFoundException("Caregiver has no shared patient profile"));
        return toDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public CaregiverAccessDto validateCaregiverAccess(String token, UUID patientId, ConsentView view) {
        var caregiverId = requireSessionUser(token, UserRole.CAREGIVER);
        var entity = consentRepository.findByCaregiverIdAndPatientId(caregiverId, patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Caregiver has no access to this patient profile"));

        var consent = ProfileShareConsentMapper.toDomain(entity);
        return new CaregiverAccessDto(
                patientId,
                caregiverId,
                view,
                consent.allows(view),
                consent.getAllowedViews()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public boolean canCaregiverView(UUID caregiverId, UUID patientId, ConsentView view) {
        if (caregiverId == null || patientId == null || view == null) {
            return false;
        }

        return consentRepository.findByCaregiverIdAndPatientId(caregiverId, patientId)
                .map(ProfileShareConsentMapper::toDomain)
                .map(consent -> consent.allows(view))
                .orElse(false);
    }

    private UUID requireSessionUser(String token, UserRole role) {
        return authService.validateSession(token, role).userId();
    }

    private UserJpaEntity requireActiveUserWithRole(UUID userId, UserRole role, String label) {
        var user = getUserOrThrow(userId, label + " not found");
        return requireActiveUserWithRole(user, role, label);
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

    private UserJpaEntity resolveCaregiver(GrantConsentRequest request) {
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

    private UserJpaEntity getUserOrThrow(UUID userId, String message) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(message));
    }

    private ProfileShareConsentDto toDto(ProfileShareConsentJpaEntity entity) {
        var patient = getUserOrThrow(entity.getPatientId(), "Patient not found");
        var caregiver = getUserOrThrow(entity.getCaregiverId(), "Caregiver not found");
        return ProfileShareConsentMapper.toDto(entity, patient, caregiver);
    }
}
