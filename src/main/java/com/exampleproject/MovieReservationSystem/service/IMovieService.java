package com.exampleproject.MovieReservationSystem.service;

import com.exampleproject.MovieReservationSystem.dto.MovieDTO;
import com.exampleproject.MovieReservationSystem.model.Movie;

import java.util.List;

public interface IMovieService {
    public Movie saveMovie(MovieDTO movieDTO);
    public List<Movie> getAllMovies();
    public Movie getMovieById(Long id);

}
