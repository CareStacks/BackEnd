package com.carestacks.careconnect.notifications.application.abstractions;

import com.carestacks.careconnect.notifications.application.notifications.dtos.AlertDto;
import com.carestacks.careconnect.notifications.application.notifications.dtos.NotificationDto;
import com.carestacks.careconnect.notifications.application.notifications.dtos.NotificationPreferenceDto;
import com.carestacks.careconnect.notifications.application.notifications.requests.CreateAlertRequest;
import com.carestacks.careconnect.notifications.application.notifications.requests.CreateNotificationRequest;
import com.carestacks.careconnect.notifications.application.notifications.requests.ScheduleEventNotificationRequest;
import com.carestacks.careconnect.notifications.application.notifications.requests.UpdateNotificationPreferenceRequest;

import java.util.List;
import java.util.UUID;

public interface NotificationService {

    NotificationDto create(CreateNotificationRequest request);

    NotificationDto scheduleReminder(ScheduleEventNotificationRequest request);

    NotificationDto getById(UUID id);

    List<NotificationDto> getAll();

    List<NotificationDto> getByRecipient(UUID recipientId);

    List<NotificationDto> getUnreadByRecipient(UUID recipientId);

    NotificationDto markAsSent(UUID id);

    NotificationDto markAsRead(UUID id);

    List<NotificationDto> markAllAsRead(UUID recipientId);

    NotificationDto cancel(UUID id);

    void delete(UUID id);

    AlertDto triggerAlert(CreateAlertRequest request);

    AlertDto resolveAlert(UUID id);

    List<AlertDto> getActiveAlerts(UUID recipientId);

    NotificationPreferenceDto getPreference(UUID recipientId);

    NotificationPreferenceDto updatePreference(UUID recipientId, UpdateNotificationPreferenceRequest request);
}
