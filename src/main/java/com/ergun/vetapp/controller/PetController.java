package com.ergun.vetapp.controller;

import com.ergun.vetapp.entity.Pet;
import com.ergun.vetapp.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}