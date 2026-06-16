package com.carestacks.careconnect.consents.interfaces;

import com.carestacks.careconnect.consents.application.abstractions.ConsentManagementService;
import com.carestacks.careconnect.consents.application.consents.dtos.CaregiverAccessDto;
import com.carestacks.careconnect.consents.application.consents.dtos.ProfileShareConsentDto;
import com.carestacks.careconnect.consents.application.consents.requests.GrantConsentRequest;
import com.carestacks.careconnect.consents.application.consents.requests.UpdateConsentViewsRequest;
import com.carestacks.careconnect.consents.domain.consents.enums.ConsentView;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/consents")
@Tag(name = "Gestión de Consentimiento", description = "Profile sharing permissions between patients and caregivers")
public class ConsentManagementController {

    private final ConsentManagementService consentManagementService;

    public ConsentManagementController(ConsentManagementService consentManagementService) {
        this.consentManagementService = consentManagementService;
    }

    @Operation(summary = "Share patient profile with a caregiver", description = "A patient grants or updates the views a caregiver can see. A caregiver can have only one shared patient profile.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Consent created or updated",
                    content = @Content(schema = @Schema(implementation = ProfileShareConsentDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request or caregiver already linked to another profile"),
            @ApiResponse(responseCode = "401", description = "Token role is not authorized")
    })
    @PostMapping
    public ResponseEntity<ProfileShareConsentDto> grantConsent(
            @RequestHeader("Authorization") String authorizationHeader,
            @Valid @RequestBody GrantConsentRequest request
    ) {
        var consent = consentManagementService.grantOrUpdateConsent(extractBearerToken(authorizationHeader), request);
        return ResponseEntity.created(URI.create("/api/consents/" + consent.id())).body(consent);
    }

    @Operation(summary = "List my granted consents", description = "Returns profile sharing consents created by the current patient.")
    @ApiResponse(responseCode = "200", description = "Consents returned")
    @GetMapping("/me/patient")
    public ResponseEntity<List<ProfileShareConsentDto>> getMyGrantedConsents(
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        return ResponseEntity.ok(consentManagementService.getMyGrantedConsents(extractBearerToken(authorizationHeader)));
    }

    @Operation(summary = "Get my shared patient profile", description = "Returns the patient profile and visible views assigned to the current caregiver.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Shared profile returned"),
            @ApiResponse(responseCode = "404", description = "No shared patient profile found")
    })
    @GetMapping("/me/caregiver")
    public ResponseEntity<ProfileShareConsentDto> getMyCaregiverProfile(
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        return ResponseEntity.ok(consentManagementService.getMyCaregiverProfile(extractBearerToken(authorizationHeader)));
    }

    @Operation(summary = "Validate caregiver access to a view", description = "Checks whether the current caregiver can see a specific patient view.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Access validation returned",
                    content = @Content(schema = @Schema(implementation = CaregiverAccessDto.class))),
            @ApiResponse(responseCode = "404", description = "Caregiver has no access to this patient")
    })
    @GetMapping("/me/caregiver/access")
    public ResponseEntity<CaregiverAccessDto> validateCaregiverAccess(
            @RequestHeader("Authorization") String authorizationHeader,
            @Parameter(description = "Patient identifier") @RequestParam UUID patientId,
            @Parameter(description = "View that caregiver wants to open") @RequestParam ConsentView view
    ) {
        return ResponseEntity.ok(consentManagementService.validateCaregiverAccess(
                extractBearerToken(authorizationHeader),
                patientId,
                view
        ));
    }

    @Operation(summary = "Update visible views", description = "A patient updates which views a caregiver can see.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Consent views updated"),
            @ApiResponse(responseCode = "404", description = "Consent not found for current patient")
    })
    @PutMapping("/{consentId}/views")
    public ResponseEntity<ProfileShareConsentDto> updateAllowedViews(
            @RequestHeader("Authorization") String authorizationHeader,
            @Parameter(description = "Consent identifier") @PathVariable UUID consentId,
            @Valid @RequestBody UpdateConsentViewsRequest request
    ) {
        return ResponseEntity.ok(consentManagementService.updateAllowedViews(
                extractBearerToken(authorizationHeader),
                consentId,
                request
        ));
    }

    @Operation(summary = "Revoke profile sharing consent", description = "A patient removes a caregiver's access to their profile.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Consent revoked"),
            @ApiResponse(responseCode = "404", description = "Consent not found for current patient")
    })
    @DeleteMapping("/{consentId}")
    public ResponseEntity<Void> revokeConsent(
            @RequestHeader("Authorization") String authorizationHeader,
            @Parameter(description = "Consent identifier") @PathVariable UUID consentId
    ) {
        consentManagementService.revokeConsent(extractBearerToken(authorizationHeader), consentId);
        return ResponseEntity.noContent().build();
    }

    private String extractBearerToken(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new BusinessRuleException("Authorization header must use Bearer token format");
        }
        return authorizationHeader.substring(7);
    }
}
