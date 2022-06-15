package com.example.jpadto.score.infraestructure.repository;

import com.example.jpadto.score.domain.score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<score,String> {
}
