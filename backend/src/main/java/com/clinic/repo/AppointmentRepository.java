package com.clinic.repo;

import com.clinic.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByPatientId(int patientId);
    List<Appointment> findByDoctorIdAndAppointmentTime(int doctorId, LocalDateTime appointmentTime);
}
