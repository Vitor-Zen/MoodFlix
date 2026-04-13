package com.zendev.oficialmoodflix.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreditsResponse(
        @JsonProperty("known_for_department") String knowForDepartment,
        String name,
        String character
) {}