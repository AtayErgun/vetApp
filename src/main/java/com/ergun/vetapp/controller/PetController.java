package com.ergun.vetapp.controller;

import com.ergun.vetapp.entity.Pet;
import com.ergun.vetapp.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "http://localhost:5173") // React'e izin ver
public class PetController {
    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public List<Pet> getAllPets() { return petRepository.findAll(); }

    @PostMapping
    public Pet addPet(@RequestBody Pet pet) { return petRepository.save(pet); }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petRepository.deleteById(id);
    }

    @GetMapping("/stats")
    public Map<String, Long> getStats() {
        long petCount = petRepository.count();
        // Randevu sayısını da buradan veya AppointmentRepository'den alabiliriz
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalPets", petCount);
        return stats;
    }
}