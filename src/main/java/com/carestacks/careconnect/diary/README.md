# Diary Bounded Context

## Propósito
El bounded context de Diary gestiona el registro y consulta de notas personales del paciente sobre su evolución diaria, síntomas, estado de ánimo y cualquier otro aspecto relevante para su seguimiento médico. Permite al paciente llevar un registro cronológico de su condición de salud que puede ser consultado tanto por él mismo como por sus cuidadores autorizados.

## Responsabilidades Principales
- Creación de nuevas entradas de diario con contenido textual y timestamp automático
- Consulta de entradas individuales por su identificador
- Listado de todas las entradas del diario ordenadas por fecha (más recientes primero)
- Actualización de entradas existentes
- Eliminación de entradas del diario
- Validación de que el contenido no exceda el límite de caracteres permitido

## Estructura Interna de Carpetas
```
src/main/java/com/carestacks/careconnect/diary/
├── application/
│   └── diary/
│       ├── abstractions/          # Interfaces de servicios de aplicación
│       ├── dtos/                  # Objetos de transferencia de datos
│       ├── requests/              # DTOs para requests entrantes
│       └── services/              # Implementaciones de servicios de aplicación
├── domain/
│   └── diary/
│       ├── entities/              # Entidades de dominio (DiaryEntry)
│       ├── enums/                 # Enumeraciones de dominio (none currently)
│       └── valueobjects/          # Value objects (EntryContent, EntryDate)
├── infrastructure/
│   ├── DiaryServiceImpl.java      # Implementación del servicio de diario
│   ├── infrastructure/
│   │   ├── mappers/               # Mapeadores entre capas
│   │   ├── persistence/           # Entidades JPA
│   │   └── repositories/          # Interfaces de repositorio Spring Data
│   └── interfaces/                # REST Controllers
└── README.md                      # Este archivo
```

## Entidades, Casos de Uso o Componentes Principales

### Entidad de Dominio: `DiaryEntry`
Representa una entrada individual en el diario del paciente con los siguientes atributos:
- `id`: UUID único
- `content`: Contenido textual de la entrada (máximo 2000 caracteres)
- `entryDate`: Fecha y hora de creación de la entrada

### Value Objects
- `EntryContent`: Encapsula el contenido textual con validación de longitud
- `EntryDate`: Representa la fecha de creación (puede extenderse para incluir hora)

### Casos de Uso Principales
1. **Creación de Entrada**
   - Validar que el contenido no esté vacío
   - Validar que el contenido no exceda 2000 caracteres
   - Asignar timestamp automático si no se proporciona
   - Persistir la entrada en base de datos

2. **Consulta de Entrada**
   - Recuperar una entrada específica por su ID
   - Devolver error si la entrada no existe

3. **Listado de Entradas**
   - Obtener todas las entradas ordenadas por fecha (descendente)
   - Soporte para paginación (futuro)

4. **Actualización de Entrada**
   - Validar que la entrada exista
   - Validar el nuevo contenido
   - Actualizar el timestamp si se modifica el contenido
   - Persistir los cambios

5. **Eliminación de Entrada**
   - Validar que la entrada exista
   - Eliminar la entrada de forma permanente

### Componentes de Infraestructura
- **Repositorio**: `DiaryRepository` define el contrato de persistencia
- **Repositorio Implementado**: `DiaryRepositoryImpl` usa Spring Data JPA
- **Entidad JPA**: `DiaryEntryJpaEntity` mapea la entidad de dominio a tabla `diary_entries`
- **Mappers**: `DiaryMapper` convierte entre entidades de dominio, DTOs y entidades JPA
- **Controlador**: `DiaryController` expone los endpoints REST

## Endpoints Disponibles
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/diary` | Crear nueva entrada de diario |
| `GET`  | `/api/diary/{id}` | Obtener entrada por ID |
| `GET`  | `/api/diary` | Listar todas las entradas |
| `PUT`  | `/api/diary/{id}` | Actualizar entrada existente |
| `DELETE` | `/api/diary/{id}` | Eliminar entrada |

### Detalles de los Endpoints

#### Crear Entrada de Diario
- **Request Body**: 
  ```json
  {
    "content": "Hoy me siento mejor, tomé mi medicación a tiempo y caminé 20 minutos."
  }
  ```
- **Responses**:
  - `201 Created`: Entrada creada exitosamente
  - `400 Bad Request`: Contenido inválido o excede límite de caracteres

#### Obtener Entrada por ID
- **Path Variable**: `id` (Long)
- **Responses**:
  - `200 OK`: 
    ```json
    {
      "id": 1,
      "content": "Hoy me siento mejor...",
      "entryDate": "2026-05-13T10:30:00"
    }
    ```
  - `404 Not Found`: Entrada no encontrada

#### Listar Todas las Entradas
- **Responses**:
  - `200 OK`: Array de objetos DiaryEntryDto ordenados por entryDate descendente
  - `200 OK`: Array vacío si no hay entradas

#### Actualizar Entrada
- **Path Variable**: `id` (Long)
- **Request Body**: Mismo formato que creación
- **Responses**:
  - `200 OK`: Entrada actualizada exitosamente
  - `400 Bad Request`: Contenido inválido
  - `404 Not Found`: Entrada no encontrada

#### Eliminar Entrada
- **Path Variable**: `id` (Long)
- **Responses**:
  - `204 No Content`: Entrada eliminada exitosamente
  - `404 Not Found`: Entrada no encontrada

## Dependencias o Integraciones Relevantes
- **Spring Boot Starter Web**: Para exposición de endpoints REST
- **Spring Boot Starter Data JPA**: Para persistencia en base de datos
- **Spring Boot Starter Validation**: Para validación de requests con jakarta.validation
- **Springdoc OpenAPI Starter Webmvc UI**: Para generación automática de documentación Swagger
- **Base de Datos**: Configurada para usar H2 en desarrollo y PostgreSQL en producción
- **Nota**: No requiere dependencias de autenticación directa ya que asumirá que el contexto de IAM maneja la seguridad a través de filtros o interceptors en capas superiores

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
# Crear una nueva entrada
curl -X POST http://localhost:8080/api/diary \
  -H "Content-Type: application/json" \
  -d '{"content":"Hoy me siento mejor, tomé mi medicación a tiempo y caminé 20 minutos."}'

# Obtener entrada por ID (asumiendo ID=1)
curl -X GET http://localhost:8080/api/diary/1

# Listar todas las entradas
curl -X GET http://localhost:8080/api/diary

# Actualizar entrada (asumiendo ID=1)
curl -X PUT http://localhost:8080/api/diary/1 \
  -H "Content-Type: application/json" \
  -d '{"content":"Hoy tuve un buen día, medité por 10 minutos y no tuve dolor."}'

# Eliminar entrada (asumiendo ID=1)
curl -X DELETE http://localhost:8080/api/diary/1
```

#### Usando Swagger UI
Acceder a: `http://localhost:8080/swagger-ui.html`
- Navegar a la sección "diary-controller"
- Probar cada endpoint directamente desde la interfaz

### Validación de Funcionamiento
1. Verificar que la creación falle con contenido vacío
2. Verificar que la creación falle con contenido > 2000 caracteres
3. Verificar que las entradas se listen en orden descendente por fecha
4. Verificar que la actualización modifique correctamente el contenido
5. Verificar que la eliminación remueva permanentemente la entrada
6. Verificar que las operaciones devuelvan códigos de estado HTTP apropiados

## Notas de Implementación
- El contexto sigue los principios de Domain-Driven Design con separación clara de capas (Domain, Application, Infrastructure, Interface).
- Todas las operaciones de escritura son transaccionales para asegurar consistencia de datos.
- Se utiliza validación mediante jakarta.validation para asegurar la integridad de los datos de entrada.
- El timestamp de entrada se establece automáticamente si no se proporciona, pero puede ser sobrescrito para casos de uso especiales (como importar datos históricos).
- Las entradas son inmutables en cuanto a su identificador y fecha de creación una vez persistidas (solo el contenido puede actualizarse).
- Se asume que la autorización y autenticación se manejan en capas superiores del API Gateway o mediante filtros de Spring Security que validarán tokens antes de llegar a este controlador.
- En el futuro, se podría extender para incluir:
  - Soporte para adjuntar imágenes o archivos a las entradas
  - Etiquetado o categorización de entradas
  - Compartir entradas específicas con cuidadores
  - Análisis de tendencias o patrones en el contenido
