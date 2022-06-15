package com.example.jpadto.student.infraestructure.dto.input;

import com.example.jpadto.alumnos_estudios.infraestructure.dto.input.InputDTOAlumnos_estudios;
import lombok.Data;


@Data
public class InputDTOStudent {
    private int persona;
    private int num_hours_week;
    private String profesor;
    String branch;
    private InputDTOAlumnos_estudios asignaturas;
}
