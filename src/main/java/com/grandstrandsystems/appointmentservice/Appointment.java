package com.grandstrandsystems.appointmentservice;

import java.util.Date;

public class Appointment {
    private final String appointmentId;
    private final Date appointmentDate;
    private final String appointmentDescription;

    public Appointment(String appointmentId, Date appointmentDate, String appointmentDescription) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID cannot be null and must be 10 characters or less");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be null or in the past");
        }
        if (appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Appointment description cannot be null and must be 50 characters or less");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentDescription = appointmentDescription;
    }

    public String getAppointmentId()
    {
        return appointmentId;
    }

    public Date getAppointmentDate()
    {
        return appointmentDate;
    }

    public String getAppointmentDescription()
    {
        return appointmentDescription;
    }
}