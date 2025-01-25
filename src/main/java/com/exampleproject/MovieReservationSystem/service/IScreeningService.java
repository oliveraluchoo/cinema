package com.exampleproject.MovieReservationSystem.service;

import com.exampleproject.MovieReservationSystem.dto.ScreeningDTO;
import com.exampleproject.MovieReservationSystem.model.Booking;
import com.exampleproject.MovieReservationSystem.model.Screening;

import java.util.List;

public interface IScreeningService {
    public Screening saveScreening(ScreeningDTO screening);
    public List<Screening> getAllScreenings();
    public Screening findById(Long id);
}
