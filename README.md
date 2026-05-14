# CareConnect Backend

Spring Boot REST API for the CareConnect bounded contexts that currently exist in this repository.

## Existing Bounded Contexts

| Bounded context | README |
| --- | --- |
| IAM | `src/main/java/com/carestacks/careconnect/iam/README.md` |
| Agenda | `src/main/java/com/carestacks/careconnect/agenda/README.md` |
| Notifications | `src/main/java/com/carestacks/careconnect/notifications/README.md` |
| Diary | `src/main/java/com/carestacks/careconnect/diary/README.md` |
| Documents | `src/main/java/com/carestacks/careconnect/documents/README.md` |

`INFO.md` also describes Compartir Perfiles, but that bounded context is not present in the current source tree and has not been created.

## Run

```bash
mvn spring-boot:run
```

The application starts on port `8080` by default and uses the H2 in-memory datasource configured in `src/main/resources/application.yml`.

## Validate

```bash
mvn test
```

## Swagger/OpenAPI

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

All current REST controllers are grouped by bounded context tags.
