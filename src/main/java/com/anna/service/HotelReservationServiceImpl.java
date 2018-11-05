package com.anna.service;

import com.anna.dao.HotelReservationDao;
import com.anna.entity.Hotel;
import com.anna.entity.Reservation;
import com.anna.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelReservationServiceImpl implements HotelReservationService {


    @Autowired
    public HotelReservationDao hotelReservationDao;

    public List<Hotel> showHotel() { return hotelReservationDao.showHotel(); }

    public List<Room> showRoom(int hotelId) { return hotelReservationDao.showRoom(hotelId); }

    public List<Reservation> showReservation(int roomId) { return hotelReservationDao.showReservation(roomId); }


}
