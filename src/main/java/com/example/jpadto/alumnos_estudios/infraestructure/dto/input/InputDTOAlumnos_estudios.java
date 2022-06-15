package com.example.jpadto.alumnos_estudios.infraestructure.dto.input;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class InputDTOAlumnos_estudios {
    int id_study;
    @NotNull
    String student;
    @NotNull
    String id_topic;
    @NotNull
    String comment;
    Date initial_date;
    Date finish_date;
}
