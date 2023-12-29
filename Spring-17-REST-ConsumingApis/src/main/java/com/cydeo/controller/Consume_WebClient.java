package com.cydeo.controller;

import com.cydeo.repository.GenreRepository;
import com.cydeo.repository.MovieRepository;

public class Consume_WebClient {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    public Consume_WebClient(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }
}
