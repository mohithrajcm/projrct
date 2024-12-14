package com.mohith.janitridemo.service;

import com.mohith.janitridemo.model.HeartRate;
import com.mohith.janitridemo.model.Patient;
import com.mohith.janitridemo.repository.HeartRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeartRateService {
    @Autowired
    private HeartRateRepository heartRateRepository;

    public HeartRate addHeartRate(HeartRate heartRate) {
        return heartRateRepository.save(heartRate);
    }

    public List<HeartRate> getHeartRatesByPatient(Patient patient) {
        return heartRateRepository.findAllByPatient(patient);
    }
}
