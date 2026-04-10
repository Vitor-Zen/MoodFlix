package com.zendev.oficialmoodflix.service.tmdb;

import com.zendev.oficialmoodflix.config.tmdb.MovieMoodsConfig;
import com.zendev.oficialmoodflix.dto.tmdb.MoviePageResponse;
import com.zendev.oficialmoodflix.dto.tmdb.MovieResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class MoviesService {

    private RestClient client;
    private MovieMoodsConfig movieMoodsConfig;

    public MoviesService(@Qualifier("tmdbRestClient") RestClient client, MovieMoodsConfig movieMoodsConfig) {
        this.client = client;
        this.movieMoodsConfig = movieMoodsConfig;
    }

    public List<MovieResponse> getMoviesByMood(String mood, int page){
        String genres = movieMoodsConfig.getGenres().get(mood);

        MoviePageResponse response = client
                .get()
                .uri("/discover/movie?with_genres={genres}&vote_count.gte=100&vote_average.gte=7&language=pt-BR&sort_by=primary_release_date.desc&page={page}", genres, page)
                .retrieve()
                .body(new ParameterizedTypeReference<MoviePageResponse>() {});

        return response != null ? response.results() : List.of();
    }
}
