package com.example.jpadto.score.application;

import com.example.jpadto.exceptions.UnprocesableException;
import com.example.jpadto.persona.infraestructure.dto.input.InputDTOPersona;
import com.example.jpadto.score.application.port.scoreService;
import com.example.jpadto.score.domain.score;
import com.example.jpadto.score.infraestructure.dto.input.inputDTOscore;
import com.example.jpadto.score.infraestructure.dto.output.outputDTOscore;
import com.example.jpadto.score.infraestructure.repository.ScoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class scoreServiceImplements implements scoreService {

    @Autowired
    ScoreRepository scoreRepository;
    @Autowired
    private ModelMapper modelMapper;

    public outputDTOscore anadirScore(@RequestBody inputDTOscore dtOscore) throws Exception {
        score Escore = modelMapper.map(dtOscore,score.class);

        return modelMapper.map(scoreRepository.save(Escore), outputDTOscore.class);
    }

    public outputDTOscore getElementbyId(String id){
        return modelMapper.map(scoreRepository.findById(id).orElseThrow(
                ()->new UnprocesableException("score no existe")) , outputDTOscore.class);
    }

    public outputDTOscore actualiza(@RequestBody inputDTOscore SCORE) throws Exception {
        score ent = modelMapper.map(SCORE, score.class);
        return (modelMapper.map(scoreRepository.save(ent),outputDTOscore.class));
    }

    public void deleteById(@PathVariable String id) throws Exception{
        scoreRepository.findById(id).orElseThrow(()-> new UnprocesableException("El score" + id + " no existe."));
        scoreRepository.deleteById(id);
    }

}
