package com.example.demo.service;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservations() {
        return reservationRepository.getReservations();
    }

    public Reservation postReservation(Reservation reservation) {
        return reservationRepository.postReservation(reservation);
    }

    public Reservation getReservationWithBookAndUser(Integer readerId, Integer bookId) {
        return reservationRepository.getReservationWithBookAndUser(readerId, bookId);
    }

    public Reservation patchReservation(Integer penalty, Integer reservationId) {
        return reservationRepository.patchReservation(penalty, reservationId);
    }
}
