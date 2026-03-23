package com.zendev.moodflix.dto.jikan;

import java.util.List;

public record AnimePageResponse(
        List<AnimeResponse> data
) {
}
