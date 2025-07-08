package com.clinic.controllers;

import com.clinic.models.Appointment;
import com.clinic.repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Create a new appointment
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Get appointments by patient ID
    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsByPatient(@PathVariable int patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    // (Optional) Filter appointments by doctor + time (for Question 26)
    @GetMapping("/filter")
    public List<Appointment> filterAppointments(
            @RequestParam int doctorId,
            @RequestParam String time // e.g., "2025-07-10T10:00"
    ) {
        return appointmentRepository.findByDoctorIdAndAppointmentTime(doctorId, java.time.LocalDateTime.parse(time));
    }
}
