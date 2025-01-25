package com.exampleproject.MovieReservationSystem.service;

import com.exampleproject.MovieReservationSystem.dto.ScreeningDTO;
import com.exampleproject.MovieReservationSystem.model.Booking;
import com.exampleproject.MovieReservationSystem.model.Movie;
import com.exampleproject.MovieReservationSystem.model.Screening;
import com.exampleproject.MovieReservationSystem.repository.MovieRepository;
import com.exampleproject.MovieReservationSystem.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService implements IScreeningService{
    @Autowired
    private ScreeningRepository screeningRepo;
    @Autowired
    private MovieRepository movieRepo;

    public Screening saveScreening(ScreeningDTO screeningDto) {
        Movie movie = movieRepo.findById(screeningDto.getMovieId()).orElseThrow(() -> new IllegalArgumentException("Movie not found with ID: " + screeningDto.getMovieId()));
        Screening screening = new Screening();
        screening.setAvailableSeats(screeningDto.getAvailableSeats());
        screening.setStartDate(screeningDto.getStartDate());
        screening.setMovie(movie);
        return screeningRepo.save(screening);
    }

    @Override
    public List<Screening> getAllScreenings() {
        return screeningRepo.findAll();
    }
    public Screening findById(Long id){
        return screeningRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("no Screening with id: " + id));
    }
    public List<Screening> findScreeningsByMovieId(Long id){
        List<Screening> list = screeningRepo.findAll();
        return list.stream().filter(s -> s.getMovie().getId().equals(id)).toList();
    }
}
