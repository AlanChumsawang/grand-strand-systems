package com.grandstrandsystems.appointmentservice;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AppointmentService {
    private final List<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }
        for (Appointment existingAppointment : appointments) {
            if (existingAppointment.getAppointmentId().equals(appointment.getAppointmentId())) {
                throw new IllegalArgumentException("Appointment ID must be unique");
            }
            if (appointment.getAppointmentDate() == null || appointment.getAppointmentDate().before(new Date())) {
                throw new IllegalArgumentException("Appointment date cannot be null or in the past");
            }
        }
        appointments.add(appointment);
    }

    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
        boolean removed = appointments.removeIf(appointment -> appointment.getAppointmentId().equals(appointmentId));
        if (!removed) {
            throw new IllegalArgumentException("Appointment not found with ID: " + appointmentId);
        }
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}