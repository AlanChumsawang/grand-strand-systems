package com.grandstrandsystems.test.appointmentservice;

import com.grandstrandsystems.appointmentservice.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    public void testAddAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 7200);
        Appointment appointment = new Appointment("1", futureDate, "Test Description");
        appointmentService.addAppointment(appointment);
        assertEquals(1, appointmentService.getAppointments().size());
    }

    @Test
    public void testAddNullAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(null);
        });
    }

    @Test
    public void testGetAppointmentDate() {
        Date futureDate = new Date(System.currentTimeMillis() + 7200);
        Appointment appointment = new Appointment("1", futureDate, "Test Description");
        assertEquals(futureDate, appointment.getAppointmentDate());
    }

    @Test
    public void testGetAppointmentDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 7200);
        Appointment appointment = new Appointment("1", futureDate, "Test Description");
        assertEquals("Test Description", appointment.getAppointmentDescription());
    }



    @Test
    public void testAddAppointmentWithPastDate() {
        AppointmentService appointmentService = new AppointmentService();
        Date pastDate = new Date(System.currentTimeMillis() - 10000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", pastDate, "Test Description");
        });
    }

    @Test
    public void testAddDuplicateAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment1 = new Appointment("1", futureDate, "Test Description 1");
        Appointment appointment2 = new Appointment("1", futureDate, "Test Description 2");
        appointmentService.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment = new Appointment("1", futureDate, "Test Description");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("1");
        assertEquals(0, appointmentService.getAppointments().size());
    }

    @Test
    public void testDeleteFakeAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("non-existent-id");
        });
    }

    @Test
    public void testDeleteNullAppointmentId() {
        AppointmentService appointmentService = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment(null);
        });
    }
}