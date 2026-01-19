package com.jdbcconnectivity.HospitalManagement.dao;

import com.jdbcconnectivity.HospitalManagement.model.Appointment;
import java.util.List;

public interface AppointmentDAO {

    void bookAppointment(Appointment appointment);

    List<Appointment> getAllAppointments();
}
