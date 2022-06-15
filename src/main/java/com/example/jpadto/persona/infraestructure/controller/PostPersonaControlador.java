package com.example.jpadto.persona.infraestructure.controller;

import com.example.jpadto.persona.infraestructure.dto.input.InputDTOPersona;
import com.example.jpadto.persona.infraestructure.dto.output.OutputDTOPersona;
import com.example.jpadto.persona.application.port.UsuarioServicioInterface;
import com.example.jpadto.persona.infraestructure.dto.output.OutputDTOpersonafull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/Usuario")
//@RequestMapping("/Persona")
public class PostPersonaControlador {

    @Autowired
    private UsuarioServicioInterface usuarioServicio;
    @Autowired
    private ModelMapper modelMapper;

    @CrossOrigin(origins="https://cdpn.io")
    @PostMapping("/addperson")
    public ResponseEntity<OutputDTOPersona> anadirUsuario(@RequestBody @Valid InputDTOPersona DTOusu) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServicio.guardar(DTOusu));
    }

    @CrossOrigin(origins="https://cdpn.io")
    @GetMapping("/getall")
    public ResponseEntity<List<OutputDTOpersonafull>> getUsuarios() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.getall());
    }
    //http://localhost:8080/getall

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
