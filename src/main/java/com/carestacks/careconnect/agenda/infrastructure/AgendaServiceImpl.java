package com.carestacks.careconnect.agenda.infrastructure;

import com.carestacks.careconnect.agenda.application.abstractions.AgendaService;
import com.carestacks.careconnect.agenda.application.agenda.dtos.HealthEventDto;
import com.carestacks.careconnect.agenda.application.agenda.requests.CreateHealthEventRequest;
import com.carestacks.careconnect.agenda.application.agenda.requests.RescheduleHealthEventRequest;
import com.carestacks.careconnect.agenda.application.agenda.requests.UpdateHealthEventRequest;
import com.carestacks.careconnect.agenda.domain.agenda.entities.HealthEvent;
import com.carestacks.careconnect.agenda.domain.agenda.entities.Reminder;
import com.carestacks.careconnect.agenda.domain.agenda.enums.EventStatus;
import com.carestacks.careconnect.agenda.infrastructure.mappers.HealthEventMapper;
import com.carestacks.careconnect.agenda.infrastructure.mappers.ReminderMapper;
import com.carestacks.careconnect.agenda.infrastructure.persistence.HealthEventJpaEntity;
import com.carestacks.careconnect.agenda.infrastructure.persistence.ReminderJpaEntity;
import com.carestacks.careconnect.agenda.infrastructure.repositories.HealthEventJpaRepository;
import com.carestacks.careconnect.agenda.infrastructure.repositories.ReminderJpaRepository;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;
import com.carestacks.careconnect.shared.domain.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final HealthEventJpaRepository healthEventRepository;
    private final ReminderJpaRepository reminderRepository;

    public AgendaServiceImpl(HealthEventJpaRepository healthEventRepository, ReminderJpaRepository reminderRepository) {
        this.healthEventRepository = healthEventRepository;
        this.reminderRepository = reminderRepository;
    }

    @Override
    @Transactional
    public HealthEventDto create(CreateHealthEventRequest request) {
        ensureNoScheduleConflict(null, request.getPatientId(), request.getStartAt(), request.getEndAt());

        var event = HealthEvent.schedule(
                request.getPatientId(),
                request.getCaregiverId(),
                request.getTitle(),
                request.getDescription(),
                request.getType(),
                request.getStartAt(),
                request.getEndAt()
        );
        var eventEntity = healthEventRepository.save(HealthEventMapper.toEntity(event));

        // Agenda owns reminder calculation; Notifications owns delivery through its own context.
        var reminderEntity = reminderRepository.save(ReminderMapper.toEntity(Reminder.schedule(eventEntity.getId(), eventEntity.getStartAt())));

        return HealthEventMapper.toDto(eventEntity, reminderEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public HealthEventDto getById(UUID id) {
        var event = findEventEntity(id);
        return HealthEventMapper.toDto(event, findReminder(event.getId()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<HealthEventDto> getAll() {
        return healthEventRepository.findAllByOrderByStartAtAsc()
                .stream()
                .map(event -> HealthEventMapper.toDto(event, findReminder(event.getId())))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<HealthEventDto> getByPatient(UUID patientId) {
        return healthEventRepository.findByPatientIdOrderByStartAtAsc(patientId)
                .stream()
                .map(event -> HealthEventMapper.toDto(event, findReminder(event.getId())))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<HealthEventDto> getByPatientAndDate(UUID patientId, LocalDate date) {
        var from = date.atStartOfDay();
        var to = date.plusDays(1).atStartOfDay().minusNanos(1);
        return healthEventRepository.findByPatientIdAndStartAtBetweenOrderByStartAtAsc(patientId, from, to)
                .stream()
                .map(event -> HealthEventMapper.toDto(event, findReminder(event.getId())))
                .toList();
    }

    @Override
    @Transactional
    public HealthEventDto update(UUID id, UpdateHealthEventRequest request) {
        var entity = findEventEntity(id);
        ensureNoScheduleConflict(entity.getId(), entity.getPatientId(), request.getStartAt(), request.getEndAt());

        var event = HealthEventMapper.toDomain(entity);
        event.update(request.getTitle(), request.getDescription(), request.getType(), request.getStartAt(), request.getEndAt());
        HealthEventMapper.copyToEntity(event, entity);
        var savedEvent = healthEventRepository.save(entity);
        var reminder = upsertReminder(savedEvent);

        return HealthEventMapper.toDto(savedEvent, reminder);
    }

    @Override
    @Transactional
    public HealthEventDto confirm(UUID id) {
        var entity = findEventEntity(id);
        var event = HealthEventMapper.toDomain(entity);
        event.confirm();
        HealthEventMapper.copyToEntity(event, entity);
        return HealthEventMapper.toDto(healthEventRepository.save(entity), findReminder(entity.getId()));
    }

    @Override
    @Transactional
    public HealthEventDto reschedule(UUID id, RescheduleHealthEventRequest request) {
        var entity = findEventEntity(id);
        ensureNoScheduleConflict(entity.getId(), entity.getPatientId(), request.getStartAt(), request.getEndAt());

        var event = HealthEventMapper.toDomain(entity);
        event.reschedule(request.getStartAt(), request.getEndAt());
        HealthEventMapper.copyToEntity(event, entity);
        var savedEvent = healthEventRepository.save(entity);
        var reminder = upsertReminder(savedEvent);

        return HealthEventMapper.toDto(savedEvent, reminder);
    }

    @Override
    @Transactional
    public HealthEventDto cancel(UUID id) {
        var entity = findEventEntity(id);
        var event = HealthEventMapper.toDomain(entity);
        event.cancel();
        HealthEventMapper.copyToEntity(event, entity);
        var savedEvent = healthEventRepository.save(entity);
        return HealthEventMapper.toDto(savedEvent, findReminder(savedEvent.getId()));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        var entity = findEventEntity(id);
        reminderRepository.deleteByHealthEventId(entity.getId());
        healthEventRepository.delete(entity);
    }

    private HealthEventJpaEntity findEventEntity(UUID id) {
        return healthEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Health event not found"));
    }

    private ReminderJpaEntity findReminder(UUID healthEventId) {
        return reminderRepository.findByHealthEventId(healthEventId).orElse(null);
    }

    private ReminderJpaEntity upsertReminder(HealthEventJpaEntity event) {
        var existingReminder = reminderRepository.findByHealthEventId(event.getId());
        if (existingReminder.isEmpty()) {
            return reminderRepository.save(ReminderMapper.toEntity(Reminder.schedule(event.getId(), event.getStartAt())));
        }

        var reminder = ReminderMapper.toDomain(existingReminder.get());
        reminder.reschedule(event.getStartAt());
        ReminderMapper.copyToEntity(reminder, existingReminder.get());
        return reminderRepository.save(existingReminder.get());
    }

    private void ensureNoScheduleConflict(UUID currentEventId, UUID patientId, java.time.LocalDateTime startAt, java.time.LocalDateTime endAt) {
        if (!endAt.isAfter(startAt)) {
            throw new BusinessRuleException("Event end date must be after start date");
        }
        var excludedId = currentEventId == null ? new UUID(0L, 0L) : currentEventId;
        var activeStatuses = EnumSet.of(EventStatus.PENDING, EventStatus.CONFIRMED);
        var hasConflict = healthEventRepository.existsOverlappingEvent(patientId, excludedId, activeStatuses, startAt, endAt);
        if (hasConflict) {
            throw new BusinessRuleException("Patient already has an event scheduled in the same time range");
        }
    }
}
