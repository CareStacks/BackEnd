# Render PostgreSQL setup

Render PostgreSQL was provisioned for the backend.

## Database

- Name: `careconnect-db`
- Render ID: `dpg-d8onlq3eo5us73egtob0-a`
- Database name: `careconnect_5i19`
- Database user: `careconnect`
- Region: `oregon`
- Plan: `free`

## Spring Boot environment variables

Set these variables in the Render web service or local `.env` file. Do not commit real passwords.

```bash
SPRING_DATASOURCE_URL=jdbc:postgresql://<render-postgres-host>:5432/careconnect_5i19?sslmode=require
SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver
SPRING_DATASOURCE_USERNAME=careconnect
SPRING_DATASOURCE_PASSWORD=<render-postgres-password>
```

If the backend is deployed as a Render service in the same workspace/region, prefer the internal PostgreSQL host/connection string.

## Security notes

- The Render API key must stay outside the repository.
- Rotate the Render API key if it was shared in chat or logs.
- Keep the PostgreSQL IP allowlist restricted to trusted development IPs or Render internal networking. The temporary IP used for verification was removed after testing.
