package com.ergun.vetapp.service;

import com.ergun.vetapp.dto.PublicAppointmentRequest;
import com.ergun.vetapp.entity.Appointment;
import com.ergun.vetapp.entity.Pet;
import com.ergun.vetapp.repository.AppointmentRepository;
import com.ergun.vetapp.repository.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PetRepository petRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, PetRepository petRepository) {
        this.appointmentRepository = appointmentRepository;
        this.petRepository = petRepository;
    }

    @Transactional
    public Appointment createPublicAppointment(PublicAppointmentRequest request) {
        Pet tempPet = new Pet();
        tempPet.setName(request.getPetName());
        tempPet.setType(request.getPetType());
        tempPet.setBreed("Dış Kayıt");
        petRepository.save(tempPet);

        Appointment appointment = new Appointment();
        appointment.setDateTime(LocalDateTime.parse(request.getDateTime()));
        appointment.setReason(request.getReason());
        appointment.setStatus("Onay Bekliyor");
        appointment.setPet(tempPet);

        return appointmentRepository.save(appointment);
    }
}