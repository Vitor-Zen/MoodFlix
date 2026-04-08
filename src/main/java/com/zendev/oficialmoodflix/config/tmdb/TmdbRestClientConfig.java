package com.zendev.oficialmoodflix.config.tmdb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class TmdbRestClientConfig {

    @Value("${tmdb.key}") String tmdbKey;

    @Bean
    public RestClient tmdbRestClient(RestClient.Builder builder){
        return builder
                .baseUrl("https://api.themoviedb.org/3")
                .defaultHeader("accept", "application/json")
                .defaultHeader("Authorization", "Bearer " + tmdbKey)
                .build();
    }
}