package com.zendev.moodflix.controller;

import com.zendev.moodflix.dto.tmdb.CastResponse;
import com.zendev.moodflix.dto.tmdb.series.SeriesResponse;
import com.zendev.moodflix.service.SeriesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {

    private final SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping
    public List<SeriesResponse> getSeriesByMood(@RequestParam String seriesMood, @RequestParam(defaultValue = "1") int page){
        return seriesService.getSeriesByMood(seriesMood, page);
    }

    @GetMapping("/{id}/cast")
    public List<CastResponse> getCastBySeriesId(@PathVariable int id){ return seriesService.getCastBySeriesId(id); }
}
