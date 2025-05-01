package com.enicarthage.Spectacles.Reservation.Controller;

import com.enicarthage.Spectacles.Reservation.Model.Reservation;
import com.enicarthage.Spectacles.Reservation.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // Créer une réservation
    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    // Récupérer les réservations d’un utilisateur donné
    @GetMapping("/user/{userId}")
    public List<Reservation> getReservationsByUser(@PathVariable Long userId) {
        return reservationService.getReservationsByClientId(userId);
    }
}
