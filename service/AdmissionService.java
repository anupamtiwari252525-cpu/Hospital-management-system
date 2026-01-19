package com.jdbcconnectivity.HospitalManagement.service;

import com.jdbcconnectivity.HospitalManagement.model.Admission;
import java.util.List;

public interface AdmissionService {

    void admitPatient(Admission admission);

    void dischargePatient(int admissionId);

    List<Admission> getAllAdmissions();
}
