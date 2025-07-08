package com.clinic.controllers;

import com.clinic.models.Prescription;
import com.clinic.services.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    // ✅ Create prescription with token + validation
    @PostMapping
    public ResponseEntity<Prescription> createPrescription(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody Prescription prescription
    ) {
        // Dummy token check
        if (!token.contains("ROLE_DOCTOR")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Prescription saved = prescriptionService.savePrescription(prescription);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Optional: Get all prescriptions
    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }
}
