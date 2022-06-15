package com.example.jpadto.application;

import com.example.jpadto.alumnos_estudios.application.port.alumnos_estudiosService;
import com.example.jpadto.alumnos_estudios.infraestructure.dto.output.OutputDTOAlumnos_estudios;
import com.example.jpadto.persona.infraestructure.dto.output.OutputDTOpersonafull;
import com.example.jpadto.profesor.domain.Profesor;
import com.example.jpadto.student.domain.Student;
import com.example.jpadto.exceptions.BeanNotFoundException;
import com.example.jpadto.exceptions.UnprocesableException;
import com.example.jpadto.profesor.infraestructure.dto.input.InputDTOProfesor;
import com.example.jpadto.student.infraestructure.dto.input.InputDTOStudent;
import com.example.jpadto.persona.infraestructure.dto.input.InputDTOPersona;
import com.example.jpadto.persona.domain.Persona;
import com.example.jpadto.profesor.infraestructure.dto.output.OutputDTOProfesor;
import com.example.jpadto.student.infraestructure.dto.output.Student.OutputDTOStudent;
import com.example.jpadto.persona.infraestructure.dto.output.OutputDTOPersona;
import com.example.jpadto.student.infraestructure.dto.output.Student.OutputDTOStudentFull;
import com.example.jpadto.student.infraestructure.repository.EstudianteRepositorio;
import com.example.jpadto.profesor.infraestructure.repository.ProfesorRepositorio;
import com.example.jpadto.persona.infraestructure.repository.PersonaRepositorio;
import com.example.jpadto.topic.domain.Topic;
import com.example.jpadto.topic.infraestructure.dto.input.inputDTOtopic;
import com.example.jpadto.topic.infraestructure.repository.TopicRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServicio implements UsuarioServicioInterface {
    @Autowired
    alumnos_estudiosService AEservice;
    @Autowired
    private PersonaRepositorio personaRepositorio;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private ProfesorRepositorio profesorRepositorio;
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    private void comprobaciones(InputDTOPersona persona) {
        String auxName = persona.getUsuario();
        if (auxName.length() < 6 || auxName.length() > 16) {
            throw new BeanNotFoundException("Error al guardar el usuario");
        }
        if (persona.getUsuario() != null && persona.getProfesor() != null) {
            throw new BeanNotFoundException("Error, el usuario no puede ser 2 cosas a la vez");
        }
        if (persona.getUsuario() == null && persona.getProfesor() == null) {
            throw new BeanNotFoundException("Error, el usuario puede ser solo una cosa");
        }
    }

    public OutputDTOPersona guardar(InputDTOPersona persona) throws Exception {
        comprobaciones(persona);
        return modelMapper.map(personaRepositorio.save(modelMapper.map(persona, Persona.class)), OutputDTOPersona.class);
    }

    public List<Object> getUsuarios(String queryParam) {
        Iterable<Persona> iterableUsuario = personaRepositorio.findAll();
        List<Object> ListaDTOs = new ArrayList<>();
        iterableUsuario.forEach((Usuario) -> {
            ListaDTOs.add(modelMapper.map(Usuario, OutputDTOpersonafull.class));
        });
        if (queryParam.equals("full")) {
            List<Object> secondList = ListaDTOs.stream()
                    .map(Usuario -> modelMapper.map(Usuario, OutputDTOPersona.class))
                    .collect(Collectors.toList());
            return (secondList);
        }
        return ListaDTOs;
    }

    public List<Object> getUsuariosByName(@PathVariable String nombre, String queryParam) {
        List<Persona> lista = personaRepositorio.findByName(nombre);
        List<Object> secondList = new ArrayList<>();
        if (queryParam.equals("full")) {
            secondList = lista.stream()
                    .map(Usuario -> modelMapper.map(Usuario, OutputDTOpersonafull.class))
                    .collect(Collectors.toList());
            return (secondList);
        } else {
            secondList = lista.stream()
                    .map(Usuario -> modelMapper.map(Usuario, OutputDTOPersona.class))
                    .collect(Collectors.toList());
        }
        return secondList;
    }

    public OutputDTOpersonafull getUserById(String id) throws Exception {
        Persona persona = personaRepositorio.findById(Integer.parseInt(id)).orElseThrow(() -> new BeanNotFoundException("Usuario no encontrado"));
        OutputDTOpersonafull prueba = modelMapper.map(persona, OutputDTOpersonafull.class);
        return prueba;
    }

    public InputDTOPersona actualiza(@RequestBody InputDTOPersona usuario) throws Exception {
        Persona persona = personaRepositorio.findById(usuario.getId()).orElseThrow(() -> new Exception("Usuario no encontrado"));
        personaRepositorio.save(modelMapper.map(persona, Persona.class));
        return usuario;
    }

    public void deleteById(String id) throws Exception {
        if (!personaRepositorio.findById(Integer.parseInt(id)).isPresent()) {
            throw new UnprocesableException("Usuario no encontrado");
        }
        if(personaRepositorio.findById(Integer.parseInt(id)).get().getProfesor()!=null || personaRepositorio.findById(Integer.parseInt(id)).get().getEstudiante()!=null){
            throw new UnprocesableException("No se puede eliminar porque tiene un profesor o estudiante asignado.");
        }
        personaRepositorio.deleteById(Integer.parseInt(id));
    }

    //alumnos_estudios

    public List<OutputDTOAlumnos_estudios> getAsignaturas(String id) throws Exception{
        Student student = estudianteRepositorio.findById(id).orElseThrow(() -> new UnprocesableException("estudiante no encontrado"));
        return student.getAsignaturas().stream().map(AE->modelMapper.map(AE, OutputDTOAlumnos_estudios.class)).collect(Collectors.toList());
    }

    public OutputDTOAlumnos_estudios eliminaTopic(String id, String id_topic) throws Exception{
        Student estudiante = estudianteRepositorio.findById(id).orElseThrow(()->new UnprocesableException("Estudiante no encontrado"));
        estudiante.getAsignaturas().remove(id_topic);
        return modelMapper.map(estudiante.getAsignaturas(), OutputDTOAlumnos_estudios.class);
    }
}
