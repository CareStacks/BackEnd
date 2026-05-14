package com.carestacks.careconnect.iam.interfaces;

import com.carestacks.careconnect.iam.application.abstractions.AuthService;
import com.carestacks.careconnect.iam.application.iam.dtos.SessionValidationDto;
import com.carestacks.careconnect.iam.application.iam.dtos.UserDto;
import com.carestacks.careconnect.iam.application.iam.requests.LoginRequest;
import com.carestacks.careconnect.iam.application.iam.requests.LoginResponse;
import com.carestacks.careconnect.iam.application.iam.requests.RegisterUserRequest;
import com.carestacks.careconnect.iam.domain.iam.enums.UserRole;
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
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "IAM", description = "Identity, authentication, session, and role validation endpoints")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Register a user", description = "Creates a patient or caregiver account with a unique email and strong password.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User registered",
                    content = @Content(schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request or duplicated email")
    })
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody RegisterUserRequest request) {
        var loginResponse = authService.register(request);
        var userDto = authService.getCurrentUser(
                authService.getUserIdFromToken(loginResponse.token()));
        return ResponseEntity.created(URI.create("/api/auth/me")).body(userDto);
    }

    @Operation(summary = "Log in", description = "Authenticates a user and returns a mock bearer token that expires after 30 minutes.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login succeeded",
                    content = @Content(schema = @Schema(implementation = LoginResponse.class))),
            @ApiResponse(responseCode = "401", description = "Invalid credentials"),
            @ApiResponse(responseCode = "423", description = "Account temporarily locked")
    })
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @Operation(summary = "Log out", description = "Revokes the provided mock bearer token for the current application instance.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Logout succeeded"),
            @ApiResponse(responseCode = "400", description = "Invalid bearer token")
    })
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String token) {
        var jwt = extractBearerToken(token);
        authService.logout(jwt);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get current user", description = "Returns the user represented by the provided bearer token.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Current user returned",
                    content = @Content(schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid bearer token"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser(@RequestHeader("Authorization") String token) {
        var jwt = extractBearerToken(token);
        var userId = authService.getUserIdFromToken(jwt);
        var userDto = authService.getCurrentUser(userId);
        return ResponseEntity.ok(userDto);
    }

    @Operation(summary = "Validate session", description = "Validates a bearer token and optionally checks that the user has a required role.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Session is valid",
                    content = @Content(schema = @Schema(implementation = SessionValidationDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid or expired bearer token"),
            @ApiResponse(responseCode = "401", description = "Role validation failed"),
            @ApiResponse(responseCode = "423", description = "Account temporarily locked")
    })
    @GetMapping("/validate")
    public ResponseEntity<SessionValidationDto> validateSession(
            @RequestHeader("Authorization") String token,
            @Parameter(description = "Optional role required for the current operation")
            @RequestParam(required = false) UserRole role
    ) {
        return ResponseEntity.ok(authService.validateSession(extractBearerToken(token), role));
    }

    private String extractBearerToken(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new BusinessRuleException("Authorization header must use Bearer token format");
        }
        return authorizationHeader.substring(7);
    }
}
