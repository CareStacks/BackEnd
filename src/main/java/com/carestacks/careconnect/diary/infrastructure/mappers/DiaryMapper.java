package com.carestacks.careconnect.diary.infrastructure.mappers;

import com.carestacks.careconnect.diary.application.diary.dtos.DiaryEntryDto;
import com.carestacks.careconnect.diary.domain.diary.entities.DiaryEntry;
import com.carestacks.careconnect.diary.infrastructure.persistence.DiaryEntryJpaEntity;

public class DiaryMapper {

    public static DiaryEntryDto toDto(DiaryEntryJpaEntity entity) {
        return new DiaryEntryDto(
                entity.getId(),
                entity.getPatientId(),
                entity.getContent(),
                entity.getEntryDate()
        );
    }

    public static DiaryEntryDto toDto(DiaryEntry domain) {
        return new DiaryEntryDto(
                domain.getId(),
                domain.getPatientId(),
                domain.getContent(),
                domain.getEntryDate()
        );
    }

    public static DiaryEntry toDomain(DiaryEntryJpaEntity entity) {
        return new DiaryEntry(
                entity.getId(),
                entity.getPatientId(),
                entity.getContent(),
                entity.getEntryDate()
        );
    }

    public static DiaryEntryJpaEntity toEntity(DiaryEntry diaryEntry) {
        return new DiaryEntryJpaEntity(
                diaryEntry.getId(),
                diaryEntry.getPatientId(),
                diaryEntry.getContent(),
                diaryEntry.getEntryDate()
        );
    }

    public static void copyToEntity(DiaryEntry diaryEntry, DiaryEntryJpaEntity entity) {
        entity.setPatientId(diaryEntry.getPatientId());
        entity.setContent(diaryEntry.getContent());
        entity.setEntryDate(diaryEntry.getEntryDate());
    }

    public static java.util.List<DiaryEntryDto> toDtoList(java.util.List<DiaryEntryJpaEntity> entities) {
        return entities.stream()
                .map(DiaryMapper::toDto)
                .toList();
    }

    public static java.util.List<DiaryEntryDto> toDtoListFromDomain(java.util.List<DiaryEntry> domains) {
        return domains.stream()
                .map(DiaryMapper::toDto)
                .toList();
    }

    public static java.util.List<DiaryEntry> toDomainList(java.util.List<DiaryEntryJpaEntity> entities) {
        return entities.stream()
                .map(DiaryMapper::toDomain)
                .toList();
    }
}
