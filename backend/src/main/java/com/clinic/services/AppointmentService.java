package com.clinic.services;

import com.clinic.models.Appointment;
import com.clinic.models.Doctor;
import com.clinic.models.Patient;
import com.clinic.repo.AppointmentRepository;
import com.clinic.repo.DoctorRepository;
import com.clinic.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Appointment bookAppointment(Long doctorId, Long patientId, LocalDateTime dateTime, String notes) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));

        // Optional: Check if doctor already has appointment at that time
        boolean exists = appointmentRepository.existsByDoctorAndAppointmentDateTime(doctor, dateTime);
        if (exists) {
            throw new RuntimeException("Doctor is not available at the selected time");
        }

        Appointment appointment = new Appointment(dateTime, doctor, patient, notes);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsForDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}
