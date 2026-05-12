package com.carestacks.careconnect.notifications.infrastructure;

import com.carestacks.careconnect.notifications.application.abstractions.NotificationService;
import com.carestacks.careconnect.notifications.application.notifications.dtos.AlertDto;
import com.carestacks.careconnect.notifications.application.notifications.dtos.NotificationDto;
import com.carestacks.careconnect.notifications.application.notifications.dtos.NotificationPreferenceDto;
import com.carestacks.careconnect.notifications.application.notifications.requests.CreateAlertRequest;
import com.carestacks.careconnect.notifications.application.notifications.requests.CreateNotificationRequest;
import com.carestacks.careconnect.notifications.application.notifications.requests.ScheduleEventNotificationRequest;
import com.carestacks.careconnect.notifications.application.notifications.requests.UpdateNotificationPreferenceRequest;
import com.carestacks.careconnect.notifications.domain.notifications.entities.Alert;
import com.carestacks.careconnect.notifications.domain.notifications.entities.Notification;
import com.carestacks.careconnect.notifications.domain.notifications.entities.NotificationPreference;
import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationPriority;
import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationStatus;
import com.carestacks.careconnect.notifications.domain.notifications.enums.NotificationType;
import com.carestacks.careconnect.notifications.infrastructure.mappers.AlertMapper;
import com.carestacks.careconnect.notifications.infrastructure.mappers.NotificationMapper;
import com.carestacks.careconnect.notifications.infrastructure.mappers.NotificationPreferenceMapper;
import com.carestacks.careconnect.notifications.infrastructure.persistence.AlertJpaEntity;
import com.carestacks.careconnect.notifications.infrastructure.persistence.NotificationJpaEntity;
import com.carestacks.careconnect.notifications.infrastructure.persistence.NotificationPreferenceJpaEntity;
import com.carestacks.careconnect.notifications.infrastructure.repositories.AlertJpaRepository;
import com.carestacks.careconnect.notifications.infrastructure.repositories.NotificationJpaRepository;
import com.carestacks.careconnect.notifications.infrastructure.repositories.NotificationPreferenceJpaRepository;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;
import com.carestacks.careconnect.shared.domain.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationJpaRepository notificationRepository;
    private final AlertJpaRepository alertRepository;
    private final NotificationPreferenceJpaRepository preferenceRepository;

    public NotificationServiceImpl(
            NotificationJpaRepository notificationRepository,
            AlertJpaRepository alertRepository,
            NotificationPreferenceJpaRepository preferenceRepository
    ) {
        this.notificationRepository = notificationRepository;
        this.alertRepository = alertRepository;
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    @Transactional
    public NotificationDto create(CreateNotificationRequest request) {
        var notification = Notification.schedule(
                request.getRecipientId(),
                request.getHealthEventId(),
                request.getTitle(),
                request.getMessage(),
                request.getType(),
                request.getPriority(),
                request.getDeliveryChannel(),
                request.getScheduledAt()
        );

        return NotificationMapper.toDto(notificationRepository.save(NotificationMapper.toEntity(notification)));
    }

    @Override
    @Transactional
    public NotificationDto scheduleReminder(ScheduleEventNotificationRequest request) {
        var scheduledAt = request.getEventStartAt().minusHours(24);
        if (scheduledAt.isBefore(LocalDateTime.now())) {
            throw new BusinessRuleException("Health event must be at least 24 hours ahead to schedule a reminder");
        }

        var notification = Notification.schedule(
                request.getRecipientId(),
                request.getHealthEventId(),
                "Upcoming health event",
                "Reminder for " + request.getEventTitle(),
                NotificationType.REMINDER,
                NotificationPriority.HIGH,
                request.getDeliveryChannel(),
                scheduledAt
        );

        return NotificationMapper.toDto(notificationRepository.save(NotificationMapper.toEntity(notification)));
    }

    @Override
    @Transactional(readOnly = true)
    public NotificationDto getById(UUID id) {
        return NotificationMapper.toDto(findNotificationEntity(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotificationDto> getAll() {
        return notificationRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(NotificationMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotificationDto> getByRecipient(UUID recipientId) {
        return notificationRepository.findByRecipientIdOrderByCreatedAtDesc(recipientId)
                .stream()
                .map(NotificationMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotificationDto> getUnreadByRecipient(UUID recipientId) {
        var unreadStatuses = EnumSet.of(NotificationStatus.SCHEDULED, NotificationStatus.SENT, NotificationStatus.DELIVERED);
        return notificationRepository.findByRecipientIdAndStatusInOrderByCreatedAtDesc(recipientId, unreadStatuses)
                .stream()
                .map(NotificationMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public NotificationDto markAsSent(UUID id) {
        var entity = findNotificationEntity(id);
        var notification = NotificationMapper.toDomain(entity);
        notification.markAsSent();
        NotificationMapper.copyToEntity(notification, entity);
        return NotificationMapper.toDto(notificationRepository.save(entity));
    }

    @Override
    @Transactional
    public NotificationDto markAsRead(UUID id) {
        var entity = findNotificationEntity(id);
        var notification = NotificationMapper.toDomain(entity);
        notification.markAsRead();
        NotificationMapper.copyToEntity(notification, entity);
        return NotificationMapper.toDto(notificationRepository.save(entity));
    }

    @Override
    @Transactional
    public List<NotificationDto> markAllAsRead(UUID recipientId) {
        var unreadStatuses = EnumSet.of(NotificationStatus.SCHEDULED, NotificationStatus.SENT, NotificationStatus.DELIVERED);
        var entities = notificationRepository.findByRecipientIdAndStatusInOrderByCreatedAtDesc(recipientId, unreadStatuses);

        // Keep transition rules in the domain entity instead of mutating persistence objects directly.
        entities.forEach(entity -> {
            var notification = NotificationMapper.toDomain(entity);
            notification.markAsRead();
            NotificationMapper.copyToEntity(notification, entity);
        });

        return notificationRepository.saveAll(entities)
                .stream()
                .map(NotificationMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public NotificationDto cancel(UUID id) {
        var entity = findNotificationEntity(id);
        var notification = NotificationMapper.toDomain(entity);
        notification.cancel();
        NotificationMapper.copyToEntity(notification, entity);
        return NotificationMapper.toDto(notificationRepository.save(entity));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        var entity = findNotificationEntity(id);
        notificationRepository.delete(entity);
    }

    @Override
    @Transactional
    public AlertDto triggerAlert(CreateAlertRequest request) {
        var alert = Alert.trigger(
                request.getRecipientId(),
                request.getNotificationId(),
                request.getHealthEventId(),
                request.getTitle(),
                request.getMessage(),
                request.getPriority()
        );
        return AlertMapper.toDto(alertRepository.save(AlertMapper.toEntity(alert)));
    }

    @Override
    @Transactional
    public AlertDto resolveAlert(UUID id) {
        var entity = findAlertEntity(id);
        var alert = AlertMapper.toDomain(entity);
        alert.resolve();
        AlertMapper.copyToEntity(alert, entity);
        return AlertMapper.toDto(alertRepository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AlertDto> getActiveAlerts(UUID recipientId) {
        return alertRepository.findByRecipientIdAndResolvedFalseOrderByTriggeredAtDesc(recipientId)
                .stream()
                .map(AlertMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public NotificationPreferenceDto getPreference(UUID recipientId) {
        var entity = preferenceRepository.findByRecipientId(recipientId)
                .orElseGet(() -> createDefaultPreference(recipientId));
        return NotificationPreferenceMapper.toDto(entity);
    }

    @Override
    @Transactional
    public NotificationPreferenceDto updatePreference(UUID recipientId, UpdateNotificationPreferenceRequest request) {
        var entity = preferenceRepository.findByRecipientId(recipientId)
                .orElseGet(() -> createDefaultPreference(recipientId));
        var preference = NotificationPreferenceMapper.toDomain(entity);
        preference.update(request.getPushEnabled(), request.getEmailEnabled(), request.getInAppEnabled(), request.getMinimumPriority());
        NotificationPreferenceMapper.copyToEntity(preference, entity);
        return NotificationPreferenceMapper.toDto(preferenceRepository.save(entity));
    }

    private NotificationJpaEntity findNotificationEntity(UUID id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found"));
    }

    private AlertJpaEntity findAlertEntity(UUID id) {
        return alertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
    }

    private NotificationPreferenceJpaEntity createDefaultPreference(UUID recipientId) {
        var preference = NotificationPreference.defaultFor(recipientId);
        return preferenceRepository.save(NotificationPreferenceMapper.toEntity(preference));
    }
}
