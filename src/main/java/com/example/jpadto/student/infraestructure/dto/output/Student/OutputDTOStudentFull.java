package com.example.jpadto.student.infraestructure.dto.output.Student;

import com.example.jpadto.alumnos_estudios.domain.Alumnos_Estudios;
import com.example.jpadto.persona.infraestructure.dto.output.OutputDTOPersona;
import com.example.jpadto.profesor.infraestructure.dto.output.OutputDTOprofesorNC;
import lombok.Data;

import java.util.List;

@Data
public class OutputDTOStudentFull extends OutputDTOStudent {
    private OutputDTOPersona persona;
    private int num_hours_week;
    private OutputDTOprofesorNC profesor;
    String branch;
    List<Alumnos_Estudios> asignaturas;
}
