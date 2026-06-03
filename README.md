
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
=======
# CareConnect Backend - Main

> Rama principal (producción). Contiene la versión estable y desplegada del backend.

## Estado: ✅ Estable

Versión actual del backend lista para producción.

## Quick Start


```bash
mvn spring-boot:run
```

The application starts on port `8080` by default and uses the H2 in-memory datasource configured in `src/main/resources/application.yml`.

## Validate

```bash
mvn test
```

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
