package com.example.jpadto.alumnos_estudios.application;

import com.example.jpadto.alumnos_estudios.application.port.alumnos_estudiosService;
import com.example.jpadto.alumnos_estudios.domain.Alumnos_Estudios;
import com.example.jpadto.alumnos_estudios.infraestructure.dto.input.InputDTOAlumnos_estudios;
import com.example.jpadto.alumnos_estudios.infraestructure.dto.output.OutputDTOAlumnos_estudios;
import com.example.jpadto.alumnos_estudios.infraestructure.repository.alumnos_estudiosRepository;
import com.example.jpadto.exceptions.UnprocesableException;
import com.example.jpadto.student.domain.Student;
import com.example.jpadto.student.infraestructure.repository.EstudianteRepositorio;
import com.example.jpadto.topic.domain.Topic;
import com.example.jpadto.topic.infraestructure.dto.input.inputDTOtopic;
import com.example.jpadto.topic.infraestructure.repository.TopicRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class alumnos_estudiosServiceImplements implements alumnos_estudiosService {
    @Autowired
    alumnos_estudiosRepository AErepository;
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    EstudianteRepositorio estudianteRepositorio;

    public OutputDTOAlumnos_estudios anadeAE(InputDTOAlumnos_estudios dto){
        Alumnos_Estudios AE = modelMapper.map(dto,Alumnos_Estudios.class);
        Student estudent = estudianteRepositorio.findById(dto.getStudent()).orElseThrow(()->new UnprocesableException("No se encuentra el estudiante"));
        Topic topic = topicRepository.findById(dto.getId_topic()).orElseThrow(()->new UnprocesableException("No se encuentra la asignatura"));
        AE.setId_topic(topic); AE.setStudent(estudent);
        Alumnos_Estudios e = AErepository.save(AE);
        return modelMapper.map(e,OutputDTOAlumnos_estudios.class);
    }
    public OutputDTOAlumnos_estudios anadeTopic(String id, inputDTOtopic topic) throws Exception{
        Alumnos_Estudios AE= AErepository.findById(id).orElseThrow(()->new UnprocesableException("Alumnos Estudios no existe"));
        Topic top = modelMapper.map(topic,Topic.class);
        AE.setId_topic(top);
        return modelMapper.map(AE,OutputDTOAlumnos_estudios.class);
    }

}
