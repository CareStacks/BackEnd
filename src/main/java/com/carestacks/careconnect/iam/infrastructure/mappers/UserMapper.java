package com.carestacks.careconnect.iam.infrastructure.mappers;

import com.carestacks.careconnect.iam.application.iam.dtos.UserDto;
import com.carestacks.careconnect.iam.domain.iam.entities.User;
import com.carestacks.careconnect.iam.infrastructure.persistence.UserJpaEntity;

public class UserMapper {

    public static UserDto toDto(UserJpaEntity entity) {
        return new UserDto(
                entity.getId(),
                entity.getEmail(),
                entity.getFullName(),
                entity.getRole(),
                entity.isActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static User toDomain(UserJpaEntity entity) {
        return new User(
                entity.getId(),
                entity.getEmail(),
                entity.getPasswordHash(),
                entity.getFullName(),
                entity.getRole(),
                entity.isActive(),
                entity.getFailedLoginAttempts(),
                entity.getLockedUntil(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static UserJpaEntity toEntity(User user) {
        return new UserJpaEntity(
                user.getId(),
                user.getEmail(),
                user.getPasswordHash(),
                user.getFullName(),
                user.getRole(),
                user.isActive(),
                user.getFailedLoginAttempts(),
                user.getLockedUntil(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    public static void copyToEntity(User user, UserJpaEntity entity) {
        entity.setFullName(user.getFullName());
        entity.setPasswordHash(user.getPasswordHash());
        entity.setActive(user.isActive());
        entity.setFailedLoginAttempts(user.getFailedLoginAttempts());
        entity.setLockedUntil(user.getLockedUntil());
    }
}
