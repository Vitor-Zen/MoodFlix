package com.zendev.moodflix.service;

import com.zendev.moodflix.config.tmdb.SeriesMoodConfig;
import com.zendev.moodflix.dto.CastResponse;
import com.zendev.moodflix.dto.CreditsResponse;
import com.zendev.moodflix.dto.series.SeriesPageResponse;
import com.zendev.moodflix.dto.series.SeriesResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class SeriesService {

    private final RestClient restClient;
    private final SeriesMoodConfig seriesMoodConfig;

    public SeriesService(@Qualifier("tmdbRestClient") RestClient restClient, SeriesMoodConfig seriesMoodConfig) {
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

    public List<CastResponse> getCastBySeriesId(int seriesId) {
        CreditsResponse response = restClient
                .get()
                .uri("/tv/{seriesId}/credits?language=pt-BR", seriesId)
                .retrieve()
                .body(new ParameterizedTypeReference<CreditsResponse>() {});

        return response != null
                ? response.cast().stream().filter(cast -> "Acting".equals(cast.knownForDepartament()))
                .filter(cast -> !cast.character().toLowerCase().contains("voice"))
                .toList()
                :List.of();
    }
}
