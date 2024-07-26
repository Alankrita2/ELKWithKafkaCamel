package com.example.elkKafkaCon.repository;

import com.example.elkKafkaCon.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaConsumerRepository extends ElasticsearchRepository<User, String> {

}
