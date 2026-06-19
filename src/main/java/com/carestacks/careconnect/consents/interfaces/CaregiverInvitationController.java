package com.carestacks.careconnect.consents.interfaces;

import com.carestacks.careconnect.consents.application.abstractions.CaregiverInvitationService;
import com.carestacks.careconnect.consents.application.invitations.dtos.CaregiverInvitationDto;
import com.carestacks.careconnect.consents.application.invitations.requests.CreateCaregiverInvitationRequest;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/invitations")
@Tag(name = "Invitaciones de Cuidadores", description = "Pending access invitations between patients and caregivers")
public class CaregiverInvitationController {

    private final CaregiverInvitationService invitationService;

    public CaregiverInvitationController(CaregiverInvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @Operation(summary = "Invite a caregiver", description = "Creates or refreshes a pending caregiver invitation and notifies the caregiver.")
    @ApiResponse(responseCode = "201", description = "Invitation created")
    @PostMapping
    public ResponseEntity<CaregiverInvitationDto> createInvitation(
            @RequestHeader("Authorization") String authorizationHeader,
            @Valid @RequestBody CreateCaregiverInvitationRequest request
    ) {
        var invitation = invitationService.createInvitation(extractBearerToken(authorizationHeader), request);
        return ResponseEntity.created(URI.create("/api/invitations/" + invitation.id())).body(invitation);
    }

    @Operation(summary = "List invitations sent by current patient")
    @GetMapping("/me/patient")
    public ResponseEntity<List<CaregiverInvitationDto>> getMyPatientInvitations(
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        return ResponseEntity.ok(invitationService.getMyPatientInvitations(extractBearerToken(authorizationHeader)));
    }

    @Operation(summary = "List invitations received by current caregiver")
    @GetMapping("/me/caregiver")
    public ResponseEntity<List<CaregiverInvitationDto>> getMyCaregiverInvitations(
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        return ResponseEntity.ok(invitationService.getMyCaregiverInvitations(extractBearerToken(authorizationHeader)));
    }

    @Operation(summary = "List pending invitations received by current caregiver")
    @GetMapping("/me/caregiver/pending")
    public ResponseEntity<List<CaregiverInvitationDto>> getMyPendingCaregiverInvitations(
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        return ResponseEntity.ok(invitationService.getMyPendingCaregiverInvitations(extractBearerToken(authorizationHeader)));
    }

    @Operation(summary = "Accept invitation", description = "Accepts a pending caregiver invitation and creates the profile sharing consent.")
    @PatchMapping("/{invitationId}/accept")
    public ResponseEntity<CaregiverInvitationDto> acceptInvitation(
            @RequestHeader("Authorization") String authorizationHeader,
            @Parameter(description = "Invitation identifier") @PathVariable UUID invitationId
    ) {
        return ResponseEntity.ok(invitationService.acceptInvitation(extractBearerToken(authorizationHeader), invitationId));
    }

    @Operation(summary = "Reject invitation", description = "Rejects a pending caregiver invitation.")
    @PatchMapping("/{invitationId}/reject")
    public ResponseEntity<CaregiverInvitationDto> rejectInvitation(
            @RequestHeader("Authorization") String authorizationHeader,
            @Parameter(description = "Invitation identifier") @PathVariable UUID invitationId
    ) {
        return ResponseEntity.ok(invitationService.rejectInvitation(extractBearerToken(authorizationHeader), invitationId));
    }

    private String extractBearerToken(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new BusinessRuleException("Authorization header must use Bearer token format");
        }
        return authorizationHeader.substring(7);
    }
}
