package com.anna.controller;


import com.anna.entity.Reservation;
import com.anna.service.HotelReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HotelReservationController {

    @Autowired
    private HotelReservationService hotelReservationService;

    @GetMapping("/")
    public  String hello(){
        return "hello";
    }

    @GetMapping("/hotels")
    public  String getAllHotel(Model model){
        model.addAttribute("hotels", hotelReservationService.showHotel());
        return "hotelsList";
    }

    @GetMapping("/hotel/{hotelId}")
    public  String getAllRoom(@PathVariable("hotelId") int hotelId, Model model){
        model.addAttribute("room", hotelReservationService.showRoom(hotelId));
        return "showRoom";
    }

    @GetMapping("/room/{roomId}")
    public String getAllReservation(@PathVariable("roomId") int roomId, Model model){
        model.addAttribute("reservation", hotelReservationService.showReservation(roomId));
        return "showReservation";
    }

    @GetMapping("/addReservation")
    public String createReservation(){
        return "createReservation";
    }

    @PostMapping("/addReservation")
    public String addResrvation(@ModelAttribute("reservation") Reservation reservation){
        hotelReservationService.addReservation(reservation);
        return "redirect:/room/" + reservation.getRoomId();
    }

    @GetMapping("/updateReservation/{reservId}")
    public String update(@PathVariable("reservId") int reservId, Model model){
        model.addAttribute("reservation", hotelReservationService.showReservation(reservId));
        hotelReservationService.showReservation(reservId);
        return "updateReservation";
    }

    @PostMapping("/updateReservation")
    public String updateResrvation(@ModelAttribute("reservation") Reservation reservation){
        hotelReservationService.updateReservation(reservation);
        return "redirect:/room/" + reservation.getRoomId();
    }

    @GetMapping("/delete/{reservId}")
    public String delete(@PathVariable("reservId") int reservId){
        hotelReservationService.deleteReservation(reservId);
        return "redirect:/room/" + reservId;
    }

}