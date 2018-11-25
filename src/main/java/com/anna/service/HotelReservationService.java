package com.anna.service;

import com.anna.entity.Hotel;
import com.anna.entity.Reservation;

import java.util.List;

public interface HotelReservationService {

    List<Hotel> showHotel();

    List showRoom(int hotelId);

    List showReservation(int roomId);


    Integer addReservation(Reservation reservation);

    void updateReservation(Reservation reservation);

    void deleteReservation(int reservId);

}
