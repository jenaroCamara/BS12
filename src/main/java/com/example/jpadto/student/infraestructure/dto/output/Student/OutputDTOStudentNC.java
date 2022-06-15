package com.example.jpadto.student.infraestructure.dto.output.Student;

import com.example.jpadto.alumnos_estudios.domain.Alumnos_Estudios;
import com.example.jpadto.persona.domain.Persona;
import com.example.jpadto.profesor.domain.Profesor;

import java.util.List;

public class OutputDTOStudentNC {
    private int num_hours_week;
    private Profesor profesor;
    String branch;
    List<Alumnos_Estudios> asignaturas;//-->MIRARCICLICA
}
