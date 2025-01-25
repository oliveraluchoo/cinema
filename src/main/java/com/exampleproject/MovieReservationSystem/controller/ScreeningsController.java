package com.exampleproject.MovieReservationSystem.controller;

import com.exampleproject.MovieReservationSystem.dto.ScreeningDTO;
import com.exampleproject.MovieReservationSystem.model.Movie;
import com.exampleproject.MovieReservationSystem.model.Screening;
import com.exampleproject.MovieReservationSystem.service.IMovieService;
import com.exampleproject.MovieReservationSystem.service.IScreeningService;
import com.exampleproject.MovieReservationSystem.service.MovieService;
import com.exampleproject.MovieReservationSystem.service.ScreeningService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screenings")
public class ScreeningsController {
    @Autowired
    private IScreeningService screeningService;
    @Autowired
    private IMovieService movieService;

    @PostMapping
    public ResponseEntity<?> addScreening(@Valid @RequestBody ScreeningDTO screeningDto){
        try{
            Screening createdScreening =  screeningService.saveScreening(screeningDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdScreening);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/movie/{movieID}")
    public ResponseEntity<?> listAllScreening(@PathVariable Long movieID){
        try {
            Movie movie = movieService.getMovieById(movieID);
            return ResponseEntity.status(HttpStatus.OK).body(movie.getScreenings());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
