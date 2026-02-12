package com.ergun.vetapp.controller;

import com.ergun.vetapp.entity.Appointment;
import com.ergun.vetapp.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AppointmentController {
private AppointmentRepository appointmentRepository;
    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
