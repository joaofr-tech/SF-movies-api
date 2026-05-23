package com.movies.map.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movies.map.model.MovieLocation;
import com.movies.map.service.MovieLocationService;

@RestController
@RequestMapping("/movies")
public class MovieController {
    
    private final MovieLocationService service;


    public MovieController(MovieLocationService movieLocationService) {
        this.service = movieLocationService;
    }

    @GetMapping
    public List<MovieLocation> getAll(@RequestParam Optional<String> title){
        return title.map(service::filterByTitle)
                    .orElseGet(service::getAllMovies);
    }

    @GetMapping("/autocomplete")
    public List<String> autocomplete(@RequestParam("q") String prefix) {
        return service.autocomplete(prefix);
    }
    

}
