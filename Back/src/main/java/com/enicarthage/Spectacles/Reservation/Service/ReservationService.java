package com.enicarthage.Spectacles.Reservation.Service;


import com.enicarthage.Spectacles.Reservation.Model.Reservation;
import com.enicarthage.Spectacles.Reservation.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsByClientId(Long userId) {
        return reservationRepository.findByClientId(userId);
    }
}