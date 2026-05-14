# Diary Bounded Context

## Purpose

Diary lets patients record personal health notes and lets authorized caregivers consult the patient diary when access exists. In the current backend, diary entries are owned by a `patientId`; cross-context authorization is pending until Compartir Perfiles exists in the source tree.

## Responsibilities From INFO.md

- Create non-empty diary entries.
- Store diary entries with an automatic timestamp.
- List and consult diary entries chronologically.
- Update and delete existing diary entries.
- Support patient-specific diary queries.
- Prepare shared-diary consultation for future integration with Compartir Perfiles.

## Internal Architecture

- `domain/diary/entities`: `DiaryEntry` domain rules.
- `application/diary/abstractions`: `DiaryService` use-case contract.
- `application/diary/dtos`: `DiaryEntryDto` response model.
- `application/diary/requests`: Create and update request bodies.
- `application/diary/services`: Application service implementation.
- `infrastructure/persistence`: JPA entity and Spring Data repository.
- `infrastructure/repositories`: Repository abstraction and implementation.
- `infrastructure/mappers`: Mapping between domain, persistence, and DTO models.
- `interfaces`: REST controller documented for Swagger/OpenAPI.

## Main Entity

- `DiaryEntry`: Patient-owned note with content and creation timestamp.

## Implemented Use Cases

- Create a diary entry for a patient.
- Get a diary entry by ID.
- List all diary entries.
- List diary entries by patient.
- Update diary entry content.
- Delete a diary entry.

## Endpoints

| Method | Path | Description |
| --- | --- | --- |
| `POST` | `/api/diary` | Creates a patient diary entry. |
| `GET` | `/api/diary` | Lists all diary entries ordered by date descending. |
| `GET` | `/api/diary/{id}` | Gets a diary entry by ID. |
| `GET` | `/api/diary/patient/{patientId}` | Lists diary entries owned by a patient. |
| `PUT` | `/api/diary/{id}` | Updates diary entry content. |
| `DELETE` | `/api/diary/{id}` | Deletes a diary entry. |

## Pending Endpoints

- Shared diary authorization endpoints are pending because Compartir Perfiles does not exist in the current source tree.
- Pagination is not implemented yet.

## Corrected Endpoints

- `POST /api/diary` now returns `201 Created`.
- All request bodies are validated with `@Valid`.
- Missing entries now return `404 Not Found` through the shared exception handler.
- `GET /api/diary/patient/{patientId}` was added to support patient-specific diary consultation.

## Swagger/OpenAPI

`DiaryController` is annotated with `@Tag`, `@Operation`, and `@ApiResponses`. The endpoints are exposed under the `Diary` tag in Swagger UI at `/swagger-ui.html`.

## How To Run Or Test

1. Run `mvn test`.
2. Start the application with `mvn spring-boot:run`.
3. Open `http://localhost:8080/swagger-ui.html`.
4. Create a diary entry with `POST /api/diary`.
5. Query entries with `GET /api/diary/patient/{patientId}`.
6. Update or delete the entry with its ID.

## Changes In This Feature Branch

- Added patient ownership to diary entries.
- Added patient-specific diary query endpoint.
- Added explicit Swagger/OpenAPI documentation for all Diary endpoints.
- Replaced generic or stale README content with this bounded-context-specific README.
- Moved validation and not-found behavior into the proper domain/application flow.

## Technical Considerations

- The Diary bounded context does not own access sharing; it exposes patient-owned data and expects future authorization checks from Compartir Perfiles.
- Content is limited to 2000 characters.
- Entries are ordered by `entryDate` descending for list operations.
