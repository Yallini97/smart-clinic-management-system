package com.clinic.repo;

import com.clinic.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // ✅ Retrieve patient by email
    Optional<Patient> findByEmail(String email);

    // ✅ Retrieve patient by phone number
    Optional<Patient> findByPhoneNumber(String phoneNumber);
}
