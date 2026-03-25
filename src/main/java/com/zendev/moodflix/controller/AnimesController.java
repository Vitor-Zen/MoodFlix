package com.zendev.moodflix.controller;

import com.zendev.moodflix.dto.jikan.AnimeResponse;
import com.zendev.moodflix.service.AnimesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animes")
public class AnimesController {
    private final AnimesService service;

    public AnimesController(AnimesService service) {
        this.service = service;
    }

    @GetMapping
    public List<AnimeResponse> getAnimesByMood(@RequestParam String mood,@RequestParam(defaultValue = "1") int page){
        return service.getAnimesByMood(mood, page);
    }

    @GetMapping("/search")
    public List<AnimeResponse> searchAnimesByName(@RequestParam String name){
        return service.getRecommendationsByAnimeName(name);
    }
}
