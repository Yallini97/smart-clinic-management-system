package com.clinic.controllers;

import com.clinic.models.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private List<Doctor> doctorList = new ArrayList<>();

    // Add a new doctor
    @PostMapping
    public String addDoctor(@RequestBody Doctor doctor) {
        doctorList.add(doctor);
        return "Doctor added successfully";
    }

    // Get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorList;
    }

    // Get doctor by ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorList.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
