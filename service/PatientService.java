package com.jdbcconnectivity.HospitalManagement.service;

import com.jdbcconnectivity.HospitalManagement.model.Patient;
import java.util.List;

public interface PatientService {

    void registerPatient(Patient patient);

    List<Patient> getAllPatients();
}
