package com.carestacks.careconnect.iam.application.iam.dtos;

import com.carestacks.careconnect.iam.domain.iam.enums.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

public record SessionValidationDto(
        boolean valid,
        UUID userId,
        UserRole role,
        LocalDateTime expiresAt
) {
}
