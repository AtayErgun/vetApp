package com.ergun.vetapp.repository;

import com.ergun.vetapp.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    boolean existsByDateTimeBetween(LocalDateTime start, LocalDateTime end);

}
