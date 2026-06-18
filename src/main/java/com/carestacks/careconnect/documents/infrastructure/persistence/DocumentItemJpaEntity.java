package com.carestacks.careconnect.documents.infrastructure.persistence;

import com.carestacks.careconnect.documents.domain.documents.valueobjects.DocumentType;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "document_items")
public class DocumentItemJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_document_id", nullable = false)
    private MedicalDocumentJpaEntity medicalDocument;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type", nullable = false, length = 50)
    private DocumentType documentType;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "file_url", nullable = false, length = 500)
    private String fileUrl;

    @Column(name = "storage_bucket", length = 80)
    private String storageBucket;

    @Column(name = "storage_path", length = 500)
    private String storagePath;

    @Column(name = "mime_type", nullable = false, length = 100)
    private String mimeType;

    @Column(name = "file_size_bytes", nullable = false)
    private long fileSizeBytes;

    @Column(name = "uploaded_at", nullable = false)
    private LocalDateTime uploadedAt;

    @Column(name = "sync_status", nullable = false, length = 40)
    private String syncStatus = "SYNCED";

    public DocumentItemJpaEntity() {}

    public DocumentItemJpaEntity(
            Long id,
            MedicalDocumentJpaEntity medicalDocument,
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
        this.medicalDocument = medicalDocument;
        this.documentType = documentType;
        this.title = title;
        this.description = description;
        this.fileUrl = fileUrl;
        this.storageBucket = storageBucket;
        this.storagePath = storagePath;
        this.mimeType = mimeType;
        this.fileSizeBytes = fileSizeBytes;
        this.uploadedAt = uploadedAt;
        this.syncStatus = syncStatus == null || syncStatus.isBlank() ? "SYNCED" : syncStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicalDocumentJpaEntity getMedicalDocument() {
        return medicalDocument;
    }

    public void setMedicalDocument(MedicalDocumentJpaEntity medicalDocument) {
        this.medicalDocument = medicalDocument;
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
