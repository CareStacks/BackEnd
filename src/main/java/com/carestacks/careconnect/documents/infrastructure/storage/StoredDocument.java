package com.carestacks.careconnect.documents.infrastructure.storage;

public record StoredDocument(
        String bucket,
        String path,
        String storageUrl
) {
}
