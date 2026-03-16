package com.zendev.moodflix.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "moviesmood") // Maps all properties with "mood" prefix from yaml to this class
public class MoviesMoodConfig {

    private Map<String, String> genres; // Read key and value of yaml file

    public Map<String, String> getGenres() { // Provide access to genres map
        return genres;
    }

    public void setGenres(Map<String, String> genres){ // Inject yalm values into the attribute
        this.genres = genres;
    }
}
