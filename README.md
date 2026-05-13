# CareConnect Backend

Backend REST API para la aplicación móvil CareConnect - Gestión de cuidado geriátrico.

## Stack Tecnológico

- **Framework:** Spring Boot 4.0.6
- **Lenguaje:** Java 25
- **Build:** Maven
- **Base de datos:** MySQL 8.0+
- **ORM:** Spring Data JPA / Hibernate 7.x

## Estructura del Proyecto

```
src/main/java/com/careconnect/
├── careconnect/
│   ├── controller/       # REST Controllers
│   ├── service/          # Business Logic
│   ├── repository/      # Data Access
│   ├── domain/          # Entities & DTOs
│   ├── exception/       # Custom Exceptions
│   └── config/          # Configuration
```

## Configuración

### Base de Datos

```yaml
# application.yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/careconnect
    username: root
    password: ${DB_PASSWORD}
```

### Variables de Entorno

```bash
DB_URL=jdbc:mysql://localhost:3306/careconnect
DB_USERNAME=root
DB_PASSWORD=TuPassword
```

## Ejecución

```bash
# Desarrollo
mvn spring-boot:run

# Build
mvn clean package
```

## Puertos

- **API:** http://localhost:8080
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **API Docs:** http://localhost:8080/v3/api-docs

## Ramas del Proyecto

| Rama | Descripción |
|------|-------------|
| `main` | Rama principal (producción) |
| `develop` | Rama de desarrollo integración |
| `feature/notifications` | Módulo de notificaciones |
| `feature/agenda` | Módulo de agenda/citas |

## Equipo

- Salcedo Champi, Matias Rodolfo (U202319698)
- Costa Morales, Christofer William (U202315968)
- Nikaido Vargas, Javier Masaru (U20221G099)
- Osores Marchese, Pietro (U202310971)
- Santillan Alvarado, Melina Liz (U202216058)

---

**Universidad Peruana de Ciencias Aplicadas (UPC)**  
Ingeniería de Software - 2026