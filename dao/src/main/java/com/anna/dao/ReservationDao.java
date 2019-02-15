package com.anna.dao;

import com.anna.model.Reservation;
import com.anna.model.SaveReservation;

import java.util.List;

public interface ReservationDao {

    List<Reservation> getReservations();

    Reservation getReservationById(Integer reservationId);

    Integer addReservation(SaveReservation reservation);

    Integer updateReservation(Integer reservationId, SaveReservation reservation);

    Integer deleteReservation(Integer reservationId);
}
