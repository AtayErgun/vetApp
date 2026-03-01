package com.ergun.vetapp.controller;

import com.ergun.vetapp.entity.Appointment;
import com.ergun.vetapp.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @PostMapping
    public Appointment create(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        appointmentRepository.deleteById(id);
    }

    @PutMapping("/{id}/status")
    public Appointment updateStatus(@PathVariable Long id, @RequestParam String status) {
        Appointment app = appointmentRepository.findById(id).orElseThrow();
        app.setStatus(status);
        return appointmentRepository.save(app);
    }
}