<div align="center">

### Logo de Universidad

**Universida Peruana de Ciencias Aplicadas**  

**Ingeniería de Software**  

**2026-01**  
<br>

**1ACC0238 - Aplicaciones para Dispositivos Móviles**  
<br>

**NRC:** 3690

**Docente:** Mayta Guillermo, Jorge Luis
<br>

### Informe de Trabajo Final
<br>

**Startup:** CareStacks

**Producto:** CareConnect
<br>

<table>
  <tr>
    <th>Integrante</th>
    <th>Código</th>
  </tr>
  <tr>
    <td>Salcedo Champi, Matias Rodolfo</td>
    <td>U202319698</td>
  </tr>
  <tr>
    <td>Costa Morales, Christofer William</td>
    <td>U202315968</td>
  </tr>
  <tr>
    <td>Nikaido Vargas, Javier Masaru</td>
    <td>U20221G099</td>
  </tr>
  <tr>
    <td>Osores Marchese, Pietro</td>
    <td>U202310971</td>
  </tr>
  <tr>
    <td>Santillan Alvarado, Melina Liz</td>
    <td>U202216058</td>
  </tr>
</table>
<br>

**Abril del 2026**  

</div>

---

# Registro de Versiones del Informe

| Versión | Fecha | Autor | Descripción de modificación |
|---|---|---|---|
| 1 | 21/04/2026 | Salcedo Champi, Matias Rodolfo; Santillan Alvarado, Melina Liz; Costa Morales, Christofer William; Nikaido Vargas, Javier Masaru; Osores Marchese, Pietro | Avance 1: En esta primera entrega se avanzó con el capítulo 1, 2 y 3 de forma organizada para empezar con el proyecto de CareStacks, estableciendo la idea, un estudio del contexto y las features, respectivamente. |

---

# Project Report Collaboration Insights




---

# Contenido

## Capítulo I: Presentación
- [1.1. Startup Profile](#11-startup-profile)  
  - [1.1.1. Descripción de la Startup](#111-descripcion-de-la-startup)  
  - [1.1.2. Perfiles de integrantes del equipo](#112-perfiles-de-integrantes-del-equipo)  
- [1.2. Solution Profile](#12-solution-profile)  
  - [1.2.1. Antecedentes y problemática](#121-antecedentes-y-problematica)  
  - [1.2.2. Lean UX Process](#122-lean-ux-process)  
    - [1.2.2.1. Lean UX Problem Statements](#1221-lean-ux-problem-statements)  
    - [1.2.2.2. Lean UX Assumptions](#1222-lean-ux-assumptions)  
    - [1.2.2.3. Lean UX Hypothesis Statements](#1223-lean-ux-hypothesis-statements)  
    - [1.2.2.4. Lean UX Canvas](#1224-lean-ux-canvas)  
- [1.3. Segmentos objetivo](#13-segmentos-objetivo)  

## Capítulo II: Requirements Development and Software Solution Design
- [2.1. Competidores](#21-competidores)  
  - [2.1.1. Análisis competitivo](#211-analisis-competitivo)  
  - [2.1.2. Estrategias y tácticas frente a competidores](#212-estrategias-y-tacticas-frente-a-competidores)  

- [2.2. Entrevistas](#22-entrevistas)  
  - [2.2.1. Diseño de entrevistas](#221-diseno-de-entrevistas)  
  - [2.2.2. Registro de entrevistas](#222-registro-de-entrevistas)  
  - [2.2.3. Análisis de entrevistas](#223-analisis-de-entrevistas)  

- [2.3. Needfinding](#23-needfinding)  
  - [2.3.1. User Personas](#231-user-personas)  
  - [2.3.2. User Task Matrix](#232-user-task-matrix)  
  - [2.3.3. User Journey Mapping](#233-user-journey-mapping)  
  - [2.3.4. Empathy Mapping](#234-empathy-mapping)  
  - [2.3.5. Ubiquitous Language](#235-ubiquitous-language)  

- [2.4. Requirements specification](#24-requirements-specification)  
  - [2.4.1. User Stories](#241-user-stories)  
  - [2.4.2. Impact Mapping](#242-impact-mapping)  
  - [2.4.3. Product Backlog](#243-product-backlog)  

- [2.5. Strategic-Level Domain-Driven Design](#25-strategic-level-domain-driven-design)  
  - [2.5.1. EventStorming](#251-eventstorming)  
    - [2.5.1.1. Candidate Context Discovery](#2511-candidate-context-discovery)  
    - [2.5.1.2. Domain Message Flows Modeling](#2512-domain-message-flows-modeling)  
    - [2.5.1.3. Bounded Context Canvases](#2513-bounded-context-canvases)  
  - [2.5.2. Context Mapping](#252-context-mapping)  
  - [2.5.3. Software Architecture](#253-software-architecture)  
    - [2.5.3.1. Software Architecture Context Level Diagrams](#2531-software-architecture-context-level-diagrams)  
    - [2.5.3.2. Software Architecture Container Level Diagrams](#2532-software-architecture-container-level-diagrams)  
    - [2.5.3.3. Software Architecture Deployment Diagrams](#2533-software-architecture-deployment-diagrams)  

- [2.6. Tactical-Level Domain-Driven Design](#26-tactical-level-domain-driven-design)  
  - [2.6.4. Bounded Context](#264-bounded-context)  
    - [2.6.4.1. Domain Layer](#2641-domain-layer)  
    - [2.6.4.2. Interface Layer](#2642-interface-layer)  
    - [2.6.4.3. Application Layer](#2643-application-layer)  
    - [2.6.4.4. Infrastructure Layer](#2644-infrastructure-layer)  
    - [2.6.4.5. Bounded Context Software Architecture Component Level Diagrams](#2645-component-level-diagrams)  
    - [2.6.4.6. Bounded Context Software Architecture Code Level Diagrams](#2646-code-level-diagrams)  
      - [2.6.4.6.1. Bounded Context Domain Layer Class Diagrams](#26461-domain-layer-class-diagrams)  
      - [2.6.4.6.2. Bounded Context Database Design Diagram](#26462-database-design-diagram)  

## Capítulo III: Solution UI/UX Design
- [3.1. Product design](#31-product-design)  
  - [3.1.1. Style Guidelines](#311-style-guidelines)  
    - [3.1.1.1. General Style Guidelines](#3111-general-style-guidelines)  
  - [3.1.2. Information Architecture](#312-information-architecture)  
    - [3.1.2.1. Organization Systems](#3121-organization-systems)  
    - [3.1.2.2. Labelling Systems](#3122-labelling-systems)  
    - [3.1.2.3. SEO Tags and Meta Tags](#3123-seo-tags-and-meta-tags)  
    - [3.1.2.4. Searching Systems](#3124-searching-systems)  
    - [3.1.2.5. Navigation Systems](#3125-navigation-systems)  
  - [3.1.3. Landing Page UI Design](#313-landing-page-ui-design)  
    - [3.1.3.1. Landing Page Wireframe](#3131-landing-page-wireframe)  
    - [3.1.3.2. Landing Page Mock-up](#3132-landing-page-mock-up)  
  - [3.1.4. Mobile Applications UX/UI Design](#314-mobile-applications-uxui-design)  
    - [3.1.4.1. Mobile Applications Wireframes](#3141-mobile-applications-wireframes)  
    - [3.1.4.2. Mobile Applications Wireflow Diagrams](#3142-mobile-applications-wireflow-diagrams)  
    - [3.1.4.3. Mobile Applications Mock-ups](#3143-mobile-applications-mock-ups)  
    - [3.1.4.4. Mobile Applications User Flow Diagrams](#3144-mobile-applications-user-flow-diagrams)  
    - [3.1.4.5. Mobile Applications Prototyping](#3145-mobile-applications-prototyping)  

## Capítulo IV: Product Implementation & Validation
- [4.1. Product Implementation & Validation](#41-product-implementation--validation)  
  - [4.1.1. Software Configuration Management](#411-software-configuration-management)  
    - [4.1.1.1. Software Development Environment Configuration](#4111-software-development-environment-configuration)  
    - [4.1.1.2. Source Code Management](#4112-source-code-management)  
    - [4.1.1.3. Source Code Style Guide & Conventions](#4113-source-code-style-guide--conventions)  
    - [4.1.1.4. Software Deployment Configuration](#4114-software-deployment-configuration)  

- [4.2. Landing Page & Mobile Application Implementation](#42-landing-page--mobile-application-implementation)  
  - [4.2.1. Sprint n](#421-sprint-n)  
    - [4.2.1.1. Sprint Planning n](#4211-sprint-planning-n)  
    - [4.2.1.2. Sprint Backlog n](#4212-sprint-backlog-n)  
    - [4.2.1.3. Development Evidence for Sprint Review](#4213-development-evidence)  
    - [4.2.1.4. Testing Suite Evidence for Sprint Review](#4214-testing-suite-evidence)  
    - [4.2.1.5. Execution Evidence for Sprint Review](#4215-execution-evidence)  
    - [4.2.1.6. Services Documentation Evidence for Sprint Review](#4216-services-documentation-evidence)  
    - [4.2.1.7. Software Deployment Evidence for Sprint Review](#4217-software-deployment-evidence)  
    - [4.2.1.8. Team Collaboration Insights during Sprint](#4218-team-collaboration-insights)  

- [4.3. Validation Interviews](#43-validation-interviews)  
  - [4.3.1. Diseño de Entrevistas](#431-diseno-de-entrevistas)  
  - [4.3.2. Registro de Entrevistas](#432-registro-de-entrevistas)  
  - [4.3.3. Evaluaciones según heurísticas](#433-evaluaciones-segun-heuristicas)  

## [Conclusiones](#conclusiones)  
## [Glosario](#glosario)  
## [Bibliografía](#bibliografia)  
## [Anexos](#anexos)  

---


# Student Outcome

El curso de Aplicaciones para Dispositivos Móviles contribuye al cumplimiento del Student Outcome ABET:

**ABET - EAC - Student Outcome 7**

**Criterio:** La capacidad de adquirir y aplicar nuevos conocimientos según sea necesario, utilizando estrategias de aprendizaje apropiadas.

A continuación se describe las acciones realizadas y conclusiones del grupo que sustentan el logro del ABET – EAC - Student Outcome 7.

| Criterio específico | Acciones realizadas | Conclusiones |
|---|---|---|
| Actualiza conceptos y conocimientos necesarios para su desarrollo profesional y en especial para su proyecto en soluciones de software. | En el marco del proyecto CareConnect, el equipo tuvo que ponerse al día con varias tecnologías que no habíamos trabajado antes con ese nivel de profundidad: desarrollo móvil multiplataforma con Flutter, integración con servicios RESTful propios y de terceros, y los principios de Domain-Driven Design. Cada integrante investigó por su cuenta y también en conjunto, según las necesidades técnicas que iban surgiendo. | Aprender tecnologías nuevas mientras se construye algo real fue exigente, pero también fue lo que permitió que el proyecto avanzara. Quedó claro que la capacidad de investigar y aplicar lo aprendido rápidamente es tan importante como el conocimiento previo. |
| Reconoce la necesidad del aprendizaje permanente para el desempeño profesional y el desarrollo de proyectos en soluciones de software. | Detectamos vacíos concretos en temas como arquitectura orientada a dominios (DDD), diseño UX/UI pensado para aplicaciones de salud, y las normas vinculadas a la privacidad de datos de pacientes. Para cerrar esas brechas recurrimos a documentación oficial, bibliografía especializada y recursos en línea. | Este proyecto dejó en evidencia que el campo del software no se detiene: lo que hoy es estándar, mañana puede estar desactualizado. Adaptarse y seguir aprendiendo no es una opción, es parte del trabajo de cualquier ingeniero de software. |

---

# Capítulo I: Presentación

## 1.1. Startup Profile

### 1.1.1. Descripción de la Startup

**CareStacks** es una startup de tecnología orientada al sector salud y bienestar social, fundada por estudiantes de Ingeniería de Software de la Universidad Peruana de Ciencias Aplicadas (UPC). El proyecto nació de una necesidad concreta: los cuidadores y pacientes geriátricos no cuentan con herramientas digitales realmente pensadas para organizar el cuidado diario, dar seguimiento a tratamientos y mantener una comunicación clara entre todos los involucrados. CareStacks busca cubrir esa brecha con una solución práctica y accesible.

**Misión:** Brindar a cuidadores y pacientes geriátricos una herramienta móvil accesible que facilite el seguimiento del bienestar del paciente y mejore la coordinación de las actividades de cuidado.

**Visión:** Consolidarse como la plataforma de referencia en Latinoamérica para la gestión del cuidado geriátrico, apostando por soluciones tecnológicas que pongan a las personas en el centro.

**Producto:** **CareConnect** es una aplicación móvil nativa y multiplataforma pensada para el día a día del cuidado: monitoreo de rutinas, gestión de tratamientos y comunicación entre cuidadores. Sus funcionalidades principales incluyen:

1. Calendario de medicación y terapias programadas.
2. Alertas y recordatorios en tiempo real.
3. Carpeta digital para documentos clínicos y tratamientos.
4. Historial de notas y registro de evolución del paciente.
5. Compartición de perfiles entre cuidadores para garantizar continuidad en la atención.

### 1.1.2. Perfiles de integrantes del equipo

> *Nota: Los perfiles de cada integrante del equipo serán completados por el responsable de cada sección correspondiente, incluyendo foto, nombres y apellidos, código de estudiante, carrera y párrafo de resumen de conocimientos técnicos y habilidades.*

| Foto | Integrante | Código | Carrera | Resumen |
|---|---|---|---|---|
| <img src="assets/matias.jpg" width="600" /> | Salcedo Champi, Matias Rodolfo | u202319698 | Ingeniería de Software | Soy un estudiante de Ingeniería de Software con experiencia en el desarrollo de aplicaciones móviles y web. He participado en proyectos de investigación y desarrollo, y tengo conocimientos en tecnologías como Flutter, Dart, Node.js, Express.js, MongoDB, PostgreSQL, Git, GitHub, entre otras. |
| <img src="assets/melina.jpg" width="600" /> | Santillan Alvarado, Melina Liz | U202216058 | Ingeniería de Software | Estudiante de Ingeniería de Software en la UPC. Cuenta con habilidades organizativas, análisis de requerimientos y proactividad para garantizar el correcto desarrollo del proyecto y el cumplimiento de los procesos ágiles. |
| <img src="assets/christofer.jpeg" width="600" /> | Costa Morales, Christofer William | u202315968 | Ingeniería de Software | Estudiante de Ingeniería de Software de la UPC. Posee experiencia con los lenguajes de programación: C++, Python, JavaScript, HTML y CSS. En lo personal, capacitado para ayudar y contribuir activamente en el desarrollo técnico de este equipo. |
| <img src="assets/javier.jpg" width="600" /> | Nikaido Vargas, Javier Masaru | U20221G099 | Ingeniería de Software | Estudiante del séptimo ciclo de la carrera de Ingeniería de Software en la Universidad Peruana de Ciencias Aplicadas. Contribuirá al equipo aportando en el desarrollo estructural y la validación funcional de la solución propuesta. |
| <img src="assets/pietro.jpg" width="600" /> | Osores Marchese, Pietro | U202310971 | Ingeniería de Software | Estudiante de Ingeniería de Software en la UPC. Apoyará en las etapas de codificación y trabajo colaborativo, enfocándose en la experiencia de usuario y garantizando entregas de valor dentro de los plazos establecidos por el equipo. |

---

## 1.2. Solution Profile

### 1.2.1. Antecedentes y Problemática

#### Antecedentes

En el Perú, el crecimiento de la población adulta mayor ha hecho más visible la necesidad de soluciones que permitan organizar mejor el cuidado geriátrico, tanto en casa como en entornos de atención especializada. Muchos pacientes geriátricos requieren seguimiento continuo de medicación, citas médicas, signos de alerta y rutinas de apoyo diario, pero ese control todavía suele manejarse de forma manual, fragmentada y dependiente de la memoria de los cuidadores.

A nivel práctico, esta situación genera desgaste en los cuidadores y reduce la autonomía de los propios pacientes geriátricos, quienes muchas veces dependen de terceros para recordar tratamientos, registrar síntomas o informar cambios en su estado. Aunque existen herramientas orientadas a clínicas y hospitales, todavía falta una solución centrada en el cuidado cotidiano, domiciliario y compartido que caracteriza a este segmento.

#### Problemática — Técnica The 5W's y 2H's

**Who (¿Quiénes?):**
Los más afectados son los cuidadores formales e informales y los pacientes geriátricos que dependen de una rutina de atención constante. Ambos segmentos viven de forma directa las consecuencias de una mala coordinación, ya sea por sobrecarga en el cuidado o por falta de seguimiento oportuno.

**What (¿Qué?):**
No existe una plataforma que centralice de forma práctica los tratamientos, rutinas, recordatorios, documentos clínicos e historial de evolución de un paciente geriátrico. Esa ausencia hace que coordinarse entre varios cuidadores sea difícil y que el propio paciente tenga poca visibilidad de su proceso de cuidado.

**Where (¿Dónde?):**
El problema ocurre principalmente en entornos de cuidado domiciliario, comunitario y de atención particular en el Perú, aunque la situación es comparable en otros países de Latinoamérica, donde gran parte del cuidado geriátrico también recae en las familias y cuidadores externos.

**When (¿Cuándo?):**
No es algo que pase de vez en cuando. Se presenta todos los días: al coordinar la medicación, al hacer el cambio de turno entre cuidadores, al buscar el historial clínico o al intentar registrar si el paciente mejoró o empeoró.

**Why (¿Por qué?):**
El cuidado geriátrico involucra a varios actores —paciente, familiares, enfermeros, médicos y cuidadores contratados—, pero no hay herramientas móviles accesibles que conecten esa información y la mantengan actualizada. El resultado es que muchas decisiones se toman con datos incompletos o tardíos, lo que incrementa el riesgo para el paciente.

**How (¿Cómo?):**
Se traduce en situaciones concretas: medicamentos olvidados o duplicados, citas médicas mal registradas, signos de alerta que no se comunican a tiempo, documentos clínicos dispersos y una dependencia excesiva de llamadas o mensajes informales para coordinar el cuidado.

**How Much (¿Cuánto?):**
El impacto se refleja en tiempo perdido, errores evitables en la administración del cuidado, mayor carga física y emocional para los cuidadores, y un seguimiento menos seguro para los pacientes geriátricos. Cuando no existe una herramienta común de coordinación, aumentan los costos asociados a consultas repetidas, omisiones en tratamientos y desorganización en la atención diaria.

---

### 1.2.2. Lean UX Process

#### 1.2.2.1. Lean UX Problem Statements

**Problem Statement 1 — Cuidadores de pacientes geriátricos:**

Hoy los cuidadores de pacientes geriátricos gestionan rutinas complejas de medicación, controles, citas y seguimiento médico con lo que tienen a la mano: libretas, grupos de WhatsApp, hojas de cálculo o recordatorios dispersos. Son herramientas útiles, pero no fueron diseñadas para un entorno donde la continuidad y la precisión importan tanto.

Lo que identificamos como el punto más crítico es la falta de una plataforma que les permita sincronizar información con otros cuidadores, acceder rápido al historial del paciente y recibir alertas a tiempo sin aumentar su carga operativa.

¿Cómo podríamos diseñar una solución móvil que centralice la gestión del cuidado geriátrico, facilite la comunicación entre cuidadores y reduzca los riesgos que genera la descoordinación diaria?

**Problem Statement 2 — Pacientes geriátricos:**

Los pacientes geriátricos suelen enfrentar dificultades para seguir sus tratamientos, recordar indicaciones médicas y mantener organizada su información de salud, especialmente cuando dependen de apoyo parcial o alternado de distintos cuidadores.

Lo que falta es una herramienta simple que les permita visualizar sus rutinas, entender qué actividades tienen pendientes y registrar cómo se sienten, sin depender por completo de llamadas, papeles o recordatorios aislados.

¿Cómo podríamos darle al paciente geriátrico mayor visibilidad y participación en su propio cuidado mediante una herramienta simple, clara y fácil de usar?

---

#### 1.2.2.2. Lean UX Assumptions

**Business Assumptions:**

1. Creemos que hay demanda real de aplicaciones móviles especializadas en la gestión del cuidado geriátrico en Perú y Latinoamérica.
2. Creemos que los cuidadores adoptarán herramientas digitales si son fáciles de configurar y no exigen formación técnica previa.
3. Creemos que un modelo freemium permitirá llegar tanto a usuarios individuales como a instituciones de salud, capturando distintos perfiles de uso.
4. Creemos que la descoordinación entre cuidadores genera costos concretos y evitables que justifican adoptar una solución como la nuestra.

**User Assumptions:**

1. **¿Quién es el usuario?** Cuidadores formales e informales de pacientes geriátricos, y pacientes geriátricos con capacidad de participar activamente en el seguimiento de su cuidado.
2. **¿Dónde encaja en su vida?** En la rutina diaria de cuidado: cuando se administran medicamentos, se revisan citas, se registran observaciones o se consulta el historial del paciente.
3. **¿Qué problema resuelve?** La descoordinación, la pérdida de información y la baja visibilidad del estado del tratamiento y las actividades pendientes.
4. **¿Cuándo y cómo se usa?** Desde el celular, varias veces al día: al iniciar una jornada de cuidado, al cumplir una indicación médica, al reportar cambios y al revisar recordatorios.
5. **¿Qué características importan más?** Las alertas de medicación, el calendario de controles, las notas de evolución, la compartición de perfiles y el acceso rápido a información clínica relevante.
6. **¿Cómo debe verse?** Simple, claro y confiable, con una interfaz fácil de entender tanto para cuidadores con poco tiempo como para pacientes mayores que requieren flujos directos.

---

#### 1.2.2.3. Lean UX Hypothesis Statements

**Hypothesis 1:**

Creemos que los cuidadores podrán gestionar los tratamientos de sus pacientes de forma más segura y coordinada **si** ofrecemos un calendario integrado de medicación y controles con alertas en tiempo real **para** cuidadores formales e informales de pacientes geriátricos.

**Sabremos que funciona cuando** el 70% de los usuarios activos utilice la función de alertas de medicación al menos una vez por día durante las primeras cuatro semanas.

---

**Hypothesis 2:**

Creemos que los pacientes geriátricos se sentirán más orientados y participarán mejor en su cuidado **si** tienen acceso claro a sus actividades, recordatorios y registro de evolución **para** pacientes geriátricos con autonomía parcial o acompañada.

**Sabremos que funciona cuando** el 60% de los pacientes activos consulte o confirme al menos una actividad diaria dentro de la plataforma durante el primer mes.

---

**Hypothesis 3:**

Creemos que la transición entre turnos de cuidado será más fluida **si** implementamos una función de compartición de perfiles de pacientes con historial completo **para** cuidadores que se alternan en la atención de un mismo paciente geriátrico.

**Sabremos que funciona cuando** el tiempo promedio de transferencia de información entre cuidadores al cambio de turno baje un 50% respecto al proceso manual, según los registros de actividad de la app.

---

#### 1.2.2.4. Lean UX Canvas

<table>
  <tr>
    <td valign="top" width="33%">
      <b>1. Business Problem</b><br><br>
      Los cuidadores de pacientes geriátricos manejan información crítica de salud de forma desordenada y sin herramientas pensadas para eso, lo que genera riesgos para el paciente y agotamiento en quien cuida.
    </td>
    <td rowspan="2" valign="top" width="33%">
      <b>5. Solution Ideas</b><br><br>
      App móvil multiplataforma con calendario de medicación y terapias, sistema de alertas, carpeta de documentos, historial de evolución y perfiles compartidos.
    </td>
    <td valign="top" width="33%">
      <b>2. Business Outcomes</b><br><br>
      Menos errores de medicación. Mejor coordinación entre cuidadores. Tasas de retención superiores al 60% al tercer mes de uso.
    </td>
  </tr>
  <tr>
    <td valign="top">
      <b>3. Users & Customers</b><br><br>
      Segmento 1: Cuidadores formales e informales de pacientes geriátricos.<br><br>
      Segmento 2: Pacientes geriátricos que necesitan seguimiento simple y claro de su cuidado diario.
    </td>
    <td valign="top">
      <b>4. User Benefits</b><br><br>
      Gestión centralizada de tratamientos y rutinas. Historial completo siempre disponible. Alertas oportunas y coordinación real con otros cuidadores.
    </td>
  </tr>
  <tr>
    <td valign="top">
      <b>6. Hypotheses</b><br><br>
      Los cuidadores adoptarán la app si la configuración inicial no les toma más de 10 minutos. Los pacientes geriátricos valorarán una interfaz simple y comprensible. Compartir perfiles mejorará la coordinación entre turnos.
    </td>
    <td valign="top">
      <b>7. What's the most important thing we need to learn first?</b><br><br>
      ¿Los cuidadores están dispuestos a registrar información durante su jornada, o lo perciben como una carga extra?
    </td>
    <td valign="top">
      <b>8. What's the least amount of work we need to do to learn the next most important thing?</b><br><br>
      Entrevistas con al menos 6 cuidadores (3 formales, 3 informales) para entender cómo trabajan hoy y dónde sienten más fricción en la gestión del cuidado.
    </td>
  </tr>
</table>

---

## 1.3. Segmentos Objetivo

CareConnect apunta a dos segmentos bien diferenciados, definidos a partir del análisis del problema y las personas que lo viven de cerca.

---

### Segmento Objetivo 1: Cuidadores de pacientes geriátricos

**Descripción:**
Este segmento incluye tanto a cuidadores formales —enfermeros, técnicos de salud y asistentes geriátricos en atención domiciliaria o centros de cuidado— como a cuidadores informales: familiares que asumen el rol principal en casa, muchas veces sin formación especializada pero con responsabilidad directa sobre la rutina del paciente.

**Características demográficas:**

- **Edad:** 25 a 60 años.
- **Género:** Con presencia mayoritaria de mujeres en labores de cuidado, aunque el segmento no excluye a ningún género.
- **Ubicación:** Principalmente zonas urbanas y periurbanas del Perú, donde existe mayor acceso a smartphones y servicios de atención domiciliaria.
- **Nivel educativo:** Variable: desde secundaria completa hasta educación superior técnica o universitaria en el caso de cuidadores formales.
- **Ocupación:** Cuidador/a formal (con experiencia en atención geriátrica) o cuidador/a informal (familiar responsable del acompañamiento diario).
- **Nivel socioeconómico:** Sectores B, C y D.

**Características conductuales y psicográficas:**

Usan el celular con frecuencia para organizar su vida diaria y muestran disposición a incorporar apps que realmente les faciliten el trabajo. Sin embargo, viven bajo presión constante: deben controlar medicación, citas, cambios de estado y comunicación con otros actores del cuidado. Valoran la simplicidad por encima de todo, porque si una herramienta les toma demasiado tiempo o esfuerzo, dejan de usarla. La mayoría accede desde dispositivos móviles de gama media.

**Datos estadísticos de sustento:**

Se trata de un segmento en crecimiento debido al aumento sostenido de la población adulta mayor y a la alta participación de familiares en tareas de cuidado no remunerado. Su relevancia también se explica por la sobrecarga física y emocional asociada al seguimiento continuo de pacientes con necesidades geriátricas.

---

### Segmento Objetivo 2: Pacientes geriátricos

**Descripción:**
Son adultos mayores que requieren seguimiento frecuente de su estado de salud, medicación y actividades diarias. Algunos conservan autonomía parcial y pueden interactuar por sí mismos con la aplicación; otros necesitan apoyo de un cuidador, pero igualmente se benefician de una herramienta que haga visible su rutina y su progreso.

**Características demográficas:**

- **Edad:** 60 años a más.
- **Género:** Sin predominancia específica.
- **Ubicación:** Principalmente zonas urbanas y periurbanas, donde el acceso a smartphones o apoyo digital es más viable.
- **Nivel educativo:** Variable; desde educación básica hasta educación superior.
- **Condición de uso:** Pacientes con autonomía parcial o acompañada que necesitan recordatorios, seguimiento y visualización simple de su cuidado.
- **Nivel socioeconómico:** Sectores B, C y D.

**Características conductuales y psicográficas:**

Este segmento valora especialmente la claridad, la legibilidad y la simplicidad. Necesita recordatorios visibles, instrucciones fáciles de entender y una experiencia que no genere confusión ni dependencia técnica excesiva. Cuando la información está bien organizada, los pacientes pueden involucrarse mejor en su tratamiento y reducir olvidos o malentendidos sobre su rutina diaria.

**Datos estadísticos de sustento:**

Su relevancia está asociada al envejecimiento de la población y a la necesidad de promover mayor adherencia a tratamientos, monitoreo oportuno y participación del paciente en su propio proceso de cuidado. Es un segmento que requiere soluciones digitales con barreras de uso mínimas y utilidad inmediata.

---

*Referencias*

- Instituto Nacional de Estadística e Informática [INEI]. Información general sobre población adulta mayor y dinámicas de cuidado en el Perú.
- Organización Mundial de la Salud [OMS]. Información general sobre envejecimiento saludable, cuidado de largo plazo y adherencia a tratamientos en personas mayores.

## 2.1. Competidores
### 2.1.1. Análisis competitivo <a id="211-analisis-competitivo"></a>

# Capítulo II: Requirements & Analysis

### 2.1.1 Competitive Analysis Landscape

<table>
  <tr>
    <th colspan="6">Competitive Analysis Landscape</th>
  </tr>

  <tr>
    <th>¿Por qué llevar a cabo este análisis?</th>
    <th colspan="5">
      ¿Cómo podemos diseñar una solución digital eficiente, confiable y diferenciada que permita a los cuidadores y familiares coordinar el cuidado de personas con discapacidad en tiempo real, reduciendo errores, mejorando la comunicación y brindando visibilidad completa del estado del paciente?
    </th>
  </tr>

  <tr>
    <th rowspan="4">Perfil</th>
    <th></th>
    <th>CareConnect</th>
    <th>Medisafe</th>
    <th>MyTherapy</th>
    <th>CareZone</th>
  </tr>

  <tr>
    <td><b>Overview</b></td>
    <td>
      Aplicación móvil enfocada en la gestión integral del cuidado de personas con discapacidad. 
      Permite coordinar tratamientos, registrar evolución del paciente y compartir información entre múltiples cuidadores en tiempo real.
    </td>
    <td>
      Aplicación enfocada en recordatorios de medicación para pacientes individuales.
    </td>
    <td>
      Aplicación orientada al seguimiento de salud, hábitos y tratamientos médicos.
    </td>
    <td>
      Plataforma que permite organizar información médica y documentos de pacientes.
    </td>
  </tr>

  <tr>
    <td><b>Ventaja competitiva</b></td>
    <td>
      Integración completa del cuidado colaborativo en una sola plataforma con múltiples usuarios.
    </td>
    <td>
      Alta especialización en recordatorios de medicación.
    </td>
    <td>
      Interfaz simple y monitoreo continuo de salud.
    </td>
    <td>
      Organización de información médica familiar.
    </td>
  </tr>

  <tr>
    <td><b>¿Qué valor ofrece a los clientes?</b></td>
    <td>
      Mejora la coordinación entre cuidadores, reduce errores en el cuidado y permite acceso centralizado a información crítica del paciente.
    </td>
    <td>
      Reduce olvidos en la toma de medicamentos.
    </td>
    <td>
      Permite seguimiento de tratamientos y hábitos de salud.
    </td>
    <td>
      Facilita el almacenamiento y acceso a información médica.
    </td>
  </tr>

  <tr>
    <th rowspan="2">Perfil de Marketing</th>
    <td><b>Mercado Objetivo</b></td>
    <td>
      Cuidadores y familiares de personas con discapacidad en entornos domiciliarios.
    </td>
    <td>
      Pacientes individuales con tratamientos médicos.
    </td>
    <td>
      Personas con enfermedades crónicas.
    </td>
    <td>
      Familias que gestionan información médica.
    </td>
  </tr>

  <tr>
    <td><b>Estrategias de Marketing</b></td>
    <td>
      Marketing digital, enfoque en bienestar, confianza y facilidad de uso.
    </td>
    <td>
      Marketing orientado a salud personal.
    </td>
    <td>
      Promoción en bienestar y seguimiento de salud.
    </td>
    <td>
      Enfoque en organización familiar.
    </td>
  </tr>

  <tr>
    <th rowspan="3">Perfil de Producto</th>
    <td><b>Productos & Servicios</b></td>
    <td>
      Aplicación móvil multiplataforma con calendario, alertas, historial clínico y perfiles compartidos.
    </td>
    <td>
      Aplicación móvil de recordatorios de medicación.
    </td>
    <td>
      Aplicación móvil de seguimiento de salud.
    </td>
    <td>
      Plataforma web y móvil para organización médica.
    </td>
  </tr>

  <tr>
    <td><b>Precios & Costos</b></td>
    <td>
      Modelo freemium con funcionalidades premium.
    </td>
    <td>
      Freemium.
    </td>
    <td>
      Freemium.
    </td>
    <td>
      Freemium.
    </td>
  </tr>

  <tr>
    <td><b>Canales de distribución (Web y/o Móvil)</b></td>
    <td>Móvil</td>
    <td>Móvil</td>
    <td>Móvil</td>
    <td>Web y móvil</td>
  </tr>

  <tr>
    <th rowspan="4">Análisis SWOT</th>
    <td><b>Fortalezas</b></td>
    <td>
      Solución integral enfocada en coordinación, centralización y colaboración entre usuarios.
    </td>
    <td>
      Alta especialización en medicación.
    </td>
    <td>
      Interfaz intuitiva.
    </td>
    <td>
      Organización básica de datos médicos.
    </td>
  </tr>

  <tr>
    <td><b>Debilidades</b></td>
    <td>
      Aplicación en etapa inicial sin posicionamiento consolidado.
    </td>
    <td>
      No permite colaboración entre múltiples usuarios.
    </td>
    <td>
      No integra completamente la información médica.
    </td>
    <td>
      Funcionalidades limitadas.
    </td>
  </tr>

  <tr>
    <td><b>Oportunidades</b></td>
    <td>
      Crecimiento del sector salud digital y necesidad de soluciones colaborativas.
    </td>
    <td>
      Expansión hacia gestión integral del cuidado.
    </td>
    <td>
      Integración con nuevas tecnologías.
    </td>
    <td>
      Mejora de funcionalidades y expansión.
    </td>
  </tr>

  <tr>
    <td><b>Amenazas</b></td>
    <td>
      Competidores ya posicionados y barreras de adopción inicial.
    </td>
    <td>
      Nuevas aplicaciones más completas.
    </td>
    <td>
      Saturación del mercado.
    </td>
    <td>
      Falta de innovación.
    </td>
  </tr>

</table>

### 2.1.2. Estrategias y tácticas frente a competidores <a id="212-estrategias-y-tacticas-frente-a-competidores"></a>

A partir del análisis competitivo realizado en la sección anterior, se identificaron diversas oportunidades y debilidades en los competidores actuales (Medisafe, MyTherapy y CareZone). En base a estos hallazgos, se plantean las siguientes estrategias y tácticas para posicionar a CareConnect como una solución diferenciada en el mercado:

---

### 1. Diferenciación mediante coordinación en tiempo real

Se identificó que competidores como Medisafe y MyTherapy se enfocan principalmente en recordatorios individuales, sin permitir la interacción o coordinación entre múltiples usuarios, mientras que CareZone solo centraliza información sin ofrecer comunicación dinámica.

**Estrategia:**  
Implementar un sistema de coordinación en tiempo real entre cuidadores y familiares.

**Tácticas:**
- Sistema de notificaciones en tiempo real sobre medicación y eventos.
- Confirmación de actividades realizadas (ej: medicación administrada).
- Alertas automáticas en caso de incumplimiento o eventos críticos.

---

### 2. Plataforma integral de cuidado

Los competidores actuales ofrecen soluciones parciales: Medisafe se enfoca en medicación, MyTherapy en seguimiento de salud y CareZone en almacenamiento de información.

**Estrategia:**  
Ofrecer una plataforma integral que centralice todos los aspectos del cuidado en una sola aplicación.

**Tácticas:**
- Integración de calendario de medicación y terapias.
- Registro de historial clínico y evolución del paciente.
- Almacenamiento de documentos médicos en una carpeta digital.
- Unificación de todas las funcionalidades en una sola interfaz.

---

### 3. Enfoque en el cuidado colaborativo

Ninguno de los competidores actuales permite una gestión eficiente entre múltiples cuidadores y familiares.

**Estrategia:**  
Permitir la gestión colaborativa del cuidado mediante perfiles compartidos.

**Tácticas:**
- Sistema de usuarios múltiples vinculados a un mismo paciente.
- Acceso compartido a historial, eventos y registros.
- Control de permisos según tipo de usuario (cuidador, familiar).

---

### 4. Mejora de la experiencia del usuario (UX/UI)

Se observó que varias soluciones no están diseñadas para contextos de uso bajo presión ni para usuarios con bajo conocimiento tecnológico.

**Estrategia:**  
Desarrollar una interfaz intuitiva, rápida y centrada en el usuario.

**Tácticas:**
- Diseño mobile-first enfocado en dispositivos Android de gama media.
- Navegación simple con flujos cortos.
- Interfaces claras para tareas críticas (registro, consulta, alertas).
- Pruebas de usabilidad con cuidadores reales.

---

### 5. Enfoque en un nicho específico (discapacidad)

Los competidores actuales no están especializados en el cuidado de personas con discapacidad.

**Estrategia:**  
Posicionar a CareConnect como una solución especializada en este segmento.

**Tácticas:**
- Adaptación de funcionalidades a rutinas complejas de cuidado.
- Diseño accesible y comprensible.
- Comunicación centrada en bienestar y apoyo al cuidador.

---

### 6. Estrategia de crecimiento y adopción

Se identificó que algunos competidores tienen alcance limitado o no están enfocados en LATAM.

**Estrategia:**  
Expandir la plataforma mediante estrategias digitales y alianzas estratégicas.

**Tácticas:**
- Campañas en redes sociales dirigidas a cuidadores y familias.
- Alianzas con centros de salud y organizaciones de apoyo.
- Modelo freemium para facilitar adopción inicial.
- Programas de recomendación entre usuarios.

---

### 7. Mejora continua basada en datos

Los competidores presentan limitaciones en personalización y evolución del producto.

**Estrategia:**  
Implementar un modelo de mejora continua basado en datos y feedback de usuarios.

**Tácticas:**
- Recolección de métricas de uso dentro de la app.
- Análisis del comportamiento del usuario.
- Iteraciones frecuentes del producto.
- Incorporación de feedback directo de cuidadores y familiares.
## 2.2. Entrevistas <a id="22-entrevistas"></a>

Esta sección presenta el diseño y la estructura de las entrevistas que serán realizadas a los segmentos objetivo, con el fin de comprender sus necesidades, problemas actuales y oportunidades de mejora en la gestión del cuidado de personas con discapacidad.

---
### 2.2.1. Diseño de entrevistas <a id="221-diseno-de-entrevistas"></a>

Se diseñaron entrevistas semiestructuradas dirigidas a los dos segmentos objetivo identificados: cuidadores y familiares.

---

#### Segmento 1: Cuidadores

El objetivo es entender cómo gestionan actualmente el cuidado diario, qué herramientas utilizan y qué dificultades enfrentan.

**Preguntas principales:**
- ¿Nos podría indicar su nombre, edad y cuánto tiempo lleva realizando actividades de cuidado?
- ¿Cómo organiza actualmente la medicación y terapias del paciente?
- ¿Qué herramientas utiliza en su día a día?
- ¿Ha tenido problemas por falta de coordinación o información?
- ¿Cómo se comunica con otros cuidadores o familiares?
- ¿Qué aspectos considera más difíciles en el cuidado diario?
- ¿Qué funcionalidades le gustaría tener en una aplicación de apoyo?
- ¿Qué espera mejorar con una solución digital?

---

#### Segmento 2: Pacientes geriátricos

El objetivo de este segmento es comprender cómo los pacientes gestionan su propio cuidado, qué dificultades tienen para seguir sus tratamientos y qué tipo de apoyo digital necesitan para mejorar su autonomía.

**Preguntas principales:**
- ¿Nos podría indicar su nombre, edad y si actualmente recibe apoyo de un cuidador?
- ¿Cómo recuerda tomar sus medicamentos o asistir a sus citas médicas?
- ¿Ha tenido dificultades para seguir su tratamiento o rutina diaria?
- ¿Qué es lo que más le cuesta recordar o controlar en su día a día?
- ¿Utiliza celular o alguna aplicación actualmente? ¿Para qué?
- ¿Qué tipo de recordatorios le ayudarían más (alarmas, notificaciones, mensajes)?
- ¿Le gustaría poder ver sus actividades o medicamentos en una sola pantalla?
- ¿Qué le haría sentir más seguro o tranquilo respecto a su cuidado?
- ¿Qué tan fácil o difícil le resulta usar aplicaciones móviles?
- ¿Qué funcionalidades le gustaría tener en una aplicación que le ayude en su cuidado?
- 
---

### 2.2.2. Registro de entrevistas <a id="222-registro-de-entrevistas"></a>
#### Segmento: Cuidadores

---

### Entrevista 1

**Información del entrevistado**
![entrevista1](assets/Entrevistado1.png)

- Nombre: Giancarlo Castañeda  
- Edad: 20 años  
- Procedencia: Perú 
- Tiempo como cuidador: 1 año  
- Tipo de cuidado: Cuidador de adultos mayores a domicilio  

**Resumen:**

El entrevistado indicó que actualmente gestiona el cuidado del paciente mediante herramientas mayormente manuales. Para la medicación utiliza pastilleros semanales organizados con base en recetas médicas, complementando con alarmas en su celular para recordar los horarios. Las terapias y citas médicas las registra en un cuaderno físico junto con el historial del paciente.

En cuanto a herramientas, utiliza dispositivos médicos básicos como tensiómetro, oxímetro y termómetro, además de un cuaderno de bitácora para registrar eventos relevantes. A nivel digital, emplea principalmente alarmas y WhatsApp para comunicarse con los familiares.

El entrevistado señaló que uno de los principales problemas es la falta de coordinación durante los cambios de turno, donde la información no siempre se transmite correctamente, lo que puede generar pérdida de datos importantes sobre el estado del paciente.

Respecto a las dificultades del cuidado diario, mencionó el manejo de cambios de humor y episodios de confusión del paciente, así como la falta de apoyo inmediato de profesionales de salud para resolver dudas.

En relación con una posible solución digital, destacó la necesidad de funcionalidades como:
- Registro compartido en tiempo real entre cuidadores  
- Confirmación de administración de medicamentos  
- Recordatorios automáticos  
- Historial de signos vitales  
- Sección de notas para relevo de turno  

Finalmente, el entrevistado espera que una solución digital le permita reducir la carga mental, mejorar la organización del cuidado y generar mayor confianza con los familiares, al brindarles visibilidad del estado del paciente en tiempo real.

---

### Entrevista 2

**Información del entrevistado**
![entrevista2](assets/Entrevistado2.png)

- Nombre: Renzo Uribe  
- Edad: 20 años  
- Procedencia: Perú  
- Tiempo como cuidador: 2 años  
- Tipo de cuidado: Cuidador de adultos mayores a domicilio  

**Resumen:**

El entrevistado indicó que gestiona el cuidado del paciente mediante una combinación de herramientas manuales y digitales. Para la medicación utiliza un pastillero semanal organizado por horarios (mañana, tarde y noche). En cuanto a terapias y citas médicas, emplea tanto un calendario físico como herramientas digitales como Google Calendar.

Respecto a las herramientas utilizadas en su día a día, mencionó el uso de hojas de papel, aplicaciones de notas y múltiples alarmas en su celular. Además, registra información relevante como alimentación, signos vitales y cambios de ánimo en notas personales.

El entrevistado señaló que uno de los principales problemas es la falta de coordinación e información, especialmente durante cambios de turno o cuando los familiares no comunican cambios en la medicación. Esto puede generar incertidumbre sobre si el paciente ya recibió una dosis o si hubo modificaciones en el tratamiento.

En cuanto a la comunicación, utiliza principalmente WhatsApp; sin embargo, considera que no es eficiente debido a la pérdida de información entre mensajes, lo que dificulta la búsqueda de datos importantes en situaciones críticas.

Entre las principales dificultades del cuidado diario, destacó:
- La responsabilidad de manejar múltiples pacientes  
- El control del stock de medicamentos y suministros  
- La necesidad de recordar citas y tareas  
- La gestión de cambios de ánimo en los pacientes  
- La dependencia de la memoria ante la falta de un sistema centralizado  

En relación con una solución digital, el entrevistado propuso funcionalidades como:
- Registro compartido de medicación con confirmación de dosis  
- Alertas automáticas en caso de olvido  
- Bitácora de salud con registro de signos vitales  
- Visualización gráfica para seguimiento médico  
- Botón de emergencia con notificación a familiares y envío de ubicación  

Finalmente, el entrevistado espera que una solución digital le permita mejorar la organización, reducir errores en el cuidado y tener mayor tranquilidad al contar con un historial claro del paciente, evitando depender únicamente de la memoria o de la comunicación informal.

---
### Entrevista 3

**Información del entrevistado**
![entrevista3](assets/Entrevistado3.png)
- Nombre: Sebastián Rubio Ortiz  
- Edad: 20 años  
- Procedencia: Perú  
- Tiempo como cuidador: Aproximadamente 1 año  
- Tipo de cuidado: Cuidador informal (inicio familiar y experiencia progresiva)  

**Resumen:**

El entrevistado indicó que organiza el cuidado del paciente utilizando principalmente herramientas digitales. Para la programación de citas y terapias emplea aplicaciones como Google Calendar, mientras que para la medicación utiliza una combinación de pastilleros físicos y recordatorios digitales en su celular.

En cuanto a las herramientas utilizadas, mencionó el uso constante del teléfono móvil para alarmas, cronómetros, notas y comunicación mediante WhatsApp. Señaló que estas herramientas son útiles, pero no están integradas entre sí.

El entrevistado destacó que uno de los principales problemas es la falta de coordinación entre cuidadores, especialmente debido al uso de distintos métodos (digitales y manuales). Indicó que el “choque generacional” dificulta la organización, ya que algunos cuidadores prefieren registrar información en papel, lo que puede generar pérdida de datos o falta de actualización en cambios de medicación.

Respecto a la comunicación, indicó que se realiza principalmente a través de grupos de WhatsApp, lo cual puede generar desorden y dificultar el acceso rápido a información relevante.

Entre las principales dificultades del cuidado diario, mencionó:
- La alta carga mental asociada a la responsabilidad del cuidado  
- El riesgo de cometer errores en la administración de medicación  
- La dificultad para organizar información de manera eficiente  
- La falta de un sistema unificado entre cuidadores  

En relación con una solución digital, el entrevistado propuso funcionalidades como:
- Interfaz intuitiva y de uso rápido  
- Sistema de checklist sincronizado entre cuidadores  
- Centralización de información médica del paciente  
- Gestión de stock de medicamentos  

Finalmente, el entrevistado espera que una solución digital le permita centralizar toda la información del paciente en un solo lugar, mejorar la coordinación entre cuidadores y facilitar la organización del cuidado diario de manera más eficiente.
#### Segmento: Pacientes geriátricos

---

### Entrevista 1

**Información del entrevistado**

- Nombre: Rosa María Quispe  
- Edad: 68 años  
- Procedencia: Lima, Perú  
- ¿Cuenta con apoyo de cuidador?: Sí (hija)  
- Nivel de autonomía: Media  
- ¿Utiliza celular?: Sí (uso básico)  

---

**Resumen:**

La entrevistada indicó que depende parcialmente de su hija para organizar su medicación y citas médicas. Utiliza alarmas en su celular para recordar algunos medicamentos, pero en ocasiones se olvida si ya los tomó o no. Señala que le gustaría tener una forma más clara de saber qué le toca hacer durante el día.

---

**Gestión del cuidado actual:**

Menciona que utiliza alarmas en su celular para recordar la medicación, pero también depende de su hija para confirmar horarios y dosis. Las citas médicas son anotadas en un cuaderno.

---

**Dificultades identificadas:**
- Olvido de medicación en algunos momentos  
- Confusión sobre si ya tomó una dosis  
- Dependencia de otra persona para confirmar información  

---

**Uso de tecnología:**

Utiliza celular principalmente para llamadas, WhatsApp y alarmas. Indica que no está familiarizada con aplicaciones complejas.

---

**Necesidades y expectativas:**

Le gustaría una herramienta simple que le indique claramente qué medicamentos debe tomar y en qué momento, sin generar confusión.

---

**Funcionalidades sugeridas:**
- Recordatorios claros con sonido  
- Confirmación visual de medicación tomada  
- Pantalla simple con actividades del día  

---

**Conclusión del entrevistado:**

Espera que una solución digital le ayude a sentirse más segura y menos dependiente, especialmente para recordar su medicación diaria.

---

### Entrevista 2

**Información del entrevistado**

- Nombre: Luis Alberto Rojas  
- Edad: 74 años  
- Procedencia: Arequipa, Perú  
- ¿Cuenta con apoyo de cuidador?: No (vive con su esposa)  
- Nivel de autonomía: Alta  
- ¿Utiliza celular?: Sí  

---

**Resumen:**

El entrevistado indicó que gestiona su cuidado de forma independiente, utilizando principalmente su memoria y algunos recordatorios en el celular. Sin embargo, reconoce que en ocasiones olvida detalles de su tratamiento o citas médicas.

---

**Gestión del cuidado actual:**

Se apoya en su memoria y en algunas alarmas para recordar la medicación. Las citas médicas las anota en un calendario físico.

---

**Dificultades identificadas:**
- Olvido ocasional de medicamentos  
- Falta de organización centralizada  
- Dificultad para llevar un historial de su salud  

---

**Uso de tecnología:**

Utiliza celular para llamadas, WhatsApp y ocasionalmente para alarmas. Se siente relativamente cómodo con tecnología básica.

---

**Necesidades y expectativas:**

Busca una herramienta que le permita tener todo organizado en un solo lugar y evitar olvidos.

---

**Funcionalidades sugeridas:**
- Recordatorios automáticos  
- Registro de medicamentos tomados  
- Historial simple de salud  

---

**Conclusión del entrevistado:**

Espera mejorar su organización diaria y reducir los errores en su tratamiento mediante una herramienta fácil de usar.

### Entrevista 3

![Pacientes](<assets/Entrevista 3 de Pacientes Geriatricos.png>)

**Información del entrevistado**

- Nombre: Laura Marcela Rios  
- Edad: 78 años  
- Procedencia: Magdalena, Lima  
- ¿Cuenta con apoyo de cuidador?: No (Pero vive con su familia)  
- Nivel de autonomía: Alta  
- ¿Utiliza celular?: Sí  

---

**Resumen:**

El entrevistado indicó que gestiona su cuidado de forma independiente, utilizando principalmente alarmas y recordatorios en su celular o tablet que usa. Sin embargo, reconoce que en ocasiones se olvida y sus hijos o las mismas alarmas le hacen acordar de sus medicamentos que debe de tomar

---

**Gestión del cuidado actual:**

Se apoya en su sus alarmas y recordatorios en su celular y tablet. Además, de poder caminar e ir a sus citas de manera presencial y sin ayuda, en la mayoria de casos.

---

**Dificultades identificadas:**
- Olvido ocasional de fechas  
- Discapacidad fisica en ciertos momentos  
- Dificultad para guardar sus documentos de una manera centralizada

---

**Uso de tecnología:**

Utiliza celular para llamadas, WhatsApp y bastante para alarmas y su calendario. Además, del uso frecuente de Tablet para sus entretenimiento u/o comunicación. Se siente cómoda con tecnología.

---

**Necesidades y expectativas:**

Busca una herramienta que le permita tener todo organizado en un solo lugar y evitar olvidos y que sea una manera rapida de transmitirle a sus hijos en caso la tengan que ayudar.

---

**Funcionalidades sugeridas:**
- Recordatorios automáticos  
- Agendado de citas acompañada
- Historial de documentos y citas pasadas

---

**Conclusión del entrevistado:**

Espera mejorar su organización diaria y reducir los errores y accidentes que pueda subrir en su tratamiento o camino a este, mediante una herramienta fácil de usar.

---
### 2.2.3. Análisis de entrevistas <a id="223-analisis-de-entrevistas"></a>

A partir de las entrevistas realizadas a los segmentos objetivo (cuidadores y pacientes geriátricos), se identificaron patrones claros en cuanto a la gestión del cuidado, dificultades actuales y necesidades de los usuarios.

Se analizaron un total de 5 entrevistas:
- 3 cuidadores
- 2 pacientes geriátricos

---
 Evidencias del proyecto:  
[Acceder al repositorio en Google Drive](https://drive.google.com/drive/folders/19tCAzW3sOqVhnpO8-5iWRA5_sTeS_uQQ?usp=sharing)

#### Análisis del segmento: Cuidadores

**Datos demográficos:**
- Edad promedio: 20 años  
- Rango: 20 - 20 años  
- Experiencia: 1 a 2 años  

---

**Herramientas utilizadas:**

- El 100% utiliza celular como herramienta principal  
- El 100% utiliza alarmas para recordar medicación  
- El 100% combina herramientas físicas (pastilleros, cuadernos) con digitales  
- El 100% utiliza WhatsApp para comunicación  

---

**Problemas identificados:**

- El 100% presenta problemas de coordinación entre cuidadores  
- El 100% ha experimentado pérdida de información  
- El 100% depende de múltiples herramientas no integradas  
- El 66.7% menciona dificultades en cambios de turno  
- El 66.7% señala desorden en la comunicación (WhatsApp)  

---

**Dificultades principales:**

- El 100% menciona alta carga mental  
- El 100% expresa preocupación por cometer errores en medicación  
- El 66.7% menciona problemas con organización de información  
- El 33.3% menciona falta de apoyo profesional inmediato  

---

**Funcionalidades más solicitadas:**

- Registro compartido en tiempo real: 100%  
- Confirmación de medicación: 100%  
- Alertas automáticas: 100%  
- Historial del paciente: 100%  
- Notas o relevo de turno: 66.7%  
- Botón de emergencia: 33.3%  
- Control de stock de medicamentos: 33.3%  

---

**Conclusiones del segmento:**

- Existe una fuerte dependencia de herramientas manuales y no especializadas  
- La coordinación entre cuidadores es el problema más crítico  
- La carga mental es alta debido a la responsabilidad del cuidado  
- Se requiere una solución que centralice la información y automatice procesos  
- La simplicidad y rapidez son factores clave para la adopción  

---

#### Análisis del segmento: Pacientes geriátricos

**Datos demográficos:**
- Edad promedio: 71 años  
- Rango: 68 - 74 años  

---

**Gestión del cuidado:**

- El 100% presenta dificultades para recordar medicación o actividades  
- El 50% depende de un cuidador para su organización  
- El 100% utiliza métodos básicos (memoria, cuaderno o alarmas simples)  

---

**Uso de tecnología:**

- El 100% utiliza celular (nivel básico)  
- El 100% utiliza funciones simples (llamadas, WhatsApp, alarmas)  
- El 50% presenta dificultad con aplicaciones complejas  

---

**Problemas identificados:**

- El 100% presenta riesgo de olvido de medicación  
- El 100% no cuenta con un sistema centralizado  
- El 50% presenta confusión sobre dosis administradas  

---

**Funcionalidades más solicitadas:**

- Recordatorios claros: 100%  
- Confirmación de medicación: 100%  
- Visualización simple de actividades: 100%  
- Interfaz sencilla: 100%  
- Historial básico: 50%  

---

**Conclusiones del segmento:**

- Los pacientes requieren soluciones extremadamente simples  
- Existe una alta dependencia de apoyo externo  
- La claridad visual y facilidad de uso son fundamentales  
- La solución debe reducir la confusión y aumentar la autonomía  

---

### Conclusión general del análisis

A partir de ambos segmentos, se identifican los siguientes insights clave:

- El 100% de los usuarios presenta problemas de organización del cuidado  
- El 100% utiliza herramientas no especializadas  
- El 100% requiere centralización de información  
- La coordinación entre cuidadores es el mayor problema  
- La carga mental es alta en cuidadores  
- Los pacientes necesitan simplicidad extrema  

---

### Implicaciones para el diseño de CareConnect

- Implementar un sistema centralizado de información  
- Diseñar una interfaz simple y accesible  
- Incorporar alertas y recordatorios inteligentes  
- Permitir la colaboración entre múltiples usuarios  
- Reducir la dependencia de herramientas externas  

CareConnect debe enfocarse en resolver la desorganización actual del cuidado, proporcionando una solución confiable, intuitiva y centrada en las necesidades reales de los usuarios.
## 2.3. Needfinding <a id="23-needfinding"></a>
### 2.3.1. User Personas <a id="231-user-personas"></a>

En esta sección se presentan los arquetipos construidos a partir de los hallazgos recogidos en el análisis de competencia (§2.1) y en el análisis de entrevistas (§2.2.3). Cada ficha concentra datos demográficos, hábitos, objetivos, frustraciones y nivel de adopción tecnológica observados durante la investigación, y sirve de referencia para las decisiones de diseño de CareConnect. Se elaboró una ficha por cada segmento objetivo definido en el Capítulo I (§1.3): el cuidador de pacientes geriátricos y el paciente geriátrico con autonomía parcial o acompañada.

Los atributos destacados son los que aparecieron de forma transversal en las entrevistas: uso intensivo del celular como herramienta principal, dependencia de soluciones no especializadas (WhatsApp, pastilleros, cuadernos), alta carga mental en cuidadores y necesidad de simplicidad extrema en pacientes. Estos rasgos orientan el tono, la jerarquía de información y las prioridades funcionales del producto.

---

#### User Persona 1 — Valeria Huamán (Cuidadora informal)

![Foto referencial - Valeria Huamán](assets/persona_valeria.png)

| Atributo | Valor |
|---|---|
| **Nombre** | Valeria Huamán Soto |
| **Edad** | 28 años |
| **Género** | Femenino |
| **Ocupación** | Asistente administrativa a tiempo parcial; cuidadora informal de su abuela |
| **Ubicación** | Lima Metropolitana, zona urbana (San Miguel) |
| **NSE** | C |
| **Estado civil** | Soltera, vive con su familia extendida |
| **Educación** | Superior técnica (Administración) |
| **Persona a cargo** | Abuela de 74 años con hipertensión, artrosis y movilidad reducida |
| **Tiempo cuidando** | 1 año y 8 meses |
| **Dispositivo principal** | Smartphone Android gama media |

**Biografía:**
Valeria divide su día entre el trabajo administrativo y el cuidado de su abuela, a quien asiste junto con su madre y una tía. Asumió el rol porque es la más hábil con el celular y se encarga de coordinar medicamentos, citas y turnos por WhatsApp. Lleva el control en un cuaderno y en alarmas del teléfono, pero varias veces ha tenido que llamar a su madre para confirmar si la abuela ya tomó una dosis. Le preocupa equivocarse y repite los mensajes "por las dudas".

**Objetivos:**
- Saber siempre en qué punto del tratamiento está su abuela sin tener que preguntar.
- Que cualquier cuidador de la familia pueda continuar el cuidado sin perder información.
- Reducir el tiempo que dedica a coordinar turnos y copiar datos entre herramientas.
- Tener evidencia rápida cuando el médico pide historial o dosis administradas.

**Frustraciones:**
- WhatsApp se llena de mensajes y termina perdiendo la indicación original.
- No hay forma fácil de confirmar si otra persona ya administró el medicamento.
- Copia la receta en el cuaderno y luego la vuelve a escribir en el celular para compartirla.
- El doctor le pide evolución semanal y tiene que reconstruirla de memoria.
- Olvidó una dosis por estar en una reunión de trabajo y cargó con la culpa varios días.

**Comportamientos y hábitos:**
- Revisa el celular cada 30 - 45 minutos durante su jornada.
- Usa alarmas con etiquetas específicas ("Enalapril 10mg", "Control cardio lunes").
- Combina WhatsApp, Google Calendar, notas del celular y cuaderno físico.
- Prefiere apps con flujos cortos; abandona si pide registrarse con más de tres datos.

**Nivel tecnológico:** Medio-alto. Se maneja bien con apps cotidianas (banca móvil, pedidos, mensajería) pero no con herramientas clínicas especializadas.

**Motivaciones:** Cariño familiar, responsabilidad compartida, reducción de errores, tranquilidad de saber que todo queda registrado.

**Frase representativa:**
> "Lo que más me estresa no es hacer las cosas, es acordarme de todo y avisarle a los demás sin equivocarme."

---

#### User Persona 2 — Don Rafael Medina (Paciente geriátrico)

![Foto referencial - Rafael Medina](assets/persona_rafael.png)

| Atributo | Valor |
|---|---|
| **Nombre** | Rafael Medina Paredes |
| **Edad** | 72 años |
| **Género** | Masculino |
| **Ocupación** | Contador jubilado |
| **Ubicación** | Lima Metropolitana, zona urbana (Surquillo) |
| **NSE** | C |
| **Estado civil** | Casado; su hija lo visita a diario |
| **Educación** | Superior universitaria |
| **Condición** | Diabetes tipo 2 controlada, hipertensión, leve pérdida de memoria reciente |
| **Autonomía** | Parcial — cocina simple, camina solo dentro de casa, depende de apoyo para citas y medicación compleja |
| **Dispositivo principal** | Smartphone Android gama media con letras grandes |

**Biografía:**
Don Rafael vive con su esposa y recibe visitas frecuentes de su hija, quien coordina la medicación y acompaña las citas médicas. Maneja su celular para llamadas, WhatsApp y alarmas simples, pero se confunde cuando una app tiene demasiados menús o pide muchos pasos. Su mayor preocupación es "no molestar" a la familia, por lo que a veces omite avisar malestares pequeños. Le gusta sentir que participa de su propio cuidado.

**Objetivos:**
- Recordar sin ayuda qué medicamento toma y a qué hora.
- Confirmar rápido que ya hizo una actividad del día (tomar pastilla, hacer ejercicio).
- Consultar sus próximas citas sin llamar a su hija.
- Comunicar cómo se siente de forma simple cuando algo no anda bien.

**Frustraciones:**
- A veces duda si ya tomó la medicación o no, y termina no tomándola por miedo a duplicar dosis.
- Las apps que prueba tienen textos pequeños, botones poco claros y demasiados menús.
- Siente que depende mucho de su hija para cosas que antes resolvía solo.
- Se pierde entre recetas físicas, resultados y comprobantes de farmacia.

**Comportamientos y hábitos:**
- Usa el celular varias veces al día, siempre para tareas sencillas.
- Pide a su hija que le configure alarmas y le explique instrucciones médicas nuevas.
- Prefiere la voz y las imágenes grandes a leer textos largos.
- Evita probar apps nuevas a menos que alguien de confianza se las instale.

**Nivel tecnológico:** Bajo-medio. Funciones básicas dominadas; se incomoda con navegación compleja o formularios.

**Motivaciones:** Mantener autonomía, no sentirse una carga, cuidar su salud para seguir compartiendo tiempo con su familia.

**Frase representativa:**
> "Yo quiero saber qué toca hacer hoy sin tener que llamar a mi hija por cada cosita."

---

### 2.3.2. User Task Matrix <a id="232-user-task-matrix"></a>

A partir de los dos User Personas definidos en §2.3.1 —Valeria Huamán (cuidadora informal) y Don Rafael Medina (paciente geriátrico)—, se consolidan las tareas que ambos segmentos realizan en su día a día para llevar adelante el cuidado geriátrico. Es importante precisar que estas tareas se identifican con independencia de la existencia de CareConnect: representan actividades que los usuarios ya ejecutan con las herramientas que tienen a mano (WhatsApp, cuadernos, alarmas, llamadas, memoria), y que cualquier solución de software debería facilitar, no reemplazar.

Para cada tarea se indica la **Frecuencia** con la que el segmento la realiza (Alta / Media / Baja) y la **Importancia** que tiene dentro del proceso de cuidado (Alta / Media / Baja). La escala se apoya en los porcentajes obtenidos en el análisis de entrevistas (§2.2.3).

| **Tarea** | **Valeria (Cuidadora)**<br>Frecuencia | **Valeria (Cuidadora)**<br>Importancia | **Rafael (Paciente)**<br>Frecuencia | **Rafael (Paciente)**<br>Importancia |
|---|:---:|:---:|:---:|:---:|
| Administrar y/o tomar la medicación según horario | Alta | Alta | Alta | Alta |
| Recordar y confirmar si una dosis ya fue administrada | Alta | Alta | Alta | Alta |
| Registrar observaciones del paciente (síntomas, ánimo, signos) | Alta | Alta | Media | Media |
| Consultar la rutina y actividades del día (controles, terapias) | Alta | Alta | Alta | Alta |
| Agendar y asistir a citas médicas | Media | Alta | Media | Alta |
| Coordinar el cambio de turno entre cuidadores | Alta | Alta | N/A | N/A |
| Comunicar cambios o malestares del paciente a familiares / médicos | Alta | Alta | Media | Alta |
| Consultar historial clínico y evolución del paciente | Media | Alta | Baja | Media |
| Gestionar documentos médicos (recetas, resultados, comprobantes) | Media | Alta | Baja | Media |
| Buscar información sobre tratamiento o medicamentos | Media | Media | Baja | Media |
| Solicitar apoyo a cuidador o familiar ante una duda | Media | Media | Alta | Alta |
| Reportar que una actividad del día fue completada | Alta | Media | Alta | Alta |

---

**Tareas con mayor frecuencia e importancia:**
La administración y confirmación de medicación, la consulta de la rutina diaria y el reporte de actividades completadas son tareas que ambos segmentos realizan con frecuencia alta y consideran de alta importancia. Esto es consistente con el 100% de entrevistados que mencionó la medicación como eje del cuidado y con las funcionalidades más solicitadas en §2.2.3 (recordatorios, confirmación de medicación, visualización simple de actividades).

**Principales coincidencias entre ambos segmentos:**
Ambos User Personas coinciden en necesitar certeza sobre el estado del tratamiento: Valeria necesita saber si alguien más ya administró una dosis, y Rafael necesita saber si él mismo ya la tomó. Ambos usan el celular como herramienta principal y valoran la rapidez para acceder a información crítica. También comparten la tarea de consultar la rutina diaria y reportar su cumplimiento, aunque con matices: Valeria la vive como responsabilidad operativa, Rafael como una forma de participar en su propio cuidado.

**Principales diferencias:**
Las tareas vinculadas a la coordinación (cambio de turno, gestión documental, comunicación con múltiples actores) concentran alta frecuencia e importancia solo para Valeria; en Rafael aparecen con baja frecuencia porque las delega en su hija o esposa. En contraste, "solicitar apoyo" es una tarea de alta frecuencia para Rafael y media para Valeria, lo que refleja la asimetría de autonomía entre ambos: el paciente busca apoyo, el cuidador lo provee.

**Implicaciones para el diseño:**
Las tareas con alta frecuencia y alta importancia en ambos segmentos deben resolverse con flujos mínimos (uno o dos tap) y visibilidad inmediata en la pantalla principal. Las tareas asimétricas —coordinación para el cuidador, solicitud de apoyo para el paciente— justifican vistas diferenciadas por rol dentro de una misma aplicación compartida. El resto de tareas (consulta de historial, gestión documental, búsqueda de información) puede vivir detrás de un segundo nivel de navegación sin perjudicar la experiencia.

### 2.3.3. User Journey Mapping <a id="233-user-journey-mapping"></a>

El User Journey Map representa, por cada User Persona, la secuencia de fases que atraviesa durante el proceso de cuidado geriátrico cotidiano, las acciones concretas que realiza en cada fase, los pensamientos asociados, los principales pain points y la curva emocional. Se construyen dos mapas —uno para Valeria Huamán como cuidadora informal y otro para Rafael Medina como paciente geriátrico— a fin de visualizar cómo las mismas etapas del cuidado generan experiencias distintas según el rol.

---

#### User Journey — Valeria Huamán (Cuidadora informal)

![User Journey Map de Valeria Huamán](assets/journey_valeria.png)

*Figura 6. User Journey Map de Valeria Huamán durante un día típico de cuidado.*

El recorrido de Valeria muestra una caída emocional progresiva a lo largo del día: arranca con incertidumbre ("¿me estoy olvidando de algo?"), se estabiliza brevemente al administrar la medicación y vuelve a caer en los momentos críticos de cambio de turno y consulta médica, donde la falta de una herramienta centralizada hace que la información dependa de memoria y cuadernos. El punto más bajo aparece en la consulta médica: cuando el doctor pide historial y evolución, Valeria debe reconstruirlo a mano. La fase de registro de evolución cierra el día con frustración por no tener un registro fiel de lo ocurrido.

#### User Journey — Rafael Medina (Paciente geriátrico)

![User Journey Map de Rafael Medina](assets/journey_rafael.png)

*Figura 7. User Journey Map de Rafael Medina durante un día típico.*

El recorrido de Rafael es más plano pero tiene un valle claro en la fase "malestar o cambio": por su intención de no molestar a la familia, tarda en avisar cuando algo está fuera de lo normal. Al momento de tomar la medicación también baja la curva porque, ante la duda de haberla tomado, prefiere omitirla. La fase de actividades del día es la más positiva (rutina conocida, sensación de autonomía), y la consulta médica recupera cierta estabilidad porque está acompañado, aunque persiste la frustración de no tener su historial al alcance.

---

### 2.3.4. Empathy Mapping <a id="234-empathy-mapping"></a>

El Empathy Map complementa al User Journey al detenerse no en el "qué hace" sino en el "qué siente, piensa y dice" el usuario. Cada mapa se organiza en cuatro cuadrantes —DICE, PIENSA, HACE y SIENTE— y consolida las citas, observaciones y reacciones recogidas durante las entrevistas (§2.2.3). Permiten al equipo anclar las decisiones de diseño y de contenido en el estado mental real de cada segmento, evitando suposiciones genéricas.

---

#### Empathy Map — Valeria Huamán (Cuidadora informal)

![Empathy Map de Valeria Huamán](assets/empathy_valeria.png)

*Figura 8. Empathy Map de Valeria Huamán.*

En Valeria destaca una tensión entre el alto nivel de responsabilidad asumido y la falta de herramientas que la acompañen. **DICE** y **PIENSA** convergen en la misma preocupación: olvidar un medicamento o una indicación. **HACE** muestra un patrón claro de uso intensivo del celular combinado con cuaderno físico, lo que refleja la ausencia de una solución centralizada. **SIENTE** combina ansiedad y culpa con momentos puntuales de alivio cuando otro familiar confirma una acción. El mapa evidencia que CareConnect debe reducir la carga mental antes que sumar nuevas funciones.

#### Empathy Map — Rafael Medina (Paciente geriátrico)

![Empathy Map de Rafael Medina](assets/empathy_rafael.png)

*Figura 9. Empathy Map de Rafael Medina.*

En Rafael el eje emocional dominante es la pérdida progresiva de autonomía. **DICE** muestra su deseo de resolver lo cotidiano sin tener que llamar a su hija por cada detalle. **PIENSA** revela una regla de decisión riesgosa: ante la duda, prefiere omitir la dosis. **HACE** confirma un uso muy acotado del celular y un rechazo natural a apps nuevas si no fueron instaladas por alguien de confianza. **SIENTE** mezcla frustración y gratitud, con tranquilidad cuando la información se presenta de forma clara. El mapa refuerza que la interfaz debe priorizar legibilidad, confirmación simple y lenguaje directo.
### 2.3.5. Ubiquitous Language <a id="235-ubiquitous-language"></a>

#### Health Event (Evento de salud)
Registro de una actividad relacionada con la salud del paciente, como una cita médica o la administración de medicación.

---

#### Appointment (Cita médica)
Evento de salud programado entre un paciente y un profesional de salud en una fecha y hora específica.

---

#### Medication Event (Evento de medicación)
Evento de salud que representa la administración o toma de un medicamento en un horario definido.

---

#### Patient (Paciente)
Usuario principal del sistema que gestiona su información de salud, eventos, documentos y seguimiento personal.

---

#### Caregiver (Cuidador)
Usuario autorizado por el paciente para supervisar su información de salud y apoyar su seguimiento.

---

#### Agenda (Agenda de salud)
Sistema que organiza y gestiona los eventos de salud del paciente en el tiempo, como citas y medicación.

---

#### Event Status (Estado del evento)
Condición de un evento de salud dentro del sistema, como pendiente, confirmado o no confirmado.

---

#### Event Confirmation (Confirmación de evento)
Acción mediante la cual el paciente valida la realización de un evento de salud programado.

---

#### Reschedule (Reprogramación)
Modificación de la fecha u hora de un evento de salud previamente registrado.

---

#### Notification (Notificación)
Mensaje informativo generado por el sistema para alertar al paciente o cuidador sobre eventos relevantes.

---

#### Alert (Alerta)
Notificación de alta prioridad enviada al cuidador cuando ocurre un incumplimiento o situación crítica.

---

#### Medical Document (Documento médico)
Archivo digital que contiene información clínica del paciente, como resultados, recetas o informes médicos.

---

#### Access Sharing (Acceso compartido)
Mecanismo mediante el cual el paciente otorga acceso a su información a un cuidador autorizado.

---

#### Permission (Permiso de acceso)
Reglas que determinan qué información puede visualizar o gestionar un cuidador dentro del sistema.

---

#### Diary Entry (Entrada de diario)
Registro cualitativo del paciente o cuidador sobre el estado, experiencia o seguimiento del paciente.

---

#### Diary (Diario de seguimiento)
Conjunto de entradas que permiten llevar un registro cualitativo del estado del paciente.

---

#### Authentication (Autenticación)
Proceso de verificación de identidad del usuario para permitir el acceso al sistema.

---

#### User Role (Rol de usuario)
Clasificación del usuario dentro del sistema, como paciente o cuidador, que determina sus permisos de acceso.

## 2.4. Requirements specification <a id="24-requirements-specification"></a>
### 2.4.1. User Stories <a id="241-user-stories"></a>

## Epics

| Epic ID | Nombre de la Épica        | Descripción                                                                                           |
|---------|---------------------------|-------------------------------------------------------------------------------------------------------|
| EP01    | Gestión de Agenda         | Como paciente o cuidador, quiero gestionar eventos de salud para organizar medicación y citas en el tiempo. |
| EP02    | Gestión de Notificaciones | Como paciente o cuidador, quiero recibir notificaciones para dar seguimiento oportuno a los eventos de salud. |
| EP03    | Gestión de Documentos     | Como paciente o cuidador, quiero gestionar documentos médicos para mantener un registro accesible.    |
| EP04    | Acceso Compartido         | Como paciente, quiero compartir mi perfil con un cuidador para permitir el seguimiento de mi estado de salud. |
| EP05    | Diario de Seguimiento     | Como paciente o cuidador, quiero registrar notas de seguimiento para monitorear la evolución del estado de salud. |
| EP06    | Autenticación             | Como paciente o cuidador, quiero acceder al sistema de forma segura para proteger mi información personal. |

### US01 – Registrar evento de salud


| **Story ID** | US01 |
|-----------|-------|
| **User** | Paciente / Cuidador |
| **Priority** | Alta |
| **Epic** | Gestión de Agenda |
| **Description** | Como paciente o cuidador, deseo registrar un evento de salud (medicación o cita) para organizar las actividades médicas en un calendario. |
| **Acceptance Criteria** | Escenario 1: Registro exitoso de evento <br> Dado que el paciente o cuidador ingresa datos válidos del evento <br> Cuando registra el evento de salud <br> Entonces el sistema almacena el evento correctamente en la agenda <br><br> Escenario 2: Validación de datos obligatorios <br> Dado que el paciente o cuidador omite datos obligatorios <br> Cuando intenta registrar el evento <br> Entonces el sistema muestra un mensaje de error indicando los campos requeridos <br><br> Escenario 3: Visualización del evento <br> Dado que el evento fue registrado correctamente <br> Cuando el paciente o cuidador accede al calendario <br> Entonces el evento se visualiza en la fecha correspondiente |

---

### US02 – Confirmar evento de salud

| **Story ID** | US02 |
|-----------|-------|
| **User** | Paciente |
| **Priority** | Alta |
| **Epic** | Gestión de Agenda |
| **Description** | Como paciente, deseo confirmar un evento de salud para registrar el cumplimiento de mi tratamiento. |
| **Acceptance Criteria** | Escenario 1: Confirmación exitosa <br> Dado que existe un evento programado <br> Cuando el paciente confirma el evento <br> Entonces el sistema actualiza su estado a “confirmado” <br><br> Escenario 2: Visualización del estado <br> Dado que el evento fue confirmado <br> Cuando el paciente accede al calendario <br> Entonces el estado del evento se muestra como confirmado |

---

### US03 – Reprogramar evento de salud

| **Story ID** | US03 |
|-----------|-------|
| **User** | Paciente / Cuidador |
| **Priority** | Media |
| **Epic** | Gestión de Agenda |
| **Description** | Como paciente o cuidador, deseo reprogramar un evento de salud para ajustarlo a cambios en la disponibilidad. |
| **Acceptance Criteria** | Escenario 1: Reprogramación exitosa <br> Dado que existe un evento previamente registrado <br> Cuando el paciente o cuidador modifica la fecha u hora <br> Entonces el sistema actualiza el evento correctamente <br><br> Escenario 2: Validación de conflicto <br> Dado que existe otro evento en el mismo horario <br> Cuando el paciente o cuidador intenta reprogramar <br> Entonces el sistema evita el conflicto y muestra una advertencia |

---

### US04 – Recibir recordatorios de eventos

| **Story ID** | US04 |
|-----------|-------|
| **User** | Paciente |
| **Priority** | Alta |
| **Epic** | Gestión de Notificaciones |
| **Description** | Como paciente, deseo recibir recordatorios de mis eventos de salud para cumplir con mis actividades programadas. |
| **Acceptance Criteria** | Escenario 1: Envío de recordatorio <br> Dado que existe un evento programado <br> Cuando se aproxima la hora del evento <br> Entonces el paciente recibe una notificación <br><br> Escenario 2: Contenido de la notificación <br> Dado que se genera una notificación <br> Cuando el paciente la visualiza <br> Entonces esta contiene información relevante del evento |

---

### US05 – Recibir alertas de incumplimiento

| **Story ID** | US05 |
|-----------|-------|
| **User** | Cuidador |
| **Priority** | Alta |
| **Epic** | Gestión de Notificaciones |
| **Description** | Como cuidador, deseo recibir alertas cuando un evento no es confirmado para supervisar al paciente. |
| **Acceptance Criteria** | Escenario 1: Generación de alerta <br> Dado que un evento no ha sido confirmado <br> Cuando se supera el tiempo límite establecido <br> Entonces el cuidador recibe una alerta de incumplimiento <br><br> Escenario 2: Validación de permisos <br> Dado que el cuidador no tiene acceso al paciente <br> Cuando se genera la alerta <br> Entonces el sistema no envía la notificación |

---

### US06 – Visualizar notificaciones

| **Story ID** | US06 |
|-----------|-------|
| **User** | Cuidador |
| **Priority** | Media |
| **Epic** | Gestión de Notificaciones |
| **Description** | Como cuidador, deseo visualizar las notificaciones recibidas para monitorear el estado del paciente. |
| **Acceptance Criteria** | Escenario 1: Consulta de notificaciones <br> Dado que existen notificaciones registradas <br> Cuando el cuidador accede a la sección de notificaciones <br> Entonces el sistema muestra la lista de notificaciones <br><br> Escenario 2: Orden de visualización <br> Dado que existen múltiples notificaciones <br> Cuando el cuidador las visualiza <br> Entonces se muestran ordenadas por fecha o prioridad |

---

### US07 – Subir documento médico

| **Story ID** | US07 |
|-----------|-------|
| **User** | Paciente / Cuidador |
| **Priority** | Alta |
| **Epic** | Gestión de Documentos |
| **Description** | Como paciente o cuidador, deseo subir documentos médicos para mantener un registro digital accesible. |
| **Acceptance Criteria** | Escenario 1: Carga exitosa <br> Dado que el paciente o cuidador selecciona un archivo válido <br> Cuando lo sube al sistema <br> Entonces el documento se almacena correctamente <br><br> Escenario 2: Validación de archivo <br> Dado que el archivo no cumple con formato o tamaño permitido <br> Cuando el paciente o cuidador intenta subirlo <br> Entonces el sistema muestra un mensaje de error |

---

### US08 – Consultar documentos

| **Story ID** | US08 |
|-----------|-------|
| **User** | Paciente / Cuidador |
| **Priority** | Media |
| **Epic** | Gestión de Documentos |
| **Description** | Como paciente o cuidador, deseo consultar los documentos almacenados para revisar información médica. |
| **Acceptance Criteria** | Escenario 1: Visualización de documentos <br> Dado que existen documentos almacenados <br> Cuando el paciente o cuidador accede a la sección correspondiente <br> Entonces el sistema muestra la lista de documentos disponibles |

---

### US09 – Acceder a documentos compartidos

| **Story ID** | US09 |
|-----------|-------|
| **User** | Cuidador |
| **Priority** | Media |
| **Epic** | Gestión de Documentos |
| **Description** | Como cuidador, deseo acceder a los documentos del paciente para apoyar en su seguimiento. |
| **Acceptance Criteria** | Escenario 1: Acceso autorizado <br> Dado que el cuidador tiene permisos de acceso <br> Cuando consulta los documentos del paciente <br> Entonces el sistema permite su visualización <br><br> Escenario 2: Acceso denegado <br> Dado que el cuidador no tiene permisos <br> Cuando intenta acceder a los documentos <br> Entonces el sistema bloquea el acceso y muestra un mensaje de restricción |

---

### US10 – Registrar cuenta

| **Story ID** | US10 |
|-----------|-------|
| **User** | Paciente /Cuidador |
| **Priority** | Alta |
| **Epic** |  Autenticación  |
| **Description** | Como usuario, quiero tener permiso para poder crear mi propia cuenta |
| **Acceptance Criteria** | Escenario 1:  Creación de cuenta <br> Dado que el usuario otorgo los datos validos <br> Cuando registra su cuenta  <br> usuario es creado <br><br> Escenario 2: Creación denegada <br> Dado que el usuario no ya exite <br> Cuando intenta ingresar el correo <br> Entonces el sistema bloquea el acceso y muestra un mensaje de "el usuario con este correo ya existe"|

---

### US11 – Validar acceso por rol

| **Story ID** | US11 |
|-----------|-------|
| **User** | Paciente/Cuidador |
| **Priority** | Alta |
| **Epic** |  Autenticación  |
| **Description** | Como usuario, quiero validar el acceso según el rol del que poseo.   |
| **Acceptance Criteria** | Escenario 1: Acceso permitido <br> Dado que el usuario tiene permisos válidos <br> Cuando abre la aplicación <br> Entonces el sistema le muestra lo que posee<br><br> Escenario 2: Acceso denegado <br> Dado que el usuario no tiene permisos <br> Cuando intenta acceder a otra pestaña <br> Entonces el sistema bloquea el acceso y muestra un mensaje de restricción |

---

### US12 – Escribir nota

| **Story ID** | US12 |
|-----------|-------|
| **User** | Paciente/Cuidador |
| **Priority** | Media |
| **Epic** |  Diario de Seguimiento  |
| **Description** | Como paciente o cuidador, quiero escribir notas en mi diario para registrar mi estado o el de mi familiar. |
| **Acceptance Criteria** | Escenario 1: Nota registrada <br> Dado que el cuidador o paciente ingreso contenido válido <br> Cuando guardo la nota <br> Entonces la nota se almacena correctamente <br><br> Escenario 2: Nota vacía <br> Dado que el cuidador o paciente no ingreso ningún contenido <br> Cuando intento guardar <br> Entonces el sistema muestra un mensaje error |

---

### US13 – Consultar diarios compartidos

| **Story ID** | US13 |
|-----------|-------|
| **User** |  Cuidador|
| **Priority** | Media |
| **Epic** |  Diario de Seguimiento  |
| **Description** | Como cuidador, quiero consultar el diario compartido del paciente para conocer su estado.  |
| **Acceptance Criteria** | Escenario 1: Consulta exitosa <br> Dado que el cuidador posee acceso autorizado <br> Cuando consulta el diario del paciente <br> Entonces el sistema le muestra las notas <br><br> Escenario 2: Acceso denegado <br> Dado que el paciente no tiene permisos <br> Cuando intenta acceder a las notas del cuidador <br> Entonces el sistema bloquea el acceso y muestra un mensaje de restricción |

---

### US14 – Compartir perfil

| **Story ID** | US14 |
|-----------|-------|
| **User** | Cuidador |
| **Priority** |  Alta |
| **Epic** |  Acceso Compartido   |
| **Description** |  Como paciente, quiero compartir mi perfil con familiares para que puedan ver mi información.|
| **Acceptance Criteria** | Escenario 1: Compartir exitoso <br> Dado que el familiar es un usuario válido <br> Cuando comparto mi perfil <br> Entonces el sistema el acceso a su cuenta es aceptado<br><br> Escenario 2: Error al compartir <br> Dado que el familiar no es un usuario válido <br> Cuando intenta acceder a los documentos <br> Entonces el sistema muestra un mensaje de usuario no existe |

---

### US15 – Consultar perfil compartido

| **Story ID** | US15 |
|-----------|-------|
| **User** | Cuidador |
| **Priority** | Media |
| **Epic** |  Acceso Compartido   |
| **Description** | Como cuidador, quiero consultar el perfil compartido del paciente para acceder a su información.  |
| **Acceptance Criteria** | Escenario 1: Consulta exitosa <br> Dado el paciente me dio permiso <br> Cuando consulto el perfil <br> Entonces se muestra la información <br><br> Escenario 2: Acceso inválido <br> Dado que el paciente no tiene permisos <br> Cuando intenta consultar el perfil <br> Entonces el sistema bloquea el acceso y muestra un mensaje de restricción |

---

### US16 – Revocar acceso

| **Story ID** | US16 |
|-----------|-------|
| **User** | Paciente |
| **Priority** | Media |
| **Epic** |  Acceso Compartido  |
| **Description** | Como paciente, quiero revocar el acceso a mi perfil para controlar quién puede ver mi información.  |
| **Acceptance Criteria** | Escenario 1: Revocación exitosa <br> Dado que el paciente otorgo los permisos <br> Cuando revoca el acceso <br> Entonces el sistema quita los privilegios al cuidador <br><br> Escenario 2: Acción no permitida <br> Dado que el paciente ya revoco el permiso al cuidador <br> Cuando intenta revocar el acceso <br> Entonces el sistema le muestra un mensaje de error |

---

### TS01 – Persistencia de eventos de agenda

| **Story ID** | TS01 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Alta |
| **Description** | Como desarrollador, quiero implementar la persistencia de eventos de salud (citas y medicación) para garantizar su almacenamiento y consulta eficiente. |
| **Acceptance Criteria** | Escenario 1: Almacenamiento exitoso <br> Dado que se recibe un evento válido <br> Cuando el sistema lo procesa <br> Entonces el evento se almacena correctamente en la base de datos <br><br> Escenario 2: Integridad de datos <br> Dado que ocurre un error en el almacenamiento <br> Cuando el sistema intenta guardar el evento <br> Entonces se evita la persistencia de datos incompletos |

---

### TS02 – Gestión de estado de eventos

| **Story ID** | TS02 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Alta |
| **Description** | Como desarrollador, quiero implementar la lógica de cambio de estado de los eventos (pendiente, confirmado, incumplido) para reflejar el seguimiento del paciente. |
| **Acceptance Criteria** | Escenario 1: Cambio de estado válido <br> Dado que existe un evento registrado <br> Cuando se actualiza su estado <br> Entonces el sistema persiste el nuevo estado correctamente <br><br> Escenario 2: Validación de transición <br> Dado un estado inválido <br> Cuando se intenta actualizar <br> Entonces el sistema rechaza la operación |

---

### TS03 – Programación de notificaciones

| **Story ID** | TS03 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Alta |
| **Description** | Como desarrollador, quiero implementar un servicio de programación que genere notificaciones basadas en la fecha y hora de los eventos registrados. |
| **Acceptance Criteria** | Escenario 1: Programación correcta <br> Dado que existe un evento con fecha definida <br> Cuando se agenda la notificación <br> Entonces el sistema programa su envío correctamente <br><br> Escenario 2: Reprogramación <br> Dado que el evento cambia de horario <br> Cuando se actualiza <br> Entonces la notificación se reprograma automáticamente |

---

### TS04 – Envío de notificaciones

| **Story ID** | TS04 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Alta |
| **Description** | Como desarrollador, quiero implementar el mecanismo de envío de notificaciones push hacia pacientes y cuidadores según reglas de negocio. |
| **Acceptance Criteria** | Escenario 1: Envío exitoso <br> Dado que existe una notificación programada <br> Cuando se cumple la condición de envío <br> Entonces el sistema envía la notificación al destinatario <br><br> Escenario 2: Manejo de fallos <br> Dado que falla el envío <br> Cuando ocurre el error <br> Entonces el sistema registra el incidente y reintenta según configuración |

---

### TS05 – Control de acceso a notificaciones

| **Story ID** | TS05 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Media |
| **Description** | Como desarrollador, quiero implementar validaciones de permisos para asegurar que solo usuarios autorizados reciban notificaciones. |
| **Acceptance Criteria** | Escenario 1: Acceso autorizado <br> Dado que el usuario tiene permisos <br> Cuando se genera una notificación <br> Entonces el sistema permite su envío <br><br> Escenario 2: Acceso restringido <br> Dado que el usuario no tiene permisos <br> Cuando se genera una notificación <br> Entonces el sistema bloquea el envío |

---

### TS06 – Almacenamiento de documentos

| **Story ID** | TS06 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Alta |
| **Description** | Como desarrollador, quiero implementar el almacenamiento de documentos médicos en un sistema seguro para garantizar su disponibilidad. |
| **Acceptance Criteria** | Escenario 1: Almacenamiento correcto <br> Dado que se recibe un archivo válido <br> Cuando el sistema lo procesa <br> Entonces el documento se almacena correctamente <br><br> Escenario 2: Validación de archivo <br> Dado un archivo inválido <br> Cuando se intenta almacenar <br> Entonces el sistema rechaza la operación |

---

### TS07 – Gestión de metadatos de documentos

| **Story ID** | TS07 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Media |
| **Description** | Como desarrollador, quiero implementar el registro de metadatos (tipo, fecha, paciente, descripción) asociados a cada documento. |
| **Acceptance Criteria** | Escenario 1: Registro de metadatos <br> Dado que se almacena un documento <br> Cuando se registran sus atributos <br> Entonces el sistema guarda correctamente los metadatos <br><br> Escenario 2: Consistencia <br> Dado datos incompletos <br> Cuando se intenta registrar <br> Entonces el sistema valida y rechaza la operación |

---

### TS08 – Control de acceso a documentos

| **Story ID** | TS08 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Alta |
| **Description** | Como desarrollador, quiero implementar mecanismos de autorización para controlar el acceso a documentos entre paciente y cuidador. |
| **Acceptance Criteria** | Escenario 1: Acceso permitido <br> Dado que el cuidador tiene permisos <br> Cuando solicita acceso <br> Entonces el sistema permite visualizar el documento <br><br> Escenario 2: Acceso denegado <br> Dado que no tiene permisos <br> Cuando intenta acceder <br> Entonces el sistema bloquea la operación |


### TS09 – Persistencia de usuarios

| **Story ID** | TS09 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Alta |
| **Description** | Como desarrollador, quiero implementar la persistencia de usuarios para garantizar el registro correcto en la base de datos |
| **Acceptance Criteria** | Escenario 1: Registro exitoso <br> Dado que el usuario envia datos válidos de usuario <br> Cuando el sistema procesa el registro <br> Entonces el usuario se almacena correctamente en la base de datos <br><br> Escenario 2: Usuario duplicado <br> Dado que el usuario proporciona un correo que ya existe <br> Cuando el sistema intenta registrar el usuario<br> Entonces se evita el registro duplicado y se muestra un error |


### TS10 – Autorización basada en roles

| **Story ID** | TS10 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Alta |
| **Description** | Como desarrollador, quiero implementar validación de acceso por roles para garantizar seguridad en los recursos. |
| **Acceptance Criteria** | Escenario 1: Acceso autorizado <br> Dado que el usuario tiene el rol correcto <br> Cuando intenta acceder a un recurso <br> Entonces el sistema permite el acceso <br><br> Escenario 2: Acceso denegado <br> Dado que el usuario no tiene permisos <br> Cuando intenta acceder<br> Entonces el sistema bloquea el acceso |

### TS11 – Persistencia de notas

| **Story ID** | TS11 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Alta |
| **Description** | Como desarrollador, quiero almacenar notas del diario para asegurar su disponibilidad. |
| **Acceptance Criteria** | Escenario 1: Guardado exitoso<br>Dado que la notatiene contenido válido<br>Cuando el sistema guarda la nota<br>Entonces se almacena correctamente<br><br>Escenario 2: Nota inválida<br>Dado que la nota está vacía<br>Cuando el sistema intenta guardarla<br>Entonces se rechaza la operación |

### TS12 – Consulta de diario compartido

| **Story ID** | TS12 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Media |
| **Description** | Como desarrollador, quiero implementar la consulta de diarios compartidos para permitir acceso a cuidadores. |
| **Acceptance Criteria** | Escenario 1: Consulta autorizada<br>Dado que el usuario tiene acceso<br>Cuando consulta el diario<br>Entonces se muestran las notas<br><br>Escenario 2: Acceso denegado<br>Dado que no tiene permisos<br>Cuando intenta consultar<br>Entonces el sistema bloquea el acceso |

### TS13 – Consulta de perfil compartido

| **Story ID** | TS13 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Media |
| **Description** | Como desarrollador, quiero permitir la visualización de perfiles compartidos. |
| **Acceptance Criteria** | Escenario 1: Consulta exitosa<br> Dado que el usuario tiene acceso<br>Cuando consulta el perfil<br>Entonces se muestra la información<br><br>Escenario 2: Acceso inválido<br>Dado que no tiene permisos<br>Cuando intenta acceder<br>Entonces se bloquea el acceso |

### TS14 – Revocación de acceso

| **Story ID** | TS14 |
|--------------|------|
| **User** | Desarrollador |
| **Priority** | Media |
| **Description** | Como desarrollador, quiero implementar la revocación de accesos para controlar permisos. |
| **Acceptance Criteria** | Escenario 1: Revocación exitosa<br>Dado que existe acceso activo<br>Cuando el propietario revoca acceso<br>Entonces se elimina el permiso<br><br>Escenario 2: Usuario sin permiso<br>Dado que no es propietario<br>Cuando intenta revocar<br>Entonces se rechaza la acción|

### 2.4.2. Impact Mapping <a id="242-impact-mapping"></a>

A continuación se presenta el Impact Map, el cual permite visualizar de manera clara cómo las funcionalidades clave de la aplicación se alinean con los objetivos de negocio, considerando a los actores involucrados y los impactos esperados en su comportamiento.

![Impact Mapping](<assets/Impact map 1.png>)

### 2.4.3. Product Backlog <a id="243-product-backlog"></a>
En esta sección se presenta el Product Backlog, que contiene las historias de usuario priorizadas y sus respectivas estimaciones de esfuerzo en puntos de historia. Este backlog es una herramienta clave para la planificación y gestión del desarrollo del producto, permitiendo al equipo enfocarse en las funcionalidades más importantes y valiosas para los usuarios.

| Orden | User Story ID | Título | Descripción | Story Points |
|------:|---------------|--------|-------------|-------------|
| 1 | US1 | Registrar evento de salud | Como paciente o cuidador, deseo registrar un evento de salud (medicación o cita) para organizar las actividades médicas en un calendario. | 3 |
| 2 | US2 | Confirmar evento de salud | Como paciente, deseo confirmar un evento de salud para registrar el cumplimiento de mi tratamiento. | 3 |
| 3 | US3 | Reprogramar evento de salud | Como paciente o cuidador, deseo reprogramar un evento de salud para ajustarlo a cambios en la disponibilidad. | 3 |
| 4 | US4 | Recibir recordatorios de eventos | Como paciente, deseo recibir recordatorios de mis eventos de salud para cumplir con mis actividades programadas. | 2 |
| 5 | US5 | Recibir alertas de incumplimiento | Como cuidador, deseo recibir alertas cuando un evento no es confirmado para supervisar al paciente.| 2 |
| 6 | US6 | Visualizar notificaciones | Como cuidador, deseo visualizar las notificaciones recibidas para monitorear el estado del paciente. | 1 |
| 7 | US7 | Subir documento médico | Como paciente o cuidador, deseo subir documentos médicos para mantener un registro digital accesible. | 2 |
| 8 | US8 | Consultar documentos | Como paciente o cuidador, deseo consultar los documentos almacenados para revisar información médica. | 1 |
| 9 | US9 | Acceder a documentos compartidos | Como cuidador, deseo acceder a los documentos del paciente para apoyar en su seguimiento. | 3|
| 10 | US10 |  Registrar cuenta | Como usuario, quiero tener permiso para poder crear mi propia cuenta| 2 |
| 11 | US11 | Validar acceso por rol | Como usuario, quiero validar el acceso según el rol del que poseo. | 3|
| 12 | US12 | Escribir nota | Como paciente o cuidador, quiero escribir notas en mi diario para registrar mi estado o el de mi familiar. | 2 |
| 13 | US13 | Consultar diarios compartidos | Como cuidador, quiero consultar el diario compartido del paciente para conocer su estado. | 3 |
| 14 | US14 | Compartir perfil | Como paciente, quiero compartir mi perfil con familiares para que puedan ver mi información. | 3 |
| 15 | US15| Consultar perfil compartido | Como cuidador, quiero consultar el perfil compartido del paciente para acceder a su información. | 3 |
| 16 | US16 | Revocar acceso | Como paciente, quiero revocar el acceso a mi perfil para controlar quién puede ver mi información. | 3 |
| 17 | TS1 | Persistencia de eventos de agenda | Como desarrollador, quiero implementar la persistencia de eventos de salud (citas y medicación) para garantizar su almacenamiento y consulta eficiente. | 3 |
| 18 | TS2 | Gestión de estado de eventos | Como desarrollador, quiero implementar la lógica de cambio de estado de los eventos (pendiente, confirmado, incumplido) para reflejar el seguimiento del paciente. | 3 |
| 19 | TS3 | Programación de notificaciones | Como desarrollador, quiero implementar un servicio de programación que genere notificaciones basadas en la fecha y hora de los eventos registrados. | 3 |
| 20 | TS4 | Envío de notificaciones | Como desarrollador, quiero implementar el mecanismo de envío de notificaciones push hacia pacientes y cuidadores según reglas de negocio. | 2 |
| 21 | TS5 | Control de acceso a notificaciones | Como desarrollador, quiero implementar validaciones de permisos para asegurar que solo usuarios autorizados reciban notificaciones. | 3 |
| 22 | TS6 | Almacenamiento de documentos| Como desarrollador, quiero implementar el almacenamiento de documentos médicos en un sistema seguro para garantizar su disponibilidad. | 2 |
| 23 | TS7 | Gestión de metadatos de documentos |Como desarrollador, quiero implementar el registro de metadatos (tipo, fecha, paciente, descripción) asociados a cada documento. | 3 |
| 24 | TS8 | Control de acceso a documentos | Como desarrollador, quiero implementar mecanismos de autorización para controlar el acceso a documentos entre paciente y cuidador. | 3 |
| 25 | TS9 | Persistencia de usuarios | Como desarrollador, quiero implementar la persistencia de usuarios para garantizar el registro correcto en la base de datos | 2 |
| 26 | TS10 | Autorización basada en roles | Como desarrollador, quiero implementar validación de acceso por roles para garantizar seguridad en los recursos. | 2 |
| 26 | TS11 | Persistencia de notas | Como desarrollador, quiero almacenar notas del diario para asegurar su disponibilidad. | 2 |
| 26 | TS12 | Consulta de diario compartido | Como desarrollador, quiero implementar la consulta de diarios compartidos para permitir acceso a cuidadores. | 3 |
| 26 | TS13 | Consulta de perfil compartido | Como desarrollador, quiero permitir la visualización de perfiles compartidos. | 3 |
| 26 | TS14 | Revocación de acceso | Como desarrollador, quiero implementar la revocación de accesos para controlar permisos. | 5 |


## 2.5. Strategic-Level Domain-Driven Design <a id="25-strategic-level-domain-driven-design"></a>
### 2.5.1. EventStorming <a id="251-eventstorming"></a>

![Event Storming](assets/Event_Storming.png)

#### 2.5.1.1. Candidate Context Discovery <a id="2511-candidate-context-discovery"></a>

Se aplicaron las tres estrategias indicadas en el enunciado para identificar los bounded contexts:
##### 3.1 Estrategia: Start-with-Value
Se identificaron las partes del dominio con mayor valor para el negocio (core). El sistema tiene como propósito principal coordinar el cuidado de salud entre pacientes, cuidadores y familiares.

| Modulo  | Valor de Negocio | Tipo de Dominio |
|------:|-------------|-------------|
| Agenda|	Coordinación de eventos de salud — núcleo del sistema|	Core Domain|
| Notificaciones|	Alerta y confirmación a cuidadores y pacientes	|Core Domain|
| Diario|	Registro del estado del paciente — diferenciador clave	|Core Domain|
| Documentos| Soporte de documentación clínica compartida|	Supporting Domain|
|Compartir-Perfiles|	Habilita la colaboración paciente-familiar|	Supporting Domain|
|IAM	|Autenticación y gestión de sesiones	|Generic Domain|

##### 3.2 Estrategia: Start-with-Simple

Se descompuso el timeline del EventStorm en steps secuenciales para identificar modelos simples con propósito claro. Cada módulo tiene actores y flujos definidos, lo que permite establecer límites claros entre contextos.

| Contexto  | Actores Involucrados | Flujo Principal |
|------:|-------------|-------------|
| Agenda|	Paciente, Cuidador|	Registrar evento → Programar → Recordatorio|
| Notificaciones	|Paciente, Cuidador	|Detectar evento → Notificar → Confirmar / Reprogramar|
| Documentos|	Paciente/Familiar, Cuidador	|Subir documento → Almacenar → Consultar|
| Diario|	Paciente, Cuidador	|Escribir nota → Almacenar → Compartir → Visualizar|
|IAM|	Paciente/Cuidador	|Registrar cuenta → Iniciar sesión → Cerrar sesión|
|Compartir-Perfiles|	Paciente, Cuidador	|Compartir perfil → Otorgar acceso → Visualizar info|

##### 3.3 Estrategia: Look-for-Pivotal-Events
Se identificaron los eventos clave del negocio que indican cruces entre diferentes partes del proceso. Estos eventos actúan como fronteras naturales entre bounded contexts.

| Pivotal Event  | Contexto Origen | Contexto Destino |
|------:|-------------|-------------|
| Evento de salud registrado|	Agenda|	Notificaciones|
| Notificacion enviada|	Notificaciones|	Agenda (confirmacion/reprogramacion)|
| Nota guardada en diario|	Diario|	Cuidador (monitoreo del paciente)|
| Acceso concedido al familiar	|Compartir-Perfiles|	Diario / Documentos (lectura compartida)|
|Sesion iniciada|IAM	|Todos los contextos (prerequisito global)|
|Documento medico almacenado|	Documentos|	Paciente/Familiar (consulta)|


Con estas estrategias pudimos identificar los bounded context que obtuvimos en el Event Storming

#### 2.5.1.2. Domain Message Flows Modeling <a id="2512-domain-message-flows-modeling"></a>

Para el desarrollo del Message Flow Modeling usaremos el Domain Storytelling, el cual es una tecnica de modelado colaborativo en la que los expertos de dominio narran como realizan su trabajo. El modelador escucha y registra estas historias usando un lenguaje pictografico que combina:
•	Actores (personas o sistemas de software)
•	Objetos de trabajo (documentos, datos, mensajes)
•	Actividades (flechas numeradas que indican el flujo secuencial)
•	Anotaciones (escenarios alternativos y condiciones de error)

Para cada flujo se identificaron: el actor iniciador, los bounded contexts involucrados, la secuencia de mensajes intercambiados y los escenarios alternativos (caminos de error).

#### DS-01: Paciente registra evento de salud y recibe recordatorio

Historia: El paciente inicia sesion, registra un evento de salud en la Agenda, el sistema lo programa y envia una notificacion al cuidador, quien confirma su asistencia.

![alt text](assets/Domain_Story1.png)

##### Bounded Contexts Involucrados:
1.  IAM — autentica al paciente
2.  Agenda — gestiona el registro y programacion del evento
3. 	Notificaciones — envia alerta al cuidador y recibe confirmacion

##### Flujo Principal:

| #  | Actor   | Mensaje / Accion | Destino | Resultado
|------:|-------------|-------------|-------------|-------------|
|1|	Paciente|	Inicia sesion en el sistema|	IAM	|Sesion iniciada
|2	|IAM|	Retorna token de sesion activa|	Agenda|	Acceso habilitado
|3	|Paciente|	Registra evento de salud con fecha y hora|	Agenda|	Evento de salud registrado
|4|	Agenda|	Programa evento y genera recordatorio|	Notificaciones|	Evento programado
|5|	Notificaciones	|Envia alerta al cuidador	|Cuidador	|Notificacion enviada
|6|	Cuidador|	Confirma asistencia al evento	|Notificaciones|	Evento confirmado


##### Escenarios Alternativos:
| Escenario Alternativo| Respuesta del Sistema   |
|------:|-------------|
|Conflicto de horario detectado|	Agenda notifica conflicto → Paciente reprograma el evento|
|Paciente no responde confirmacion|	Notificaciones envia alerta al cuidador → Cuidador toma accion|
Datos incompletos al registrar|	Agenda rechaza el evento → Muestra error con campos requeridos|


#### DS-02: Paciente sube documento medico y cuidador lo consulta

Historia: El paciente o familiar sube un documento medico al sistema. El documento queda disponible para que el cuidador autorizado lo consulte a traves del contexto de Compartir-Perfiles.

![alt text](assets/Domain_Story_2.png)

##### Bounded Contexts Involucrados:

1.	IAM — autentica al paciente o familiar
2.	Documentos — gestiona subida y almacenamiento del archivo
3.	Compartir-Perfiles — controla el acceso del cuidador al documento

##### Flujo Principal:

| #  | Actor   | Mensaje / Accion | Destino | Resultado
|------:|-------------|-------------|-------------|-------------|
|1|	Paciente/Familiar|	Se autentica en el sistema|	IAM	|Sesion activa|
|2	|IAM|	Concede acceso al modulo de documentos|	Documentos|	Acceso concedido|
|3	|Paciente/Familiar	|Sube documento medico (PDF, imagen)	|Documentos	|Documento almacenado
|4|	Documentos|	Notifica disponibilidad al cuidador|	Compartir-Perfiles	|Documento disponible
|5|	Cuidador	|Solicita consultar el documento medico|	Compartir-Perfiles	|Acceso validado|
|6|	Compartir-Perfiles|	Retorna documento para visualizacion	|Cuidador	|Documento visualizado|

##### Escenarios Alternativos:
| Escenario Alternativo| Respuesta del Sistema   |
|------:|-------------|
|Error al subir documento (formato invalido)|	Documentos rechaza el archivo → Muestra mensaje de error al usuario|
|Cuidador sin permisos de acceso	|Compartir-Perfiles deniega la solicitud → Acceso no autorizado|
|Documento no encontrado	|Documentos retorna error 404 → Informacion del documento no disponible|


#### DS-03: Paciente escribe en diario y cuidador monitorea su estado

Historia: El paciente escribe una nota personal en su diario clinico. La nota queda almacenada y, si el diario ha sido compartido, el cuidador puede visualizarlo en tiempo real.

![alt text](assets/Domain_Story_3.png)


##### Bounded Contexts Involucrados:

1.	IAM — autentica al paciente o familiar
2.	Diario  — gestiona el registro y almacenamiento de notas
3.	Compartir-Perfiles — controla el acceso del cuidador al documento

##### Flujo Principal:

| #  | Actor   | Mensaje / Accion | Destino | Resultado
|------:|-------------|-------------|-------------|-------------|
|1|	Paciente|	Inicia sesion en el sistema	|IAM	|Sesion iniciada|
|2|	IAM	|Habilita acceso al diario clinico	|Diario 	|Acceso habilitado|
|3|	Paciente	|Escribe nota de estado de salud	|Diario |	Nota registrada y almacenada|
|4|	Diario |	Marca nota como disponible para compartir	|Compartir-Perfiles|	Nota compartida|
|5|	Cuidador	|Solicita lectura del diario compartido	|Compartir-Perfiles	|Acceso de lectura concedido|
|6|	Compartir-Perfiles|	Retorna contenido del diario al cuidador	|Cuidador	|Diario compartido visualizado|


##### Escenarios Alternativos:
| Escenario Alternativo| Respuesta del Sistema   |
|------:|-------------|
|Nota vacia al intentar guardar|	Diario Clinico rechaza el guardado → Muestra error: nota vacia|
|Acceso no autorizado al diario	|Compartir-Perfiles deniega acceso → Acceso no autorizado al diario compartido|
|Diario no compartido aun con el cuidador|	Sistema solicita al paciente activar el permiso de lectura|


#### DS-04: Paciente comparte su perfil con un familiar

Historia: El paciente decide compartir su perfil de salud con un familiar. Genera un enlace de acceso, el familiar lo recibe y puede consultar la información del paciente de forma controlada.

![alt text](assets/Domain_Story_4.png)

##### Bounded Contexts Involucrados:

1.	IAM — autentica al paciente o familiar
3.	Compartir-Perfiles — controla el acceso del cuidador al documento

##### Flujo Principal:

| #  | Actor   | Mensaje / Accion | Destino | Resultado
|------:|-------------|-------------|-------------|-------------|
|1|	Paciente|	Se autentica para gestionar su perfil|	IAM|	Sesión activa|
|2|	IAM|	Valida identidad y autoriza acción|	Compartir-Perfiles	|Sesión verificada|
|3|	Paciente|	Solicita compartir perfil con familiar	|Compartir-Perfiles|	Perfil compartido — enlace generado|
|4|	Compartir-Perfiles	|Envía enlace de acceso al familiar	|Familiar|	Enlace recibido|
|5|	Familiar|	Accede mediante el enlace recibido	|Compartir-Perfiles	|Acceso al familiar concedido|
|6|	Compartir-Perfiles|	Muestra información del paciente al familiar	|Familiar	|Información del paciente visualizado|



##### Escenarios Alternativos:
| Escenario Alternativo| Respuesta del Sistema   |
|------:|-------------|
|Enlace expirado al intentar acceder	|Compartir-Perfiles rechaza el acceso → Enlace expirado|
|Acceso no autorizado (enlace invalido)	|Sistema deniega la solicitud → Acceso no autorizado|
|Error al compartir perfil	|Compartir-Perfiles retorna error → Acceso no concedido|

#### 2.5.1.3. Bounded Context Canvases <a id="2513-bounded-context-canvases"></a>

Segun el valor de negocio identificado en el Candidate Context Discovery, el orden de elaboracion de los canvases es:

| #  | Bounded Context   | Tipo | Justificacion| 
|------:|-------------|-------------|-------------|
|1|	Agenda y Programacion|	Core Domain|	Nucleo del sistema — coordina todos los eventos de salud|
|2|	Notificaciones|	Core Domain|	Cierra el loop de la Agenda — alerta y confirmacion|
|3|	Diario|	Core Domain|	Diferenciador del producto — seguimiento continuo|
|4|	Documentos Medicos|	Supporting Domain	|Soporte al historial clinico del paciente|
|5|	Compartir-Perfiles|	Supporting Domain	|Habilita la colaboracion entre actores|
|6|	IAM — Identidad y Acceso	|Generic Domain	|Prerequisito de todos los contextos — candidato a externalizarse|

#### Bounded Context Canvas 1:

##### BC-01 — Agenda y Programacion


###### Context Overview Definition

Campos:

1. Proposito:	Gestionar el ciclo de vida completo de los eventos de salud: registro, programacion, reprogramacion y generacion de recordatorios.
2. Problema:	Los pacientes olvidan sus citas y eventos de salud. Los cuidadores necesitan visibilidad sobre la agenda del paciente para coordinar su asistencia.
3. Usuarios:	Paciente (crea y consulta eventos), Cuidador (visualiza y reprograma eventos)
4. Alcance:	Incluye: registro de eventos, programacion en calendario, deteccion de conflictos, recordatorios. Excluye: envio de notificaciones (Notificaciones BC).


###### Business Rules Distillation

Regla de Negocio:

1. Un evento debe tener fecha, hora y tipo definidos para ser registrado
2. No pueden existir dos eventos del mismo paciente en el mismo horario
3. Un recordatorio se genera automaticamente 24h antes del evento
4. Solo el paciente o su cuidador asignado pueden reprogramar un evento

Razon / Consecuencia:

1. Sin estos datos el evento no puede programarse ni generar recordatorios
2. Evita conflictos de agenda y confusion en la coordinacion del cuidado
3. Garantiza que paciente y cuidador esten preparados con anticipacion
4. Protege la integridad de la agenda contra modificaciones no autorizadas



###### Ubiquitous Language Capture

Terminos:

1. Evento de Salud:	Cita medica, toma de medicamento o actividad de cuidado programada para un paciente
2. Calendario de Eventos:	Vista consolidada de todos los eventos de salud de un paciente en un periodo de tiempo
3. Conflicto de Horario:	Situacion en la que dos eventos del mismo paciente se superponen en el tiempo
4. Recordatorio:	Aviso automatico generado antes del evento para alertar a los actores involucrados
5. Reprogramacion:	Accion de cambiar la fecha u hora de un evento ya registrado



###### Capability Analysis

Capacidad:

1. Registrar evento de salud	Permite crear un nuevo evento con tipo, fecha, hora y descripcion
2. Detectar conflictos de horario	Valida que no existan superposiciones en la agenda del paciente
3. Programar recordatorios	Genera avisos automaticos previos al evento
4. Reprogramar evento	Permite modificar fecha/hora de un evento existente
5. Consultar calendario	Vista de todos los eventos del paciente en un rango de fechas

Valor al Negocio:

1. Alto — core de la propuesta de valor
2. Alto — evita errores de coordinacion
3. Alto — reduce incumplimiento de citas
4. Medio — flexibilidad operativa
5. Medio — visibilidad para cuidadores


###### Capability Layering

Capa-Capacidad:

1. Core: Registrar evento de salud, Detectar conflictos de horario, Programar recordatorios    
2. Supporting: Reprogramar evento, Consultar calendario de eventos, Actualizar estado del evento
3. Generic: Validacion de fechas y horas, Formato de calendario

###### Dependencies Capture

|Tipo|	Contexto	|Dato / Mensaje Intercambiado	|Patron de Integracion|
|----------|------|--------|---------|
|Upstream|	IAM|	Token de sesion activa del usuario|	Open Host Service|
|Downstream|	Notificaciones	|Evento programado / Recordatorio generado|	Published Language / Evento de dominio|


###### Design Critique

1. Fortalezas: Responsabilidad unica y bien delimitada. Flujo claro de registro → programacion → recordatorio. Alta cohesion interna.

2. Riesgos / Debilidades: Acoplamiento temporal con Notificaciones si el envio de recordatorios se hace sincrono. Posible sobrecarga si el volumen de eventos crece mucho.

3. Recomendaciones: Usar mensajeria asincrona (eventos de dominio) para desacoplar de Notificaciones. Considerar paginacion en la consulta del calendario.


#### Bounded Context Canvas 2:

##### BC-02 — Notificaciones


###### Context Overview Definition

Campos:

1. Proposito:	Detectar eventos pendientes, enviar alertas oportunas a los actores del sistema y gestionar el ciclo de confirmacion o escalamiento.
2. Problema:	Los cuidadores y pacientes necesitan ser alertados en el momento correcto. La falta de notificacion causa incumplimiento de citas y riesgos en el cuidado.
3. Usuarios: Paciente (recibe confirmaciones), Cuidador (recibe alertas y responde confirmaciones)
4. Alcance:	Incluye: deteccion de eventos pendientes, envio de notificaciones, gestion de respuestas. Excluye: programacion de eventos (Agenda BC), autenticacion (IAM).


###### Business Rules Distillation

Regla de Negocio:

1. Toda notificacion debe enviarse al menos 24h antes del evento programado
2. Si el cuidador no confirma en 12h, se genera una alerta de escalamiento
3. Una notificacion solo puede enviarse a usuarios autenticados y activos
4. Cada notificacion debe registrar su estado: enviada, confirmada o sin respuesta

Razon / Consecuencia:

1. Permite al cuidador reorganizarse con tiempo suficiente
2. Garantiza que ningun evento quede sin atencion
3. Evita envios a cuentas inactivas o no autorizadas
4. Permite auditoria y seguimiento del ciclo de atencion



###### Ubiquitous Language Capture

Terminos:

1. Notificacion:	Mensaje automatico enviado a un actor sobre un evento pendiente o cambio de estado
2. Confirmacion:	Respuesta del cuidador o paciente que valida su asistencia o conocimiento del evento
3. Alerta de Escalamiento:	Notificacion secundaria enviada cuando no hay confirmacion en el tiempo esperado
4. Estado de Notificacion:	Ciclo de vida de una notificacion: enviada → confirmada / sin respuesta
5. Evento Pendiente:	Evento de salud proximos sin confirmacion de asistencia



###### Capability Analysis

Capacidad:

1. Enviar notificacion: Genera y entrega alertas a pacientes y cuidadores
2. Gestionar confirmaciones: Procesa respuestas de confirmacion o rechazo
3. Escalar notificacion: Reenvio automatico si no hay respuesta en el tiempo limite
4. Consultar lista de notificaciones: Vista del historial de notificaciones enviadas y su estado



Valor al Negocio:

1. Alto — nucleo del contexto
2. Alto — cierra el loop de la Agenda
3. Alto — garantiza atencion del evento
4. Medio — transparencia para el usuario

###### Capability Layering

Capa-Capacidad:

1. Core: Enviar notificacion, Gestionar confirmaciones, Escalar notificacion sin respuesta    
2. Supporting: Consultar lista de notificaciones, Registrar estado de notificacion
3. Generic: Plantillas de mensajes, Formato y canal de envio

###### Dependencies Capture

|Tipo|	Contexto	|Dato / Mensaje Intercambiado	|Patron de Integracion|
|----------|------|--------|---------|
|Upstream|	Agenda|	Evento programado / Recordatorio pendiente|	OEvent-Driven / Suscriptor|
|Upstream|	IAM|	Identidad y canal de contacto del usuario|	Open Host Service|
|Downstream|	Agenda	|Confirmación / Rechazo del evento|	Published Language|


###### Design Critique

1. Fortalezas: Contexto bien acotado con responsabilidad clara. Desacoplado de la logica de negocio de Agenda. Escalable de forma independiente.

2. Riesgos / Debilidades: Dependencia del canal de envio (email, push, SMS) puede convertirse en un cuello de botella. Logica de escalamiento puede complejizarse con muchos tipos de eventos.

3. Recomendaciones: Abstraer el canal de envio como un puerto (adapter pattern). Definir politicas de escalamiento configurables por tipo de evento.

#### Bounded Context Canvas 3:

##### BC-03 — Diario 


###### Context Overview Definition

Campos:

1. Proposito:	Permitir al paciente registrar notas personales sobre su estado de salud y compartirlas de forma controlada con cuidadores autorizados.
2. Problema:	No existe un canal estructurado para que el paciente comunique su estado diario. Los cuidadores carecen de visibilidad continua entre eventos de salud formales.
3. Usuarios: Paciente (escribe y administra notas), Cuidador (lee notas compartidas con permiso)
4. Alcance:	Incluye: escritura, almacenamiento y comparticion de notas. Excluye: control de acceso entre actores (Compartir-Perfiles BC), autenticacion (IAM).


###### Business Rules Distillation

Regla de Negocio:

1. Una nota no puede guardarse si esta vacia o solo contiene espacios en blanco
2. Solo el paciente propietario puede escribir y eliminar sus notas
3. El cuidador solo puede leer notas si el paciente compartio el diario explicitamente
4. Cada nota debe registrar fecha y hora de creacion automaticamente


Razon / Consecuencia:

1. Evita entradas sin valor informativo en el diario
2. Protege la privacidad e integridad del diario personal
3. Garantiza el consentimiento del paciente sobre su informacion de salud
4. Permite seguimiento cronologico del estado del paciente

###### Ubiquitous Language Capture

Terminos:

1. Nota de Salud:	Registro textual del paciente sobre su estado fisico o emocional en un momento dado
2. Diario:	Coleccion ordenada cronologicamente de notas de salud de un paciente
3. Diario Compartido:	Diario cuyo acceso de lectura ha sido habilitado para un cuidador especifico
4. Nota Almacenada:	Nota que ha sido persistida exitosamente en el sistema
5. Acceso de Lectura	Permiso otorgado a un cuidador para visualizar el contenido del diario



###### Capability Analysis

Capacidad:

1. Escribir nota de salud:	Registra una nueva entrada en el diario del paciente
2. Almacenar nota:	Persiste la nota con marca de tiempo automatica
3. Compartir diario con cuidador:	Habilita el acceso de lectura para un cuidador autorizado
4. Visualizar diario compartido:	Permite al cuidador leer las notas del paciente
5. Revocar acceso al diario:	El paciente puede retirar el permiso de lectura otorgado


Valor al Negocio:

1. Alto — diferenciador del producto
2. Alto — base del seguimiento continuo
3. Alto — habilita el monitoreo
4. Alto — visibilidad del estado del paciente
5. Medio — control de privacidad

###### Capability Layering

Capa-Capacidad:

1. Core: Escribir nota de salud, Almacenar nota, Compartir diario con cuidador    
2. Supporting: Visualizar diario compartido, Revocar acceso, Consultar historial de notas
3. Generic: Almacenamiento de texto, Marca de tiempo automatica

###### Dependencies Capture

|Tipo|	Contexto	|Dato / Mensaje Intercambiado	|Patron de Integracion|
|----------|------|--------|---------|
|Upstream|	IAM|	Token de sesion del paciente o cuidador|	Open Host Service|
|Upstream|	Compartir-Perfiles|	Validacion de acceso del cuidador al diario|	Anticorruption Layer|
|Downstream|	Compartir-Perfiles	|Solicitud de compartir diario (evento)|	Published Language|


###### Design Critique

1. Fortalezas: Diferenciador clave del producto. Alta cohesion. Separa correctamente la escritura del control de acceso (Compartir-Perfiles).

2. Riesgos / Debilidades: Sin paginacion puede volverse lento con diarios extensos. El consentimiento de compartir podria volverse complejo si se necesitan permisos granulares por nota.

3. Recomendaciones: Implementar paginacion desde el inicio. Considerar cifrado en reposo para notas sensibles. Registrar audit log de accesos al diario.

#### Bounded Context Canvas 4:

##### BC-04 — Documentos Medicos 


###### Context Overview Definition

Campos:

1. Proposito:	Gestionar la subida, almacenamiento seguro y consulta de documentos medicos clinicos del paciente.
2. Problema:	Los documentos medicos estan dispersos y no accesibles para los actores del sistema. Los cuidadores necesitan consultar historial clinico para tomar decisiones de cuidado.
3. Usuarios: Paciente/Familiar (sube documentos), Cuidador (consulta documentos autorizados)
4. Alcance:	Incluye: subida, almacenamiento, visualizacion y metadatos de documentos. Excluye: control de acceso entre actores (Compartir-Perfiles), autenticacion (IAM).


###### Business Rules Distillation

Regla de Negocio:

1.  Solo se aceptan documentos en formato PDF o imagen (JPG, PNG)
2. El tamano maximo por documento es de 10 MB
3. Cada documento debe tener un tipo y fecha asociados al cargarlo
4. Un cuidador solo puede consultar documentos si tiene acceso autorizado al perfil del paciente



Razon / Consecuencia:

1. Garantiza compatibilidad de visualizacion en todos los dispositivos
2. Evita sobrecarga del almacenamiento y tiempos de carga excesivos
3. Permite organizacion y busqueda eficiente del historial clinico
4. Protege la privacidad del historial medico


###### Ubiquitous Language Capture

Terminos:

1.  Documento Medico	Archivo digital (PDF o imagen) que representa un resultado clinico, receta o informe de salud del paciente
2. Tipo de Documento	Clasificacion del documento: resultado de laboratorio, receta, informe medico, radiografia, etc.
3. Documento Almacenado	Documento que ha sido cargado y persistido exitosamente en el sistema
4. Información del Documento	Metadatos del archivo: nombre, tipo, fecha de carga, tamano y propietario
5. Documento Visualizado	Documento que ha sido abierto y consultado por un actor autorizado



###### Capability Analysis

Capacidad:

1. Subir documento medico	Permite cargar archivos clinicos al sistema con sus metadatos
2. Almacenar documento	Persiste el archivo de forma segura con metadatos
3. Consultar documento medico	Permite visualizar documentos clinicos a actores autorizados
4. Listar documentos del paciente	Muestra el inventario de documentos disponibles


Valor al Negocio:

1. Alto — centraliza el historial clinico
2. Alto — base del repositorio clinico
3. Alto — soporte a decisiones de cuidado
4. Medio — navegacion del historial


###### Capability Layering

Capa-Capacidad:

1. Core: Subir documento medico, Almacenar documento, Consultar documento medico  
2. Supporting: Listar documentos, Buscar por tipo o fecha, Eliminar documento
3. Generic: Almacenamiento de archivos, Validacion de formato y tamano

###### Dependencies Capture

|Tipo|	Contexto	|Dato / Mensaje Intercambiado	|Patron de Integracion|
|----------|------|--------|---------|
|Upstream|	IAM|	Token de sesion del usuario|	Open Host Service|
|Upstream|	Compartir-Perfiles|	Validacion de acceso del cuidador|	Anticorruption Layer|


###### Design Critique

1. Fortalezas: Responsabilidad clara y bien acotada. Puede evolucionar de forma independiente al core. Candidato a integracion con servicios de almacenamiento en la nube.

2. Riesgos / Debilidades: Puede convertirse en un cuello de botella si el almacenamiento no escala. La validacion de acceso duplica logica con Compartir-Perfiles.

3. Recomendaciones: Externalizar el almacenamiento a un servicio cloud (S3, GCS). Delegar toda validacion de acceso a Compartir-Perfiles mediante llamadas explicitas.

#### Bounded Context Canvas 5:

##### BC-05 — Compartir-Perfiles 


###### Context Overview Definition

Campos:

1. Proposito:	Gestionar el acceso controlado y con consentimiento del paciente a su informacion de salud por parte de familiares o cuidadores autorizados.
2. Problema:	No existe un mecanismo seguro para que el paciente autorice a terceros (familiares) a consultar su informacion de salud sin perder el control sobre ella.
3. Usuarios: Paciente (otorga y revoca acceso), Familiar (consume informacion del paciente con permiso)
4. Alcance:	Incluye: generacion de enlaces de acceso, validacion de permisos, revocacion. Excluye: almacenamiento de documentos o notas (sus propios contextos).


###### Business Rules Distillation

Regla de Negocio:

1. Solo el paciente puede iniciar el proceso de compartir su perfil
2. Un enlace de acceso expira a los 7 dias de generado si no es utilizado
3. El paciente puede revocar el acceso en cualquier momento
4. El familiar solo puede leer informacion — no puede modificarla ni eliminarla




Razon / Consecuencia:

1. El consentimiento del titular es obligatorio para compartir informacion de salud
2. Evita accesos persistentes no controlados a informacion sensible
3. Garantiza el derecho del paciente a controlar su informacion
4. El familiar es un observador autorizado, no un administrador del perfil



###### Ubiquitous Language Capture

Terminos:

1.  Perfil Compartido: Conjunto de informacion del paciente que ha sido habilitada para acceso de un tercero autorizado
2. Enlace de Acceso:	URL temporal y unica generada para que un familiar acceda al perfil del paciente
3. Acceso Concedido:	Estado en el que un familiar cuenta con permisos activos para consultar la informacion del paciente
4. Acceso Revocado:	Estado en el que el paciente ha retirado los permisos previamente otorgados a un familiar
5. Enlace Expirado:	Enlace de acceso que ha superado su tiempo de validez sin ser utilizado



###### Capability Analysis

Capacidad:

1. Compartir perfil con familiar:	Genera enlace de acceso temporal para el familiar
2. Validar acceso del familiar:	Verifica que el enlace sea valido y no haya expirado
3. Otorgar acceso al familiar:	Activa los permisos de lectura para el familiar
4. Revocar acceso:	El paciente retira los permisos de acceso en cualquier momento
5. Consultar informacion del paciente:	El familiar visualiza datos autorizados del perfil



Valor al Negocio:

1. Alto — habilita la colaboracion familiar
2. Alto — seguridad del acceso
3. Alto — core del contexto
4. Alto — control de privacidad
5. Medio — visibilidad familiar



###### Capability Layering

Capa-Capacidad:

1. Core: Compartir perfil, Validar acceso, Otorgar acceso al familiar, Revocar acceso
2. Supporting: Consultar informacion del paciente, Listar accesos activos
3. Generic: Generacion de tokens/enlaces, Validacion de expiracion

###### Dependencies Capture

|Tipo|	Contexto	|Dato / Mensaje Intercambiado	|Patron de Integracion|
|----------|------|--------|---------|
|Upstream|	IAM|	Identidad del paciente autenticado|	Open Host Service|
|Downstream|	Diario |	Solicitud de acceso de lectura al diario|	Anticorruption Layer|
|Downstream|	Documentos|	Solicitud de acceso a documentos del paciente|	Anticorruption Layer|


###### Design Critique

1. Fortalezas: Centraliza toda la logica de consentimiento y acceso. Evita que Diario y Documentos implementen su propio control de acceso. Cumple con principios de privacidad.

2. Riesgos / Debilidades: Se convierte en un punto crítico de falla: si cae, ningún familiar puede acceder. Los enlaces expirados pueden generar fricción en la experiencia del familiar.

3. Recomendaciones: Implementar cache de permisos activos para reducir latencia. Proveer mecanismo de renovacion de enlace sin necesidad de re-invitacion completa.


#### Bounded Context Canvas 6:

##### BC-06 — IAM  


###### Context Overview Definition

Campos:

1. Proposito:	Gestionar el registro de usuarios, autenticacion y administracion de sesiones para todos los actores del sistema.
2. Problema:	Todos los contextos del sistema requieren verificar la identidad del usuario antes de ejecutar cualquier operacion. Sin IAM no existe seguridad en el sistema.
3. Usuarios: Paciente (se registra e inicia sesion), Familiar (se registra e inicia sesion)
4. Alcance:	Incluye: registro de cuenta, login, logout, gestion de sesion. Excluye: autorizacion a recursos especificos (Compartir-Perfiles BC), logica de negocio.


###### Business Rules Distillation

Regla de Negocio:

1. El email debe ser unico en el sistema — no pueden existir dos cuentas con el mismo correo
2. La contrasena debe tener minimo 8 caracteres con al menos un numero y una mayuscula
3. Una sesion expira tras 30 minutos de inactividad
4. Tras 5 intentos fallidos de login, la cuenta se bloquea temporalmente por 15 minutos




Razon / Consecuencia:

1. Evita ambiguedad en la identificacion del usuario
2. Garantiza un nivel minimo de seguridad en las credenciales
3. Reduce el riesgo de acceso no autorizado en dispositivos compartidos
4. Protege contra ataques de fuerza bruta


###### Ubiquitous Language Capture

Terminos:

1.  Usuario:	Persona registrada en el sistema con credenciales validas (Paciente o Familiar)
2. Credenciales:	Combinacion de email y contrasena que identifica a un usuario
3. Sesion:	Periodo de tiempo activo desde el login hasta el logout o expiracion
4. Token de Sesion:	Identificador seguro generado al autenticar que autoriza operaciones en el sistema
5. Inicio de Sesion Fallido: Intento de autenticacion con credenciales incorrectas



###### Capability Analysis

Capacidad:

1. Registrar cuenta:	Crea un nuevo usuario en el sistema con email y contrasena
2. Iniciar sesion:	Autentica al usuario y genera token de sesion
3. Cerrar sesion:	Invalida el token de sesion activo
4. Validar sesion activa:	Verifica que el token sea valido y no haya expirado




Valor al Negocio:

1. Alto — prerequisito de todo el sistema
2. Alto — habilita todos los contextos
3. Alto — seguridad basica
4. Alto — usado por todos los contextos




###### Capability Layering

Capa-Capacidad:

1. Core: Registrar cuenta, Iniciar sesion, Cerrar sesion, Validar sesion activa
2. Supporting: Bloqueo por intentos fallidos, Gestion de expiracion de sesion
3. Generic: Hashing de contrasenas, Generacion de tokens JWT, Validacion de email

###### Dependencies Capture

|Tipo|	Contexto	|Dato / Mensaje Intercambiado	|Patron de Integracion|
|----------|------|--------|---------|
|Downstream|	Todos los contextos|	SToken de sesion activa del usuario|	Open Host Service / Published Language|


###### Design Critique

1. Fortalezas: Responsabilidad generica y bien definida. Candidato ideal para ser reemplazado por un servicio externo (Auth0, Keycloak, AWS Cognito) sin impacto en el dominio.

2. Riesgos / Debilidades: Al ser prerequisito de todos los contextos, su caida paraliza todo el sistema. Logica de seguridad hecha a medida puede tener vulnerabilidades.

3. Recomendaciones: Priorizar migracion a un proveedor de identidad consolidado (Auth0 o similar). Implementar refresh tokens para mejorar la experiencia sin comprometer seguridad.



### 2.5.2. Context Mapping <a id="252-context-mapping"></a>

En esta sección se documenta el proceso seguido por el equipo para producir el Context Map de CareConnect, entendido como la visualización de las relaciones estructurales entre los bounded contexts identificados durante el EventStorming (§2.5.1). El punto de partida fueron los seis candidate contexts derivados de las épicas del producto —Autenticación, Acceso Compartido, Agenda, Notificaciones, Diario de Seguimiento y Documentos—, los dos actores definidos en el Context Level Diagram (paciente geriátrico y cuidador) y los sistemas externos con los que el producto necesita integrarse (Google Sign-In, Firebase Cloud Messaging y SendGrid).

La elaboración no se resolvió en una única iteración: el equipo construyó varias alternativas, las comparó a partir de preguntas de diseño deliberadas y seleccionó la que mejor equilibraba cohesión, acoplamiento y capacidad de evolución. A continuación se describen las alternativas consideradas y, a partir de ellas, el Context Map final adoptado con los patrones de relación entre bounded contexts propios de Domain-Driven Design.

---

#### Alternativas de Context Mapping evaluadas

Cada alternativa responde a una de las preguntas de diseño recomendadas para este tipo de ejercicio. Se conservan aquí las discusiones para que la decisión final sea trazable.

**Alternativa 1 — ¿Qué pasaría si fusionamos Diario de Seguimiento y Documentos en un solo bounded context?**
Ambos contextos manejan información generada en torno al paciente. Sin embargo, Diario se ocupa de notas cualitativas con alta frecuencia de escritura y consulta conversacional, mientras que Documentos gestiona archivos clínicos (recetas, resultados de laboratorio) con ciclo de vida más lento y control de acceso explícito. Fusionarlos diluiría dos Ubiquitous Languages distintos ("entrada de diario" vs. "documento médico"), mezclaría reglas de invariantes y dificultaría escalar cada módulo en forma independiente. **Se descarta.**

**Alternativa 2 — ¿Qué pasaría si duplicamos la lógica de notificaciones dentro de Agenda, Acceso Compartido y Documentos para romper la dependencia con Notificaciones?**
Cada bounded context quedaría responsable de generar sus propios recordatorios, eliminando la dependencia transversal. El problema es doble: se duplicarían las integraciones con Firebase Cloud Messaging y SendGrid (con su Anti-Corruption Layer correspondiente) y se perdería la política común de reintentos y preferencias de notificación que cada usuario configura una sola vez. **Se descarta.** Conviene mantener Notificaciones como bounded context dedicado que recibe eventos de dominio desde los demás.

**Alternativa 3 — ¿Qué pasaría si creamos un shared service de control de acceso para reducir la duplicación entre Documentos, Agenda y Diario?**
Hoy, cada uno de estos contextos necesita saber qué cuidadores están autorizados a leer información del paciente. La alternativa de incorporar la lógica de permisos en cada bounded context produciría inconsistencias cuando el paciente revoque accesos. En su lugar, Acceso Compartido se consolida como fuente de verdad y publica eventos de dominio (`AccessGrantedEvent`, `AccessRevokedEvent`) que los demás contextos consumen para mantener su propia proyección de permisos. **Se adopta.**

**Alternativa 4 — ¿Qué pasaría si Autenticación y Acceso Compartido fueran el mismo bounded context?**
Ambos participan en la identidad del usuario, pero resuelven preocupaciones distintas: Autenticación responde "¿quién es este usuario?" mientras que Acceso Compartido responde "¿qué puede ver este usuario del paciente?". Unirlos rompe el principio de responsabilidad única y mezcla la gestión de sesiones con las reglas de negocio del acceso compartido. **Se descarta.**

**Alternativa 5 — ¿Qué pasaría si aislamos los core capabilities (Agenda, Diario, Documentos) y movemos el resto a subdomains de soporte y genéricos?**
Los tres contextos que encapsulan la experiencia clínica del paciente son los que concentran la ventaja competitiva del producto y son tratados como **Core Subdomains**. Notificaciones y Acceso Compartido son **Supporting Subdomains** porque habilitan al core pero no lo constituyen. Autenticación se clasifica como **Generic Subdomain** porque su responsabilidad es comparable a la de cualquier otro sistema y apoya un proveedor externo. **Se adopta.**

**Alternativa 6 — ¿Qué pasaría si tratamos Firebase Cloud Messaging, SendGrid y Google Sign-In como extensiones del sistema en vez de integraciones externas?**
Esto implicaría que nuestros bounded contexts conformaran su modelo al de esos proveedores (relación Conformist), lo que nos dejaría atados a cambios de contrato ajenos. **Se descarta.** Se opta por interponer una **Anti-Corruption Layer** en Notificaciones y en Autenticación para traducir los modelos externos al lenguaje propio del dominio.

---

#### Context Map seleccionado

A partir de las alternativas evaluadas, el Context Map final consolida los seis bounded contexts del producto más los tres sistemas externos, organizados en tres capas visuales: el eje de identidad arriba (Autenticación y Acceso Compartido), los core subdomains clínicos en el medio (Agenda, Diario de Seguimiento y Documentos) y el subdomain de soporte para notificaciones en la parte inferior, flanqueado por los sistemas externos a los que se conecta.

![Figura 10. Context Map estratégico de CareConnect](assets/context_map.png)

*Figura 10. Context Map estratégico de CareConnect, con los patrones de relación entre bounded contexts y sistemas externos.*

---

#### Patrones DDD aplicados en las relaciones

Las flechas del diagrama se anotan con los patrones de Strategic Design que corresponden a cada relación. A continuación se explican y se justifican en el contexto del producto.

| Relación | Patrón | Justificación |
|---|---|---|
| Autenticación → Acceso Compartido | **Customer/Supplier (U/S) + Open Host Service (OHS)** | Autenticación es upstream porque provee la identidad sobre la que Acceso Compartido opera. Expone un contrato público estable (OHS) para que el downstream no dependa de detalles internos. |
| Autenticación → Agenda / Diario / Documentos | **Customer/Supplier (U/S)** | Cada core context consulta la identidad autenticada para autorizar operaciones sobre el paciente. |
| Autenticación → Identity Provider (Google) | **Anti-Corruption Layer (ACL)** | La ACL traduce los tokens y atributos de Google Sign-In al modelo de usuario propio del dominio, evitando que un cambio en el proveedor externo contamine el resto del sistema. |
| Acceso Compartido → Agenda / Diario / Documentos | **Customer/Supplier (U/S) + events** | Acceso Compartido publica `AccessGrantedEvent` y `AccessRevokedEvent` como Published Language; los core contexts se suscriben para mantener sus proyecciones de permisos actualizadas. |
| Agenda → Notificaciones | **Customer/Supplier (U/S) + Published Language (PL)** | Agenda publica eventos de dominio (`MedicationScheduled`, `AppointmentCreated`) con un contrato estable que Notificaciones consume para programar recordatorios. |
| Documentos → Notificaciones | **Customer/Supplier (U/S) + Published Language (PL)** | Documentos emite eventos cuando un archivo clínico se sube o se vuelve accesible; Notificaciones transforma esos eventos en alertas dirigidas al cuidador. |
| Diario → Notificaciones | **Conformist (C)** | Diario se apoya de forma ocasional en Notificaciones para enviar recordatorios de registro; adopta el contrato tal como existe sin negociar cambios, por lo que se clasifica como Conformist. |
| Acceso Compartido → Notificaciones | **Customer/Supplier (U/S) + events** | Las invitaciones y revocaciones de acceso disparan notificaciones hacia el familiar autorizado. |
| Notificaciones → Firebase Cloud Messaging | **Anti-Corruption Layer (ACL)** | Aísla el contrato de FCM; si Google cambia su SDK o modelo de payload, el cambio queda contenido en el adaptador. |
| Notificaciones → SendGrid | **Anti-Corruption Layer (ACL)** | Mismo razonamiento para el envío de correos transaccionales: se traduce el modelo interno de "notificación" al formato esperado por SendGrid. |

**Nota sobre Shared Kernel:** Se evaluó introducir un Shared Kernel para tipos primitivos compartidos (identificadores de usuario, paciente y cuidador). Se descartó su uso formal porque acopla los ciclos de liberación de múltiples bounded contexts; en su lugar, cada contexto mantiene su propio value object equivalente y la conversión se realiza en los bordes mediante Published Language, preservando la independencia entre módulos.

---

#### Conclusión del proceso

El Context Map adoptado mantiene los tres core subdomains aislados entre sí, reservando el acoplamiento necesario hacia Autenticación (identidad) y Acceso Compartido (permisos) a través de eventos de dominio. Notificaciones se comporta como infraestructura de salida común, consumiendo eventos del resto y exponiendo únicamente adaptadores hacia los servicios externos. Esta configuración permite evolucionar cada bounded context de forma independiente, reemplazar proveedores externos sin contaminar el dominio y escalar selectivamente los módulos donde se concentre más tráfico, sin sacrificar la consistencia conceptual del producto.

### 2.5.3. Software Architecture <a id="253-software-architecture"></a>

En esta sección se presenta la representación de la arquitectura de software para la solución CareConnect, aplicando el C4 Model y utilizando Structurizr como herramienta de elaboración. La arquitectura abarca todos los productos digitales que forman parte del alcance: el Landing Page, los Web Services (RESTful API), y la Mobile Application nativa y multiplataforma. Los diagramas presentados a continuación permiten visualizar la solución desde distintos niveles de abstracción, partiendo del contexto general del sistema, pasando por la descomposición en containers y en sus seis bounded contexts, hasta la distribución física del despliegue.

La solución está organizada alrededor de seis bounded contexts identificados durante el diseño estratégico, uno por cada épica del producto:

| Bounded Context | Épica | Responsabilidad principal |
|-----------------|-------|---------------------------|
| Agenda | EP01 Gestión de Agenda | Gestión de eventos de salud, citas y medicación en el calendario. |
| Notificaciones | EP02 Gestión de Notificaciones | Programación, envío y visualización de recordatorios y alertas. |
| Documentos | EP03 Gestión de Documentos | Almacenamiento, consulta y control de acceso a documentos médicos. |
| Acceso Compartido | EP04 Acceso Compartido | Compartir y revocar el perfil del paciente con los cuidadores. |
| Diario de Seguimiento | EP05 Diario de Seguimiento | Registro y consulta de notas sobre la evolución del paciente. |
| Autenticación | EP06 Autenticación | Gestión de cuentas, sesiones y control de acceso por rol. |

#### 2.5.3.1. Software Architecture Context Level Diagrams <a id="2531-software-architecture-context-level-diagrams"></a>

El Context Diagram muestra el sistema CareConnect como una caja central, rodeado por los actores que interactúan con él y los sistemas externos de los cuales depende. Este diagrama permite entender el alcance del sistema y sus principales relaciones a alto nivel.

Los actores identificados corresponden exactamente a los dos segmentos objetivo de la solución:

- **Geriatric Patient (Paciente geriátrico):** Usuario que utiliza la aplicación para recibir recordatorios de medicación y citas, confirmar sus eventos de salud, registrar notas en su diario y compartir su perfil con cuidadores. Interactúa con el sistema a través de la Mobile Application.
- **Caregiver (Cuidador):** Usuario que supervisa al paciente, gestiona la medicación, terapias y registros clínicos, recibe alertas de incumplimiento y consulta el perfil compartido del paciente. Interactúa con el sistema a través de la Mobile Application.

Los sistemas externos identificados son:

- **Email Service (e.g., SendGrid):** Utilizado para el envío de correos de verificación, recuperación de contraseña y notificaciones por email.
- **Push Notification Service (e.g., Firebase Cloud Messaging):** Servicio externo para el envío de notificaciones push a los dispositivos móviles de pacientes y cuidadores.
- **Identity Provider:** Servicio de autenticación externo que permite el inicio de sesión mediante proveedores como Google Sign-In.

![Figura 1. Software Architecture Context Level Diagram para CareConnect](assets/context-diagram.png)

*Figura 1. Software Architecture Context Level Diagram para CareConnect.*

#### 2.5.3.2. Software Architecture Container Level Diagrams <a id="2532-software-architecture-container-level-diagrams"></a>

El Container Diagram descompone el sistema CareConnect en sus elementos de alto nivel, mostrando cómo se distribuyen las responsabilidades entre los distintos containers y las principales decisiones de tecnología adoptadas. El diagrama se organiza en cinco filas horizontales, de arriba hacia abajo: los dos segmentos objetivo, la capa de clientes (Mobile App y Landing Page), el API Gateway con sus seis bounded contexts dispuestos en una cuadrícula, la capa de persistencia y los sistemas externos. Esta disposición evita el cruce de flechas y deja visible la descomposición estratégica.

Los containers identificados son:

- **Landing Page:** Sitio web desarrollado con React. Presenta el modelo de negocio, las características del producto y los enlaces de descarga.
- **Mobile Application:** Aplicación nativa desarrollada con Kotlin para Android y estrategia cross-platform con Flutter/Dart o Kotlin Multiplatform (KMP). Constituye la interfaz principal mediante la cual el paciente geriátrico y el cuidador interactúan con el sistema. Se comunica con el API Gateway a través de HTTPS/JSON.
- **API Gateway (RESTful Web Services):** Backend desarrollado con Spring Boot (Java) siguiendo el estilo arquitectónico RESTful API y documentado con OpenAPI/Swagger. Se organiza internamente en seis módulos, uno por cada bounded context:
  - **Autenticación Service:** Endpoints para registro, login y validación de acceso por rol.
  - **Acceso Compartido Service:** Endpoints para compartir, consultar y revocar el perfil del paciente.
  - **Agenda Service:** Endpoints para la gestión de eventos de salud (citas, medicación, terapias).
  - **Notificaciones Service:** Endpoints para la programación, consulta y marcado de notificaciones y alertas.
  - **Documentos Service:** Endpoints para la carga, consulta y control de acceso a documentos médicos.
  - **Diario Service:** Endpoints para registrar y consultar notas de seguimiento.
- **Database:** Base de datos relacional (PostgreSQL) que persiste la información de los seis bounded contexts.
- **Local Storage (SQLite / Room):** Almacenamiento local en el dispositivo móvil que permite el acceso offline a información crítica del paciente, medicación pendiente y registros recientes.

Las relaciones principales entre containers son:

| Origen | Destino | Descripción | Protocolo |
|--------|---------|-------------|-----------|
| Mobile Application | API Gateway | Consume endpoints RESTful de los seis bounded contexts | HTTPS / JSON |
| Mobile Application | Local Storage | Almacena y consulta datos para acceso offline | SQLite / Room |
| Mobile Application | Push Notification Service | Recibe notificaciones push | FCM |
| API Gateway | Database | Persiste y consulta datos del dominio | JDBC / JPA |
| Notificaciones Service | Email Service / Push Notification Service | Envía emails y notificaciones push | HTTPS / SMTP |
| Autenticación Service | Email Service / Identity Provider | Envía emails transaccionales y verifica autenticación federada | HTTPS / OAuth 2.0 |

![Figura 2. Software Architecture Container Level Diagram para CareConnect](assets/container-diagram.png)

*Figura 2. Software Architecture Container Level Diagram para CareConnect, con el API Gateway descompuesto en sus seis bounded contexts y organizado en capas horizontales para evitar cruces.*

#### 2.5.3.3. Software Architecture Deployment Diagrams <a id="2533-software-architecture-deployment-diagrams"></a>

El Deployment Diagram muestra la distribución física del sistema CareConnect, destacando cómo los componentes de software se despliegan sobre la infraestructura de hardware y los entornos de ejecución. Este diagrama permite visualizar los nodos físicos y virtuales, las relaciones de red entre ellos y la asignación de containers a cada nodo. El API Gateway empaqueta en un mismo despliegue los seis bounded contexts (Agenda, Notificaciones, Documentos, Acceso Compartido, Diario y Autenticación), que comparten el mismo motor de persistencia relacional.

Los nodos de despliegue identificados son:

- **User's Mobile Device (Android):** Utilizado tanto por el paciente geriátrico como por el cuidador.
  - Ejecuta la **Mobile Application** (APK distribuido vía Firebase App Distribution).
  - Contiene el **Local Storage** (SQLite/Room) para persistencia offline.
  - Se comunica con el backend a través de HTTPS sobre internet.

- **User's Web Browser:**
  - Renderiza el **Landing Page** estático, servido desde un proveedor de hosting.

- **Cloud Hosting Provider (e.g., Railway / Render / AWS):**
  - **Web Server Node:** Aloja el **API Gateway / RESTful Web Services** (Spring Boot). Recibe peticiones HTTPS desde la Mobile Application y ejecuta la lógica de negocio.
  - **Database Server Node:** Aloja la **Database** relacional (e.g., PostgreSQL / MySQL). Accedida únicamente desde el Web Server Node a través de la red interna del proveedor.

- **Static Hosting Provider (e.g., GitHub Pages / Netlify / Vercel):**
  - Sirve los archivos estáticos del **Landing Page** (HTML, CSS, JS) a los navegadores web de los visitantes.

- **Firebase (Google Cloud):**
  - **Firebase Cloud Messaging:** Servicio de notificaciones push que envía alertas a los dispositivos móviles.
  - **Firebase App Distribution:** Servicio para la distribución y prueba de la aplicación móvil en dispositivos antes del lanzamiento.

- **External Email Service (e.g., SendGrid):**
  - Procesa y envía correos electrónicos disparados desde el backend.

Las conexiones de red principales son:

| Origen | Destino | Protocolo | Descripción |
|--------|---------|-----------|-------------|
| Mobile Device | Cloud Web Server | HTTPS | Consumo de RESTful API |
| Mobile Device | Firebase Cloud Messaging | HTTPS | Recepción de notificaciones push |
| Web Browser | Static Hosting | HTTPS | Carga del Landing Page |
| Cloud Web Server | Database Server | TCP/JDBC | Persistencia de datos |
| Cloud Web Server | SendGrid | HTTPS/SMTP | Envío de emails |
| Cloud Web Server | Firebase Cloud Messaging | HTTPS | Disparo de notificaciones |

![Figura 3. Software Architecture Deployment Diagram para CareConnect](assets/deployment-diagram.png)

*Figura 3. Software Architecture Deployment Diagram para CareConnect.*

## 2.6. Tactical-Level Domain-Driven Design <a id="26-tactical-level-domain-driven-design"></a>

### 2.6.1. Bounded Context: Agenda

#### 2.6.1.1. Domain Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| Agenda | Aggregate Root | Gestiona la consistencia transaccional de los eventos de salud del paciente. |
| HealthEvent | Entity | Representa un evento de salud, como una cita médica, medicación o actividad terapéutica. |
| Reminder | Entity | Representa un recordatorio asociado a un evento programado. |
| EventDateTime | Value Object | Encapsula la fecha y hora del evento. |
| EventStatus | Value Object | Representa el estado actual del evento. |
| EventType | Value Object | Define la categoría del evento de salud. |
| EventSchedulerService | Domain Service | Gestiona las reglas de programación de eventos. |
| ScheduleValidationService | Domain Service | Valida conflictos y restricciones de horario. |
| AgendaRepository | Repository | Define el contrato de persistencia del agregado Agenda. |
| EventCreatedEvent | Domain Event | Se publica cuando se crea un evento. |
| EventConfirmedEvent | Domain Event | Se publica cuando se confirma un evento. |
| EventRescheduledEvent | Domain Event | Se publica cuando se reprograma un evento. |
| EventDeletedEvent | Domain Event | Se publica cuando se elimina un evento. |

#### 2.6.1.2. Interface Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| AgendaActivity | Activity | Punto de entrada principal del módulo de agenda. |
| CalendarFragment | Fragment | Presenta los eventos de salud en formato calendario. |
| EventDetailFragment | Fragment | Muestra la información detallada de un evento seleccionado. |
| AgendaViewModel | ViewModel | Gestiona el estado de la interfaz y coordina Commands y Queries con la capa de aplicación. |

#### 2.6.1.3. Application Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| CreateEventCommand | Command | Solicita la creación de un nuevo evento de salud. |
| ConfirmEventCommand | Command | Solicita la confirmación de un evento programado. |
| RescheduleEventCommand | Command | Solicita la reprogramación de un evento existente. |
| DeleteEventCommand | Command | Solicita la eliminación de un evento. |
| CreateEventHandler | Command Handler | Procesa la creación de eventos. |
| ConfirmEventHandler | Command Handler | Procesa la confirmación de eventos. |
| RescheduleEventHandler | Command Handler | Procesa la reprogramación de eventos. |
| DeleteEventHandler | Command Handler | Procesa la eliminación de eventos. |
| GetEventsQuery | Query | Recupera todos los eventos registrados. |
| GetEventByIdQuery | Query | Recupera un evento por su identificador. |
| GetEventsByDateQuery | Query | Recupera los eventos programados para una fecha específica. |
| GetEventsHandler | Query Handler | Procesa la consulta de todos los eventos. |
| GetEventByIdHandler | Query Handler | Procesa la consulta por identificador. |
| GetEventsByDateHandler | Query Handler | Procesa la consulta por fecha. |
| EventDTO | DTO | Transfiere información de eventos entre capas. |
| ReminderDTO | DTO | Transfiere información de recordatorios. |

#### 2.6.1.4. Infrastructure Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| AgendaRepositoryImpl | Repository Implementation | Implementa la persistencia del agregado Agenda. |
| EventDao | DAO | Proporciona operaciones de acceso a datos para eventos. |
| EventEntity | Persistence Entity | Representa un evento dentro de la base de datos local. |
| WorkManagerScheduler | Scheduler | Programa recordatorios y tareas en segundo plano. |
| EventMapper | Mapper | Convierte objetos entre Domain, DTO y Persistence. |

#### 2.6.1.5. Bounded Context Software Architecture Component Level Diagrams

![Diagrama-componentes-agenda](./assets/Diagrama-componentes-Agenda.png)

#### 2.6.1.6. Bounded Context Software Architecture Code Level Diagrams
##### 2.6.1.6.1. Bounded Context Domain Layer Class Diagrams

![Diagrama-clases-agenda](./assets/Diagrama-clases-Agenda.PNG)

##### 2.6.1.6.2. Bounded Context Database Design Diagram

![Diagrama-db-agenda](./assets/Diagrama-DB-Agenda.PNG)

---

### 2.6.2. Bounded Context: Notificaciones

Este bounded context es responsable de la planificación, envío, recepción, visualización y control de acceso de las notificaciones y alertas que reciben pacientes y cuidadores dentro de la plataforma CareConnect. Cubre las historias de usuario US04 (recordatorios de eventos), US05 (alertas de incumplimiento) y US06 (visualización de notificaciones), así como las historias técnicas TS03 (programación), TS04 (envío) y TS05 (control de acceso). Se integra con Firebase Cloud Messaging (FCM) para push, con SendGrid para email y con el bounded context de Agenda a través de eventos de dominio.

#### 2.6.2.1. Domain Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| NotificationCenter | Aggregate Root | Gestiona la consistencia transaccional de las notificaciones y alertas de un destinatario. |
| Notification | Entity | Representa una notificación individual (recordatorio, alerta o informativa) dirigida a un usuario. |
| Alert | Entity | Representa una alerta de incumplimiento generada cuando un evento no es confirmado a tiempo. |
| NotificationPreference | Entity | Representa las preferencias del usuario sobre canales y tipos de notificación. |
| NotificationContent | Value Object | Encapsula el título, el mensaje y el payload asociado a la notificación. |
| NotificationType | Value Object | Define la categoría de la notificación (REMINDER, ALERT, INFO). |
| NotificationPriority | Value Object | Representa el nivel de prioridad de la notificación (LOW, MEDIUM, HIGH, CRITICAL). |
| NotificationStatus | Value Object | Representa el estado actual de la notificación (SCHEDULED, SENT, DELIVERED, READ, FAILED). |
| DeliveryChannel | Value Object | Indica el canal de entrega de la notificación (PUSH, EMAIL, IN_APP). |
| RecipientId | Value Object | Identifica de forma única al destinatario (paciente o cuidador). |
| ScheduledAt | Value Object | Encapsula la fecha y hora programada de envío. |
| NotificationDispatchService | Domain Service | Aplica las reglas de negocio para despachar una notificación al canal adecuado. |
| AlertEvaluationService | Domain Service | Evalúa si se debe generar una alerta de incumplimiento ante un evento no confirmado. |
| NotificationAccessPolicy | Domain Service | Valida que el destinatario tenga los permisos necesarios para recibir la notificación (TS05). |
| NotificationRepository | Repository | Define el contrato de persistencia del agregado NotificationCenter. |
| NotificationScheduledEvent | Domain Event | Se publica cuando se programa una nueva notificación. |
| NotificationSentEvent | Domain Event | Se publica cuando se envía una notificación al canal de entrega. |
| NotificationDeliveredEvent | Domain Event | Se publica cuando el canal confirma la entrega al dispositivo. |
| NotificationReadEvent | Domain Event | Se publica cuando el destinatario marca la notificación como leída. |
| AlertTriggeredEvent | Domain Event | Se publica cuando se genera una alerta de incumplimiento. |
| NotificationFailedEvent | Domain Event | Se publica cuando falla el envío o la entrega de la notificación. |

#### 2.6.2.2. Interface Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| NotificationCenterActivity | Activity | Punto de entrada principal del módulo de notificaciones en la aplicación móvil. |
| NotificationListFragment | Fragment | Presenta la lista de notificaciones recibidas ordenadas por fecha y prioridad (US06). |
| NotificationDetailFragment | Fragment | Muestra el contenido detallado de una notificación seleccionada. |
| AlertBannerFragment | Fragment | Presenta alertas críticas de incumplimiento de manera prominente al cuidador (US05). |
| NotificationSettingsFragment | Fragment | Permite al usuario configurar sus preferencias de notificación. |
| NotificationViewModel | ViewModel | Gestiona el estado de la lista y el detalle, coordinando Commands y Queries con la capa de aplicación. |
| AlertsViewModel | ViewModel | Gestiona el estado de las alertas activas visibles para el cuidador. |
| NotificationPreferencesViewModel | ViewModel | Gestiona el estado de las preferencias de notificación del usuario. |

#### 2.6.2.3. Application Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| ScheduleNotificationCommand | Command | Solicita la programación de una nueva notificación (TS03). |
| SendNotificationCommand | Command | Solicita el envío inmediato de una notificación (TS04). |
| CancelScheduledNotificationCommand | Command | Solicita la cancelación de una notificación previamente programada. |
| MarkNotificationAsReadCommand | Command | Solicita el marcado de una notificación como leída. |
| TriggerAlertCommand | Command | Solicita la generación de una alerta de incumplimiento (US05). |
| UpdateNotificationPreferencesCommand | Command | Solicita la actualización de las preferencias del usuario. |
| ScheduleNotificationHandler | Command Handler | Procesa la programación de notificaciones. |
| SendNotificationHandler | Command Handler | Procesa el envío de notificaciones a través del canal correspondiente. |
| CancelScheduledNotificationHandler | Command Handler | Procesa la cancelación de notificaciones programadas. |
| MarkNotificationAsReadHandler | Command Handler | Procesa el marcado de lectura. |
| TriggerAlertHandler | Command Handler | Procesa la generación de alertas, aplicando NotificationAccessPolicy. |
| UpdateNotificationPreferencesHandler | Command Handler | Procesa la actualización de preferencias. |
| GetNotificationsQuery | Query | Recupera todas las notificaciones del destinatario. |
| GetNotificationByIdQuery | Query | Recupera una notificación por su identificador. |
| GetUnreadNotificationsQuery | Query | Recupera las notificaciones no leídas del destinatario. |
| GetActiveAlertsQuery | Query | Recupera las alertas activas del cuidador. |
| GetNotificationPreferencesQuery | Query | Recupera las preferencias de notificación del usuario. |
| GetNotificationsHandler | Query Handler | Procesa la consulta de todas las notificaciones. |
| GetNotificationByIdHandler | Query Handler | Procesa la consulta por identificador. |
| GetUnreadNotificationsHandler | Query Handler | Procesa la consulta de notificaciones no leídas. |
| GetActiveAlertsHandler | Query Handler | Procesa la consulta de alertas activas. |
| GetNotificationPreferencesHandler | Query Handler | Procesa la consulta de preferencias. |
| HealthEventCreatedListener | Event Listener | Reacciona al evento EventCreatedEvent del contexto Agenda para programar recordatorios. |
| HealthEventRescheduledListener | Event Listener | Reacciona al evento EventRescheduledEvent para reprogramar notificaciones. |
| HealthEventMissedListener | Event Listener | Reacciona al vencimiento sin confirmación para disparar TriggerAlertCommand. |
| NotificationDTO | DTO | Transfiere información de notificaciones entre capas. |
| AlertDTO | DTO | Transfiere información de alertas. |
| NotificationPreferenceDTO | DTO | Transfiere información de preferencias de notificación. |

#### 2.6.2.4. Infrastructure Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| NotificationRepositoryImpl | Repository Implementation | Implementa la persistencia del agregado NotificationCenter. |
| AppDatabase | Database | Configura la base de datos local utilizando Room para persistencia offline de notificaciones. |
| NotificationDao | DAO | Proporciona operaciones de acceso a datos para las notificaciones. |
| AlertDao | DAO | Proporciona operaciones de acceso a datos para las alertas. |
| NotificationPreferenceDao | DAO | Proporciona operaciones de acceso a datos para las preferencias. |
| NotificationEntity | Persistence Entity | Representa una notificación dentro de la base de datos local. |
| AlertEntity | Persistence Entity | Representa una alerta dentro de la base de datos local. |
| NotificationPreferenceEntity | Persistence Entity | Representa las preferencias dentro de la base de datos local. |
| FCMPushNotificationAdapter | External Service Adapter | Adaptador hacia Firebase Cloud Messaging para el envío de notificaciones push (TS04). |
| SendGridEmailAdapter | External Service Adapter | Adaptador hacia SendGrid para el envío de notificaciones por correo electrónico. |
| CareConnectFirebaseMessagingService | Platform Service | Servicio Android que recibe las notificaciones push entregadas por FCM. |
| WorkManagerNotificationScheduler | Scheduler | Programa el envío diferido de notificaciones y el reintento ante fallos (TS03). |
| AlertEvaluationWorker | Background Worker | Worker periódico que dispara AlertEvaluationService sobre eventos vencidos sin confirmación. |
| NotificationMapper | Mapper | Convierte objetos Notification entre Domain, DTO y Persistence. |
| AlertMapper | Mapper | Convierte objetos Alert entre Domain, DTO y Persistence. |
| NotificationPreferenceMapper | Mapper | Convierte objetos NotificationPreference entre Domain, DTO y Persistence. |
| RetryPolicyConfig | Configuration | Define la política de reintentos para fallos de envío (TS04). |

#### 2.6.2.5. Bounded Context Software Architecture Component Level Diagrams

El Component Diagram del bounded context Notificaciones presenta, en un layout vertical y con un número reducido de componentes, la organización interna del módulo en cuatro capas claramente separadas: Interface (API REST), Application (servicio de aplicación), Domain (servicios de dominio) e Infrastructure (repositorio, scheduler y adaptadores a FCM y SendGrid). También muestra la integración de entrada desde la Mobile Application y desde el bounded context Agenda, y las salidas hacia la base de datos y los servicios externos.

![Figura 4. Component Level Diagram del bounded context Notificaciones](assets/notificaciones-component-diagram.png)

*Figura 4. Component Level Diagram del bounded context Notificaciones, organizado por capas.*

#### 2.6.2.6. Bounded Context Software Architecture Code Level Diagrams

##### 2.6.2.6.1. Bounded Context Domain Layer Class Diagrams

El Class Diagram de la capa de dominio del bounded context Notificaciones muestra el agregado NotificationCenter, sus entidades internas (Notification, Alert, NotificationPreference), los value objects que describen su comportamiento, los domain services que encapsulan las reglas de negocio y los domain events que comunican cambios relevantes hacia otros contextos.

![Figura 5. Domain Layer Class Diagram del bounded context Notificaciones](assets/notificaciones-class-diagram.png)

*Figura 5. Domain Layer Class Diagram del bounded context Notificaciones.*

##### 2.6.2.6.2. Bounded Context Database Design Diagram

El Database Design Diagram del bounded context Notificaciones muestra el esquema relacional que soporta la persistencia del agregado NotificationCenter y sus entidades asociadas. Está compuesto por cuatro tablas propias del contexto (`notifications`, `alerts`, `notification_preferences` y `notification_delivery_attempts`) y una referencia conceptual a la tabla `users`, que pertenece al bounded context de Autenticación y se muestra únicamente a efectos de integridad referencial. Cada notificación se asocia a un destinatario mediante `recipient_id`, puede referenciar al evento de salud que la originó (`health_event_id`, cuya autoridad reside en el bounded context Agenda) y mantiene una trazabilidad temporal de su ciclo de vida (scheduled → sent → delivered → read / failed). La tabla `notification_delivery_attempts` implementa la bitácora de reintentos requerida por la historia técnica TS04 (Envío de notificaciones), mientras que `alerts` captura las alertas de incumplimiento generadas por la historia US05 y, opcionalmente, referencia la notificación que las disparó.

| Tabla | Propósito | Historias de usuario / técnicas |
|-------|-----------|--------------------------------|
| `notifications` | Almacena las notificaciones programadas, enviadas y leídas. | US04, US06, TS03, TS04 |
| `alerts` | Almacena las alertas de incumplimiento generadas para los cuidadores. | US05 |
| `notification_preferences` | Persiste las preferencias de canal y tipo por usuario. | US06 |
| `notification_delivery_attempts` | Registra los intentos de envío y sus fallos para reintentos. | TS04 |
| `users` *(referenciada)* | Tabla propietaria del bounded context Autenticación. | TS05 |

![Figura 6. Database Design Diagram del bounded context Notificaciones](assets/notificaciones-db-diagram.png)

*Figura 6. Database Design Diagram del bounded context Notificaciones.*

---

# 2.6.3. Bounded Context: Diary

## 2.6.3.1. Domain Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| Diary | Aggregate Root | Gestiona la consistencia de las entradas del diario del paciente. |
| DiaryEntry | Entity | Representa una nota registrada por el paciente. |
| EntryContent | Value Object | Encapsula el contenido textual de la nota del diario. |
| EntryDate | Value Object | Representa la fecha de creación de la entrada. |
| DiaryRepository | Repository | Define el contrato de persistencia del diario de seguimiento. |
| DiaryEntryCreatedEvent | Domain Event | Se publica cuando se crea una nueva entrada en el diario. |
| DiaryEntryUpdatedEvent | Domain Event | Se publica cuando se actualiza una entrada existente. |
| DiaryEntryDeletedEvent | Domain Event | Se publica cuando se elimina una entrada del diario. |

## 2.6.3.2. Interface Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| DiaryActivity | Activity | Punto de entrada principal del módulo diario. |
| DiaryEntryFragment | Fragment | Permite crear y visualizar entradas del diario. |
| DiaryDetailFragment | Fragment | Muestra el detalle de una entrada seleccionada. |
| DiaryViewModel | ViewModel | Gestiona el estado de la interfaz y la comunicación con Application Layer. |

## 2.6.3.3. Application Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| CreateDiaryEntryCommand | Command | Solicita la creación de una nueva entrada. |
| UpdateDiaryEntryCommand | Command | Solicita la actualización de una entrada existente. |
| DeleteDiaryEntryCommand | Command | Solicita la eliminación de una entrada del diario. |
| CreateDiaryEntryHandler | Command Handler | Procesa la creación de entradas del diario. |
| UpdateDiaryEntryHandler | Command Handler | Procesa la actualización de entradas. |
| DeleteDiaryEntryHandler | Command Handler | Procesa la eliminación de entradas. |
| GetDiaryEntriesQuery | Query | Recupera todas las entradas del diario. |
| GetDiaryEntryByIdQuery | Query | Recupera una entrada específica por ID. |
| GetDiaryEntriesHandler | Query Handler | Procesa la consulta de todas las entradas. |
| GetDiaryEntryByIdHandler | Query Handler | Procesa la consulta por identificador. |
| DiaryEntryDTO | DTO | Transfiere información de entradas entre capas. |

## 2.6.3.4. Infrastructure Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| DiaryRepositoryImpl | Repository Implementation | Implementa la persistencia del diario usando base de datos local. |
| AppDatabase | Database | Configuración de la base de datos del sistema. |
| DiaryDao | DAO | Acceso a datos de las entradas del diario. |
| DiaryEntity | Persistence Entity | Representa una entrada del diario en la base de datos. |
| DiaryMapper | Mapper | Convierte entre Domain, DTO y Persistence models. |

#### 2.6.3.5. Bounded Context Software Architecture Component Level Diagrams
![ Bounded Context Software Architecture Component Level Diagrams](assets/components_diary.jpeg)

#### 2.6.3.6. Bounded Context Software Architecture Code Level Diagrams
##### 2.6.3.6.1. Bounded Context Domain Layer Class Diagrams
![ Bounded Context Domain Layer Class Diagrams](assets/daigram.png)

##### 2.6.3.6.2. Bounded Context Database Design Diagram
![Bounded Context Database Design Diagram](assets/diagram_dairy.png)
### 2.6.4. Bounded Context: Compartir Perfiles <a id="264-bounded-context"></a>

Este bounded context gestiona el ciclo de vida del acceso compartido entre un paciente y sus familiares. Cubre las historias de usuario **US14** (compartir perfil), **US15** (consultar perfil compartido) y **US16** (revocar acceso), correspondientes a la épica **EP04 – Acceso Compartido**. Se integra con el bounded context de Notificaciones mediante eventos de dominio para informar cuando un acceso es creado, aceptado o revocado.

---

#### 2.6.4.1. Domain Layer <a id="2641-domain-layer"></a>

| Componente | Tipo | Descripción |
|---|---|---|
| `ProfileSharing` | Aggregate Root | Gestiona la consistencia transaccional del ciclo de compartir y revocar acceso al perfil del paciente. |
| `SharedAccess` | Entity | Representa un vínculo de acceso activo entre un paciente y un familiar autorizado. |
| `AccessRequest` | Entity | Representa una solicitud de acceso enviada por el paciente hacia un familiar. |
| `ShareToken` | Value Object | Encapsula el token de invitación generado para compartir el perfil. |
| `AccessStatus` | Value Object | Representa el estado del acceso (`PENDING`, `ACTIVE`, `REVOKED`, `EXPIRED`). |
| `AccessPermission` | Value Object | Define el nivel de permisos otorgados al familiar (`READ_ONLY`, `FULL_ACCESS`). |
| `ExpirationDate` | Value Object | Encapsula la fecha y hora de expiración del acceso compartido. |
| `ProfileSharingService` | Domain Service | Aplica las reglas de negocio para generar, validar y revocar accesos al perfil. |
| `AccessValidationService` | Domain Service | Valida que el familiar sea un usuario existente y que el token no haya expirado. |
| `SharedProfileRepository` | Repository | Define el contrato de persistencia del agregado `ProfileSharing`. |
| `ProfileSharedEvent` | Domain Event | Se publica cuando el paciente comparte su perfil con un familiar. |
| `AccessGrantedEvent` | Domain Event | Se publica cuando el familiar acepta el acceso y este queda activo. |
| `AccessRevokedEvent` | Domain Event | Se publica cuando el paciente revoca el acceso a un familiar. |
| `AccessExpiredEvent` | Domain Event | Se publica cuando el token de acceso expira sin ser aceptado. |

---

#### 2.6.4.2. Interface Layer <a id="2642-interface-layer"></a>

| Componente | Tipo | Descripción |
|---|---|---|
| `ShareProfileActivity` | Activity | Punto de entrada principal del módulo de compartir perfiles en la aplicación móvil. |
| `ShareProfileFragment` | Fragment | Permite al paciente ingresar los datos del familiar y generar el enlace de acceso (US14). |
| `SharedAccessListFragment` | Fragment | Muestra la lista de familiares con acceso activo al perfil del paciente (US16). |
| `FamilyPatientProfileFragment` | Fragment | Presenta al familiar la información del paciente cuyo perfil fue compartido (US15). |
| `ShareProfileViewModel` | ViewModel | Gestiona el estado del formulario de compartir y coordina Commands con la capa de aplicación. |
| `SharedAccessViewModel` | ViewModel | Gestiona el estado de la lista de accesos activos y las acciones de revocación. |

---

#### 2.6.4.3. Application Layer <a id="2643-application-layer"></a>

| Componente | Tipo | Descripción |
|---|---|---|
| `ShareProfileCommand` | Command | Solicita la creación de un acceso compartido y la generación del token de invitación. |
| `RevokeAccessCommand` | Command | Solicita la revocación del acceso de un familiar específico. |
| `AcceptSharedAccessCommand` | Command | Solicita la activación del acceso cuando el familiar acepta la invitación. |
| `ShareProfileHandler` | Command Handler | Procesa la generación del token y el registro del acceso pendiente. |
| `RevokeAccessHandler` | Command Handler | Procesa la revocación del acceso, actualizando el estado a `REVOKED`. |
| `AcceptSharedAccessHandler` | Command Handler | Procesa la activación del acceso, validando token y fecha de expiración. |
| `GetSharedAccessListQuery` | Query | Recupera la lista de familiares con acceso al perfil del paciente. |
| `GetPatientSharedProfileQuery` | Query | Recupera la información del perfil del paciente visible para el familiar autorizado. |
| `GetSharedAccessListHandler` | Query Handler | Procesa la consulta de accesos activos del paciente. |
| `GetPatientSharedProfileHandler` | Query Handler | Procesa la consulta del perfil compartido, validando permisos del familiar. |
| `SharedAccessDTO` | DTO | Transfiere información de accesos compartidos entre capas. |
| `PatientSharedProfileDTO` | DTO | Transfiere la información del perfil del paciente hacia la vista del familiar. |

---

#### 2.6.4.4. Infrastructure Layer <a id="2644-infrastructure-layer"></a>

| Componente | Tipo | Descripción |
|---|---|---|
| `SharedProfileRepositoryImpl` | Repository Implementation | Implementa la persistencia del agregado `ProfileSharing`. |
| `SharedAccessDao` | DAO | Proporciona operaciones de acceso a datos para los registros de acceso compartido. |
| `SharedAccessEntity` | Persistence Entity | Representa un acceso compartido dentro de la base de datos local. |
| `AccessRequestEntity` | Persistence Entity | Representa una solicitud de acceso pendiente en la base de datos. |
| `SharedAccessMapper` | Mapper | Convierte objetos entre Domain, DTO y Persistence. |
| `TokenGeneratorService` | External Utility | Genera tokens únicos y seguros para las invitaciones de acceso. |
| `NotificationBoundedContextAdapter` | Adapter | Publica eventos hacia el bounded context de Notificaciones cuando se genera o revoca un acceso. |

---

#### 2.6.4.5. Bounded Context Software Architecture Component Level Diagrams <a id="2645-component-level-diagrams"></a>

El Component Diagram del bounded context Compartir Perfiles presenta la organización interna del módulo en cuatro capas: Interface (REST Controllers), Application (Command y Query Services), Domain (servicios de dominio y repositorio) e Infrastructure (repositorio implementado, generador de tokens y adaptador hacia Notificaciones). Muestra las entradas desde la Mobile Application y la integración de salida hacia la base de datos y el bounded context de Notificaciones.

![Component Diagram - Bounded Context Compartir Perfiles](assets/diag_sharing_component.png)

---

#### 2.6.4.6. Bounded Context Software Architecture Code Level Diagrams <a id="2646-code-level-diagrams"></a>

##### 2.6.4.6.1. Bounded Context Domain Layer Class Diagrams <a id="26461-domain-layer-class-diagrams"></a>

El diagrama de clases de la capa de dominio muestra el agregado `ProfileSharing` como raíz, sus entidades internas (`SharedAccess`, `AccessRequest`), los value objects (`ShareToken`, `ExpirationDate`, `AccessStatus`, `AccessPermission`), los domain services (`ProfileSharingService`, `AccessValidationService`), el contrato de repositorio y los domain events publicados durante el ciclo de compartir, aceptar, revocar y expirar accesos.

![Domain Layer Class Diagram - Bounded Context Compartir Perfiles](assets/diag_sharing_domain_class.png)

##### 2.6.4.6.2. Bounded Context Database Design Diagram <a id="26462-database-design-diagram"></a>

El diagrama de base de datos representa las tablas `profile_sharings`, `shared_accesses` y `access_requests`, junto con sus relaciones (1..N) y restricciones de integridad. El campo `token` en `shared_accesses` es único; `permission` y `status` se almacenan como strings con valores acotados equivalentes a los enums de dominio.

![Database Design Diagram - Bounded Context Compartir Perfiles](assets/diag_sharing_database.png)

---

### 2.6.5. Bounded Context: Documents

---

#### 2.6.5.1. Domain Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| MedicalDocument | Aggregate Root | Representa el conjunto de documentos médicos de un paciente y controla su consistencia. Es el punto de entrada para gestionar documentos. |
| DocumentItem | Entity | Representa un documento médico individual como receta, resultado de laboratorio o informe clínico. |
| DocumentType | Value Object | Define el tipo de documento médico (receta, laboratorio, informe, etc.). |
| DocumentMetadata | Value Object | Contiene información adicional del documento como fecha, descripción y origen. |
| DocumentRepository | Repository | Define el contrato de persistencia del agregado MedicalDocument. |
| DocumentUploadedEvent | Domain Event | Se publica cuando un documento médico es registrado en el sistema. |
| DocumentAccessedEvent | Domain Event | Se publica cuando un documento es consultado por un usuario autorizado. |

---

#### 2.6.5.2. Interface Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| DocumentsActivity | Activity | Pantalla principal del módulo de gestión de documentos médicos. |
| DocumentsFragment | Fragment | Muestra la lista de documentos del paciente. |
| DocumentDetailFragment | Fragment | Muestra el detalle de un documento médico seleccionado. |
| DocumentsViewModel | ViewModel | Gestiona el estado de la interfaz y coordina Commands y Queries del módulo. |

---

#### 2.6.5.3. Application Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| UploadDocumentCommand | Command | Solicita la carga de un nuevo documento médico. |
| DeleteDocumentCommand | Command | Solicita la eliminación de un documento médico. |
| UploadDocumentHandler | Command Handler | Procesa la carga de documentos médicos. |
| DeleteDocumentHandler | Command Handler | Procesa la eliminación de documentos médicos. |
| GetDocumentsQuery | Query | Recupera todos los documentos del paciente. |
| GetDocumentByIdQuery | Query | Recupera un documento específico por su identificador. |
| GetDocumentsHandler | Query Handler | Procesa la consulta de documentos médicos. |
| GetDocumentByIdHandler | Query Handler | Procesa la consulta de un documento específico. |
| MedicalDocumentDTO | DTO | Transfiere información de documentos entre capas del sistema. |

---

#### 2.6.5.4. Infrastructure Layer

| Componente | Tipo | Descripción |
|-----------|------|-------------|
| DocumentRepositoryImpl | Repository Implementation | Implementa la persistencia del agregado MedicalDocument usando base de datos local. |
| DocumentDao | DAO | Proporciona acceso a los datos de documentos médicos. |
| DocumentEntity | Persistence Entity | Representa un documento médico en la base de datos. |
| DocumentMapper | Mapper | Convierte entre modelos de Domain, DTO y Persistence. |

#### 2.6.5.5. Bounded Context Software Architecture Component Level Diagrams 

![alt text](<assets/Component diagram.jpeg>)

#### 2.6.4.6. Bounded Context Software Architecture Code Level Diagrams <a id="2646-code-level-diagrams"></a>

##### 2.6.4.6.1. Bounded Context Domain Layer Class Diagrams <a id="26461-domain-layer-class-diagrams"></a>

![alt text](assets/Class_Diagram_Documents.png)


##### 2.6.4.6.2. Bounded Context Database Design Diagram <a id="26462-database-design-diagram"></a>

![alt text](assets/Diagram_db_documents.png)

# Capítulo III: Solution UI/UX Design

## 3.1. Product design <a id="31-product-design"></a>

### 3.1.1. Style Guidelines <a id="311-style-guidelines"></a>
#### 3.1.1.1. General Style Guidelines <a id="3111-general-style-guidelines"></a>

### 3.1.2. Information Architecture <a id="312-information-architecture"></a>
#### 3.1.2.1. Organization Systems <a id="3121-organization-systems"></a>
#### 3.1.2.2. Labelling Systems <a id="3122-labelling-systems"></a>
#### 3.1.2.3. SEO Tags and Meta Tags <a id="3123-seo-tags-and-meta-tags"></a>
#### 3.1.2.4. Searching Systems <a id="3124-searching-systems"></a>
#### 3.1.2.5. Navigation Systems <a id="3125-navigation-systems"></a>

### 3.1.3. Landing Page UI Design <a id="313-landing-page-ui-design"></a>
#### 3.1.3.1. Landing Page Wireframe <a id="3131-landing-page-wireframe"></a>
#### 3.1.3.2. Landing Page Mock-up <a id="3132-landing-page-mock-up"></a>

### 3.1.4. Mobile Applications UX/UI Design <a id="314-mobile-applications-uxui-design"></a>
#### 3.1.4.1. Mobile Applications Wireframes <a id="3141-mobile-applications-wireframes"></a>
#### 3.1.4.2. Mobile Applications Wireflow Diagrams <a id="3142-mobile-applications-wireflow-diagrams"></a>
#### 3.1.4.3. Mobile Applications Mock-ups <a id="3143-mobile-applications-mock-ups"></a>
#### 3.1.4.4. Mobile Applications User Flow Diagrams <a id="3144-mobile-applications-user-flow-diagrams"></a>
#### 3.1.4.5. Mobile Applications Prototyping <a id="3145-mobile-applications-prototyping"></a>

---

# Capítulo IV: Product Implementation & Validation

## 4.1. Product Implementation & Validation <a id="41-product-implementation--validation"></a>

### 4.1.1. Software Configuration Management <a id="411-software-configuration-management"></a>
#### 4.1.1.1. Software Development Environment Configuration <a id="4111-software-development-environment-configuration"></a>
#### 4.1.1.2. Source Code Management <a id="4112-source-code-management"></a>
#### 4.1.1.3. Source Code Style Guide & Conventions <a id="4113-source-code-style-guide--conventions"></a>
#### 4.1.1.4. Software Deployment Configuration <a id="4114-software-deployment-configuration"></a>

## 4.2. Landing Page & Mobile Application Implementation <a id="42-landing-page--mobile-application-implementation"></a>

### 4.2.1. Sprint n <a id="421-sprint-n"></a>
#### 4.2.1.1. Sprint Planning n <a id="4211-sprint-planning-n"></a>
#### 4.2.1.2. Sprint Backlog n <a id="4212-sprint-backlog-n"></a>
#### 4.2.1.3. Development Evidence for Sprint Review <a id="4213-development-evidence"></a>
#### 4.2.1.4. Testing Suite Evidence for Sprint Review <a id="4214-testing-suite-evidence"></a>
#### 4.2.1.5. Execution Evidence for Sprint Review <a id="4215-execution-evidence"></a>
#### 4.2.1.6. Services Documentation Evidence for Sprint Review <a id="4216-services-documentation-evidence"></a>
#### 4.2.1.7. Software Deployment Evidence for Sprint Review <a id="4217-software-deployment-evidence"></a>
#### 4.2.1.8. Team Collaboration Insights during Sprint <a id="4218-team-collaboration-insights"></a>

## 4.3. Validation Interviews <a id="43-validation-interviews"></a>
### 4.3.1. Diseño de Entrevistas <a id="431-diseno-de-entrevistas"></a>
### 4.3.2. Registro de Entrevistas <a id="432-registro-de-entrevistas"></a>
### 4.3.3. Evaluaciones según heurísticas <a id="433-evaluaciones-segun-heuristicas"></a>

---

# Conclusiones <a id="conclusiones"></a>

# Glosario <a id="glosario"></a>

# Bibliografía <a id="bibliografia"></a>

# Anexos <a id="anexos"></a>
