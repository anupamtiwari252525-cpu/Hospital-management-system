package com.jdbcconnectivity.HospitalManagement.dao;

import com.jdbcconnectivity.HospitalManagement.model.Admission;
import java.util.List;

public interface AdmissionDAO {

    void admitPatient(Admission admission);

    void dischargePatient(int admissionId);

    List<Admission> getAllAdmissions();
}
