package com.zendev.moodflix.dto;

import java.util.List;

public record CreditsResponse(
        Integer id,
        List<CastResponse> cast
) {
}
