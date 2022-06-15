package com.example.jpadto.alumnos_estudios.infraestructure.dto.output;

import com.example.jpadto.topic.infraestructure.dto.input.inputDTOtopic;
import lombok.Data;

import java.util.Date;

@Data
public class OutputDTOAlumnos_estudios {
    String id_study;
    inputDTOtopic id_topic;
    String comment;
    Date initial_date;
    Date finish_date;
}
