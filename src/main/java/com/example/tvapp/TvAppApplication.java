package com.example.tvapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TvAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(TvAppApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "TV Application is running!";
    }
}