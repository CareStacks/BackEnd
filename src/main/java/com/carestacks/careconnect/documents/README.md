# Documents Bounded Context

## Purpose

The Documents bounded context manages medical document storage metadata for CareConnect patients. It supports uploading document records, listing patient documents, consulting document details, and deleting documents when they are no longer needed.

## Responsibilities From INFO.md

- Upload medical documents with required metadata.
- Accept only PDF, JPG, and PNG documents.
- Enforce a maximum document size of 10 MB.
- Store document type, upload date, file URL, MIME type, size, and patient ownership.
- List and consult documents for a patient.
- Keep document access concerns ready for integration with the Compartir Perfiles bounded context when that context exists.

## Internal Architecture

- `domain/documents/entities`: Domain model and business rules for `MedicalDocument` and `DocumentItem`.
- `domain/documents/valueobjects`: `DocumentType` catalog.
- `application/documents/abstractions`: `DocumentService` use-case contract.
- `application/documents/services`: Application service that coordinates validation, persistence, and DTO mapping.
- `application/documents/dtos`: Response DTOs exposed by the REST API.
- `application/documents/requests`: Validated request bodies for creating document containers and uploading document items.
- `infrastructure/persistence`: JPA entities and Spring Data repositories.
- `infrastructure/mappers`: Mapping between domain, persistence, and DTO models.
- `interfaces`: REST controller documented for Swagger/OpenAPI.

## Main Entities

- `MedicalDocument`: Patient-owned aggregate that groups uploaded document items.
- `DocumentItem`: Individual medical document metadata entry.
- `DocumentType`: Supported business classification such as prescription, lab result, clinical report, imaging, referral, vaccination record, insurance form, and other.

## Implemented Use Cases

- Create a medical document container for a patient.
- Upload a document item with metadata validation.
- List all medical document containers.
- List medical documents by patient.
- Consult a medical document by ID.
- Consult a document item by ID.
- Remove a document item from a medical document.
- Delete a medical document and its items.

## Endpoints

| Method | Path | Description |
| --- | --- | --- |
| `POST` | `/api/documents` | Creates a patient-owned medical document container. |
| `GET` | `/api/documents` | Lists all medical document containers. |
| `GET` | `/api/documents/patient/{patientId}` | Lists medical documents owned by a patient. |
| `GET` | `/api/documents/{id}` | Gets a medical document container with its items. |
| `POST` | `/api/documents/{medicalDocumentId}/items` | Uploads document metadata for a PDF, JPG, or PNG file up to 10 MB. |
| `GET` | `/api/documents/{medicalDocumentId}/items/{documentItemId}` | Gets a single document item. |
| `DELETE` | `/api/documents/{medicalDocumentId}/items/{documentItemId}` | Removes a document item. |
| `DELETE` | `/api/documents/{id}` | Deletes a medical document container and its items. |

## Pending Endpoints

- No separate binary file upload endpoint is implemented yet. The current API stores file metadata and a `fileUrl`; physical storage can be integrated later with S3, GCS, or another storage adapter.
- Cross-context authorization for shared caregivers is pending because the Compartir Perfiles bounded context does not exist in the current source tree.

## Swagger/OpenAPI

`DocumentController` is annotated with `@Tag`, `@Operation`, and `@ApiResponses`. The endpoints are exposed under the `Documents` tag in Swagger UI at `/swagger-ui.html`.

## How To Run Or Test

1. Start the application with `mvn spring-boot:run`.
2. Open Swagger UI at `http://localhost:8080/swagger-ui.html`.
3. Create a medical document container with `POST /api/documents`.
4. Add document metadata with `POST /api/documents/{medicalDocumentId}/items`.
5. Query by patient or by document ID to verify persistence.

## Changes In This Feature Branch

- Added the REST controller for the Documents bounded context.
- Added request DTOs for container creation and document upload metadata.
- Fixed domain and persistence mapping inconsistencies.
- Added validation for allowed MIME types and 10 MB maximum file size.
- Added patient-based document listing.
- Added Swagger/OpenAPI documentation for all Documents endpoints.

## Technical Considerations

- The bounded context stores metadata only; binary file storage is intentionally externalized for a future adapter.
- The current API uses H2 in-memory persistence from `application.yml`.
- Document access authorization should delegate to Compartir Perfiles once that bounded context exists.
