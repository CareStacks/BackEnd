package com.carestacks.careconnect.diary.infrastructure.persistence;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "diary_entries")
public class DiaryEntryJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id", nullable = false)
    private UUID patientId;

    @Column(name = "content", nullable = false, length = 2000)
    private String content;

    @Column(name = "entry_date", nullable = false)
    private LocalDateTime entryDate;

    public DiaryEntryJpaEntity() {}

    public DiaryEntryJpaEntity(Long id, UUID patientId, String content, LocalDateTime entryDate) {
        this.id = id;
        this.patientId = patientId;
        this.content = content;
        this.entryDate = entryDate;
    }

    @PrePersist
    public void prePersist() {
        if (entryDate == null) {
            entryDate = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }
}
