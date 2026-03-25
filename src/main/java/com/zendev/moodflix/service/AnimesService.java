package com.zendev.moodflix.service;

import com.zendev.moodflix.config.jikan.AnimesMoodConfig;
import com.zendev.moodflix.dto.jikan.AnimePageResponse;
import com.zendev.moodflix.dto.jikan.AnimeResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class AnimesService {

    private final RestClient restClient;
    private final AnimesMoodConfig animesMoodConfig;

    public AnimesService(@Qualifier("jikanRestClient") RestClient restClient, AnimesMoodConfig animesMoodConfig) {
        this.restClient = restClient;
        this.animesMoodConfig = animesMoodConfig;
    }

    public List<AnimeResponse> getAnimesByMood(String mood, int page){
        String genres = animesMoodConfig.getGenres().get(mood);

        AnimePageResponse response = restClient
                .get()
                .uri("/anime?genres={genres}&sfw=true&min_score=7&order_by=score&sort=desc&page={page}", genres, page)
                .retrieve()
                .body(new ParameterizedTypeReference<AnimePageResponse>() {});

        return response != null ? response.data() : List.of();
    }

    public List<AnimeResponse> getRecommendationsByAnimeName(String name) {
        AnimePageResponse response = restClient
                .get()
                .uri("/anime?q={name}&sfw=true&type=tv", name)
                .retrieve()
                .body(new ParameterizedTypeReference<AnimePageResponse>() {});

        if (response == null || response.data().isEmpty()){
            return List.of();
        }

        int malId = response.data().get(0).malId();

        return getAnimeRecommendationsByMalId(malId);
    }

    private List<AnimeResponse> getAnimeRecommendationsByMalId(int malId) {
        AnimePageResponse response = restClient
                .get()
                .uri("/anime/{malId}/recommendations", malId)
                .retrieve()
                .body(new ParameterizedTypeReference<AnimePageResponse>() {});

        return response != null
                ? response.data()
                : List.of();
    }
}
