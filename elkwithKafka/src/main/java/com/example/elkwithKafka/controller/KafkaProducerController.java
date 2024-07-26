package com.example.elkwithKafka.controller;

import com.example.elkwithKafka.model.User;
import com.example.elkwithKafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaProducerController {
    @Autowired
    KafkaService kafkaProducer;

    @PostMapping("/producer")
    public String sendMessage(@RequestBody User user) {
        kafkaProducer.send(user);
        return "Message sent successfully to the Kafka topic elk";
    }

    @PostMapping("/producerlist")
    public String sendMessage(@RequestBody List<User> user) {
        kafkaProducer.sendList(user);
        return "Message sent successfully to the Kafka topic elk";
    }
}
