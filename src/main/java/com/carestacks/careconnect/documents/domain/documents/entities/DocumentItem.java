package com.carestacks.careconnect.documents.domain.documents.entities;

import com.carestacks.careconnect.documents.domain.documents.valueobjects.DocumentType;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;

import java.time.LocalDateTime;
import java.util.Set;

public class DocumentItem {

    public static final long MAX_FILE_SIZE_BYTES = 10L * 1024L * 1024L;
    private static final Set<String> ALLOWED_MIME_TYPES = Set.of("application/pdf", "image/jpeg", "image/png");

    private Long id;
    private Long medicalDocumentId;
    private DocumentType documentType;
    private String title;
    private String description;
    private String fileUrl;
    private String mimeType;
    private long fileSizeBytes;
    private LocalDateTime uploadedAt;

    public DocumentItem(
            Long id,
            Long medicalDocumentId,
            DocumentType documentType,
            String title,
            String description,
            String fileUrl,
            String mimeType,
            long fileSizeBytes,
            LocalDateTime uploadedAt
    ) {
        this.id = id;
        this.medicalDocumentId = medicalDocumentId;
        this.documentType = requireValue(documentType, "documentType");
        this.title = requireText(title, "title");
        this.description = description == null ? null : description.trim();
        this.fileUrl = requireText(fileUrl, "fileUrl");
        this.mimeType = requireAllowedMimeType(mimeType);
        this.fileSizeBytes = requireAllowedSize(fileSizeBytes);
        this.uploadedAt = uploadedAt == null ? LocalDateTime.now() : uploadedAt;
    }

    public static DocumentItem upload(
            Long medicalDocumentId,
            DocumentType documentType,
            String title,
            String description,
            String fileUrl,
            String mimeType,
            long fileSizeBytes,
            LocalDateTime uploadedAt
    ) {
        return new DocumentItem(null, medicalDocumentId, documentType, title, description, fileUrl, mimeType, fileSizeBytes, uploadedAt);
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

    private static String requireAllowedMimeType(String mimeType) {
        var normalized = requireText(mimeType, "mimeType").toLowerCase();
        if (!ALLOWED_MIME_TYPES.contains(normalized)) {
            throw new BusinessRuleException("Only PDF, JPG, and PNG documents are allowed");
        }
        return normalized;
    }

    private static long requireAllowedSize(long fileSizeBytes) {
        if (fileSizeBytes <= 0) {
            throw new BusinessRuleException("File size must be greater than zero");
        }
        if (fileSizeBytes > MAX_FILE_SIZE_BYTES) {
            throw new BusinessRuleException("File size must not exceed 10 MB");
        }
        return fileSizeBytes;
    }

    public Long getId() { return id; }
    public Long getMedicalDocumentId() { return medicalDocumentId; }
    public DocumentType getDocumentType() { return documentType; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getFileUrl() { return fileUrl; }
    public String getMimeType() { return mimeType; }
    public long getFileSizeBytes() { return fileSizeBytes; }
    public LocalDateTime getUploadedAt() { return uploadedAt; }

    public void assignToMedicalDocument(Long medicalDocumentId) { this.medicalDocumentId = medicalDocumentId; }
}
