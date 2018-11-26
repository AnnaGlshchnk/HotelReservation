package com.anna.dao;

import com.anna.entity.*;


import java.util.List;

public interface HotelReservationDao {


    List<Hotel> showHotel();

    List showRoom(int hotelId);

    List showReservation(int roomId);

    int addReservation(Reservation reservation);

    int updateReservation(Reservation reservation);

    int deleteReservation(int reservId);
}
