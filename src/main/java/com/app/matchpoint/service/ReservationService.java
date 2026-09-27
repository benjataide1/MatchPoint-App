package com.app.matchpoint.service;

import com.app.matchpoint.model.Reservation;
import com.app.matchpoint.repository.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservationService{

    @Autowired
    private IReservationRepository reservationRepository;


    @Override
    public Reservation createReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation getReservationById(Long id) {
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return List.of();
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {
        return null;
    }

    @Override
    public boolean deleteReservation(Long id) {
        return false;
    }
}
