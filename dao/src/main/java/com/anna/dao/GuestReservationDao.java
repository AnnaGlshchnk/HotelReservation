package com.anna.dao;

import com.anna.dto.Guest;
import com.anna.dto.Reservation;
import com.anna.dto.SaveGuest;
import com.anna.dto.SaveReservation;

import java.util.List;

public interface GuestReservationDao {
    List<Guest> getGuests();

    Guest getGuestById(Integer guestId);

    Integer addGuest(SaveGuest guest);

    Integer updateGuest(Integer guestId, SaveGuest guest);

    List<Reservation> getReservations();

    Reservation getReservationById(Integer reservationId);

    Integer addReservation(SaveReservation reservation);

    Integer updateReservation(Integer reservationId, SaveReservation reservation);

    Integer deleteReservation(Integer reservationId);
}
