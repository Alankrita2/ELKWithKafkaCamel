package com.camel.microservice.demo_camel.route;

import com.camel.microservice.demo_camel.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SimpleRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        /*from("file:files/input").setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("http://localhost:8082/getElasticUserFromKafka/1")
                .log("${body}");
        from("file:files/input")
                .to("rest:get:getElasticUserFromKafka/1?host=http://localhost:8082")
                .log("${body}");*/

/*
        from("jetty://http://localhost:8082/egetElasticUserFromKafka")
                .log("${body}");
*/

        from("file:files/input")
               .log("${body}")
                .to("direct:fetchUser")
                .log("${body}")
                .setHeader(Exchange.HTTP_METHOD, simple("POST"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .toD("rest:post:producer?host=http://localhost:8081")
                .log("Completed")
                .end();


        from("direct:fetchUser").to("rest:get:getElasticUserFromKafka/4?host=http://localhost:8082")
                .log("${body}")
                .process(this::requestBody)
                .end();


    }

    private void requestBody(Exchange exchange) {
        String message = exchange.getIn().getBody(String.class);
        try {
            User user = readUser(message);
            user.setId(user.getId()+1);
            Date d = new Date();
            user.setPdate(d);
            String outMessage = getStringFromUser(user);
            exchange.getIn().setBody(outMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

    private String getStringFromUser(User user) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(user);
    }

    private User readUser(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(message, User.class);
    }
}
