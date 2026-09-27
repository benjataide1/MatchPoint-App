package com.app.matchpoint.repository;

import com.app.matchpoint.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}
