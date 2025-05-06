package com.example.tvapp.service;

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
                .orElseGet(() -> {
                    updatedTelevision.setId(id);
                    return repository.save(updatedTelevision);
                });
    }

    public void deleteTelevision(Long id) {
        repository.deleteById(id);
    }
}