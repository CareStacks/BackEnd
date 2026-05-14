package com.carestacks.careconnect.documents.infrastructure.mappers;

import com.carestacks.careconnect.documents.application.documents.dtos.MedicalDocumentDto;
import com.carestacks.careconnect.documents.domain.documents.entities.MedicalDocument;
import com.carestacks.careconnect.documents.infrastructure.persistence.MedicalDocumentJpaEntity;

import java.util.stream.Collectors;

public class MedicalDocumentMapper {

    public static MedicalDocumentDto toDto(MedicalDocumentJpaEntity entity) {
        return new MedicalDocumentDto(
                entity.getId(),
                entity.getPatientId(),
                entity.getDocumentItems().stream()
                        .map(DocumentItemMapper::toDto)
                        .collect(Collectors.toList()),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static MedicalDocument toDomain(MedicalDocumentJpaEntity entity) {
        return new MedicalDocument(
                entity.getId(),
                entity.getPatientId(),
                entity.getDocumentItems().stream()
                        .map(DocumentItemMapper::toDomain)
                        .collect(Collectors.toList()),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static MedicalDocumentJpaEntity toEntity(MedicalDocument medicalDocument) {
        MedicalDocumentJpaEntity entity = new MedicalDocumentJpaEntity(
                medicalDocument.getId(),
                medicalDocument.getPatientId(),
                medicalDocument.getCreatedAt(),
                medicalDocument.getUpdatedAt()
        );
        medicalDocument.getDocumentItems()
                .forEach(documentItem -> entity.addDocumentItem(DocumentItemMapper.toEntity(documentItem, entity)));
        return entity;
    }

    public static void copyToEntity(MedicalDocument medicalDocument, MedicalDocumentJpaEntity entity) {
        entity.setPatientId(medicalDocument.getPatientId());
        entity.setUpdatedAt(medicalDocument.getUpdatedAt());
    }

    public static java.util.List<MedicalDocumentDto> toDtoList(java.util.List<MedicalDocumentJpaEntity> entities) {
        return entities.stream()
                .map(MedicalDocumentMapper::toDto)
                .collect(Collectors.toList());
    }

    public static java.util.List<MedicalDocument> toDomainList(java.util.List<MedicalDocumentJpaEntity> entities) {
        return entities.stream()
                .map(MedicalDocumentMapper::toDomain)
                .collect(Collectors.toList());
    }
}
