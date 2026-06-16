# Gestión de Consentimiento

Bounded context for patient profile sharing with caregivers.

## Rules

- Only a `PATIENT` can grant, update, or revoke consent.
- Only a `CAREGIVER` can query their assigned shared profile.
- A caregiver can have only one patient profile at a time.
- The patient decides which views the caregiver can see through `ConsentView`:
  - `PROFILE`
  - `AGENDA`
  - `NOTIFICATIONS`
  - `DOCUMENTS`
  - `DIARY`

## Endpoints

- `POST /api/consents`: grant or update caregiver access by `caregiverId` or `caregiverEmail`.
- `GET /api/consents/me/patient`: list consents granted by current patient.
- `GET /api/consents/me/caregiver`: get current caregiver shared patient profile.
- `GET /api/consents/me/caregiver/access?patientId={uuid}&view=DIARY`: validate access to a view.
- `PUT /api/consents/{consentId}/views`: update visible views.
- `DELETE /api/consents/{consentId}`: revoke access.

All endpoints expect `Authorization: Bearer <mock-token>` from the IAM login flow.
