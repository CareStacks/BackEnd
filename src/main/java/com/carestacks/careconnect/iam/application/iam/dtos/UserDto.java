package com.carestacks.careconnect.iam.application.iam.dtos;

import com.carestacks.careconnect.iam.domain.iam.enums.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDto(
        UUID id,
        String email,
        String fullName,
        UserRole role,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}