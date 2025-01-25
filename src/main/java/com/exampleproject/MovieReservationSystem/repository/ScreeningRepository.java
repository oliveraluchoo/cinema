package com.exampleproject.MovieReservationSystem.repository;

import com.exampleproject.MovieReservationSystem.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface ScreeningRepository extends JpaRepository<Screening,Long> {
}
