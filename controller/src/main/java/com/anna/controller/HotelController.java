package com.anna.controller;

import com.anna.model.HotelData;
import com.anna.model.HotelDetails;
import com.anna.service.api.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    @ResponseStatus(HttpStatus.OK)
    public List<HotelData> getHotels() {
        return hotelService.getHotels();
    }

    @GetMapping("/hotels/{hotelId}")
    @ResponseStatus(HttpStatus.OK)
    public HotelDetails getHotelById(@PathVariable(value = "hotelId") Integer hotelId) {
        return hotelService.getHotelById(hotelId);
    }
}
