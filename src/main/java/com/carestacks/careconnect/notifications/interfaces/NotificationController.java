package com.carestacks.careconnect.notifications.interfaces;

import com.carestacks.careconnect.notifications.application.abstractions.NotificationService;
import com.carestacks.careconnect.notifications.application.notifications.dtos.AlertDto;
import com.carestacks.careconnect.notifications.application.notifications.dtos.NotificationDto;
import com.carestacks.careconnect.notifications.application.notifications.dtos.NotificationPreferenceDto;
import com.carestacks.careconnect.notifications.application.notifications.requests.CreateAlertRequest;
import com.carestacks.careconnect.notifications.application.notifications.requests.CreateNotificationRequest;
import com.carestacks.careconnect.notifications.application.notifications.requests.ScheduleEventNotificationRequest;
import com.carestacks.careconnect.notifications.application.notifications.requests.UpdateNotificationPreferenceRequest;
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
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<NotificationDto> create(@Valid @RequestBody CreateNotificationRequest request) {
        var notification = notificationService.create(request);
        return ResponseEntity.created(URI.create("/api/notifications/" + notification.id())).body(notification);
    }

    @PostMapping("/reminders")
    public ResponseEntity<NotificationDto> scheduleReminder(@Valid @RequestBody ScheduleEventNotificationRequest request) {
        var notification = notificationService.scheduleReminder(request);
        return ResponseEntity.created(URI.create("/api/notifications/" + notification.id())).body(notification);
    }

    @GetMapping
    public ResponseEntity<List<NotificationDto>> getAll() {
        return ResponseEntity.ok(notificationService.getAll());
    }

    @GetMapping("/recipient/{recipientId}")
    public ResponseEntity<List<NotificationDto>> getByRecipient(@PathVariable UUID recipientId) {
        return ResponseEntity.ok(notificationService.getByRecipient(recipientId));
    }

    @GetMapping("/recipient/{recipientId}/unread")
    public ResponseEntity<List<NotificationDto>> getUnreadByRecipient(@PathVariable UUID recipientId) {
        return ResponseEntity.ok(notificationService.getUnreadByRecipient(recipientId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(notificationService.getById(id));
    }

    @PatchMapping("/{id}/send")
    public ResponseEntity<NotificationDto> markAsSent(@PathVariable UUID id) {
        return ResponseEntity.ok(notificationService.markAsSent(id));
    }

    @PatchMapping("/{id}/read")
    public ResponseEntity<NotificationDto> markAsRead(@PathVariable UUID id) {
        return ResponseEntity.ok(notificationService.markAsRead(id));
    }

    @PatchMapping("/read-all")
    public ResponseEntity<List<NotificationDto>> markAllAsRead(@RequestParam UUID recipientId) {
        return ResponseEntity.ok(notificationService.markAllAsRead(recipientId));
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<NotificationDto> cancel(@PathVariable UUID id) {
        return ResponseEntity.ok(notificationService.cancel(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        notificationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/alerts")
    public ResponseEntity<AlertDto> triggerAlert(@Valid @RequestBody CreateAlertRequest request) {
        var alert = notificationService.triggerAlert(request);
        return ResponseEntity.created(URI.create("/api/notifications/alerts/" + alert.id())).body(alert);
    }

    @GetMapping("/alerts/active")
    public ResponseEntity<List<AlertDto>> getActiveAlerts(@RequestParam UUID recipientId) {
        return ResponseEntity.ok(notificationService.getActiveAlerts(recipientId));
    }

    @PatchMapping("/alerts/{id}/resolve")
    public ResponseEntity<AlertDto> resolveAlert(@PathVariable UUID id) {
        return ResponseEntity.ok(notificationService.resolveAlert(id));
    }

    @GetMapping("/preferences/{recipientId}")
    public ResponseEntity<NotificationPreferenceDto> getPreference(@PathVariable UUID recipientId) {
        return ResponseEntity.ok(notificationService.getPreference(recipientId));
    }

    @PutMapping("/preferences/{recipientId}")
    public ResponseEntity<NotificationPreferenceDto> updatePreference(
            @PathVariable UUID recipientId,
            @Valid @RequestBody UpdateNotificationPreferenceRequest request
    ) {
        return ResponseEntity.ok(notificationService.updatePreference(recipientId, request));
    }
}
