package com.anna.dao;

import com.anna.entity.*;


import java.util.List;

public interface HotelReservationDao {


    List<Hotel> showHotel();

    List<Room> showRoom(int hotelId);

    List<Reservation> showReservation(int roomId);

}
