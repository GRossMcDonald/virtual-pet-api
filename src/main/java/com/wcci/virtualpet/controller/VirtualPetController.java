package com.wcci.virtualpet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualpet.entity.VirtualPet;
import com.wcci.virtualpet.service.VirtualPetService;

@RestController
@RequestMapping("/api/virtualpets")
public class VirtualPetController {

    @Autowired
    private VirtualPetService virtualPetService;

    @GetMapping("/ping")
    public ResponseEntity<String> pingPong() {
        return ResponseEntity.ok("pong");
    }

    @PostMapping
    public ResponseEntity<VirtualPet> addPet(@RequestBody VirtualPet pet) {
        VirtualPet createdPet = virtualPetService.createPet(pet);
        return new ResponseEntity<>(createdPet, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VirtualPet>> findAllPets() {
        List<VirtualPet> pets = virtualPetService.getAllPets();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findPetById(@PathVariable Long id) {
        VirtualPet foundPet = virtualPetService.getPetById(id);
        String errorMessage = "Error: Pet with ID " + id + " cannot be found.";
        if (foundPet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }

        return ResponseEntity.ok(foundPet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePet(@PathVariable Long id) {
        boolean isDeleted = virtualPetService.deletePet(id);

        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.noContent().build();
    }
}
