package com.anna.dao;

import com.anna.entity.Hotel;
import com.anna.entity.Room;

import java.util.List;

public interface HotelReservationDao {


    List<Hotel> showHotel();

    List<Room> showRoom(int hotelId);


    Room getHotelByID(int hotelId);

}
