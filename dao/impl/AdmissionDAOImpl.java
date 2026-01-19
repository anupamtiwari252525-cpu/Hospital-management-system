package com.jdbcconnectivity.HospitalManagement.dao.impl;

import com.jdbcconnectivity.HospitalManagement.dao.AdmissionDAO;
import com.jdbcconnectivity.HospitalManagement.model.Admission;
import com.jdbcconnectivity.HospitalManagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdmissionDAOImpl implements AdmissionDAO {

    @Override
    public void admitPatient(Admission admission) {

        String sql =
            "INSERT INTO admission(patient_id, room_no, admission_date) VALUES (?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, admission.getPatientId());
            ps.setString(2, admission.getRoomNo());
            ps.setDate(3, admission.getAdmissionDate());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dischargePatient(int admissionId) {

        String sql =
            "UPDATE admission SET discharge_date = CURDATE() WHERE admission_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, admissionId);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Admission> getAllAdmissions() {

        List<Admission> list = new ArrayList<>();
        String sql = "SELECT * FROM admission";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Admission a = new Admission();
                a.setAdmissionId(rs.getInt("admission_id"));
                a.setPatientId(rs.getInt("patient_id"));
                a.setRoomNo(rs.getString("room_no"));
                a.setAdmissionDate(rs.getDate("admission_date"));
                a.setDischargeDate(rs.getDate("discharge_date"));
                list.add(a);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
