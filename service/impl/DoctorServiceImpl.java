package com.jdbcconnectivity.HospitalManagement.service.impl;

import com.jdbcconnectivity.HospitalManagement.dao.DoctorDAO;
import com.jdbcconnectivity.HospitalManagement.dao.impl.DoctorDAOImpl;
import com.jdbcconnectivity.HospitalManagement.model.Doctor;
import com.jdbcconnectivity.HospitalManagement.service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    private DoctorDAO doctorDAO = new DoctorDAOImpl();

    @Override
    public void addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }
}
