package com.zendev.moodflix.dto.movie;

import java.util.List;

public record CreditsResponse(
        Integer id,
        List<CastResponse> cast
) {
}
