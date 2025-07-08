package com.clinic.repo;

import com.clinic.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // ✅ Filter doctors by specialization and availability
    List<Doctor> findBySpecializationAndAvailability(String specialization, boolean availability);
}
