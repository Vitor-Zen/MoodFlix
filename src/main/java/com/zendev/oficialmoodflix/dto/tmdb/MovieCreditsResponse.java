package com.zendev.oficialmoodflix.dto.tmdb;

import java.util.List;

public record MovieCreditsResponse(
        Integer id,
        List<CreditsResponse> cast
) {}