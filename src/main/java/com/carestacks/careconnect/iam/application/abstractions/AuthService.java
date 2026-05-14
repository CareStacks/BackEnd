package com.carestacks.careconnect.iam.application.abstractions;

import com.carestacks.careconnect.iam.application.iam.dtos.UserDto;
import com.carestacks.careconnect.iam.application.iam.dtos.SessionValidationDto;
import com.carestacks.careconnect.iam.application.iam.requests.LoginRequest;
import com.carestacks.careconnect.iam.application.iam.requests.LoginResponse;
import com.carestacks.careconnect.iam.application.iam.requests.RegisterUserRequest;
import com.carestacks.careconnect.iam.domain.iam.enums.UserRole;

import java.util.UUID;

public interface AuthService {

    LoginResponse register(RegisterUserRequest request);

    LoginResponse login(LoginRequest request);

    void logout(String token);

    UserDto getCurrentUser(UUID userId);

    boolean validateToken(String token);

    SessionValidationDto validateSession(String token, UserRole requiredRole);

    UUID getUserIdFromToken(String token);
}
