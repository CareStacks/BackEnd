package com.carestacks.careconnect.diary.infrastructure.repositories;

import com.carestacks.careconnect.diary.domain.diary.entities.DiaryEntry;
import com.carestacks.careconnect.diary.infrastructure.persistence.DiaryEntryJpaEntity;
import com.carestacks.careconnect.diary.infrastructure.mappers.DiaryMapper;
import com.carestacks.careconnect.diary.infrastructure.persistence.DiaryEntryJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class DiaryRepositoryImpl implements DiaryRepository {

    private final DiaryEntryJpaRepository jpaRepository;

    public DiaryRepositoryImpl(DiaryEntryJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public DiaryEntry save(DiaryEntry diaryEntry) {
        DiaryEntryJpaEntity entity = DiaryMapper.toEntity(diaryEntry);
        DiaryEntryJpaEntity savedEntity = jpaRepository.save(entity);
        return DiaryMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<DiaryEntry> findById(Long id) {
        return jpaRepository.findById(id)
                .map(DiaryMapper::toDomain);
    }

    @Override
    public List<DiaryEntry> findAll() {
        return DiaryMapper.toDomainList(jpaRepository.findAllByOrderByEntryDateDesc());
    }

    @Override
    public List<DiaryEntry> findByPatientId(UUID patientId) {
        return DiaryMapper.toDomainList(jpaRepository.findByPatientIdOrderByEntryDateDesc(patientId));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
