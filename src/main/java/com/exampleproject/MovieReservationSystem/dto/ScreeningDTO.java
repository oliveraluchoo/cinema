package com.exampleproject.MovieReservationSystem.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ScreeningDTO {
    private Long movieId;

    @NotNull(message = "The date cannot be null")
    @Future(message = "The date must be in the future")
    private LocalDateTime startDate;

    @NotNull(message = "The amount of seats cannot be null")
    @Min(value = 1, message = "The amount of seats must be at least 1")
    private Integer availableSeats;

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
}
