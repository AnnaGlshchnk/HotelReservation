package com.anna.service.api;

import com.anna.model.Hotel;
import com.anna.service.exception.OperationFailedException;

import java.util.List;

public interface HotelService {

    List<Hotel> getHotels() throws OperationFailedException;

    Hotel getHotelById(Integer hotelId) throws OperationFailedException;
}
