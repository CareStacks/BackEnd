package com.carestacks.careconnect.iam.domain.iam.entities;

import com.carestacks.careconnect.iam.domain.iam.enums.UserRole;
import com.carestacks.careconnect.shared.domain.entities.AuditableEntity;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;

import java.time.LocalDateTime;
import java.util.UUID;

public class User extends AuditableEntity {

    private String email;
    private String passwordHash;
    private String fullName;
    private UserRole role;
    private boolean active;
    private int failedLoginAttempts;
    private LocalDateTime lockedUntil;

    public User(
            UUID id,
            String email,
            String passwordHash,
            String fullName,
            UserRole role,
            boolean active,
            int failedLoginAttempts,
            LocalDateTime lockedUntil,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        super(id, createdAt, updatedAt);
        this.email = requireEmail(email);
        this.passwordHash = requirePassword(passwordHash);
        this.fullName = requireText(fullName, "fullName");
        this.role = requireValue(role, "role");
        this.active = active;
        this.failedLoginAttempts = failedLoginAttempts;
        this.lockedUntil = lockedUntil;
    }

    public static User register(String email, String passwordHash, String fullName, UserRole role) {
        return new User(null, email, passwordHash, fullName, role, true, 0, null, null, null);
    }

    public void updateProfile(String fullName) {
        this.fullName = requireText(fullName, "fullName");
        touch();
    }

    public void recordFailedLogin() {
        this.failedLoginAttempts++;
        if (failedLoginAttempts >= 5) {
            this.lockedUntil = LocalDateTime.now().plusMinutes(15);
        }
        touch();
    }

    public void recordSuccessfulLogin() {
        this.failedLoginAttempts = 0;
        this.lockedUntil = null;
        touch();
    }

    public void deactivate() {
        this.active = false;
        touch();
    }

    public void activate() {
        this.active = true;
        touch();
    }

    public void lock(LocalDateTime until) {
        this.lockedUntil = until;
        touch();
    }

    public void unlock() {
        this.lockedUntil = null;
        this.failedLoginAttempts = 0;
        touch();
    }

    private void ensureActive(String action) {
        if (!active) {
            throw new BusinessRuleException("Cannot " + action + " inactive user");
        }
    }

    private static String requireEmail(String value) {
        if (value == null || value.isBlank()) {
            throw new BusinessRuleException("Email is required");
        }
        var trimmed = value.trim().toLowerCase();
        if (!trimmed.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new BusinessRuleException("Invalid email format");
        }
        return trimmed;
    }

    private static String requirePassword(String value) {
        if (value == null || value.isBlank()) {
            throw new BusinessRuleException("Password is required");
        }
        return value;
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new BusinessRuleException(fieldName + " is required");
        }
        return value.trim();
    }

    private static <T> T requireValue(T value, String fieldName) {
        if (value == null) {
            throw new BusinessRuleException(fieldName + " is required");
        }
        return value;
    }

    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public String getFullName() { return fullName; }
    public UserRole getRole() { return role; }
    public boolean isActive() { return active; }
    public int getFailedLoginAttempts() { return failedLoginAttempts; }
    public LocalDateTime getLockedUntil() { return lockedUntil; }

    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setFullName(String fullName) { this.fullName = fullName; }
}
