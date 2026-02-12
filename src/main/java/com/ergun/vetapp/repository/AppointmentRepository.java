package com.ergun.vetapp.repository;

import com.ergun.vetapp.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
