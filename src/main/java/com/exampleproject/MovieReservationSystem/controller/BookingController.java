package com.exampleproject.MovieReservationSystem.controller;

import com.exampleproject.MovieReservationSystem.dto.BookingDTO;
import com.exampleproject.MovieReservationSystem.model.Booking;
import com.exampleproject.MovieReservationSystem.model.Screening;
import com.exampleproject.MovieReservationSystem.service.BookingService;
import com.exampleproject.MovieReservationSystem.service.IBookingService;
import com.exampleproject.MovieReservationSystem.service.IScreeningService;
import com.exampleproject.MovieReservationSystem.service.ScreeningService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private IBookingService bookingService;
    @Autowired
    private IScreeningService screeningService;

    @PostMapping
    public ResponseEntity<?> addBooking(@RequestBody BookingDTO bookingDTO) {
        try {
            Booking booking = bookingService.saveBooking(bookingDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(booking);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{idBooking}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long idBooking){
        try {
            Booking booking = bookingService.findBookingById(idBooking);
            bookingService.deleteBooking(booking);
            return ResponseEntity.status(HttpStatus.OK).body(booking);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/screening/{screeningId}")
    public ResponseEntity<?> getBookingsByScreeningId(@PathVariable Long screeningId){
        try {
            Screening screening = screeningService.findById(screeningId);
            return ResponseEntity.status(HttpStatus.OK).body(screening.getBookings());
        }
        catch (Exception e ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
