package com.zendev.moodflix.config.jikan;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "animesmood")
public class AnimesMoodConfig {

    private Map<String, String> genres;

    public Map<String, String> getGenres() { return genres; }

    public void setGenres(Map<String, String> genres) { this.genres = genres; }
}