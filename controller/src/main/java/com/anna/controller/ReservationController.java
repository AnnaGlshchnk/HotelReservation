package com.anna.controller;

import com.anna.model.Reservation;
import com.anna.model.ReservationData;
import com.anna.model.ReservationDetails;
import com.anna.model.SaveReservation;
import com.anna.service.api.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    @ResponseStatus(HttpStatus.OK)
    public List<Reservation> getReservations() {
        return reservationService.getReservations();
    }

    @GetMapping("/reservations/{reservationId}")
    @ResponseStatus(HttpStatus.OK)
    public ReservationDetails getReservationById(@PathVariable(value = "reservationId") Integer reservationId) {
        return reservationService.getReservationById(reservationId);
    }

    @PostMapping("/reservations")
    public ResponseEntity<Void> addReservation(@Valid @RequestBody SaveReservation reservation, UriComponentsBuilder builder) {
        Integer createdId = reservationService.addReservation(reservation);
        UriComponents uriComponents = builder.path("/reservations/{reservationId}").buildAndExpand(createdId);
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/reservations/{reservationId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateReservation(@Valid @RequestBody SaveReservation reservation, @PathVariable("reservationId") Integer reservationId) {
        reservationService.updateReservation(reservationId, reservation);
    }

    @DeleteMapping("/reservations/{reservationId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReservation(@PathVariable(value = "reservationId") Integer reservationId) {
        reservationService.deleteReservation(reservationId);
    }
}
