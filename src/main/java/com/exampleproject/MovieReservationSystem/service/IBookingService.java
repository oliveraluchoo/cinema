package com.exampleproject.MovieReservationSystem.service;

import com.exampleproject.MovieReservationSystem.dto.BookingDTO;
import com.exampleproject.MovieReservationSystem.model.Booking;

import java.util.List;

public interface IBookingService {
    public Booking saveBooking(BookingDTO bookingDTO);
    public List<Booking> getAllBookings();
    public void deleteBooking(Booking booking);
    public Booking findBookingById(Long id);
}
