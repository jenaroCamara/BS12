package com.example.jpadto.profesor.infraestructure.dto.input;

import com.example.jpadto.alumnos_estudios.infraestructure.dto.input.InputDTOAlumnos_estudios;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class InputDTOProfesor {
    private int id_profesor;
    @NotNull
    private String persona;
    @NotNull
    private String coments;
    @NotNull
    private String branch;
    @NotNull
    private InputDTOAlumnos_estudios asignaturas;
}
