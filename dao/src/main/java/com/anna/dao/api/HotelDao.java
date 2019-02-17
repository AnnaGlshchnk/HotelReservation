package com.anna.dao.api;

import com.anna.model.Hotel;

import java.util.List;

public interface HotelDao {

    List<Hotel> getHotels();

    Hotel getHotelById(Integer hotelId);
}
