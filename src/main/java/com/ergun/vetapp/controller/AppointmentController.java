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
    private final AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentService appointmentService, AppointmentRepository appointmentRepository) {
        this.appointmentService = appointmentService;
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping("/public")
    public Appointment createPublicAppointment(@RequestBody PublicAppointmentRequest request) {
        return appointmentService.createPublicAppointment(request);
    }

    @GetMapping // Bu metodun olduğundan emin ol
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }

    @PutMapping("/{id}/status")
    public Appointment updateStatus(@PathVariable Long id, @RequestParam String status) {
        return appointmentService.updateStatus(id, status);
    }
}