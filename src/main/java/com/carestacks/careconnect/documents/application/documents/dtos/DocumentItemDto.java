package com.carestacks.careconnect.documents.application.documents.dtos;

import com.carestacks.careconnect.documents.domain.documents.valueobjects.DocumentType;
import java.time.LocalDateTime;

public class DocumentItemDto {

    private Long id;
    private DocumentType documentType;
    private String title;
    private String description;
    private String fileUrl;
    private String storageBucket;
    private String storagePath;
    private String mimeType;
    private long fileSizeBytes;
    private LocalDateTime uploadedAt;
    private String syncStatus;

    public DocumentItemDto() {}

    public DocumentItemDto(
            Long id,
            DocumentType documentType,
            String title,
            String description,
            String fileUrl,
            String storageBucket,
            String storagePath,
            String mimeType,
            long fileSizeBytes,
            LocalDateTime uploadedAt,
            String syncStatus
    ) {
        this.id = id;
        this.documentType = documentType;
        this.title = title;
        this.description = description;
        this.fileUrl = fileUrl;
        this.storageBucket = storageBucket;
        this.storagePath = storagePath;
        this.mimeType = mimeType;
        this.fileSizeBytes = fileSizeBytes;
        this.uploadedAt = uploadedAt;
        this.syncStatus = syncStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getStorageBucket() {
        return storageBucket;
    }

    public void setStorageBucket(String storageBucket) {
        this.storageBucket = storageBucket;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public long getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(long fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }
}
