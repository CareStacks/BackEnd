# IAM Bounded Context

## Purpose

IAM manages account registration, login, logout, session validation, and role checks for CareConnect users. According to `INFO.md`, every bounded context depends on IAM to identify active patients and caregivers before executing protected operations.

## Main Responsibilities

- Register users with unique email addresses.
- Enforce password rules: at least 8 characters, one uppercase letter, and one number.
- Authenticate users with email and password.
- Issue mock bearer tokens with a 30-minute inactivity-style expiration window.
- Revoke tokens on logout for the current application instance.
- Validate active sessions and optional role requirements.
- Temporarily lock accounts for 15 minutes after 5 failed login attempts.

## Internal Architecture

- `domain/iam/entities`: `User` domain entity and account state rules.
- `domain/iam/enums`: `UserRole` values.
- `application/abstractions`: `AuthService` use-case contract.
- `application/iam/dtos`: User and session validation responses.
- `application/iam/requests`: Register, login, and login response models.
- `infrastructure`: `AuthServiceImpl`, mappers, JPA entity, and Spring Data repository.
- `interfaces`: REST controller documented for Swagger/OpenAPI.

## Main Entity

- `User`: Registered account with email, password hash, full name, role, active flag, failed login counter, lock expiration timestamp, and audit timestamps.

## Implemented Use Cases

- Register a patient or caregiver account.
- Log in and receive a bearer token.
- Log out and revoke the provided bearer token.
- Get the current user from a bearer token.
- Validate a token and optionally enforce a required role.
- Lock an account after repeated failed credentials.

## Endpoints

| Method | Path | Description |
| --- | --- | --- |
| `POST` | `/api/auth/register` | Registers a user account. |
| `POST` | `/api/auth/login` | Authenticates a user and returns a bearer token. |
| `POST` | `/api/auth/logout` | Revokes the current bearer token. |
| `GET` | `/api/auth/me` | Returns the user represented by the bearer token. |
| `GET` | `/api/auth/validate?role={role}` | Validates the session and optionally checks the user role. |

## Pending Endpoints

- No refresh-token endpoint exists yet.
- Persistent token storage is not implemented; logout revocation is in memory for the current application process.

## Corrected Endpoints

- `POST /api/auth/login` now applies 15-minute account locks after 5 failed attempts.
- `POST /api/auth/logout` now revokes the provided token instead of only acknowledging the request.
- `GET /api/auth/validate` was added to cover session validation and role access validation from `INFO.md`.

## Swagger/OpenAPI

`AuthController` is annotated with `@Tag`, `@Operation`, and `@ApiResponses`. IAM endpoints are exposed under the `IAM` tag in Swagger UI at `/swagger-ui.html`.

The shared security configuration permits local Swagger and API access because this project currently validates bearer tokens explicitly inside IAM endpoints instead of using a global JWT filter.

## How To Run Or Test

1. Run `mvn test` to compile and execute the Spring context test.
2. Start the application with `mvn spring-boot:run`.
3. Open `http://localhost:8080/swagger-ui.html`.
4. Register a user with `POST /api/auth/register`.
5. Log in with `POST /api/auth/login`.
6. Use the returned token as `Authorization: Bearer <token>` for `/me`, `/validate`, and `/logout`.

## Example Request

```json
{
  "email": "patient@example.com",
  "password": "Password123",
  "fullName": "Patient Example",
  "role": "PATIENT"
}
```

## Changes In This Feature Branch

- Added explicit Swagger/OpenAPI documentation to IAM endpoints.
- Added session validation endpoint with optional role enforcement.
- Changed `lockedUntil` from an invalid UUID field to a timestamp.
- Added 30-minute mock token expiration.
- Added in-memory token revocation for logout.
- Added HTTP 401 handling for invalid credentials and HTTP 423 handling for locked accounts.
- Configured local Spring Security to allow Swagger and REST testing while IAM handles mock bearer-token validation.

## Technical Considerations

- Tokens are intentionally simple mock tokens for this academic backend. A production implementation should replace them with signed JWTs or an identity provider such as Keycloak, Auth0, or Cognito.
- In-memory token revocation is suitable only for local execution; it resets when the application restarts.
- Authorization for domain resources remains the responsibility of the owning bounded context or the future Compartir Perfiles bounded context.
