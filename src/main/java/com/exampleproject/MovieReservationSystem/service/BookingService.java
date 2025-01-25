package com.exampleproject.MovieReservationSystem.service;

import com.exampleproject.MovieReservationSystem.dto.BookingDTO;
import com.exampleproject.MovieReservationSystem.model.Booking;
import com.exampleproject.MovieReservationSystem.model.Screening;
import com.exampleproject.MovieReservationSystem.repository.BookingRepository;
import com.exampleproject.MovieReservationSystem.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements IBookingService{
    @Autowired
    private BookingRepository bookingRepo;
    @Autowired
    private ScreeningRepository screeningRepo;

    @Override
    public Booking saveBooking(BookingDTO bookingDTO) {
        System.out.println(bookingDTO.getScreeningId());
        Screening screening = screeningRepo.findById(bookingDTO.getScreeningId()).orElseThrow(() -> new IllegalArgumentException("There's no screening wit the ID: " + bookingDTO.getScreeningId()));
        if (screening.getAvailableSeats() - bookingDTO.getNumberOfSeats() < 0){
            throw new IllegalArgumentException("The number of seats must be less than or equal to: " + screening.getAvailableSeats());
        }
        screening.setAvailableSeats(screening.getAvailableSeats() - bookingDTO.getNumberOfSeats());
        Booking booking = new Booking();
        booking.setAmount(bookingDTO.getNumberOfSeats());
        booking.setScreening(screening);
        booking.setCustomerName(bookingDTO.getCustomerName());
        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public void deleteBooking(Booking booking) {
        Booking book = bookingRepo.findById(booking.getId()).orElseThrow(() -> new IllegalArgumentException("No booking with id: " + booking.getId()));
        bookingRepo.delete(booking);
    }
    public Booking findBookingById(Long id){
        return bookingRepo.findById(id).orElseThrow( () -> new IllegalArgumentException("No booking with id: " + id));
    }
}
