package com.anna.dao.api;

import com.anna.model.HotelData;
import com.anna.model.HotelDetails;

import java.util.List;

public interface HotelDao {

    List<HotelData> getHotels();

    HotelDetails getHotelById(Integer hotelId);
}
