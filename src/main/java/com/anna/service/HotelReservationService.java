package com.anna.service;

import com.anna.entity.Hotel;
import com.anna.entity.Room;

import java.util.List;

public interface HotelReservationService {

    List<Hotel> showHotel();

    List<Room> showRoom();

    void save(Hotel hotel);
    Hotel getHotelByID(int hotelId);

    void update(Hotel hotel);

    void delete(int hotelId);
}