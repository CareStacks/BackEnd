# Notifications Bounded Context

## Purpose

Notifications detects pending health events, schedules reminders, records delivery/read states, manages escalation alerts, and stores recipient notification preferences.

## Responsibilities From INFO.md

- Schedule reminders at least 24 hours before health events.
- Send or mark notification delivery through an explicit state transition.
- Track notification states such as scheduled, sent, delivered, read, failed, and cancelled.
- Trigger escalation alerts when events are not confirmed in time.
- Let recipients review notification history and unread notifications.
- Manage channel and priority preferences for each recipient.
- Keep health-event scheduling in Agenda and user identity in IAM.

## Internal Architecture

- `domain/notifications/entities`: `Notification`, `Alert`, and `NotificationPreference`.
- `domain/notifications/enums`: delivery channel, type, priority, and status catalogs.
- `application/abstractions`: `NotificationService` use-case contract.
- `application/notifications/dtos`: Response DTOs for notifications, alerts, and preferences.
- `application/notifications/requests`: Validated request bodies.
- `infrastructure`: Application service, JPA entities, repositories, and mappers.
- `interfaces`: REST controller documented for Swagger/OpenAPI.

## Main Entities

- `Notification`: Message scheduled or sent to a recipient.
- `Alert`: Escalation record for unconfirmed or critical health events.
- `NotificationPreference`: Recipient delivery-channel and priority settings.

## Implemented Use Cases

- Create a notification.
- Schedule a health-event reminder.
- List all notifications.
- List notifications by recipient.
- List unread notifications by recipient.
- Get a notification by ID.
- Mark a notification as sent.
- Mark one or all recipient notifications as read.
- Cancel and delete notifications.
- Trigger and resolve alerts.
- List active alerts.
- Get and update notification preferences.

## Endpoints

| Method | Path | Description |
| --- | --- | --- |
| `POST` | `/api/notifications` | Creates a notification. |
| `POST` | `/api/notifications/reminders` | Schedules a reminder 24 hours before a health event. |
| `GET` | `/api/notifications` | Lists all notifications. |
| `GET` | `/api/notifications/recipient/{recipientId}` | Lists notification history for a recipient. |
| `GET` | `/api/notifications/recipient/{recipientId}/unread` | Lists unread notifications for a recipient. |
| `GET` | `/api/notifications/{id}` | Gets a notification by ID. |
| `PATCH` | `/api/notifications/{id}/send` | Marks a notification as sent. |
| `PATCH` | `/api/notifications/{id}/read` | Marks a notification as read. |
| `PATCH` | `/api/notifications/read-all?recipientId={recipientId}` | Marks all recipient notifications as read. |
| `PATCH` | `/api/notifications/{id}/cancel` | Cancels a notification. |
| `DELETE` | `/api/notifications/{id}` | Deletes a notification. |
| `POST` | `/api/notifications/alerts` | Triggers an escalation alert. |
| `GET` | `/api/notifications/alerts/active?recipientId={recipientId}` | Lists unresolved alerts. |
| `PATCH` | `/api/notifications/alerts/{id}/resolve` | Resolves an alert. |
| `GET` | `/api/notifications/preferences/{recipientId}` | Gets recipient preferences. |
| `PUT` | `/api/notifications/preferences/{recipientId}` | Updates recipient preferences. |

## Pending Endpoints

- No direct integration with Firebase Cloud Messaging or SendGrid is implemented. Delivery is represented through state transitions and persisted metadata.
- No asynchronous event listener from Agenda exists yet; reminders are created through the REST endpoint.

## Corrected Endpoints

- Swagger/OpenAPI documentation was added for every Notifications endpoint.

## Swagger/OpenAPI

`NotificationController` is annotated with `@Tag`, `@Operation`, and `@ApiResponses`. The endpoints are exposed under the `Notifications` tag in Swagger UI at `/swagger-ui.html`.

## How To Run Or Test

1. Run `mvn test`.
2. Start the application with `mvn spring-boot:run`.
3. Open `http://localhost:8080/swagger-ui.html`.
4. Create a notification or reminder.
5. Query by recipient, mark it as sent/read, and trigger or resolve alerts.

## Changes In This Feature Branch

- Added explicit Swagger/OpenAPI documentation for all Notifications endpoints.
- Added this bounded-context-specific README.

## Technical Considerations

- Agenda remains the owner of health-event scheduling.
- IAM remains the owner of user identity.
- Notification delivery providers are future infrastructure adapters; current implementation persists notification state.
