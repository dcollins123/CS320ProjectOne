package com.projectone.cs320;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000000);
        Appointment appointment = new Appointment("1", futureDate, "Appointment Description");
        appointmentService.addAppointment(appointment);
        assertEquals(appointment, appointmentService.getAppointment("1"));
    }

    @Test
    public void testDeleteAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000000);
        Appointment appointment = new Appointment("1", futureDate, "Appointment Description");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("1");
        assertNull(appointmentService.getAppointment("1"));
    }

    @Test
    public void testUpdateAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000000);
        Appointment appointment = new Appointment("1", futureDate, "Appointment Description");
        appointmentService.addAppointment(appointment);
        Date newDate = new Date(System.currentTimeMillis() + 2000000);
        appointmentService.updateAppointment("1", newDate, "New Appointment Description");
        assertEquals(newDate, appointmentService.getAppointment("1").getAppointmentDate());
        assertEquals("New Appointment Description", appointmentService.getAppointment("1").getDescription());
    }
}
