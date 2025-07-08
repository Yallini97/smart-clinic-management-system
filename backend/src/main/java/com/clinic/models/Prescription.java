package com.clinic.models;

import jakarta.persistence.*;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicationName;
    private String dosage;
    private String frequency;
    private String notes;

    // Constructors
    public Prescription() {
    }

    public Prescription(String medicationName, String dosage, String frequency, String notes) {
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.frequency = frequency;
        this.notes = notes;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    // ✅ Add this to avoid update errors
    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
