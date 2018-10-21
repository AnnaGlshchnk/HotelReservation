package com.anna.DAO;

import org.springframework.dao.DataAccessException;

import java.util.Date;
import java.util.List;


public interface hotelReservationDAO {

        List<Hotel> getCompanies(String hotelName) throws DataAccessException;

        Hotel getHotelById(Integer hotelId) throws DataAccessException;

        Hotel getHotelByName(String hotelName) throws DataAccessException;

        Integer addHotel(Hotel hotel) throws DataAccessException;

        Integer updateHotel(Hotel hotel) throws DataAccessException;

        Integer deleteHotel(Integer hotelId) throws DataAccessException;


        List<Room> getPhones(Integer price) throws DataAccessException;

        Room getRoomById(Integer roomId) throws DataAccessException;

        Integer addRoom(Room room) throws DataAccessException;

        Integer updateRoom(Room room) throws DataAccessException;

        Integer deleteRoom(Integer roomId) throws DataAccessException;


        List<Reservation> getReserv(Date startRes, Date endRes) throws DataAccessException;

        Reservation getReservById(Integer reservId) throws DataAccessException;

        Integer addReserv(Reservation reserv) throws DataAccessException;

        Integer updateReserv(Reservation reserv) throws DataAccessException;

        Integer deleteReserv(Integer reservId) throws DataAccessException;


        List<Guest> getGuest(String fName, String sName) throws DataAccessException;

        Guest getGuestById(Integer guestId) throws DataAccessException;

        Integer addGuest(Guest guest) throws DataAccessException;

        Integer updateGuest(Guest guest) throws DataAccessException;

        Integer deleteGuest(Integer guestId) throws DataAccessException;

    }
}
