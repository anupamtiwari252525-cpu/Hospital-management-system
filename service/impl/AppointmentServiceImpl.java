package com.jdbcconnectivity.HospitalManagement.service.impl;

import com.jdbcconnectivity.HospitalManagement.dao.AppointmentDAO;
import com.jdbcconnectivity.HospitalManagement.dao.impl.AppointmentDAOImpl;
import com.jdbcconnectivity.HospitalManagement.model.Appointment;
import com.jdbcconnectivity.HospitalManagement.service.AppointmentService;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

    @Override
    public void bookAppointment(Appointment appointment) {
        appointmentDAO.bookAppointment(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }
}
