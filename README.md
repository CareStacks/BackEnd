
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
| Gestión de Consentimiento | `src/main/java/com/carestacks/careconnect/consents/README.md` |

`INFO.md` describes Acceso Compartido; that capability is implemented as the Gestión de Consentimiento bounded context.

## Run
=======
# CareConnect Backend - Main

> Rama principal (producción). Contiene la versión estable y desplegada del backend.

## Estado: ✅ Estable

Versión actual del backend lista para producción.

## Quick Start


```bash
mvn spring-boot:run
```

The application starts on port `8080` by default. Configure the datasource through `DB_URL`, `DB_DRIVER_CLASS_NAME`, `DB_USERNAME`, and `DB_PASSWORD`.

## Validate

```bash
mvn test
```

## Render PostgreSQL

Deployment database notes are documented in `RENDER.md`. Secrets must be configured as environment variables, not committed to the repository.

## Swagger/OpenAPI

- Swagger UI: `https://careconnect-backend-hvyq.onrender.com/swagger-ui/index.html#/IAM/register`

All current REST controllers are grouped by bounded context tags.
=======
## Documentación

- **API:** https://careconnect-backend-hvyq.onrender.com
- **Swagger UI:** https://careconnect-backend-hvyq.onrender.com/swagger-ui/index.html#/IAM/register

## Ramas de Trabajo

```
main (producción)
 └── develop (integración)
      ├── feature/notifications
      └── feature/agenda
```

**Ver rama develop para desarrollo activo.**
