package com.clinic.controllers;

import com.clinic.models.Prescription;
import com.clinic.repo.PrescriptionRepository;
import com.clinic.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private TokenService tokenService;

    // Save a prescription (requires valid token)
    @PostMapping("/{patientId}")
    public ResponseEntity<String> savePrescription(
            @RequestHeader("Authorization") String token,
            @PathVariable Long patientId,
            @Valid @RequestBody Prescription prescription) {

        // Remove "Bearer " prefix if present
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        // Validate token
        if (!tokenService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired token");
        }

        // Save prescription
        prescription.setPatientId(patientId);
        prescriptionRepository.save(prescription);

        return ResponseEntity.ok("Prescription saved successfully");
    }
}
