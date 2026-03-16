package com.zendev.moodflix.controller;

import com.zendev.moodflix.dto.CastResponse;
import com.zendev.moodflix.dto.MovieResponse;
import com.zendev.moodflix.service.TmdbService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final TmdbService tmdbService;

    public MovieController(TmdbService tmdbService) {
        this.tmdbService = tmdbService;
    }

    @GetMapping
    public List<MovieResponse> getMoviesByMood(@RequestParam String moviesMood, @RequestParam(defaultValue = "1") int page) {
        return tmdbService.getMoviesByMood(moviesMood, page);
    }

    @GetMapping("/{id}/cast")
    public List<CastResponse> getCastByMovieId(@PathVariable int id) {
        return tmdbService.getCastByMovieId(id);
    }
}
