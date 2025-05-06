package com.example.tvapp.repository;

import com.example.tvapp.model.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelevisionRepository extends JpaRepository<Television, Long> {
}