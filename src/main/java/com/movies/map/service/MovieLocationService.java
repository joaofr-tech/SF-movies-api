package com.movies.map.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.movies.map.model.MovieLocation;

@Service
public class MovieLocationService {
    
    private final WebClient webClient;

    public MovieLocationService(WebClient.Builder builder){
        this.webClient = builder
                            .baseUrl("https://data.sfgov.org/api/v3/views/yitu-d5am/query.json")
                            .build();
    }

    public List<MovieLocation> getAllMovies(){
        return webClient.get()
                .retrieve()
                .bodyToFlux(MovieLocation.class)
                .collectList()
                .block();
    }

    public List<MovieLocation> filterByTitle(String title){
        return getAllMovies().stream()
                .filter(movie -> movie.getTitle() != null && movie.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
}
