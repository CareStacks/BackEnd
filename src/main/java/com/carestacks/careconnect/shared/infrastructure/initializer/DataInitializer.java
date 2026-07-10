package com.carestacks.careconnect.shared.infrastructure.initializer;

import com.carestacks.careconnect.documents.infrastructure.persistence.MedicalDocumentJpaRepository;
import com.carestacks.careconnect.iam.domain.iam.enums.UserRole;
import com.carestacks.careconnect.iam.infrastructure.persistence.UserJpaEntity;
import com.carestacks.careconnect.iam.infrastructure.repositories.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final UserJpaRepository userRepository;
    private final MedicalDocumentJpaRepository medicalDocumentRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
            UserJpaRepository userRepository,
            MedicalDocumentJpaRepository medicalDocumentRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.medicalDocumentRepository = medicalDocumentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() > 0) {
            log.info("Database already has users – skipping test data initialization.");
            return;
        }

        var testUsers = List.of(
                new UserJpaEntity(
                        UUID.randomUUID(),
                        "paciente@test.com",
                        passwordEncoder.encode("Test1234"),
                        "María García Paciente",
                        UserRole.PATIENT,
                        true,
                        0,
                        null,
                        LocalDateTime.now(),
                        LocalDateTime.now()
                ),
                new UserJpaEntity(
                        UUID.randomUUID(),
                        "cuidador@test.com",
                        passwordEncoder.encode("Cuidador1"),
                        "Carlos López Cuidador",
                        UserRole.CAREGIVER,
                        true,
                        0,
                        null,
                        LocalDateTime.now(),
                        LocalDateTime.now()
                )
        );

        userRepository.saveAll(testUsers);

        log.info("Created {} test user(s) for local development.", testUsers.size());
    }
}
