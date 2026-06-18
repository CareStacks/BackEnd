package com.carestacks.careconnect.documents.application.documents.abstractions;

import com.carestacks.careconnect.documents.application.documents.dtos.MedicalDocumentDto;
import com.carestacks.careconnect.documents.application.documents.dtos.DocumentItemDto;
import com.carestacks.careconnect.documents.application.documents.requests.CreateMedicalDocumentRequest;
import com.carestacks.careconnect.documents.application.documents.requests.UploadDocumentItemRequest;
import com.carestacks.careconnect.documents.domain.documents.valueobjects.DocumentType;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface DocumentService {

    MedicalDocumentDto createMedicalDocument(CreateMedicalDocumentRequest request);

    MedicalDocumentDto getMedicalDocumentById(Long id);

    List<MedicalDocumentDto> getAllMedicalDocuments();

    List<MedicalDocumentDto> getMedicalDocumentsByPatient(UUID patientId);

    DocumentItemDto getDocumentItemById(Long medicalDocumentId, Long documentItemId);

    MedicalDocumentDto addDocumentItem(Long medicalDocumentId, UploadDocumentItemRequest request);

    MedicalDocumentDto uploadDocumentFile(
            Long medicalDocumentId,
            DocumentType documentType,
            String title,
            String description,
            LocalDateTime uploadedAt,
            MultipartFile file
    );

    MedicalDocumentDto removeDocumentItem(Long medicalDocumentId, Long documentItemId);

    void deleteMedicalDocument(Long id);
}
