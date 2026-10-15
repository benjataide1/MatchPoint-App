package com.app.matchpoint.service;

import com.app.matchpoint.model.Reservation;
import com.app.matchpoint.repository.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    private IReservationRepository reservationRepository;


    @Override
    public Reservation createReservation(Reservation reservation) {

        if (!this.validator(reservation)) {
            return null;
        }

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {

        Reservation reservationToUpdate = reservationRepository.findById(id).orElse(null);

        if (reservationToUpdate == null) {
            return null;
        }

        if (!this.validator(reservation)) {
            return null;
        }

        reservationToUpdate.setDate(reservation.getDate());
        reservationToUpdate.setTime(reservation.getTime());
        reservationToUpdate.setUser(reservation.getUser());
        reservationToUpdate.setCourt(reservation.getCourt());
       
        return reservationRepository.save(reservationToUpdate);

    }

    @Override
    public boolean deleteReservation(Long id) {
        Reservation reservationToDelete = reservationRepository.findById(id).orElse(null);
        if(reservationToDelete == null) {
            return false;
        }
        reservationRepository.delete(reservationToDelete);
        return true;
    }

    private boolean validator(Reservation reservation) {
        if (reservation.getDate() == null) {
            return false;
        }
        if (reservation.getTime() == null) {
            return false;
        }
        if (reservation.getUser() == null) {
            return false;
        }
        if(reservation.getCourt() == null) {
            return false;
        }
        return true;
    }
}
