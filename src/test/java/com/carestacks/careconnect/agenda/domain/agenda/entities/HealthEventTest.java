package com.carestacks.careconnect.agenda.domain.agenda.entities;

import com.carestacks.careconnect.agenda.domain.agenda.enums.EventStatus;
import com.carestacks.careconnect.agenda.domain.agenda.enums.EventType;
import com.carestacks.careconnect.shared.domain.exceptions.BusinessRuleException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class HealthEventTest {

    private final UUID patientId = UUID.randomUUID();
    private final LocalDateTime start = LocalDateTime.of(2026, 10, 5, 9, 0);
    private final LocalDateTime end = start.plusHours(1);

    @Test
    void schedulesValidEventAsPending() {
        var event = HealthEvent.schedule(patientId, null, "Control médico", null, EventType.APPOINTMENT, start, end);

        assertEquals(patientId, event.getPatientId());
        assertEquals("Control médico", event.getTitle());
        assertEquals(EventStatus.PENDING, event.getStatus());
        assertEquals(start, event.getStartAt());
        assertEquals(end, event.getEndAt());
    }

    @Test
    void rejectsAnEndAtOrBeforeStart() {
        assertThrows(BusinessRuleException.class,
                () -> HealthEvent.schedule(patientId, null, "Control", null, EventType.APPOINTMENT, start, start));
        assertThrows(BusinessRuleException.class,
                () -> HealthEvent.schedule(patientId, null, "Control", null, EventType.APPOINTMENT, start, start.minusMinutes(1)));
    }

    @Test
    void confirmsReschedulesAndCancelsEvent() {
        var event = HealthEvent.schedule(patientId, null, "Control", null, EventType.APPOINTMENT, start, end);

        event.confirm();
        assertEquals(EventStatus.CONFIRMED, event.getStatus());

        event.reschedule(start.plusDays(1), end.plusDays(1));
        assertEquals(EventStatus.PENDING, event.getStatus());
        assertEquals(start.plusDays(1), event.getStartAt());

        event.cancel();
        assertEquals(EventStatus.CANCELLED, event.getStatus());
    }

    @Test
    void doesNotConfirmCancelledEvent() {
        var event = HealthEvent.schedule(patientId, null, "Control", null, EventType.APPOINTMENT, start, end);
        event.cancel();

        assertThrows(BusinessRuleException.class, event::confirm);
        assertEquals(EventStatus.CANCELLED, event.getStatus());
    }
}
