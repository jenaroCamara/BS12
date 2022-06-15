package com.example.jpadto.topic.infraestructure.repository;

import com.example.jpadto.topic.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,String> {
}
