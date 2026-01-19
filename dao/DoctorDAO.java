package com.jdbcconnectivity.HospitalManagement.dao;

import com.jdbcconnectivity.HospitalManagement.model.Doctor;
import java.util.List;

public interface DoctorDAO {

    void addDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();
}
