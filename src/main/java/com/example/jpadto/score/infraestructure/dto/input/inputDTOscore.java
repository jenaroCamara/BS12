package com.example.jpadto.score.infraestructure.dto.input;

import lombok.Data;

import java.util.Date;

@Data
public class inputDTOscore {
    String id_score;
    String id_student;
    String id_registry_type;
    float note;
    String branch;
    String id_topic;
    String coment;
    Date creationDate;
}
