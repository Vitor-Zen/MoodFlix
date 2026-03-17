package com.zendev.moodflix.controller;

import com.zendev.moodflix.dto.movie.CastResponse;
import com.zendev.moodflix.dto.movie.MovieResponse;
import com.zendev.moodflix.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieResponse> getMoviesByMood(@RequestParam String moviesMood, @RequestParam(defaultValue = "1") int page) {
        return movieService.getMoviesByMood(moviesMood, page);
    }

    @GetMapping("/{id}/cast")
    public List<CastResponse> getCastByMovieId(@PathVariable int id) {
        return movieService.getCastByMovieId(id);
    }
}
