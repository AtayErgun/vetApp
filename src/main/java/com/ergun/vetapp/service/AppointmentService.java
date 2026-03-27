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
        // Müşterinin seçtiği tarih
        LocalDateTime requestedTime = LocalDateTime.parse(request.getDateTime());

        // 30 dakikalık koruma kalkanı oluşturuyoruz
        LocalDateTime bufferStart = requestedTime.minusMinutes(30);
        LocalDateTime bufferEnd = requestedTime.plusMinutes(30);

        // Veritabanında bu 1 saatlik dilimde (30 dk önce - 30 dk sonra) randevu var mı?
        // Not: existsByDateTimeBetween (başlangıç ve bitiş dahil) kontrolü yapar.
        if (appointmentRepository.existsByDateTimeBetween(bufferStart, bufferEnd)) {
            throw new RuntimeException("Seçtiğiniz saat diğer randevularla çakışıyor. " +
                    "Lütfen en az 30 dakika öncesini veya sonrasını seçiniz.");
        }

        // Çakışma yoksa Pet ve Randevu oluşturma işlemlerine devam et...
        Pet tempPet = new Pet();
        tempPet.setName(request.getPetName());
        tempPet.setType(request.getPetType());
        tempPet.setBreed("Dış Kayıt");
        petRepository.save(tempPet);

        Appointment appointment = new Appointment();
        appointment.setDateTime(requestedTime);
        appointment.setReason(request.getReason());
        appointment.setStatus("Onay Bekliyor");
        appointment.setPet(tempPet);

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Transactional
    public Appointment updateStatus(Long id, String status) {
        Appointment app = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Randevu bulunamadı"));
        app.setStatus(status);
        return appointmentRepository.save(app);
    }
}