package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@EnableAutoConfiguration
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(value = "/reservations")
    public String getReservations() {
        return new Gson().toJson(reservationService.getReservations());
    }

    @GetMapping(value = "/reservation")
    public String getReservationWithBookAndUser(@RequestParam Integer readerId, @RequestParam Integer bookId) {
        return new Gson().toJson(reservationService.getReservationWithBookAndUser(readerId, bookId));
    }

    @PostMapping (value = "/postReservation")
    public String postReservation(@RequestBody Reservation reservation) {
        return new Gson().toJson(reservationService.postReservation(reservation));
    }

    @PatchMapping (value = "/patchReservation")
    public String patchReservation(@RequestParam(value="penalty") Integer penalty, @RequestParam(value="reservationId") Integer reservationId) {
        return new Gson().toJson(reservationService.patchReservation(penalty, reservationId));
    }
}
