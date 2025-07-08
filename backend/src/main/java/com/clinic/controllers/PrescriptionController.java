package com.clinic.controllers;

import com.clinic.models.Prescription;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private List<Prescription> prescriptionList = new ArrayList<>();

    @PostMapping
    public String createPrescription(@RequestBody Prescription prescription) {
        prescriptionList.add(prescription);
        return "Prescription added successfully";
    }

    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionList;
    }

    @GetMapping("/{id}")
    public Prescription getPrescriptionById(@PathVariable int id) {
        return prescriptionList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
