package com.app.matchpoint.service;

import com.app.matchpoint.model.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation createReservation(Reservation reservation);

    Reservation getReservationById(Long id);

    List<Reservation> getAllReservations();

    Reservation updateReservation(Long id, Reservation reservation);

    boolean deleteReservation(Long id);
}
