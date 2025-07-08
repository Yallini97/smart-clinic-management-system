package com.clinic.services;

import com.clinic.models.Appointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    private List<Appointment> appointmentList = new ArrayList<>();

    public String bookAppointment(Appointment appointment) {
        appointmentList.add(appointment);
        return "Appointment booked successfully";
    }

    public List<Appointment> getAllAppointments() {
        return appointmentList;
    }

    public Appointment getAppointmentById(int id) {
        return appointmentList.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
