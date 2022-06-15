package com.example.jpadto.alumnos_estudios.infraestructure.controller;

import com.example.jpadto.alumnos_estudios.application.port.alumnos_estudiosService;
import com.example.jpadto.alumnos_estudios.infraestructure.dto.input.InputDTOAlumnos_estudios;
import com.example.jpadto.alumnos_estudios.infraestructure.dto.output.OutputDTOAlumnos_estudios;
import com.example.jpadto.topic.infraestructure.dto.input.inputDTOtopic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/AEstudios")
public class alumnos_estudiosController {
    @Autowired
    alumnos_estudiosService AEservice;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/anadeTopic/{id}") //esto asigna todos los topics actuales a un alumnos estudios
    public ResponseEntity<OutputDTOAlumnos_estudios> anadeTopic(@PathVariable String id, @RequestBody inputDTOtopic topic) throws Exception{
        return ResponseEntity.ok().body(AEservice.anadeTopic(id, topic));
    }

    @PostMapping("/anadeAE")
    public ResponseEntity<OutputDTOAlumnos_estudios> anadeAE(@RequestBody InputDTOAlumnos_estudios dto){
        OutputDTOAlumnos_estudios out = AEservice.anadeAE(dto);
        return ResponseEntity.ok().body(out);
    }

}
