package com.example.jpadto.student.infraestructure.controller;


import com.example.jpadto.alumnos_estudios.infraestructure.dto.output.OutputDTOAlumnos_estudios;
import com.example.jpadto.application.UsuarioServicioInterface;
import com.example.jpadto.student.application.port.StudentInterface;
import com.example.jpadto.student.infraestructure.dto.output.Student.OutputDTOStudent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EstudianteG")
public class GetEstudianteCrontrolador {

    @Autowired
    private StudentInterface studentInterface;
    @Autowired
    private UsuarioServicioInterface usuarioServicio;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getEstudiante/{id}")
    public Object getEstudiante(@PathVariable String id, @RequestParam String queryParam) throws Exception {
        Object h = studentInterface.getEstudiante(id);
        if (!queryParam.equals("full")){
            OutputDTOStudent out = new OutputDTOStudent();
            out.setId_student(id);
            Object nuevo = modelMapper.map(out,OutputDTOStudent.class);
            return nuevo;
        }
        return h;
    }

    @GetMapping("/getTopic/{id}")
    public ResponseEntity<List<OutputDTOAlumnos_estudios>> getAsignaturas(@PathVariable String id)throws  Exception{
        return ResponseEntity.ok().body(usuarioServicio.getAsignaturas(id));
    }

}
