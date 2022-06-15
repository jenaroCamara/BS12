package com.example.jpadto.student.application;

import com.example.jpadto.alumnos_estudios.application.port.alumnos_estudiosService;
import com.example.jpadto.alumnos_estudios.domain.Alumnos_Estudios;
import com.example.jpadto.exceptions.BeanNotFoundException;
import com.example.jpadto.exceptions.UnprocesableException;
import com.example.jpadto.persona.domain.Persona;
import com.example.jpadto.persona.infraestructure.repository.PersonaRepositorio;
import com.example.jpadto.student.application.port.StudentInterface;
import com.example.jpadto.student.domain.Student;
import com.example.jpadto.student.infraestructure.dto.input.InputDTOStudent;
import com.example.jpadto.student.infraestructure.dto.output.Student.OutputDTOStudent;
import com.example.jpadto.student.infraestructure.dto.output.Student.OutputDTOStudentFull;
import com.example.jpadto.student.infraestructure.repository.EstudianteRepositorio;
import com.example.jpadto.topic.domain.Topic;
import com.example.jpadto.topic.infraestructure.dto.input.inputDTOtopic;
import com.example.jpadto.topic.infraestructure.repository.TopicRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StudentInterfaceImplements implements StudentInterface {

    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    EstudianteRepositorio estudianteRepositorio;
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    alumnos_estudiosService AEservice;

    //---------------------------Estudiante--------------------
    public OutputDTOStudent guardarEstudiante(InputDTOStudent dtoStudent) {
        Persona persona = personaRepositorio.findById(dtoStudent.getPersona()).orElseThrow(
                () -> new UnprocesableException("Error, la persona con id: " + dtoStudent.getPersona() + ", no se encuentra"));

        if (persona.getProfesor() != null) {
            throw new BeanNotFoundException("Error, el usuario no puede ser 2 cosas a la vez");
        }
        Student estudiante = modelMapper.map(dtoStudent, Student.class);
        estudiante.setPersona(persona);
        estudiante.setAsignaturas(new ArrayList<>());
        estudianteRepositorio.save(estudiante);
        return modelMapper.map(estudiante, OutputDTOStudent.class);
    }

    public OutputDTOStudentFull getEstudiante(String id) {
        Student estudent = estudianteRepositorio.findById(id).orElseThrow(() -> new UnprocesableException("Usuario no encontrado"));
        OutputDTOStudentFull h = modelMapper.map(estudent, OutputDTOStudentFull.class);
        return h;
    }

    public OutputDTOStudentFull actualizaTopics(String id) throws Exception {
        List<Topic> lista = topicRepository.findAll();
        for(int i=0; i < lista.size(); i++){
            AEservice.anadeTopic(id,modelMapper.map(lista.get(i), inputDTOtopic.class));
        }
        Student estudiante = estudianteRepositorio.findById(id).orElseThrow(() -> new UnprocesableException("estudiante no encontrado"));
        return modelMapper.map(estudiante, OutputDTOStudentFull.class);
    }
}
