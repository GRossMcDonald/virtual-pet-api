package com.wcci.virtualpet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wcci.virtualpet.entity.VirtualPet;
import com.wcci.virtualpet.repository.VirtualPetRepository;

@Component
public class LoadDatabase implements CommandLineRunner {
    @Autowired
    private VirtualPetRepository virtualPetRepository;

    @Override
    public void run(String... args) throws Exception {
        virtualPetRepository.deleteAll();

        VirtualPet pet1 = new VirtualPet("Useless", "Useless animal.", 100, 100, 100);
        VirtualPet pet2 = new VirtualPet("Dummy", "Dumb animal.", 100, 100, 100);
        VirtualPet pet3 = new VirtualPet("Cripple", "Crippled animal.", 100, 100, 100);
        VirtualPet pet4 = new VirtualPet("Lazy", "Lazy animal.", 100, 100, 100);
        VirtualPet pet5 = new VirtualPet("Annoying", "Annoying animal.", 100, 100, 100);

        virtualPetRepository.save(pet1);
        virtualPetRepository.save(pet2);
        virtualPetRepository.save(pet3);
        virtualPetRepository.save(pet4);
        virtualPetRepository.save(pet5);
    }
}
