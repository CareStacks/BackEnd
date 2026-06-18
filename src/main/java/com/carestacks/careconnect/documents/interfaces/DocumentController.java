package com.carestacks.careconnect.documents.interfaces;

import com.carestacks.careconnect.documents.application.documents.abstractions.DocumentService;
import com.carestacks.careconnect.documents.application.documents.dtos.DocumentItemDto;
import com.carestacks.careconnect.documents.application.documents.dtos.MedicalDocumentDto;
import com.carestacks.careconnect.documents.application.documents.requests.CreateMedicalDocumentRequest;
import com.carestacks.careconnect.documents.application.documents.requests.UploadDocumentItemRequest;
import com.carestacks.careconnect.documents.domain.documents.valueobjects.DocumentType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/documents")
@Tag(name = "Documents", description = "Medical document upload, metadata, and consultation endpoints")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @Operation(summary = "Create a medical document container", description = "Creates the patient-owned document aggregate used to store medical document items.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Medical document container created",
                    content = @Content(schema = @Schema(implementation = MedicalDocumentDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid patient identifier")
    })
    @PostMapping
    public ResponseEntity<MedicalDocumentDto> createMedicalDocument(@Valid @RequestBody CreateMedicalDocumentRequest request) {
        var medicalDocument = documentService.createMedicalDocument(request);
        return ResponseEntity.created(URI.create("/api/documents/" + medicalDocument.getId())).body(medicalDocument);
    }

    @Operation(summary = "List medical documents", description = "Returns all medical document containers registered in the system.")
    @ApiResponse(responseCode = "200", description = "Medical documents returned")
    @GetMapping
    public ResponseEntity<List<MedicalDocumentDto>> getAllMedicalDocuments() {
        return ResponseEntity.ok(documentService.getAllMedicalDocuments());
    }

    @Operation(summary = "List documents by patient", description = "Returns the medical document containers that belong to a patient.")
    @ApiResponse(responseCode = "200", description = "Patient documents returned")
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalDocumentDto>> getMedicalDocumentsByPatient(
            @Parameter(description = "Patient identifier") @PathVariable UUID patientId
    ) {
        return ResponseEntity.ok(documentService.getMedicalDocumentsByPatient(patientId));
    }

    @Operation(summary = "Get a medical document", description = "Returns a medical document container and its uploaded document items.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Medical document returned"),
            @ApiResponse(responseCode = "404", description = "Medical document not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MedicalDocumentDto> getMedicalDocumentById(
            @Parameter(description = "Medical document identifier") @PathVariable Long id
    ) {
        return ResponseEntity.ok(documentService.getMedicalDocumentById(id));
    }

    @Operation(summary = "Upload a document item", description = "Registers metadata for a PDF, JPG, or PNG document up to 10 MB.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Document item uploaded"),
            @ApiResponse(responseCode = "400", description = "Invalid file metadata"),
            @ApiResponse(responseCode = "404", description = "Medical document not found")
    })
    @PostMapping("/{medicalDocumentId}/items")
    public ResponseEntity<MedicalDocumentDto> uploadDocumentItem(
            @Parameter(description = "Medical document identifier") @PathVariable Long medicalDocumentId,
            @Valid @RequestBody UploadDocumentItemRequest request
    ) {
        var medicalDocument = documentService.addDocumentItem(medicalDocumentId, request);
        return ResponseEntity.created(URI.create("/api/documents/" + medicalDocumentId)).body(medicalDocument);
    }

    @Operation(summary = "Upload a document file", description = "Uploads the file to private Supabase Storage and stores only metadata in the database.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Document file uploaded"),
            @ApiResponse(responseCode = "400", description = "Invalid file or storage configuration"),
            @ApiResponse(responseCode = "404", description = "Medical document not found")
    })
    @PostMapping(value = "/{medicalDocumentId}/items/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MedicalDocumentDto> uploadDocumentFile(
            @Parameter(description = "Medical document identifier") @PathVariable Long medicalDocumentId,
            @RequestParam DocumentType documentType,
            @RequestParam String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime uploadedAt,
            @RequestParam("file") MultipartFile file
    ) {
        var medicalDocument = documentService.uploadDocumentFile(
                medicalDocumentId,
                documentType,
                title,
                description,
                uploadedAt,
                file
        );
        return ResponseEntity.created(URI.create("/api/documents/" + medicalDocumentId)).body(medicalDocument);
    }

    @Operation(summary = "Get a document item", description = "Returns the metadata of a specific uploaded document item.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Document item returned"),
            @ApiResponse(responseCode = "404", description = "Document item not found")
    })
    @GetMapping("/{medicalDocumentId}/items/{documentItemId}")
    public ResponseEntity<DocumentItemDto> getDocumentItemById(
            @Parameter(description = "Medical document identifier") @PathVariable Long medicalDocumentId,
            @Parameter(description = "Document item identifier") @PathVariable Long documentItemId
    ) {
        return ResponseEntity.ok(documentService.getDocumentItemById(medicalDocumentId, documentItemId));
    }

    @Operation(summary = "Delete a document item", description = "Removes an uploaded document item from a medical document container.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Document item removed"),
            @ApiResponse(responseCode = "404", description = "Medical document or document item not found")
    })
    @DeleteMapping("/{medicalDocumentId}/items/{documentItemId}")
    public ResponseEntity<MedicalDocumentDto> removeDocumentItem(
            @Parameter(description = "Medical document identifier") @PathVariable Long medicalDocumentId,
            @Parameter(description = "Document item identifier") @PathVariable Long documentItemId
    ) {
        return ResponseEntity.ok(documentService.removeDocumentItem(medicalDocumentId, documentItemId));
    }

    @Operation(summary = "Delete a medical document", description = "Deletes a medical document container and all its document items.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Medical document deleted"),
            @ApiResponse(responseCode = "404", description = "Medical document not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalDocument(
            @Parameter(description = "Medical document identifier") @PathVariable Long id
    ) {
        documentService.deleteMedicalDocument(id);
        return ResponseEntity.noContent().build();
    }
}
