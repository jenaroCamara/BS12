package com.example.jpadto.score.application.port;

import com.example.jpadto.score.infraestructure.dto.input.inputDTOscore;
import com.example.jpadto.score.infraestructure.dto.output.outputDTOscore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface scoreService {
    public outputDTOscore anadirScore(@RequestBody inputDTOscore dtOscore) throws Exception;
    public outputDTOscore getElementbyId(@PathVariable String id) throws Exception;
    public outputDTOscore actualiza(@RequestBody inputDTOscore SCORE) throws Exception;
    public void deleteById(@PathVariable String id) throws Exception;
}
