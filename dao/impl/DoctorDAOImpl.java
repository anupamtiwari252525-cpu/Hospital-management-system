package com.jdbcconnectivity.HospitalManagement.dao.impl;

import com.jdbcconnectivity.HospitalManagement.dao.DoctorDAO;
import com.jdbcconnectivity.HospitalManagement.model.Doctor;
import com.jdbcconnectivity.HospitalManagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public void addDoctor(Doctor doctor) {

        String sql = "INSERT INTO doctor(name, specialization, phone) VALUES (?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Doctor> getAllDoctors() {

        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctor";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Doctor d = new Doctor();
                d.setDoctorId(rs.getInt("doctor_id"));
                d.setName(rs.getString("name"));
                d.setSpecialization(rs.getString("specialization"));
                d.setPhone(rs.getString("phone"));
                list.add(d);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
