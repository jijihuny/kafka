package com.jijihuny.project.kafka.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    
    private final static Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    private final static String TOPIC = "kafka-demo";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {   

        logger.info("Produce message : {}", message);

        this.kafkaTemplate.send(TOPIC, message);
    }
}
