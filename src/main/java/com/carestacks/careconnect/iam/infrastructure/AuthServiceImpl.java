package com.carestacks.careconnect.iam.infrastructure;

import com.carestacks.careconnect.iam.application.abstractions.AuthService;
import com.carestacks.careconnect.iam.application.iam.dtos.SessionValidationDto;
import com.carestacks.careconnect.iam.application.iam.dtos.UserDto;
import com.carestacks.careconnect.iam.application.iam.requests.LoginRequest;
import com.carestacks.careconnect.iam.application.iam.requests.LoginResponse;
import com.carestacks.careconnect.iam.application.iam.requests.RegisterUserRequest;
import com.carestacks.careconnect.iam.domain.iam.entities.User;
import com.carestacks.careconnect.iam.domain.iam.enums.UserRole;
import com.carestacks.careconnect.iam.infrastructure.mappers.UserMapper;
import com.carestacks.careconnect.iam.infrastructure.repositories.UserJpaRepository;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;
import com.carestacks.careconnect.shared.domain.exceptions.ResourceNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthServiceImpl implements AuthService {

    private static final long SESSION_EXPIRATION_SECONDS = 30L * 60L;
    private static final String TOKEN_PREFIX = "mock-token-";

    private final UserJpaRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Set<String> revokedTokens = ConcurrentHashMap.newKeySet();

    public AuthServiceImpl(UserJpaRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public LoginResponse register(RegisterUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BusinessRuleException("Ya existe una cuenta registrada con ese correo electrónico");
        }

        var user = User.register(
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getFullName(),
                request.getRole()
        );

        var savedUser = userRepository.save(UserMapper.toEntity(user));
        var token = generateMockToken(savedUser.getId());

        return LoginResponse.of(token, SESSION_EXPIRATION_SECONDS);
    }

    @Override
    @Transactional
    public LoginResponse login(LoginRequest request) {
        var userEntity = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Correo o contraseña incorrectos"));

        if (!userEntity.isActive()) {
            throw new BadCredentialsException("La cuenta está inactiva. Contacta soporte para revisarla");
        }
        if (isLocked(userEntity.getLockedUntil())) {
            throw new LockedException("La cuenta está bloqueada temporalmente por varios intentos fallidos");
        }
        if (userEntity.getLockedUntil() != null) {
            userEntity.setLockedUntil(null);
            userEntity.setFailedLoginAttempts(0);
        }

        if (!passwordEncoder.matches(request.getPassword(), userEntity.getPasswordHash())) {
            userEntity.setFailedLoginAttempts(userEntity.getFailedLoginAttempts() + 1);
            if (userEntity.getFailedLoginAttempts() >= 5) {
                userEntity.setLockedUntil(LocalDateTime.now().plusMinutes(15));
            }
            userRepository.save(userEntity);
            throw new BadCredentialsException("Correo o contraseña incorrectos");
        }

        var user = UserMapper.toDomain(userEntity);
        user.recordSuccessfulLogin();
        userRepository.save(UserMapper.toEntity(user));

        var token = generateMockToken(user.getId());
        return LoginResponse.of(token, SESSION_EXPIRATION_SECONDS);
    }

    @Override
    @Transactional
    public void logout(String token) {
        validateTokenOrThrow(token);
        revokedTokens.add(token);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getCurrentUser(UUID userId) {
        var userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return UserMapper.toDto(userEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean validateToken(String token) {
        try {
            validateTokenOrThrow(token);
            return true;
        } catch (RuntimeException exception) {
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public SessionValidationDto validateSession(String token, UserRole requiredRole) {
        var parsedToken = validateTokenOrThrow(token);
        var userEntity = userRepository.findById(parsedToken.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!userEntity.isActive()) {
            throw new BadCredentialsException("La cuenta está inactiva. Contacta soporte para revisarla");
        }
        if (isLocked(userEntity.getLockedUntil())) {
            throw new LockedException("La cuenta está bloqueada temporalmente por varios intentos fallidos");
        }
        if (requiredRole != null && userEntity.getRole() != requiredRole) {
            throw new BadCredentialsException("No tienes permisos para realizar esta acción");
        }

        return new SessionValidationDto(true, userEntity.getId(), userEntity.getRole(), parsedToken.expiresAt());
    }

    @Override
    @Transactional(readOnly = true)
    public UUID getUserIdFromToken(String token) {
        return validateTokenOrThrow(token).userId();
    }

    private String generateMockToken(UUID userId) {
        var expiresAt = LocalDateTime.now().plusSeconds(SESSION_EXPIRATION_SECONDS);
        var expiresAtEpochSeconds = expiresAt.toEpochSecond(ZoneOffset.UTC);
        return TOKEN_PREFIX + userId + "." + expiresAtEpochSeconds;
    }

    private ParsedToken validateTokenOrThrow(String token) {
        if (token == null || !token.startsWith(TOKEN_PREFIX) || revokedTokens.contains(token)) {
            throw new BusinessRuleException("Tu sesión no está activa. Inicia sesión nuevamente");
        }

        var tokenPayload = token.substring(TOKEN_PREFIX.length());
        var separatorIndex = tokenPayload.lastIndexOf('.');
        if (separatorIndex <= 0 || separatorIndex == tokenPayload.length() - 1) {
            throw new BusinessRuleException("Tu sesión no está activa. Inicia sesión nuevamente");
        }

        try {
            var userId = UUID.fromString(tokenPayload.substring(0, separatorIndex));
            var expiresAtEpochSeconds = Long.parseLong(tokenPayload.substring(separatorIndex + 1));
            var expiresAt = LocalDateTime.ofEpochSecond(expiresAtEpochSeconds, 0, ZoneOffset.UTC);
            if (expiresAt.isBefore(LocalDateTime.now())) {
                throw new BusinessRuleException("Tu sesión expiró. Inicia sesión nuevamente");
            }
            return new ParsedToken(userId, expiresAt);
        } catch (IllegalArgumentException exception) {
            throw new BusinessRuleException("Tu sesión no está activa. Inicia sesión nuevamente");
        }
    }

    private boolean isLocked(LocalDateTime lockedUntil) {
        return lockedUntil != null && lockedUntil.isAfter(LocalDateTime.now());
    }

    private record ParsedToken(UUID userId, LocalDateTime expiresAt) {}
}
