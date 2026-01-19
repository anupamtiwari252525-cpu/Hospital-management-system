package com.jdbcconnectivity.HospitalManagement.service;

import com.jdbcconnectivity.HospitalManagement.model.Doctor;
import java.util.List;

public interface DoctorService {

    void addDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();
}
