package com.app.matchpoint.controller;

import com.app.matchpoint.model.Reservation;
import com.app.matchpoint.service.IReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Get all reservations
    @GetMapping()
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    // Get reservation by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation == null) {
            return ResponseEntity.status(404).body("Reservation not found with ID: " + id);
        }
        return ResponseEntity.ok(reservation);
    }

    // Create
    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody Reservation reservation) {
        Reservation result = reservationService.createReservation(reservation);
        if (result == null) {
            return ResponseEntity.badRequest().body("Invalid reservation data");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {

        Reservation updatedReservation = reservationService.updateReservation(id, reservation);

        if (updatedReservation == null) {
            return ResponseEntity.badRequest().body("Failed to update reservation with ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedReservation);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id) {
        boolean deleted = reservationService.deleteReservation(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservation not found with ID: " + id);
        }
        return ResponseEntity.ok("Reservation deleted successfully");
    }

}
