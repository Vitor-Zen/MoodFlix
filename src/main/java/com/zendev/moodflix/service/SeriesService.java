package com.zendev.moodflix.service;

import com.zendev.moodflix.config.SeriesMoodConfig;
import com.zendev.moodflix.dto.SeriesPageResponse;
import com.zendev.moodflix.dto.SeriesResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class SeriesService {

    private final RestClient restClient;
    private final SeriesMoodConfig seriesMoodConfig;

    public SeriesService(RestClient restClient, SeriesMoodConfig seriesMoodConfig) {
        this.restClient = restClient;
        this.seriesMoodConfig = seriesMoodConfig;
    }

    public List<SeriesResponse> getSeriesByMood(String mood, int page) {
        String genres = seriesMoodConfig.getGenres().get(mood);

        SeriesPageResponse response = restClient
                .get()
                .uri("/discover/tv?with_genres={genres}&with_original_language=en&vote_count.gte=50&vote_average.gte=7.5&language=pt-BR&sort_by=first_air_date.desc&page={page}", genres, page)
                .retrieve()
                .body(new ParameterizedTypeReference<SeriesPageResponse>() {});

        return response != null ? response.results() : List.of();
    }
}
