package com.example.jpadto.profesor.application.port;

import com.example.jpadto.profesor.infraestructure.dto.input.InputDTOProfesor;
import com.example.jpadto.profesor.infraestructure.dto.output.OutputDTOProfesor;

public interface ProfesorInterface {
    public OutputDTOProfesor guardarProfesor(InputDTOProfesor profesor) throws Exception;
    public OutputDTOProfesor getProfesor(String id) throws Exception;
}
