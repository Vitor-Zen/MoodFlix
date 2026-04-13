package com.zendev.oficialmoodflix.controller.tmdb;

import com.zendev.oficialmoodflix.dto.tmdb.MovieResponse;
import com.zendev.oficialmoodflix.service.tmdb.MoviesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MoviesService service;

    public MovieController(MoviesService service) {
        this.service = service;
    }

    @GetMapping
    public List<MovieResponse> getMoviesByMood(String mood, int page){
        return service.getMoviesByMood(mood, page);
    }
}
