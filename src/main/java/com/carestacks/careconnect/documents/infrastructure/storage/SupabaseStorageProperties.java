package com.carestacks.careconnect.documents.infrastructure.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "supabase.storage")
public record SupabaseStorageProperties(
        String url,
        String serviceRoleKey,
        String bucket
) {

    private static final String DEFAULT_BUCKET = "documents";

    public boolean isConfigured() {
        return isPresent(url) && isPresent(serviceRoleKey);
    }

    public String bucketName() {
        return isPresent(bucket) ? bucket.trim() : DEFAULT_BUCKET;
    }

    public String normalizedUrl() {
        if (!isPresent(url)) {
            return "";
        }

        return url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
    }

    private static boolean isPresent(String value) {
        return value != null && !value.isBlank();
    }
}
