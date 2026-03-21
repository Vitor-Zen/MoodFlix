package com.zendev.moodflix.config.tmdb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "seriesmood")
public class SeriesMoodConfig {

    private Map<String, String> genres;

    public Map<String, String> getGenres() { return genres; }

    public void setGenres(Map<String, String> genres) { this.genres = genres; }
}
