package com.clinic.services;

import com.clinic.models.Doctor;
import com.clinic.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // ✅ Filter doctors by specialization and availability
    public List<Doctor> filterDoctors(String specialization, boolean availability) {
        return doctorRepository.findBySpecializationAndAvailability(specialization, availability);
    }

    // ✅ Check if doctor is available (dummy implementation)
    public boolean isDoctorAvailable(Long doctorId, String date) {
        // You can later add real availability logic here if needed
        return doctorRepository.findById(doctorId).isPresent();
    }
}
