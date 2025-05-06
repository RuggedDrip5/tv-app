package com.example.tvapp.service;

import com.example.tvapp.exception.InvalidDataException;
import com.example.tvapp.exception.ResourceNotFoundException;
import com.example.tvapp.model.Television;
import com.example.tvapp.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {
    private final TelevisionRepository repository;

    public TelevisionService(TelevisionRepository repository) {
        this.repository = repository;
    }

    public List<Television> getAllTelevisions() {
        return repository.findAll();
    }

    public Optional<Television> getTelevisionById(Long id) {
        return repository.findById(id);
    }

    public Television createTelevision(Television television) {
        if (television.getBrand() == null || television.getBrand().isEmpty()) {
            throw new InvalidDataException("Brand cannot be empty");
        }
        // Добавьте другие проверки по необходимости

        return repository.save(television);
    }

    public Television updateTelevision(Long id, Television updatedTelevision) {
        return repository.findById(id)
                .map(television -> {
                    television.setBrand(updatedTelevision.getBrand());
                    television.setModel(updatedTelevision.getModel());
                    television.setPrice(updatedTelevision.getPrice());
                    television.setScreenSize(updatedTelevision.getScreenSize());
                    television.setResolution(updatedTelevision.getResolution());
                    television.setSmartTv(updatedTelevision.isSmartTv());
                    return repository.save(television);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Television not found with id: " + id));
    }

    public void deleteTelevision(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Television not found with id: " + id);
        }
        repository.deleteById(id);
    }
}