package com.mohith.janitridemo.repository;

import com.mohith.janitridemo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}