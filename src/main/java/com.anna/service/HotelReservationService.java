package com.anna.service;

import com.anna.entity.*;

import java.util.List;

public interface HotelReservationService {

    List<HotelWithRoom> getHotel();
    Hotel getHotelByName(String name);

    List<RoomWithReservation> getRoom();

    Room getRoomByPrice(Integer price);

    List<Guest> getGuest();

    Guest getGuestById(Integer guestId);
    Guest getGuestByName(String fName, String sName);
    Integer addGuest(Guest guest);
    void updateGuest(Guest guest);
    void deleteGuest(Integer guestId);

    List<ReservationWithRoom> getReserv();

    Reservation getReservById(Integer reservId);
    Integer addReserv(Reservation reservation);
    void updateReserv(Reservation reservation);
    void deleteReserv(Integer reservId);
}
