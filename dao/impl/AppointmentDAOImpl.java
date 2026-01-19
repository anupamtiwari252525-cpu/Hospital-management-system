package com.jdbcconnectivity.HospitalManagement.dao.impl;

import com.jdbcconnectivity.HospitalManagement.dao.AppointmentDAO;
import com.jdbcconnectivity.HospitalManagement.model.Appointment;
import com.jdbcconnectivity.HospitalManagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

    @Override
    public void bookAppointment(Appointment appointment) {

        String sql =
            "INSERT INTO appointment(patient_id, doctor_id, appointment_date) VALUES (?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setDate(3, appointment.getAppointmentDate());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Appointment> getAllAppointments() {

        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointment";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Appointment a = new Appointment();
                a.setAppointmentId(rs.getInt("appointment_id"));
                a.setPatientId(rs.getInt("patient_id"));
                a.setDoctorId(rs.getInt("doctor_id"));
                a.setAppointmentDate(rs.getDate("appointment_date"));
                list.add(a);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
