package com.zendev.moodflix.controller;

import com.zendev.moodflix.dto.SeriesResponse;
import com.zendev.moodflix.service.SeriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
