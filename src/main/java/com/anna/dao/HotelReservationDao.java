package com.anna.dao;

import com.anna.entity.*;


import java.util.List;

public interface HotelReservationDao {


    List<Hotel> showHotel();

    List showRoom(int hotelId);

    List showReservation(int roomId);

    void addReservation(Reservation reservation);

    void updateReservation(Reservation reservation);

    void deleteReservation(Reservation reservation);

}
