package com.anna.rest;

import com.anna.service.HotelReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HotelReservationController {

    private HotelReservationService hotelReservationService;

    @Autowired
    public HotelReservationController(@Qualifier("hotelReservationImpl") HotelReservationService service) {
        this.hotelReservationService = service;
    }

    @GetMapping("/hotel")
    public String getHotel(Model model){
        model.addAttribute("hotel", hotelReservationService.getHotel());
        return "hotelList";
    }

}

