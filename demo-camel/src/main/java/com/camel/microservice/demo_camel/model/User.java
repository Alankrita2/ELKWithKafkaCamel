package com.camel.microservice.demo_camel.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    int id;
    String name;
    Date pdate;
}
