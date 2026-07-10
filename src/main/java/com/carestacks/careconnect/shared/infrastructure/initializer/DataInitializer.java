package com.carestacks.careconnect.shared.infrastructure.initializer;

import com.carestacks.careconnect.documents.domain.documents.valueobjects.DocumentType;
import com.carestacks.careconnect.documents.infrastructure.persistence.DocumentItemJpaEntity;
import com.carestacks.careconnect.documents.infrastructure.persistence.MedicalDocumentJpaEntity;
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

        // Find the patient user to associate documents
        var patientUser = userRepository.findByEmail("paciente@test.com").orElseThrow();
        var patientId = patientUser.getId();

        // --- Seed dicto documents (legal/medical opinion documents) ---
        var now = LocalDateTime.now();

        var dictoDocument = new MedicalDocumentJpaEntity(
                null, patientId, now, now
        );

        dictoDocument.addDocumentItem(new DocumentItemJpaEntity(
                null, dictoDocument,
                DocumentType.DICTO,
                "Dictamen Médico General",
                """
DICTAMEN MÉDICO GENERAL

PACIENTE: María García Paciente
FECHA: 15 de junio de 2026
MÉDICO: Dr. Ricardo Mendoza - CMP 45231

I. EVALUACIÓN CLÍNICA: Paciente de 78 años, ingresa para evaluación geriátrica integral.

II. DIAGNÓSTICO:
- Hipertensión arterial controlada (Estadio I)
- Osteoporosis moderada (T-score: -2.8)
- Deterioro cognitivo leve (MMSE: 24/30)
- Presbiacusia bilateral

III. RECOMENDACIONES:
1. Continuar Losartán 50mg/día
2. Suplementación con calcio y vitamina D
3. Terapia física 2 veces/semana
4. Evaluación audiológica en 3 meses
5. Control médico cada 30 días

IV. PRONÓSTICO: Favorable con manejo integral.

--- Dr. Ricardo Mendoza - CMP 45231""",
                "https://storage.example.com/dictos/dictamen-medico-general.pdf",
                "documents", "dictos/dictamen-medico-general.pdf",
                "application/pdf", 245760,
                now.minusDays(24), "SYNCED"
        ));

        dictoDocument.addDocumentItem(new DocumentItemJpaEntity(
                null, dictoDocument,
                DocumentType.DICTO,
                "Directiva Anticipada de Voluntad",
                """
DIRECTIVA ANTICIPADA DE VOLUNTAD

OTORGANTE: María García Paciente
FECHA: 10 de mayo de 2026

Yo, María García Paciente, en pleno uso de mis facultades mentales, declaro mis instrucciones sobre el cuidado médico que deseo recibir.

INSTRUCCIONES:
1. RCP: NO deseo reanimación si mi calidad de vida se viera comprometida.
2. Ventilación: Acepto por máx. 7 días con expectativa de recuperación.
3. Alimentación: Deseo mantenerla siempre, incluso en etapas avanzadas.
4. Dolor: Solicito todos los cuidados paliativos necesarios.

REPRESENTANTE: Ana López García (Hija) - +51 987 654 321

--- María García Paciente""",
                "https://storage.example.com/dictos/directiva-anticipada.pdf",
                "documents", "dictos/directiva-anticipada.pdf",
                "application/pdf", 198400,
                now.minusDays(60), "SYNCED"
        ));

        dictoDocument.addDocumentItem(new DocumentItemJpaEntity(
                null, dictoDocument,
                DocumentType.DICTO,
                "Poder Notarial para Asuntos de Salud",
                """
PODER NOTARIAL PARA ASUNTOS DE SALUD

OTORGANTE: María García Paciente
FECHA: 22 de abril de 2026

OTORGO PODER ESPECIAL a Ana López García (DN: 45218976, Hija) para:

FACULTADES:
1. Autorizar/rechazar procedimientos médicos.
2. Contratar servicios de cuidado personal.
3. Acceder a mi historial clínico.
4. Elegir médicos e instituciones de salud.
5. Decidir sobre internamientos.
6. Administrar recursos para mi cuidado.

VIGENCIA: Al certificarse mi incapacidad temporal o permanente.

--- María García Paciente
--- Ana López García (Apoderada)""",
                "https://storage.example.com/dictos/poder-notarial.pdf",
                "documents", "dictos/poder-notarial.pdf",
                "application/pdf", 182300,
                now.minusDays(78), "SYNCED"
        ));

        dictoDocument.addDocumentItem(new DocumentItemJpaEntity(
                null, dictoDocument,
                DocumentType.DICTO,
                "Testamento Vital",
                """
TESTAMENTO VITAL

OTORGANTE: María García Paciente
FECHA: 05 de marzo de 2026

Declaro:

PRIMERO: Deseo cuidados paliativos aunque acorten mi vida.

SEGUNDO: NO deseo:
- RCP si mi corazón se detiene
- Ventilación prolongada (>7 días sin mejora)
- Diálisis sin expectativa de recuperación
- Alimentación por sonda en estado vegetativo

TERCERO: SÍ deseo:
- Hidratación y nutrición básica oral
- Control del dolor
- Compañía de seres queridos
- Morir en casa si es posible

--- María García Paciente
Testigos: Dr. Ricardo Mendoza, Lic. Carmen Silva""",
                "https://storage.example.com/dictos/testamento-vital.pdf",
                "documents", "dictos/testamento-vital.pdf",
                "application/pdf", 215600,
                now.minusDays(126), "SYNCED"
        ));

        dictoDocument.addDocumentItem(new DocumentItemJpaEntity(
                null, dictoDocument,
                DocumentType.DICTO,
                "Consentimiento Informado para Procedimiento",
                """
CONSENTIMIENTO INFORMADO

PROCEDIMIENTO: Evaluación Geriátrica Integral
PACIENTE: María García Paciente
MÉDICO: Dr. Ricardo Mendoza

INFORMACIÓN:
- Evaluación física completa, pruebas cognitivas (MMSE),
  evaluación funcional (Índice de Barthel), screening nutricional.

BENEFICIOS: Identificación temprana de deterioro, plan personalizado.
RIESGOS: Mínimos. Posible fatiga durante la evaluación.

DECLARO: Haber comprendido la información. OTORGO MI CONSENTIMIENTO.

--- María García Paciente
--- Dr. Ricardo Mendoza""",
                "https://storage.example.com/dictos/consentimiento-informado.pdf",
                "documents", "dictos/consentimiento-informado.pdf",
                "application/pdf", 168900,
                now.minusDays(139), "SYNCED"
        ));

        dictoDocument.addDocumentItem(new DocumentItemJpaEntity(
                null, dictoDocument,
                DocumentType.DICTO,
                "Declaración de Voluntad Anticipada",
                """
DECLARACIÓN DE VOLUNTAD ANTICIPADA

PACIENTE: María García Paciente
FECHA: 12 de enero de 2026

MIS VALORES: Independencia y calidad de vida sobre longevidad.

ESCENARIO 1 - Enfermedad terminal:
- Cuidados paliativos en casa, sin tratamientos agresivos.

ESCENARIO 2 - Demencia avanzada:
- Cuidados de confort, sin hospitalización curativa.

ESCENARIO 3 - Incapacidad temporal recuperable:
- Acepto todos los tratamientos necesarios.

CONTACTO: Ana López García - +51 987 654 321

--- María García Paciente""",
                "https://storage.example.com/dictos/voluntad-anticipada.pdf",
                "documents", "dictos/voluntad-anticipada.pdf",
                "application/pdf", 192000,
                now.minusDays(178), "SYNCED"
        ));

        dictoDocument.addDocumentItem(new DocumentItemJpaEntity(
                null, dictoDocument,
                DocumentType.DICTO,
                "Certificado de Capacidad Mental",
                """
CERTIFICADO DE CAPACIDAD MENTAL

PACIENTE: María García Paciente
FECHA: 08 de diciembre de 2025
MÉDICO: Dr. Ricardo Mendoza - Geriatría

PRUEBAS:
- MMSE: 24/30 (deterioro leve)
- Test del Reloj: 4/4 (normal)
- Índice de Barthel: 85/100

CONCLUSIÓN: La paciente presenta capacidad cognitiva conservada para
comprender información médica, evaluar riesgos/beneficios, comunicar
preferencias y tomar decisiones informadas.

CERTIFICO que se encuentra en pleno uso de sus facultades mentales
y es legalmente competente para firmar documentos legales.

--- Dr. Ricardo Mendoza - CMP 45231""",
                "https://storage.example.com/dictos/certificado-capacidad.pdf",
                "documents", "dictos/certificado-capacidad.pdf",
                "application/pdf", 153600,
                now.minusDays(213), "SYNCED"
        ));

        medicalDocumentRepository.save(dictoDocument);
        log.info("Created 1 medical document with {} dicto items for test patient.", dictoDocument.getDocumentItems().size());
        log.info("Created {} test user(s) for local development.", testUsers.size());
    }
}
