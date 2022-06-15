package com.example.jpadto.topic.application.port;

import com.example.jpadto.topic.infraestructure.dto.input.inputDTOtopic;
import com.example.jpadto.topic.infraestructure.dto.output.outputDTOtopic;

public interface topicService {
    public outputDTOtopic crearTopic(inputDTOtopic dtotopic) throws Exception;
}
