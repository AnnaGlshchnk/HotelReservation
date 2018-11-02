package com.anna.controller;


import com.anna.service.HotelReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HotelReservationController {

    @Autowired
    public HotelReservationService hotelReservationService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/hello")
    public  String hello(){
        return "hello";
    }

    @GetMapping("/hotels")
    public  String getAllHotel(Model model){
        model.addAttribute("hotels", hotelReservationService.showHotel());
        return "hotelsList";
    }

    @GetMapping("/hotel/{hotelId}")
    public  String getHotelByID(@PathVariable("hotelId") int hotelId, Model model){
        model.addAttribute("hotel", hotelReservationService.getHotelByID(hotelId));
        return "showHotel";
    }
}
