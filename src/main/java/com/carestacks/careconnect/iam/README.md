# IAM (Identity and Access Management) Bounded Context

## Propósito
El bounded context de IAM gestiona el registro de usuarios, autenticación y administración de sesiones para todos los actores del sistema (pacientes y cuidadores). Es un prerequisito de todo el sistema, ya que ningún otro contexto puede operar sin primero verificar la identidad del usuario.

## Responsabilidades Principales
- Registro de nuevos usuarios con validación de email único y contraseña segura
- Autenticación de usuarios mediante email y contraseña
- Generación y validación de tokens de sesión
- Gestión de sesiones (inicio, cierre, expiración)
- Bloqueo de cuentas tras múltiples intentos fallidos de login
- Validación de acceso por rol (PATIENT o CAREGIVER)
- Invalidez de tokens al cerrar sesión

## Estructura Interna de Carpetas
```
src/main/java/com/carestacks/careconnect/iam/
├── application/
│   └── iam/
│       ├── abstractions/          # Interfaces de servicios de aplicación
│       ├── dtos/                  # Objetos de transferencia de datos
│       └── requests/              # DTOs para requests entrantes
├── domain/
│   └── iam/
│       ├── entities/              # Entidades de dominio (User)
│       ├── enums/                 # Enumeraciones de dominio (UserRole)
│       └── valueobjects/          # Value objects (none currently)
├── infrastructure/
│   ├── AuthServiceImpl.java       # Implementación del servicio de autenticación
│   ├── infrastructure/
│   │   ├── mappers/               # Mapeadores entre capas
│   │   ├── persistence/           # Entidades JPA
│   │   └── repositories/          # Interfaces de repositorio Spring Data
│   └── interfaces/                # REST Controllers
└── README.md                      # Este archivo
```

## Entidades, Casos de Uso o Componentes Principales

### Entidad de Dominio: `User`
Representa a un usuario registrado en el sistema con los siguientes atributos:
- `id`: UUID único
- `email`: Email único (utilizado para login)
- `passwordHash`: Hash seguro de la contraseña
- `fullName`: Nombre completo del usuario
- `role`: Rol del usuario (PATIENT o CAREGIVER)
- `active`: Estado de activación de la cuenta
- `failedLoginAttempts`: Contador de intentos fallidos de login
- `lockedUntil`: Timestamp de cuándo se desbloqueará la cuenta
- `createdAt` y `updatedAt`: Timestamps de auditoría

### Casos de Uso Principales
1. **Registro de Usuario** (`RegisterUserRequest`)
   - Validar formato de email
   - Validar fortaleza de contraseña (mínimo 8 caracteres, número y mayúscula)
   - Verificar unicidad de email
   - Crear usuario con rol especificado

2. **Autenticación** (`LoginRequest`)
   - Verificar existencia de email
   - Validar contraseña mediante hash
   - Gestionar intentos fallidos (bloqueo tras 5 intentos)
   - Generar token de sesión válido

3. **Gestión de Sesión**
   - Validar token de sesión
   - Cerrar sesión (invalidez de token)
   - Obtener información del usuario actual

### Componentes de Infraestructura
- **Repositorio**: `UserJpaRepository` extiende `JpaRepository` para operaciones CRUD
- **Entidad JPA**: `UserJpaEntity` mapea la entidad de dominio a tabla `users`
- **Mappers**: `UserMapper` convierte entre entidades de dominio, DTOs y entidades JPA
- **Controlador**: `AuthController` expone los endpoints REST

## Endpoints Disponibles
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/auth/register` | Registrar nuevo usuario |
| `POST` | `/api/auth/login` | Iniciar sesión y obtener token |
| `POST` | `/api/auth/logout` | Cerrar sesión |
| `GET`  | `/api/auth/me` | Obtener información del usuario actual (requiere token) |

### Detalles de los Endpoints

#### Registro de Usuario
- **Request Body**: 
  ```json
  {
    "email": "usuario@ejemplo.com",
    "password": "Password123",
    "fullName": "Nombre Apellido",
    "role": "PATIENT"
  }
  ```
- **Responses**:
  - `201 Created`: Usuario creado exitosamente
  - `400 Bad Request`: Datos inválidos o email ya existente

#### Inicio de Sesión
- **Request Body**:
  ```json
  {
    "email": "usuario@ejemplo.com",
    "password": "Password123"
  }
  ```
- **Responses**:
  - `200 OK`: 
    ```json
    {
      "token": "mock-token-uuid-generado",
      "type": "Bearer",
      "expiresIn": 3600
    }
    ```
  - `401 Unauthorized`: Credenciales inválidas
  - `423 Locked`: Cuenta bloqueada por intentos fallidos

#### Cierre de Sesión
- **Request Headers**:
  ```
  Authorization: Bearer mock-token-uuid-generado
  ```
- **Responses**:
  - `204 No Content`: Sesión cerrada exitosamente

#### Obtener Usuario Actual
- **Request Headers**:
  ```
  Authorization: Bearer mock-token-uuid-generado
  ```
- **Responses**:
  - `200 OK`: 
    ```json
    {
      "id": "uuid-generado",
      "email": "usuario@ejemplo.com",
      "fullName": "Nombre Apellido",
      "role": "PATIENT",
      "active": true,
      "createdAt": "2026-05-13T10:30:00",
      "updatedAt": "2026-05-13T10:30:00"
    }
    ```
  - `401 Unauthorized`: Token inválido o ausente

## Dependencias o Integraciones Relevantes
- **Spring Boot Starter Web**: Para exposición de endpoints REST
- **Spring Boot Starter Data JPA**: Para persistencia en base de datos
- **Spring Boot Starter Validation**: Para validación de requests con jakarta.validation
- **Springdoc OpenAPI Starter Webmvc UI**: Para generación automática de documentación Swagger
- **Base de Datos**: Configurada para usar H2 en desarrollo y PostgreSQL en producción
- **PasswordEncoder**: Implementación de Spring Security para hash seguro de contraseñas (BCrypt por defecto)

## Cómo Ejecutar o Probar este Módulo

### Prerrequisitos
- Java 25 instalado
- Maven 3.8+ instalado
- Base de datos configurada (por defecto usa H2 en memoria)

### Pasos para Ejecutar
1. Clonar el repositorio
2. Navegar al directorio del proyecto
3. Ejecutar: `./mvnw spring-boot:run`
4. La aplicación iniciará en el puerto 8080 por defecto

### Probar los Endpoints
Una vez la aplicación esté corriendo, puede probar los endpoints usando:

#### Usando curl
```bash
# Registrar un nuevo usuario
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com","password":"Password123","fullName":"Test User","role":"PATIENT"}'

# Iniciar sesión
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com","password":"Password123"}'

# Obtener usuario actual (usar el token del login anterior)
curl -X GET http://localhost:8080/api/auth/me \
  -H "Authorization: Bearer <token-del-paso-anterior>"

# Cerrar sesión
curl -X POST http://localhost:8080/api/auth/logout \
  -H "Authorization: Bearer <token-del-paso-anterior>"
```

#### Usando Swagger UI
Acceder a: `http://localhost:8080/swagger-ui.html`
- Navegar a la sección "auth-controller"
- Probar cada endpoint directamente desde la interfaz

### Validación de Funcionamiento
1. Verificar que el registro falle con email duplicado
2. Verificar que el login falle con contraseña incorrecta
3. Verificar que la cuenta se bloquee tras 5 intentos fallidos
4. Verificar que los tokens expiren (en implementación real, actualmente son mocks)
5. Verificar que solo usuarios activos puedan autenticarse

## Notas de Implementación
- Este contexto utiliza un enfoque de "mock tokens" para simplicidad en desarrollo. En producción, se debería implementar JWT válido con firma y expiración propera.
- La contraseña se almacena usando BCrypt mediante Spring Security's PasswordEncoder.
- El contexto sigue los principios de Domain-Driven Design con separación clara de capas.
- Todas las operaciones de escritura son transaccionales para asegurar consistencia de datos.
- Se maneja explícitamente el caso de cuenta bloqueada por intentos fallidos de login.