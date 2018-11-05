package com.anna.service;

import com.anna.entity.Hotel;
import com.anna.entity.Reservation;
import com.anna.entity.Room;

import java.util.List;

public interface HotelReservationService {

    List<Hotel> showHotel();

    List<Room> showRoom(int hotelId);

    List<Reservation> showReservation(int roomId);

}
