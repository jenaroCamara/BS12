package com.example.jpadto.profesor.infraestructure.dto.output;

import com.example.jpadto.persona.infraestructure.dto.output.OutputDTOPersona;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OutputDTOProfesor {
    private String id_profesor;
    private OutputDTOPersona persona;
    private String coments;
    private String branch;
}
