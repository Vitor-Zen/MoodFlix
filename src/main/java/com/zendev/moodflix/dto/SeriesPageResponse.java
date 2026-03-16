package com.zendev.moodflix.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record SeriesPageResponse(
        Integer page,
        List<SeriesResponse> results,
        @JsonProperty("total_pages") Integer totalPages,
        @JsonProperty("total_results") Integer totalResults
) {
}
