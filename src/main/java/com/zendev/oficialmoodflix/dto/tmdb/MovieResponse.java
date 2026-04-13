package com.zendev.oficialmoodflix.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MovieResponse(
        Integer id,
        String overview,
        String title,
        @JsonProperty("vote_average") Double voteAverage
        ) {
}
