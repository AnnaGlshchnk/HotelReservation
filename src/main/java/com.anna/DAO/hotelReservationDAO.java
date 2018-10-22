package com.anna.DAO;

import org.springframework.dao.DataAccessException;

import java.util.Date;
import java.util.List;


public interface hotelReservationDAO {

    List<Hotel> getHotel();

    Hotel getHotelById(Integer hotelId);
    Hotel getHotelByName(String name);

    List<Room> getRoom();

    Room getRoomById(Integer roomId);
    Room getRooomByName(Integer price);

    List<Guest> getGuest();

    Guest getGuestById(Integer guestId);
    Guest getGuestByName(String fName, String sName);
    Integer addGuest(Guest guest);
    Integer updateGuest(Guest guest);
    Integer deleteGuest(Integer guestId);

    List<Reservation> getReserv();

    Reservation getReservById(Integer reservId);
    Integer addReserv(Reservation reserv);
    Integer updateReserv(Reservation reserv);
    Integer deleteReserv(Integer reservId);


}
