package com.zendev.moodflix.dto.tmdb.series;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SeriesResponse(
        @JsonProperty("first_air_date") String firstAirDate,
        @JsonProperty("original_name") String originalName,
        String name,
        Integer id,
        String overview
        ) {
}
