package com.zendev.moodflix.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CastResponse(
        String name,
        String character,
        @JsonProperty("known_for_department") String knownForDepartament
) {
}
