package com.zendev.moodflix.dto.jikan;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AnimeResponse(
        @JsonProperty("mal_id") Integer malId,
        String title,
        @JsonProperty("title_english") String titleEnglish,
        String type,
        Integer episodes,
        String status,
        String synopsis,
        Double score,
        Images images,
        Aired aired
) {
    public record Images(
            Jpg jpg
    ) {
        public record Jpg (
                @JsonProperty("image_url") String imageUrl
        ) {}
    }

    public record Aired(
            String string
    ) {}
}
