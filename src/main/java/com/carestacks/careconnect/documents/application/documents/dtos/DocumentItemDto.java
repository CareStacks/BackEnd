package com.carestacks.careconnect.documents.application.documents.dtos;

import com.carestacks.careconnect.documents.domain.documents.valueobjects.DocumentType;
import java.time.LocalDateTime;

public class DocumentItemDto {

    private Long id;
    private DocumentType documentType;
    private String title;
    private String description;
    private String fileUrl;
    private String mimeType;
    private long fileSizeBytes;
    private LocalDateTime uploadedAt;

    public DocumentItemDto() {}

    public DocumentItemDto(
            Long id,
            DocumentType documentType,
            String title,
            String description,
            String fileUrl,
            String mimeType,
            long fileSizeBytes,
            LocalDateTime uploadedAt
    ) {
        this.id = id;
        this.documentType = documentType;
        this.title = title;
        this.description = description;
        this.fileUrl = fileUrl;
        this.mimeType = mimeType;
        this.fileSizeBytes = fileSizeBytes;
        this.uploadedAt = uploadedAt;
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
}
