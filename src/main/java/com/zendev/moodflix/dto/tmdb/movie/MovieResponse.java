package com.zendev.moodflix.dto.tmdb.movie;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MovieResponse(
        // @JsonProperty maps snake_case fields from TMDB API to camelCase Java fields
        Integer id,
        String title,
        @JsonProperty("original_title") String originalTitle,
        String overview,
        @JsonProperty("release_date") String releaseDate,
        @JsonProperty("vote_average") Double voteAverage
) {
}
