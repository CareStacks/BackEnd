package com.carestacks.careconnect.documents.infrastructure.repositories;

import com.carestacks.careconnect.documents.domain.documents.entities.MedicalDocument;
import java.util.List;
import java.util.Optional;

public interface MedicalDocumentRepository {

    MedicalDocument save(MedicalDocument medicalDocument);

    Optional<MedicalDocument> findById(Long id);

    List<MedicalDocument> findAll();

    void deleteById(Long id);
}
