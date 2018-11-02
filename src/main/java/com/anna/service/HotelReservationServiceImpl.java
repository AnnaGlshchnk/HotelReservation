package com.anna.service;

import com.anna.dao.HotelReservationDao;
import com.anna.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelReservationServiceImpl implements HotelReservationService {


    @Autowired
    public HotelReservationDao hotelReservationDao;

    public List<Hotel> showHotel() {
        return hotelReservationDao.showHotel();
    }

    public void save(Hotel hotel) {
        hotelReservationDao.save(hotel);
    }

    public Hotel getHotelByID(int hotelId) {
        return hotelReservationDao.getHotelByID(hotelId);
    }

    public void update(Hotel hotel) {
        hotelReservationDao.update(hotel);
    }

    public void delete(int hotelId) {
        hotelReservationDao.delete(hotelId);
    }
}
