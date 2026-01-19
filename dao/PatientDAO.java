package com.jdbcconnectivity.HospitalManagement.dao;

import com.jdbcconnectivity.HospitalManagement.model.Patient;
import java.util.List;

public interface PatientDAO {

    void addPatient(Patient patient);

    List<Patient> getAllPatients();
}
