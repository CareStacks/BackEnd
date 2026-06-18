package com.carestacks.careconnect.documents.application.documents.services;

import com.carestacks.careconnect.documents.application.documents.abstractions.DocumentService;
import com.carestacks.careconnect.documents.application.documents.dtos.DocumentItemDto;
import com.carestacks.careconnect.documents.application.documents.dtos.MedicalDocumentDto;
import com.carestacks.careconnect.documents.application.documents.requests.CreateMedicalDocumentRequest;
import com.carestacks.careconnect.documents.application.documents.requests.UploadDocumentItemRequest;
import com.carestacks.careconnect.documents.domain.documents.entities.DocumentItem;
import com.carestacks.careconnect.documents.domain.documents.entities.MedicalDocument;
import com.carestacks.careconnect.documents.domain.documents.valueobjects.DocumentType;
import com.carestacks.careconnect.documents.infrastructure.mappers.DocumentItemMapper;
import com.carestacks.careconnect.documents.infrastructure.mappers.MedicalDocumentMapper;
import com.carestacks.careconnect.documents.infrastructure.persistence.DocumentItemJpaEntity;
import com.carestacks.careconnect.documents.infrastructure.persistence.DocumentItemJpaRepository;
import com.carestacks.careconnect.documents.infrastructure.persistence.MedicalDocumentJpaEntity;
import com.carestacks.careconnect.documents.infrastructure.persistence.MedicalDocumentJpaRepository;
import com.carestacks.careconnect.documents.infrastructure.storage.SupabaseStorageService;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;
import com.carestacks.careconnect.shared.domain.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    private final MedicalDocumentJpaRepository medicalDocumentRepository;
    private final DocumentItemJpaRepository documentItemRepository;
    private final SupabaseStorageService supabaseStorageService;

    public DocumentServiceImpl(
            MedicalDocumentJpaRepository medicalDocumentRepository,
            DocumentItemJpaRepository documentItemRepository,
            SupabaseStorageService supabaseStorageService
    ) {
        this.medicalDocumentRepository = medicalDocumentRepository;
        this.documentItemRepository = documentItemRepository;
        this.supabaseStorageService = supabaseStorageService;
    }

    @Override
    public MedicalDocumentDto createMedicalDocument(CreateMedicalDocumentRequest request) {
        var medicalDocument = MedicalDocument.createForPatient(request.getPatientId());
        var savedMedicalDocument = medicalDocumentRepository.save(MedicalDocumentMapper.toEntity(medicalDocument));
        return MedicalDocumentMapper.toDto(savedMedicalDocument);
    }

    @Override
    @Transactional(readOnly = true)
    public MedicalDocumentDto getMedicalDocumentById(Long id) {
        return MedicalDocumentMapper.toDto(findMedicalDocumentEntity(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalDocumentDto> getAllMedicalDocuments() {
        return medicalDocumentRepository.findAll()
                .stream()
                .map(MedicalDocumentMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalDocumentDto> getMedicalDocumentsByPatient(UUID patientId) {
        return medicalDocumentRepository.findByPatientIdOrderByCreatedAtDesc(patientId)
                .stream()
                .map(MedicalDocumentMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DocumentItemDto getDocumentItemById(Long medicalDocumentId, Long documentItemId) {
        var item = findDocumentItemEntity(documentItemId);
        ensureDocumentItemBelongsToMedicalDocument(item, medicalDocumentId);
        return DocumentItemMapper.toDto(item);
    }

    @Override
    public MedicalDocumentDto addDocumentItem(Long medicalDocumentId, UploadDocumentItemRequest request) {
        var medicalDocumentEntity = findMedicalDocumentEntity(medicalDocumentId);

        // Domain construction centralizes file type and size rules from INFO.md.
        var documentItem = DocumentItem.upload(
                medicalDocumentId,
                request.getDocumentType(),
                request.getTitle(),
                request.getDescription(),
                request.getFileUrl(),
                request.getStorageBucket(),
                request.getStoragePath(),
                request.getMimeType(),
                request.getFileSizeBytes(),
                request.getUploadedAt(),
                request.getSyncStatus()
        );
        medicalDocumentEntity.addDocumentItem(DocumentItemMapper.toEntity(documentItem, medicalDocumentEntity));

        return MedicalDocumentMapper.toDto(medicalDocumentRepository.save(medicalDocumentEntity));
    }

    @Override
    public MedicalDocumentDto uploadDocumentFile(
            Long medicalDocumentId,
            DocumentType documentType,
            String title,
            String description,
            LocalDateTime uploadedAt,
            MultipartFile file
    ) {
        var medicalDocumentEntity = findMedicalDocumentEntity(medicalDocumentId);
        var uploadDate = uploadedAt == null ? LocalDateTime.now() : uploadedAt;
        var storedDocument = supabaseStorageService.uploadPatientDocument(
                medicalDocumentEntity.getPatientId(),
                file,
                uploadDate
        );

        var documentItem = DocumentItem.upload(
                medicalDocumentId,
                documentType,
                title,
                description,
                storedDocument.storageUrl(),
                storedDocument.bucket(),
                storedDocument.path(),
                file.getContentType(),
                file.getSize(),
                uploadDate,
                "SYNCED"
        );
        medicalDocumentEntity.addDocumentItem(DocumentItemMapper.toEntity(documentItem, medicalDocumentEntity));

        return MedicalDocumentMapper.toDto(medicalDocumentRepository.save(medicalDocumentEntity));
    }

    @Override
    public MedicalDocumentDto removeDocumentItem(Long medicalDocumentId, Long documentItemId) {
        var medicalDocument = findMedicalDocumentEntity(medicalDocumentId);
        var documentItem = findDocumentItemEntity(documentItemId);
        ensureDocumentItemBelongsToMedicalDocument(documentItem, medicalDocumentId);

        medicalDocument.removeDocumentItem(documentItem);
        return MedicalDocumentMapper.toDto(medicalDocumentRepository.save(medicalDocument));
    }

    @Override
    public void deleteMedicalDocument(Long id) {
        var medicalDocument = findMedicalDocumentEntity(id);
        medicalDocumentRepository.delete(medicalDocument);
    }

    private MedicalDocumentJpaEntity findMedicalDocumentEntity(Long id) {
        return medicalDocumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medical document not found"));
    }

    private DocumentItemJpaEntity findDocumentItemEntity(Long id) {
        return documentItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Document item not found"));
    }

    private void ensureDocumentItemBelongsToMedicalDocument(DocumentItemJpaEntity documentItem, Long medicalDocumentId) {
        if (!documentItem.getMedicalDocument().getId().equals(medicalDocumentId)) {
            throw new BusinessRuleException("Document item does not belong to the medical document");
        }
    }
}
