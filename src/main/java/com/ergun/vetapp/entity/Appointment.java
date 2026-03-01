package com.ergun.vetapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime; // Tarih ve Saat
    private String reason;          // Muayene nedeni

    @ManyToOne
    @JoinColumn(name = "pet_id") // Veritabanında pet_id sütunu oluşturur
    private Pet pet;
    private String status = "Planlandı"; // Varsayılan değer

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }
}