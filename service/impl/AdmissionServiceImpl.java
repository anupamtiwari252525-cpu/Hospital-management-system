package com.jdbcconnectivity.HospitalManagement.service.impl;

import com.jdbcconnectivity.HospitalManagement.dao.AdmissionDAO;
import com.jdbcconnectivity.HospitalManagement.dao.impl.AdmissionDAOImpl;
import com.jdbcconnectivity.HospitalManagement.model.Admission;
import com.jdbcconnectivity.HospitalManagement.service.AdmissionService;

import java.util.List;

public class AdmissionServiceImpl implements AdmissionService {

    private AdmissionDAO admissionDAO = new AdmissionDAOImpl();

    @Override
    public void admitPatient(Admission admission) {
        admissionDAO.admitPatient(admission);
    }

    @Override
    public void dischargePatient(int admissionId) {
        admissionDAO.dischargePatient(admissionId);
    }

    @Override
    public List<Admission> getAllAdmissions() {
        return admissionDAO.getAllAdmissions();
    }
}
