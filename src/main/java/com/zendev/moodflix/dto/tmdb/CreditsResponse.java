package com.zendev.moodflix.dto.tmdb;

import java.util.List;

public record CreditsResponse(
        Integer id,
        List<CastResponse> cast
) {
}
