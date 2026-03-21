package com.zendev.moodflix.config.tmdb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class TmdbRestClientConfig {

    // Inject value from application.properties directly into the field
    @Value("${tmdb.api.token}")
    private String apiToken;

    // Produces an object managed by the Spring Context,
    // available for dependency injection in any class
    @Bean
    public RestClient tmdbRestClient(RestClient.Builder builder) {
        return builder
                .baseUrl("https://api.themoviedb.org/3")
                .defaultHeader("accept", "application/json")
                .defaultHeader("Authorization", "Bearer " + apiToken)
                .build();
    }
}