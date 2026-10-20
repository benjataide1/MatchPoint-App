package com.app.matchpoint.service;

import com.app.matchpoint.model.PadelCourt;
import com.app.matchpoint.model.Reservation;
import com.app.matchpoint.model.User;
import com.app.matchpoint.repository.IPadelCourtRepository;
import com.app.matchpoint.repository.IReservationRepository;
import com.app.matchpoint.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    private IReservationRepository reservationRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPadelCourtRepository padelCourtRepository;


    @Override
    public Reservation createReservation(Reservation reservation) {

        if (!this.validator(reservation)) {
            return null;
        }

        if(reservation.getUser().getId_user() == null || reservation.getCourt().getId_court() == null) {
            return null;
        }

        User user = userRepository.findById(reservation.getUser().getId_user()).orElse(null);

        PadelCourt court = padelCourtRepository.findById(reservation.getCourt().getId_court()).orElse(null);

        if(user == null || court == null) {
            return null;
        }
        reservation.setUser(user);
        reservation.setCourt(court);

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
