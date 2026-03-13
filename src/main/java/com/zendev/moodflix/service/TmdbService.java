package com.zendev.moodflix.service;

import com.zendev.moodflix.config.MoodConfig;
import com.zendev.moodflix.dto.CastResponse;
import com.zendev.moodflix.dto.CreditsResponse;
import com.zendev.moodflix.dto.MoviePageResponse;
import com.zendev.moodflix.dto.MovieResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class TmdbService {

    private final RestClient restClient;
    private final MoodConfig moodConfig;

    public TmdbService(RestClient restClient, MoodConfig moodConfig) {
        this.restClient = restClient;
        this.moodConfig = moodConfig;
    }

    public List<MovieResponse> getMoviesByMood(String mood, int page) {
        String genres = moodConfig.getGenres().get(mood); // Gets genreIds from yaml by mood key

        MoviePageResponse response = restClient
                .get() // HTTP method
                .uri("/discover/movie?with_genres={genres}&without_genres=16&vote_count.gte=100&vote_average.gte=7.5&language=pt-BR&sort_by=primary_release_date.desc&page={page}", genres, page)
                // {genres} is replaced by genres variable above
                // {page} is replaced by page variable above
                // vote_count.gte=value filter out movies with less than 100 votes
                // language=pt-BR brings titles and overview in portuguese
                // without_genres=16 filter to prevent animation
                // vote_average.gte=value filter to balance the ratings given to movies
                // sort_by=primary_release_date.desc filter to sort descending order by year
                .retrieve() // Execute this request
                .body(new ParameterizedTypeReference<MoviePageResponse>() {}); // Informs to RestClient how to deserialize the response

        return response != null ? response.results() : List.of();
    }

    public List<CastResponse> getCastByMovieId(int movieId) {
        CreditsResponse response = restClient
                .get() // HTTP Method
                .uri("/movie/{movieId}/credits?language=pt-BR", movieId)
                .retrieve() // Execute this request
                .body(new ParameterizedTypeReference<CreditsResponse>() {});

            return response != null
                    ? response.cast().stream().filter(cast -> "Acting".equals(cast.knowForDepartament())) // Filter only actors
                    .filter(cast -> !cast.character().toLowerCase().contains("voice")) // Filter out voice actors
                    .toList()
                    : List.of();
        }
}
