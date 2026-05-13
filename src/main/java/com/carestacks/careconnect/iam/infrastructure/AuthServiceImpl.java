package com.carestacks.careconnect.iam.infrastructure;

import com.carestacks.careconnect.iam.application.abstractions.AuthService;
import com.carestacks.careconnect.iam.application.iam.dtos.UserDto;
import com.carestacks.careconnect.iam.application.iam.requests.LoginRequest;
import com.carestacks.careconnect.iam.application.iam.requests.LoginResponse;
import com.carestacks.careconnect.iam.application.iam.requests.RegisterUserRequest;
import com.carestacks.careconnect.iam.domain.iam.entities.User;
import com.carestacks.careconnect.iam.infrastructure.mappers.UserMapper;
import com.carestacks.careconnect.iam.infrastructure.repositories.UserJpaRepository;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserJpaRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserJpaRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public LoginResponse register(RegisterUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BusinessRuleException("User with this email already exists");
        }

        var user = User.register(
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getFullName(),
                request.getRole()
        );

        var savedUser = userRepository.save(UserMapper.toEntity(user));
        var token = generateMockToken(savedUser.getId());

        return LoginResponse.of(token, 3600L); // 1 hour expiration
    }

    @Override
    @Transactional
    public LoginResponse login(LoginRequest request) {
        var userEntity = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), userEntity.getPasswordHash())) {
            userEntity.setFailedLoginAttempts(userEntity.getFailedLoginAttempts() + 1);
            if (userEntity.getFailedLoginAttempts() >= 5) {
                userEntity.setLockedUntil(UUID.randomUUID());
            }
            userRepository.save(userEntity);
            throw new BadCredentialsException("Invalid email or password");
        }

        var user = UserMapper.toDomain(userEntity);
        user.recordSuccessfulLogin();
        userRepository.save(UserMapper.toEntity(user));

        var token = generateMockToken(user.getId());
        return LoginResponse.of(token, 3600L);
    }

    @Override
    @Transactional
    public void logout(UUID userId) {
        // In a real app, you would blacklist the token
        // For simplicity, we just acknowledge the logout
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getCurrentUser(UUID userId) {
        var userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessRuleException("User not found"));
        return UserMapper.toDto(userEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean validateToken(String token) {
        // In a real app, you would validate JWT signature and expiration
        // For simplicity, we check if token is not null and follows our mock pattern
        return token != null && token.startsWith("mock-token-");
    }

    @Override
    @Transactional(readOnly = true)
    public UUID getUserIdFromToken(String token) {
        if (!validateToken(token)) {
            throw new BusinessRuleException("Invalid token");
        }
        // Extract user ID from mock token
        var userIdStr = token.replace("mock-token-", "");
        return UUID.fromString(userIdStr);
    }

    private String generateMockToken(UUID userId) {
        return "mock-token-" + userId;
    }
}