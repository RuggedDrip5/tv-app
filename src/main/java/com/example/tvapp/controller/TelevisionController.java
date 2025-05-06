package com.example.tvapp.controller;

import com.example.tvapp.model.Television;
import com.example.tvapp.service.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/televisions")
public class TelevisionController {
    private final TelevisionService service;

    public TelevisionController(TelevisionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Television> getAllTelevisions() {
        return service.getAllTelevisions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable Long id) {
        return service.getTelevisionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Television> createTelevision(@RequestBody Television television) {
        Television saved = service.createTelevision(television);
        return ResponseEntity.created(URI.create("/api/televisions/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television television) {
        return ResponseEntity.ok(service.updateTelevision(id, television));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        service.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }
}