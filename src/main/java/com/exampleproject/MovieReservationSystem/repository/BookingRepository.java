package com.exampleproject.MovieReservationSystem.repository;

import com.exampleproject.MovieReservationSystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BookingRepository extends JpaRepository<Booking,Long> {
}
