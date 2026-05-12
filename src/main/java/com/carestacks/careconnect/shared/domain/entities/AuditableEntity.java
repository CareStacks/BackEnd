package com.carestacks.careconnect.shared.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class AuditableEntity extends EntityBase {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected AuditableEntity() {
        super();
        var now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    protected AuditableEntity(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
        this.updatedAt = updatedAt == null ? this.createdAt : updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Keeps domain timestamps consistent when a business operation mutates the entity.
    protected void touch() {
        this.updatedAt = LocalDateTime.now();
    }
}
