package com.carestacks.careconnect.documents.application.documents.abstractions;

import com.carestacks.careconnect.documents.application.documents.dtos.MedicalDocumentDto;
import com.carestacks.careconnect.documents.application.documents.dtos.DocumentItemDto;
import com.carestacks.careconnect.documents.application.documents.requests.CreateMedicalDocumentRequest;
import com.carestacks.careconnect.documents.application.documents.requests.UploadDocumentItemRequest;

import java.util.List;
import java.util.UUID;

public interface DocumentService {

    MedicalDocumentDto createMedicalDocument(CreateMedicalDocumentRequest request);

    MedicalDocumentDto getMedicalDocumentById(Long id);

    List<MedicalDocumentDto> getAllMedicalDocuments();

    List<MedicalDocumentDto> getMedicalDocumentsByPatient(UUID patientId);

    DocumentItemDto getDocumentItemById(Long medicalDocumentId, Long documentItemId);

    MedicalDocumentDto addDocumentItem(Long medicalDocumentId, UploadDocumentItemRequest request);

    MedicalDocumentDto removeDocumentItem(Long medicalDocumentId, Long documentItemId);

    void deleteMedicalDocument(Long id);
}
