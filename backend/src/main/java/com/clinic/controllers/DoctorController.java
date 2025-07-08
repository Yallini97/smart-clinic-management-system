package com.clinic.controllers;

import com.clinic.models.Doctor;
import com.clinic.repo.DoctorRepository;
import com.clinic.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;

    // Add a new doctor
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Get doctor by ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.orElse(null);
    }

    // Filter doctors
    @GetMapping("/filter")
    public List<Doctor> filterDoctors(@RequestParam String specialization, @RequestParam boolean availability) {
        return doctorRepository.findBySpecializationAndAvailability(specialization, availability);
    }

    // ✅ New: Check doctor availability by date and token
    @GetMapping("/availability")
    public ResponseEntity<Boolean> checkDoctorAvailability(
            @RequestParam Long doctorId,
            @RequestParam String date,
            @RequestHeader("Authorization") String token
    ) {
        // Dummy role check for token
        if (!token.contains("ROLE_DOCTOR")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        boolean available = doctorService.isDoctorAvailable(doctorId, date);
        return ResponseEntity.ok(available);
    }
}

