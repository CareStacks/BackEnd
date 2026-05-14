package com.carestacks.careconnect.documents.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentItemJpaRepository extends JpaRepository<DocumentItemJpaEntity, Long> {
    List<DocumentItemJpaEntity> findByMedicalDocumentId(Long medicalDocumentId);
}
