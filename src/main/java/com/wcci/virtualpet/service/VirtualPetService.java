package com.wcci.virtualpet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcci.virtualpet.entity.VirtualPet;
import com.wcci.virtualpet.repository.VirtualPetRepository;

@Service
public class VirtualPetService {
    @Autowired
    private VirtualPetRepository virtualPetRepository;

    public VirtualPet createPet(VirtualPet pet) {
        return virtualPetRepository.save(pet);
    }

    public List<VirtualPet> getAllPets() {
        return virtualPetRepository.findAll();
    }

    public VirtualPet getPetById(Long id) {
        return virtualPetRepository.findById(id).orElse(null);
    }

    public boolean deletePet(Long id) {
        if (!virtualPetRepository.existsById(id)) {
            return false;
        }

        virtualPetRepository.deleteById(id);
        return true;
    }

}
