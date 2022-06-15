package com.example.jpadto.score.infraestructure.dto.output;

import com.example.jpadto.registry_type.domain.Registry_type;
import com.example.jpadto.student.domain.Student;
import com.example.jpadto.topic.domain.Topic;
import lombok.Data;

import java.util.Date;

@Data
public class outputDTOscore {
    String id_score;
    String id_student;
    Registry_type id_registry_type;
    float note;
    String branch;
    String coment;
    Date creationDate;
}
