package com.zendev.moodflix.config.jikan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class JikanRestClientConfig {

    @Bean
    public RestClient jikanRestClient(RestClient.Builder builder) {
        return builder
                .baseUrl("https://api.jikan.moe/v4/")
                .build();
    }
}