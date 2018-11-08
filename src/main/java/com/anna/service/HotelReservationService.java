package com.anna.service;

import com.anna.entity.Hotel;
import com.anna.entity.ReservationAndGuest;
import com.anna.entity.Room;

import java.util.List;

public interface HotelReservationService {

    List<Hotel> showHotel();

    List<Room> showRoom(int hotelId);

    List<ReservationAndGuest> showReservationAndGuest(int roomId);

}
