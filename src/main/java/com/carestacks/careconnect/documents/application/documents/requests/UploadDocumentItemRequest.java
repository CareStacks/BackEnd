package com.carestacks.careconnect.documents.application.documents.requests;

import com.carestacks.careconnect.documents.domain.documents.entities.DocumentItem;
import com.carestacks.careconnect.documents.domain.documents.valueobjects.DocumentType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class UploadDocumentItemRequest {

    @NotNull(message = "Selecciona el tipo de documento")
    private DocumentType documentType;

    @NotBlank(message = "Ingresa el nombre del documento")
    @Size(max = 255, message = "El nombre del documento no debe superar 255 caracteres")
    private String title;

    @Size(max = 1000, message = "La descripción no debe superar 1000 caracteres")
    private String description;

    @NotBlank(message = "Selecciona un archivo antes de continuar")
    @Size(max = 500, message = "La ruta del archivo no debe superar 500 caracteres")
    private String fileUrl;

    @Size(max = 80, message = "El bucket de almacenamiento no debe superar 80 caracteres")
    private String storageBucket;

    @Size(max = 500, message = "La ruta de almacenamiento no debe superar 500 caracteres")
    private String storagePath;

    @NotBlank(message = "El tipo de archivo no es válido")
    private String mimeType;

    @Positive(message = "El archivo está vacío o no se pudo leer")
    @Max(value = DocumentItem.MAX_FILE_SIZE_BYTES, message = "El archivo supera el tamaño permitido")
    private long fileSizeBytes;

    private LocalDateTime uploadedAt;

    @Size(max = 40, message = "El estado de sincronización no debe superar 40 caracteres")
    private String syncStatus;

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
