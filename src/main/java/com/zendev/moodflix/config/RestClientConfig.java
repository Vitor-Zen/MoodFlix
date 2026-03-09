package com.zendev.moodflix.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${tmdb.api.token}")
    private String apiToken;

    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder
                .baseUrl("https://api.themoviedb.org")
                .defaultHeader("accept", "application/json")
                .defaultHeader("Authorization", "Bearer " + apiToken)
                .build();
    }
}