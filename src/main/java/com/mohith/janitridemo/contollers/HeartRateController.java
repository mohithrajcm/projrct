package com.mohith.janitridemo.contollers;

import com.mohith.janitridemo.model.HeartRate;
import com.mohith.janitridemo.model.Patient;
import com.mohith.janitridemo.service.HeartRateService;
import com.mohith.janitridemo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients/{id}/heart-rate")
public class HeartRateController {
    @Autowired
    private HeartRateService heartRateService;
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<HeartRate> addHeartRate(@PathVariable Long id, @RequestBody HeartRate heartRate) {
        Optional<Patient> patient = patientService.getPatient(id);
        if (patient.isPresent()) {
            heartRate.setPatient(patient.get());
            return ResponseEntity.ok(heartRateService.addHeartRate(heartRate));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<HeartRate>> getHeartRates(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatient(id);
        return patient.map(value -> ResponseEntity.ok(heartRateService.getHeartRatesByPatient(value))).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}