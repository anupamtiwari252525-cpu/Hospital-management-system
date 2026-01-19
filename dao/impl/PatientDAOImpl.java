package com.jdbcconnectivity.HospitalManagement.dao.impl;

import com.jdbcconnectivity.HospitalManagement.dao.PatientDAO;
import com.jdbcconnectivity.HospitalManagement.model.Patient;
import com.jdbcconnectivity.HospitalManagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public void addPatient(Patient patient) {

        String sql = "INSERT INTO patient(name, age, gender, phone, address) VALUES(?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Patient> getAllPatients() {

        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patient";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setGender(rs.getString("gender"));
                p.setPhone(rs.getString("phone"));
                p.setAddress(rs.getString("address"));
                list.add(p);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
