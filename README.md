# Feature: Agenda Module

> Módulo de gestión de agenda y citas para CareConnect.

## Estado: 🚧 En Desarrollo

## Funcionalidades

- Programación de citas médicas
- Gestión de terapias y tratamientos
- Calendario de medicación
- Historial de eventos del paciente

## Endpoints Principales

```
POST   /api/agenda          - Crear evento
GET    /api/agenda          - Listar eventos
GET    /api/agenda/{id}     - Obtener evento
PUT    /api/agenda/{id}     - Actualizar evento
DELETE /api/agenda/{id}     - Eliminar evento
GET    /api/agenda/calendar - Ver calendario completo
```

## Tecnologías

- Spring Boot 4.0.6
- Spring Data JPA
- MySQL

## Integración

Esta rama se integra a `develop` cuando esté lista para testing.

```
feature/agenda → develop → main
```