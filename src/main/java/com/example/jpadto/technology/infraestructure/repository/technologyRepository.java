package com.example.jpadto.technology.infraestructure.repository;

import com.example.jpadto.technology.domain.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface technologyRepository extends JpaRepository<Technology,String> {
}
