package com.example.jpadto.persona.application.port;

import com.example.jpadto.alumnos_estudios.infraestructure.dto.output.OutputDTOAlumnos_estudios;
import com.example.jpadto.persona.infraestructure.dto.output.OutputDTOpersonafull;
import com.example.jpadto.profesor.infraestructure.dto.input.InputDTOProfesor;
import com.example.jpadto.student.infraestructure.dto.input.InputDTOStudent;
import com.example.jpadto.persona.infraestructure.dto.input.InputDTOPersona;
import com.example.jpadto.profesor.infraestructure.dto.output.OutputDTOProfesor;
import com.example.jpadto.student.infraestructure.dto.output.Student.OutputDTOStudent;
import com.example.jpadto.persona.infraestructure.dto.output.OutputDTOPersona;
import com.example.jpadto.student.infraestructure.dto.output.Student.OutputDTOStudentFull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UsuarioServicioInterface {
    public OutputDTOPersona guardar(InputDTOPersona persona) throws Exception;
    public List<Object> getUsuarios(String queryParam);
    public List<OutputDTOpersonafull> getall();
    public List<Object> getUsuariosByName(@PathVariable String nombre, String queryParam)throws Exception;
    public OutputDTOpersonafull getUserById(String id) throws Exception;
    public InputDTOPersona actualiza(@RequestBody InputDTOPersona usuario) throws Exception;
    public void deleteById(String id) throws Exception;
    public List<OutputDTOAlumnos_estudios> getAsignaturas(String id) throws Exception;
    public OutputDTOAlumnos_estudios eliminaTopic(String id, String id_topic) throws Exception;
}
