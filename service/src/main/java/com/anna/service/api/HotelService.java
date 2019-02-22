package com.anna.service.api;

import com.anna.model.HotelData;
import com.anna.model.HotelDetails;
import com.anna.service.exception.OperationFailedException;

import java.util.List;

public interface HotelService {

    List<HotelData> getHotels() throws OperationFailedException;

    HotelDetails getHotelById(Integer hotelId) throws OperationFailedException;
}
