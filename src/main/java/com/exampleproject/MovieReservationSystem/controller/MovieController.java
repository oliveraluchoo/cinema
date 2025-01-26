package com.exampleproject.MovieReservationSystem.controller;

import com.exampleproject.MovieReservationSystem.dto.MovieDTO;
import com.exampleproject.MovieReservationSystem.model.Movie;
import com.exampleproject.MovieReservationSystem.service.IMovieService;
import com.exampleproject.MovieReservationSystem.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private IMovieService movieService;

    @GetMapping()
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping()

    public ResponseEntity<Movie> addMovie(@Valid @RequestBody MovieDTO movieDTO){
        Movie movie =  movieService.saveMovie(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }
}
