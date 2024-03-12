package com.aleksnose.hoteru.repository;

import com.aleksnose.hoteru.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
