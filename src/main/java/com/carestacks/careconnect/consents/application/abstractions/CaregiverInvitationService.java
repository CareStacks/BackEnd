package com.carestacks.careconnect.consents.application.abstractions;

import com.carestacks.careconnect.consents.application.invitations.dtos.CaregiverInvitationDto;
import com.carestacks.careconnect.consents.application.invitations.requests.CreateCaregiverInvitationRequest;

import java.util.List;
import java.util.UUID;

public interface CaregiverInvitationService {

    CaregiverInvitationDto createInvitation(String token, CreateCaregiverInvitationRequest request);

    List<CaregiverInvitationDto> getMyPatientInvitations(String token);

    List<CaregiverInvitationDto> getMyCaregiverInvitations(String token);

    List<CaregiverInvitationDto> getMyPendingCaregiverInvitations(String token);

    CaregiverInvitationDto acceptInvitation(String token, UUID invitationId);

    CaregiverInvitationDto rejectInvitation(String token, UUID invitationId);
}
