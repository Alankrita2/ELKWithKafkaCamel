package com.example.elkKafkaCon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = {"elkKafkaCon.repository"})
@ComponentScan(basePackages = {"elkKafkaCon"})
public class ElasticSearchConfiguration extends ElasticsearchConfiguration{
    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("elaticserver")//elasticsearch server url
                .usingSsl("") //add the generated sha-256 fingerprint
                .withBasicAuth("", "") //add your username and password
                .build();
    }
}
