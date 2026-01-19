package com.jdbcconnectivity.HospitalManagement.service.impl;

import com.jdbcconnectivity.HospitalManagement.dao.PatientDAO;
import com.jdbcconnectivity.HospitalManagement.dao.impl.PatientDAOImpl;
import com.jdbcconnectivity.HospitalManagement.model.Patient;
import com.jdbcconnectivity.HospitalManagement.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    private PatientDAO patientDAO = new PatientDAOImpl();

    @Override
    public void registerPatient(Patient patient) {
        patientDAO.addPatient(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }
}
