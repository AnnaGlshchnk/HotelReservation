package com.anna.dao;

import com.anna.dto.Hotel;
import com.anna.dto.Room;

import java.util.List;

public interface HotelRoomDao {

    List<Hotel> getHotels();

    Hotel getHotelById(Integer hotelId);

    List<Room> getRooms();

    Room getRoomById(Integer roomId);


}
