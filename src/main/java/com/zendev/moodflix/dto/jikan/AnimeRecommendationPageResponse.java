package com.zendev.moodflix.dto.jikan;

import java.util.List;

public record AnimeRecommendationPageResponse(
        List<AnimeRecommendationResponse> data
) {
    public record AnimeRecommendationResponse(
            AnimeResponse entry
    ) {}
}
