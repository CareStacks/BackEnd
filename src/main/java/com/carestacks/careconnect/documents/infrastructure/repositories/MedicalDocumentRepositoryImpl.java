package com.carestacks.careconnect.documents.infrastructure.repositories;

import com.carestacks.careconnect.documents.domain.documents.entities.MedicalDocument;
import com.carestacks.careconnect.documents.infrastructure.persistence.MedicalDocumentJpaEntity;
import com.carestacks.careconnect.documents.infrastructure.persistence.MedicalDocumentJpaRepository;
import com.carestacks.careconnect.documents.infrastructure.mappers.MedicalDocumentMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MedicalDocumentRepositoryImpl implements MedicalDocumentRepository {

    private final MedicalDocumentJpaRepository jpaRepository;

    public MedicalDocumentRepositoryImpl(MedicalDocumentJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public MedicalDocument save(MedicalDocument medicalDocument) {
        MedicalDocumentJpaEntity entity = MedicalDocumentMapper.toEntity(medicalDocument);
        MedicalDocumentJpaEntity savedEntity = jpaRepository.save(entity);
        return MedicalDocumentMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<MedicalDocument> findById(Long id) {
        return jpaRepository.findById(id)
                .map(MedicalDocumentMapper::toDomain);
    }

    @Override
    public List<MedicalDocument> findAll() {
        return MedicalDocumentMapper.toDomainList(jpaRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
