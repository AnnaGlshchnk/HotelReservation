package com.anna.dao;

import com.anna.entity.*;


import java.util.List;

public interface HotelReservationDao {


    List<Hotel> showHotel();

    List<Room> showRoom(int hotelId);

    List<ReservationAndGuest> showReservationAndGuest(int roomId);

    void addReservationAndGuest(ReservationAndGuest reservationAndGuest);

    void updateReservationAndGuest(ReservationAndGuest reservationAndGuest);

    void deleteReservationAndGuest(ReservationAndGuest reservationAndGuest);

}
