package br.com.consoli.animal_registration.controllers;

import br.com.consoli.animal_registration.entities.Animal;
import br.com.consoli.animal_registration.repository.AnimalRepository;
import br.com.consoli.animal_registration.services.AnimalService; // Importando o AnimalService
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalRepository repository;
    private final AnimalService animalService; // Adicionando a variável para AnimalService

    // Injetando o AnimalService no construtor
    public AnimalController(AnimalRepository repository, AnimalService animalService) {
        this.repository = repository;
        this.animalService = animalService; // Inicializando o AnimalService
    }

    @GetMapping
    public List<Animal> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        return repository.save(animal);
    }

    @GetMapping("/not-adopted/{tipo}")
    public List<Animal> findNotAdoptedByType(@PathVariable String tipo) {
        return repository.findNotAdoptedByType(tipo);
    }

    @GetMapping("/adopted/{tipo}")
    public List<Animal> findAdoptedByType(@PathVariable String tipo) {
        return repository.findAdoptedByType(tipo);
    }

    @GetMapping("/rescates")
    public Map<String, Long> getRescuedAnimalsCount(
            @RequestParam String startDate,
            @RequestParam String endDate) {

        return animalService.getRescuedAnimalsCount(startDate, endDate);
    }
}
