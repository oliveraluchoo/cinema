package com.exampleproject.MovieReservationSystem.service;

import com.exampleproject.MovieReservationSystem.dto.MovieDTO;
import com.exampleproject.MovieReservationSystem.model.Movie;
import com.exampleproject.MovieReservationSystem.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieRepository movieRepo;

    @Override
    public Movie saveMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setDuration(movieDTO.getDuration());
        movie.setGenre(movieDTO.getGenre());
        movie.setTitle(movieDTO.getTitle());
        movie.setScreenings(null);
        return movieRepo.save(movie);
    }
    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }
    public Movie getMovieById(Long id){
        return movieRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No movie with id: " + id));
    }
}
