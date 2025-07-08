# MySQL Schema Design for Smart Clinic Management System

## Table: Doctor
- doctor_id (INT, PK, AUTO_INCREMENT)
- name (VARCHAR)
- specialization (VARCHAR)
- available_times (VARCHAR)

## Table: Patient
- patient_id (INT, PK, AUTO_INCREMENT)
- name (VARCHAR)
- email (VARCHAR)
- phone (VARCHAR)

## Table: Appointment
- appointment_id (INT, PK, AUTO_INCREMENT)
- doctor_id (INT, FK → Doctor.doctor_id)
- patient_id (INT, FK → Patient.patient_id)
- appointment_time (DATETIME)

## Table: Prescription
- prescription_id (INT, PK, AUTO_INCREMENT)
- appointment_id (INT, FK → Appointment.appointment_id)
- medication (TEXT)
- dosage (VARCHAR)
