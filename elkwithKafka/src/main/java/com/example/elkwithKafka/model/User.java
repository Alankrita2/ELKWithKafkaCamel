package com.example.elkwithKafka.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    int id;
    String name;
    Date pdate;
}
