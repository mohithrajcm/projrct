package com.mohith.janitridemo.repository;

import com.mohith.janitridemo.model.HeartRate;
import com.mohith.janitridemo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {
    List<HeartRate> findAllByPatient(Patient patient);
}
