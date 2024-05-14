package com.projectone.cs320;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    public void deleteAppointment(String appointmentId) {
        appointments.remove(appointmentId);
    }

    public void updateAppointment(String appointmentId, Date appointmentDate, String description) {
        Appointment appointment = appointments.get(appointmentId);
        if (appointment != null) {
            if (appointmentDate != null && !appointmentDate.before(new Date())) appointment.setAppointmentDate(appointmentDate);
            if (description != null && description.length() <= 50) appointment.setDescription(description);
        }
    }

    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
