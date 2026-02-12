package com.ergun.vetapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentDate; // Randevu tarihi ve saati
    private String reason; // Muayene sebebi (Aşı, Kontrol vb.)

    @ManyToOne // Birçok randevu bir pete ait olabilir
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Appointment() {}

    // Getter ve Setter'lar
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDateTime appointmentDate) { this.appointmentDate = appointmentDate; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }
}