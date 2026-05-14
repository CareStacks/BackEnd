package com.carestacks.careconnect.documents.infrastructure.repositories;

import com.carestacks.careconnect.documents.domain.documents.entities.DocumentItem;
import java.util.List;
import java.util.Optional;

public interface DocumentItemRepository {

    DocumentItem save(DocumentItem documentItem);

    Optional<DocumentItem> findById(Long id);

    List<DocumentItem> findByMedicalDocumentId(Long medicalDocumentId);

    void deleteById(Long id);
}
