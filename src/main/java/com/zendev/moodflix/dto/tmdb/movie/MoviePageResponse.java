package com.zendev.moodflix.dto.tmdb.movie;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MoviePageResponse(
        Integer page,
        List<MovieResponse> results,
        @JsonProperty("total_pages") Integer totalPages,
        @JsonProperty("total_results") Integer totalResults
) {
}
