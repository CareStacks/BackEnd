package com.carestacks.careconnect.iam.application.abstractions;

import com.carestacks.careconnect.iam.application.iam.dtos.UserDto;
import com.carestacks.careconnect.iam.application.iam.requests.LoginRequest;
import com.carestacks.careconnect.iam.application.iam.requests.LoginResponse;
import com.carestacks.careconnect.iam.application.iam.requests.RegisterUserRequest;

import java.util.UUID;

public interface AuthService {

    LoginResponse register(RegisterUserRequest request);

    LoginResponse login(LoginRequest request);

    void logout(UUID userId);

    UserDto getCurrentUser(UUID userId);

    boolean validateToken(String token);

    UUID getUserIdFromToken(String token);
}