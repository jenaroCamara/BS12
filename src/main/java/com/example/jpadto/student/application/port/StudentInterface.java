package com.example.jpadto.student.application.port;

import com.example.jpadto.student.infraestructure.dto.input.InputDTOStudent;
import com.example.jpadto.student.infraestructure.dto.output.Student.OutputDTOStudent;
import com.example.jpadto.student.infraestructure.dto.output.Student.OutputDTOStudentFull;

public interface StudentInterface {
    public OutputDTOStudent guardarEstudiante(InputDTOStudent dtoStudent);
    public OutputDTOStudentFull getEstudiante(String id);
    public OutputDTOStudentFull actualizaTopics(String id) throws Exception;
}
