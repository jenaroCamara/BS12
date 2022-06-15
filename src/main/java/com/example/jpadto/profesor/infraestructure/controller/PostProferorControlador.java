package com.example.jpadto.profesor.infraestructure.controller;

import com.example.jpadto.profesor.application.port.ProfesorInterface;
import com.example.jpadto.profesor.infraestructure.dto.input.InputDTOProfesor;
import com.example.jpadto.profesor.infraestructure.dto.output.OutputDTOProfesor;
import com.example.jpadto.persona.application.port.UsuarioServicioInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/Profesor")
public class PostProferorControlador {
    @Autowired
    private UsuarioServicioInterface usuarioServicio;
    @Autowired
    private ProfesorInterface profesorInterface;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/anadirProfesor")//Dejo esta función así, hasta ver si las validation van en dto o en las entidades
    public ResponseEntity<OutputDTOProfesor> anadirProfesor(@RequestBody @Valid InputDTOProfesor DTOprofesor) throws Exception {
        OutputDTOProfesor profesor = profesorInterface.guardarProfesor(DTOprofesor);
        return ResponseEntity.status(HttpStatus.CREATED).body(profesor);
    }
}
