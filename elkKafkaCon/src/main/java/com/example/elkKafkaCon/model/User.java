package com.example.elkKafkaCon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "kafkauser")
public class User {
    @Id
    int id;
    @Field(type = FieldType.Text, name = "name")
    String name;
    @Field(type = FieldType.Date, name = "pdate")
    Date pdate;



}
