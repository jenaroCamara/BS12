package com.example.jpadto.topic.infraestructure.controller;

import com.example.jpadto.topic.application.TopicServiceImplements;
import com.example.jpadto.topic.infraestructure.dto.input.inputDTOtopic;
import com.example.jpadto.topic.infraestructure.dto.output.outputDTOtopic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class topicController {

    @Autowired
    TopicServiceImplements topicServiceImplements;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/crearTopic")
    public ResponseEntity<outputDTOtopic> crearTopic(@RequestBody inputDTOtopic dtotopic) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(topicServiceImplements.crearTopic(dtotopic));
    }
}
