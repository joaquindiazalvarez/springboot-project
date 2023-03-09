package com.example.services;

import com.example.models.Animal;
import com.example.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    public void addAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void updateAnimal(Long id, Animal animal) {
        Optional<Animal> existingAnimalOptional = animalRepository.findById(id);
        if (existingAnimalOptional.isPresent()) {
            Animal existingAnimal = existingAnimalOptional.get();
            existingAnimal.setType(animal.getType());
            existingAnimal.setState(animal.getState());
            animalRepository.save(existingAnimal);
        }
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}
