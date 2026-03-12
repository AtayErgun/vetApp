package com.ergun.vetapp.controller;

import com.ergun.vetapp.dto.PublicAppointmentRequest;
import com.ergun.vetapp.entity.Appointment;
import com.ergun.vetapp.repository.AppointmentRepository;
import com.ergun.vetapp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/public")
    public Appointment createPublicAppointment(@RequestBody PublicAppointmentRequest request) {
        return appointmentService.createPublicAppointment(request);
    }
}