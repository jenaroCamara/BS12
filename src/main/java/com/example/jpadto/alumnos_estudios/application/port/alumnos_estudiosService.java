package com.example.jpadto.alumnos_estudios.application.port;

import com.example.jpadto.alumnos_estudios.infraestructure.dto.input.InputDTOAlumnos_estudios;
import com.example.jpadto.alumnos_estudios.infraestructure.dto.output.OutputDTOAlumnos_estudios;
import com.example.jpadto.topic.infraestructure.dto.input.inputDTOtopic;

public interface alumnos_estudiosService {
    public OutputDTOAlumnos_estudios anadeAE(InputDTOAlumnos_estudios dto);
    public OutputDTOAlumnos_estudios anadeTopic( String id, inputDTOtopic topic)  throws Exception;
}
