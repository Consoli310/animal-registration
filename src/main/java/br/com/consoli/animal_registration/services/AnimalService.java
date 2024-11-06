package br.com.consoli.animal_registration.services;

import br.com.consoli.animal_registration.entities.Animal;
import br.com.consoli.animal_registration.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    // Método para buscar todos os animais
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    // Método para criar um novo animal
    public Animal create(Animal animal) {
        return animalRepository.save(animal);
    }

    // Método para buscar animais não adotados por tipo
    public List<Animal> findNotAdoptedByType(String tipo) {
        return animalRepository.findNotAdoptedByType(tipo);
    }

    // Método para buscar animais adotados por tipo
    public List<Animal> findAdoptedByType(String tipo) {
        return animalRepository.findAdoptedByType(tipo);
    }

    public Map<String, Long> getRescuedAnimalsCount(String startDateStr, String endDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Formato de data
        LocalDate startDate;
        LocalDate endDate;

        try {
            startDate = LocalDate.parse(startDateStr, formatter);
            endDate = LocalDate.parse(endDateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data inválida. Use o formato yyyy-MM-dd.", e);
        }

        List<Object[]> result = animalRepository.countAnimalsRescuedByEmployee(startDate, endDate);

        Map<String, Long> rescuedCountMap = new HashMap<>();
        for (Object[] record : result) {
            String nomeRecebedor = (String) record[0];
            Long count = (Long) record[1];
            rescuedCountMap.put(nomeRecebedor, count);
        }

        return rescuedCountMap;
    }
    }

