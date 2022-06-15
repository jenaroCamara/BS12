package com.example.jpadto.score.infraestructure.controller;

import com.example.jpadto.persona.infraestructure.dto.input.InputDTOPersona;
import com.example.jpadto.score.application.scoreServiceImplements;
import com.example.jpadto.score.infraestructure.dto.input.inputDTOscore;
import com.example.jpadto.score.infraestructure.dto.output.outputDTOscore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
public class scoreController {

    @Autowired
    scoreServiceImplements scoreService;

    @PostMapping("/anadirScore")
    public ResponseEntity<outputDTOscore> anadirScore(@RequestBody inputDTOscore dtOscore) throws Exception {
        outputDTOscore score = scoreService.anadirScore(dtOscore);
        return ResponseEntity.status(HttpStatus.CREATED).body(score);
    }

    @GetMapping("/getScore/{id}")
    public  ResponseEntity<outputDTOscore> getScore(@PathVariable String id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(scoreService.getElementbyId(id));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<outputDTOscore> actualiza(@RequestBody inputDTOscore SCORE) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(scoreService.actualiza(SCORE));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable String id) throws Exception {
        scoreService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario:"+ id + " borrado");

    }

}
