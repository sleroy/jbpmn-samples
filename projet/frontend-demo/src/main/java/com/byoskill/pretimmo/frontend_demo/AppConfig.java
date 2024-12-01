package com.byoskill.pretimmo.frontend_demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class AppConfig {


    @Value("${backend.url}")  // Correct usage of @Value
    private String backendUrl;


    @Bean

    public RestTemplate restTemplate() {

        return new RestTemplateBuilder().rootUri(backendUrl).build();

    }

}