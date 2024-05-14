package com.projectone.cs320;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
    @Test
    public void testAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000000);
        Appointment appointment = new Appointment("1", futureDate, "Appointment Description");
        assertEquals("1", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Appointment Description", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", new Date(System.currentTimeMillis() - 1000000), "Appointment Description");
        });
    }
}
