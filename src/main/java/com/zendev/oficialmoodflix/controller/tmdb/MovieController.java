package com.zendev.oficialmoodflix.controller.tmdb;

import com.zendev.oficialmoodflix.dto.tmdb.CreditsResponse;
import com.zendev.oficialmoodflix.dto.tmdb.MovieResponse;
import com.zendev.oficialmoodflix.service.tmdb.MoviesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MoviesService service;

    public MovieController(MoviesService service) {
        this.service = service;
    }

    @GetMapping
    public List<MovieResponse> getMoviesByMood(@RequestParam String mood,@RequestParam(required = false, defaultValue = "1") int page){
        return service.getMoviesByMood(mood, page);
    }

    @GetMapping("/{id}/credits")
    public List<CreditsResponse> getCreditsById(@PathVariable int id){
        return service.getCreditsById(id);
    }
}