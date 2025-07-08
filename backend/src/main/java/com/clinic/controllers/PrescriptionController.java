package com.clinic.controllers;

import com.clinic.models.Prescription;
import com.clinic.repo.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    // Create a new prescription
    @PostMapping
    public Prescription createPrescription(@RequestBody Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    // Get all prescriptions
    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    // Get prescription by ID
    @GetMapping("/{id}")
    public Optional<Prescription> getPrescriptionById(@PathVariable Long id) {
        return prescriptionRepository.findById(id);
    }

    // Update prescription
    @PutMapping("/{id}")
    public Prescription updatePrescription(@PathVariable Long id, @RequestBody Prescription updatedPrescription) {
        return prescriptionRepository.findById(id).map(prescription -> {
            prescription.setMedicationName(updatedPrescription.getMedicationName());
            prescription.setDosage(updatedPrescription.getDosage());
            prescription.setFrequency(updatedPrescription.getFrequency());
            prescription.setNotes(updatedPrescription.getNotes());
            return prescriptionRepository.save(prescription);
        }).orElseGet(() -> {
            updatedPrescription.setId(id);
            return prescriptionRepository.save(updatedPrescription);
        });
    }

    // Delete prescription
    @DeleteMapping("/{id}")
    public String deletePrescription(@PathVariable Long id) {
        prescriptionRepository.deleteById(id);
        return "Prescription deleted with ID: " + id;
    }
}
