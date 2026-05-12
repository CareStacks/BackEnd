package com.carestacks.careconnect.shared.domain.entities;

import java.util.UUID;

public abstract class EntityBase {

    private UUID id;

    protected EntityBase() {
        this.id = UUID.randomUUID();
    }

    protected EntityBase(UUID id) {
        this.id = id == null ? UUID.randomUUID() : id;
    }

    public UUID getId() {
        return id;
    }

    protected void setId(UUID id) {
        this.id = id;
    }
}
