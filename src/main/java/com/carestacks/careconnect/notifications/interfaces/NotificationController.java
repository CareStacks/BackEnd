package com.carestacks.careconnect.notifications.interfaces;

import com.carestacks.careconnect.notifications.application.abstractions.NotificationService;
import com.carestacks.careconnect.notifications.application.notifications.dtos.AlertDto;
import com.carestacks.careconnect.notifications.application.notifications.dtos.NotificationDto;
import com.carestacks.careconnect.notifications.application.notifications.dtos.NotificationPreferenceDto;
import com.carestacks.careconnect.notifications.application.notifications.requests.CreateAlertRequest;
import com.carestacks.careconnect.notifications.application.notifications.requests.CreateNotificationRequest;
import com.carestacks.careconnect.notifications.application.notifications.requests.ScheduleEventNotificationRequest;
import com.carestacks.careconnect.notifications.application.notifications.requests.UpdateNotificationPreferenceRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notifications")
@Tag(name = "Notifications", description = "Notification, reminder, alert, read-state, and preference endpoints")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Operation(summary = "Create a notification", description = "Schedules or registers a notification for a recipient and delivery channel.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Notification created",
                    content = @Content(schema = @Schema(implementation = NotificationDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid notification data")
    })
    @PostMapping
    public ResponseEntity<NotificationDto> create(@Valid @RequestBody CreateNotificationRequest request) {
        var notification = notificationService.create(request);
        return ResponseEntity.created(URI.create("/api/notifications/" + notification.id())).body(notification);
    }

    @Operation(summary = "Schedule event reminder", description = "Creates a reminder notification 24 hours before a health event.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Reminder notification scheduled",
                    content = @Content(schema = @Schema(implementation = NotificationDto.class))),
            @ApiResponse(responseCode = "400", description = "Event is too close or request is invalid")
    })
    @PostMapping("/reminders")
    public ResponseEntity<NotificationDto> scheduleReminder(@Valid @RequestBody ScheduleEventNotificationRequest request) {
        var notification = notificationService.scheduleReminder(request);
        return ResponseEntity.created(URI.create("/api/notifications/" + notification.id())).body(notification);
    }

    @Operation(summary = "List notifications", description = "Returns every notification ordered by creation date.")
    @ApiResponse(responseCode = "200", description = "Notifications returned")
    @GetMapping
    public ResponseEntity<List<NotificationDto>> getAll() {
        return ResponseEntity.ok(notificationService.getAll());
    }

    @Operation(summary = "List notifications by recipient", description = "Returns notification history for a recipient.")
    @ApiResponse(responseCode = "200", description = "Recipient notifications returned")
    @GetMapping("/recipient/{recipientId}")
    public ResponseEntity<List<NotificationDto>> getByRecipient(
            @Parameter(description = "Recipient user identifier") @PathVariable UUID recipientId
    ) {
        return ResponseEntity.ok(notificationService.getByRecipient(recipientId));
    }

    @Operation(summary = "List unread notifications", description = "Returns scheduled, sent, or delivered notifications not marked as read.")
    @ApiResponse(responseCode = "200", description = "Unread notifications returned")
    @GetMapping("/recipient/{recipientId}/unread")
    public ResponseEntity<List<NotificationDto>> getUnreadByRecipient(
            @Parameter(description = "Recipient user identifier") @PathVariable UUID recipientId
    ) {
        return ResponseEntity.ok(notificationService.getUnreadByRecipient(recipientId));
    }

    @Operation(summary = "Get a notification", description = "Returns a notification by ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Notification returned"),
            @ApiResponse(responseCode = "404", description = "Notification not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<NotificationDto> getById(
            @Parameter(description = "Notification identifier") @PathVariable UUID id
    ) {
        return ResponseEntity.ok(notificationService.getById(id));
    }

    @Operation(summary = "Mark notification as sent", description = "Moves a scheduled notification to the sent state.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Notification marked as sent"),
            @ApiResponse(responseCode = "400", description = "Invalid notification transition"),
            @ApiResponse(responseCode = "404", description = "Notification not found")
    })
    @PatchMapping("/{id}/send")
    public ResponseEntity<NotificationDto> markAsSent(
            @Parameter(description = "Notification identifier") @PathVariable UUID id
    ) {
        return ResponseEntity.ok(notificationService.markAsSent(id));
    }

    @Operation(summary = "Mark notification as read", description = "Marks a notification as read by its recipient.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Notification marked as read"),
            @ApiResponse(responseCode = "400", description = "Invalid notification transition"),
            @ApiResponse(responseCode = "404", description = "Notification not found")
    })
    @PatchMapping("/{id}/read")
    public ResponseEntity<NotificationDto> markAsRead(
            @Parameter(description = "Notification identifier") @PathVariable UUID id
    ) {
        return ResponseEntity.ok(notificationService.markAsRead(id));
    }

    @Operation(summary = "Mark all recipient notifications as read", description = "Marks all unread notifications for a recipient as read.")
    @ApiResponse(responseCode = "200", description = "Notifications marked as read")
    @PatchMapping("/read-all")
    public ResponseEntity<List<NotificationDto>> markAllAsRead(
            @Parameter(description = "Recipient user identifier") @RequestParam UUID recipientId
    ) {
        return ResponseEntity.ok(notificationService.markAllAsRead(recipientId));
    }

    @Operation(summary = "Cancel a notification", description = "Cancels a scheduled notification that should not be delivered.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Notification cancelled"),
            @ApiResponse(responseCode = "400", description = "Invalid notification transition"),
            @ApiResponse(responseCode = "404", description = "Notification not found")
    })
    @PatchMapping("/{id}/cancel")
    public ResponseEntity<NotificationDto> cancel(
            @Parameter(description = "Notification identifier") @PathVariable UUID id
    ) {
        return ResponseEntity.ok(notificationService.cancel(id));
    }

    @Operation(summary = "Delete a notification", description = "Deletes a notification record.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Notification deleted"),
            @ApiResponse(responseCode = "404", description = "Notification not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "Notification identifier") @PathVariable UUID id
    ) {
        notificationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Trigger an alert", description = "Creates an escalation alert when a health event is not confirmed in time.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Alert triggered",
                    content = @Content(schema = @Schema(implementation = AlertDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid alert data")
    })
    @PostMapping("/alerts")
    public ResponseEntity<AlertDto> triggerAlert(@Valid @RequestBody CreateAlertRequest request) {
        var alert = notificationService.triggerAlert(request);
        return ResponseEntity.created(URI.create("/api/notifications/alerts/" + alert.id())).body(alert);
    }

    @Operation(summary = "List active alerts", description = "Returns unresolved alerts for a recipient.")
    @ApiResponse(responseCode = "200", description = "Active alerts returned")
    @GetMapping("/alerts/active")
    public ResponseEntity<List<AlertDto>> getActiveAlerts(
            @Parameter(description = "Recipient user identifier") @RequestParam UUID recipientId
    ) {
        return ResponseEntity.ok(notificationService.getActiveAlerts(recipientId));
    }

    @Operation(summary = "Resolve an alert", description = "Marks an active alert as resolved.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Alert resolved"),
            @ApiResponse(responseCode = "404", description = "Alert not found")
    })
    @PatchMapping("/alerts/{id}/resolve")
    public ResponseEntity<AlertDto> resolveAlert(
            @Parameter(description = "Alert identifier") @PathVariable UUID id
    ) {
        return ResponseEntity.ok(notificationService.resolveAlert(id));
    }

    @Operation(summary = "Get notification preferences", description = "Returns recipient notification preferences, creating defaults if none exist.")
    @ApiResponse(responseCode = "200", description = "Notification preferences returned")
    @GetMapping("/preferences/{recipientId}")
    public ResponseEntity<NotificationPreferenceDto> getPreference(
            @Parameter(description = "Recipient user identifier") @PathVariable UUID recipientId
    ) {
        return ResponseEntity.ok(notificationService.getPreference(recipientId));
    }

    @Operation(summary = "Update notification preferences", description = "Updates channel preferences and minimum priority for a recipient.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Notification preferences updated"),
            @ApiResponse(responseCode = "400", description = "Invalid preference data")
    })
    @PutMapping("/preferences/{recipientId}")
    public ResponseEntity<NotificationPreferenceDto> updatePreference(
            @Parameter(description = "Recipient user identifier") @PathVariable UUID recipientId,
            @Valid @RequestBody UpdateNotificationPreferenceRequest request
    ) {
        return ResponseEntity.ok(notificationService.updatePreference(recipientId, request));
    }
}
