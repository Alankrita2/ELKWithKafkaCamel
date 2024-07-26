package com.example.elkKafkaCon.controller;

import com.example.elkKafkaCon.model.User;
import com.example.elkKafkaCon.service.KafkaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class KafkaConsumerController {

    @Autowired
    KafkaConsumerService kafkaConsumerService;

    @KafkaListener(topics = "elk", groupId = "elk-group")
    public void listen(User user) {
        System.out.println("Received User information : " + user.toString());
        try {
            kafkaConsumerService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/getElasticUserFromKafka")
    public Iterable<User> findAllUser() {
        return kafkaConsumerService.findAllUsers();
    }

    @GetMapping("/getElasticUserFromKafka/{id}")
    public Optional<User> findById(@PathVariable int id){
        return kafkaConsumerService.findById(id);
    }

    @DeleteMapping("/deleteElasticUserFromKafka/{id}")
    public void deleteById(@PathVariable int id){
        kafkaConsumerService.deleteById(id);
    }

    @DeleteMapping("/deleteElasticUserFromKafka")
    public void deleteAll(){
        kafkaConsumerService.deleteAll();
    }

}
