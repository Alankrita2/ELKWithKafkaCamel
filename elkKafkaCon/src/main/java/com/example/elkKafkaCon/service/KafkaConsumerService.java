package com.example.elkKafkaCon.service;

import com.example.elkKafkaCon.model.User;
import com.example.elkKafkaCon.repository.KafkaConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaConsumerService {
    @Autowired
    private KafkaConsumerRepository kafkaConsumerRepo;

    public void saveUser(User user){
        kafkaConsumerRepo.save(user);
    }

    public Iterable<User> findAllUsers(){
        return kafkaConsumerRepo.findAll();
    }

    public Optional<User> findById(int id){ return kafkaConsumerRepo.findById(String.valueOf(id));}

    public void deleteById(int id){
        kafkaConsumerRepo.deleteById(String.valueOf(id));
    }

    public void deleteAll(){
        kafkaConsumerRepo.deleteAll();
    }
}
