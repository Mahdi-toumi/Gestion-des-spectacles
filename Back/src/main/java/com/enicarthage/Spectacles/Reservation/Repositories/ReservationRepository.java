package com.enicarthage.Spectacles.Reservation.Repositories;

import com.enicarthage.Spectacles.Reservation.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByClientId(Long userId);
}
