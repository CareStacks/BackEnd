package com.carestacks.careconnect.documents.infrastructure.mappers;

import com.carestacks.careconnect.documents.application.documents.dtos.DocumentItemDto;
import com.carestacks.careconnect.documents.domain.documents.entities.DocumentItem;
import com.carestacks.careconnect.documents.infrastructure.persistence.DocumentItemJpaEntity;
import com.carestacks.careconnect.documents.infrastructure.persistence.MedicalDocumentJpaEntity;

public class DocumentItemMapper {

    public static DocumentItemDto toDto(DocumentItemJpaEntity entity) {
        return new DocumentItemDto(
                entity.getId(),
                entity.getDocumentType(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getFileUrl(),
                entity.getMimeType(),
                entity.getFileSizeBytes(),
                entity.getUploadedAt()
        );
    }

    public static DocumentItem toDomain(DocumentItemJpaEntity entity) {
        return new DocumentItem(
                entity.getId(),
                entity.getMedicalDocument().getId(),
                entity.getDocumentType(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getFileUrl(),
                entity.getMimeType(),
                entity.getFileSizeBytes(),
                entity.getUploadedAt()
        );
    }

    public static DocumentItemJpaEntity toEntity(DocumentItem documentItem, MedicalDocumentJpaEntity medicalDocument) {
        return new DocumentItemJpaEntity(
                documentItem.getId(),
                medicalDocument,
                documentItem.getDocumentType(),
                documentItem.getTitle(),
                documentItem.getDescription(),
                documentItem.getFileUrl(),
                documentItem.getMimeType(),
                documentItem.getFileSizeBytes(),
                documentItem.getUploadedAt()
        );
    }

    public static void copyToEntity(DocumentItem documentItem, DocumentItemJpaEntity entity, MedicalDocumentJpaEntity medicalDocument) {
        entity.setMedicalDocument(medicalDocument);
        entity.setDocumentType(documentItem.getDocumentType());
        entity.setTitle(documentItem.getTitle());
        entity.setDescription(documentItem.getDescription());
        entity.setFileUrl(documentItem.getFileUrl());
        entity.setMimeType(documentItem.getMimeType());
        entity.setFileSizeBytes(documentItem.getFileSizeBytes());
        entity.setUploadedAt(documentItem.getUploadedAt());
    }

    public static java.util.List<DocumentItemDto> toDtoList(java.util.List<DocumentItemJpaEntity> entities) {
        return entities.stream()
                .map(DocumentItemMapper::toDto)
                .toList();
    }

    public static java.util.List<DocumentItem> toDomainList(java.util.List<DocumentItemJpaEntity> entities) {
        return entities.stream()
                .map(DocumentItemMapper::toDomain)
                .toList();
    }
}
