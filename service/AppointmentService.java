package com.jdbcconnectivity.HospitalManagement.service;

import com.jdbcconnectivity.HospitalManagement.model.Appointment;
import java.util.List;

public interface AppointmentService {

    void bookAppointment(Appointment appointment);

    List<Appointment> getAllAppointments();
}
