package com.anna.DAO;

import com.anna.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import javax.sql.DataSource;
import java.util.List;

public class HotelReservationImpl implements hotelReservationDAO {

    @Value("${hotelReservationDAOSql.getGuest}")
    private String getGuestSql;
    @Value("${hotelReservationDAOSql.getGuestById}")
    private String getGuestByIdSql;
    @Value("${hotelReservationDAOSql.getGuestByName}")
    private String getGuestByNameSql;
    @Value("${hotelReservationDAOSql.addGuest}")
    private String addGuestSql;
    @Value("${hotelReservationDAOSql.updateGuest}")
    private String updateGuestSql;
    @Value("${hotelReservationDAOSql.deleteGuest}")
    private String deleteGuestSql;
    @Value("${hotelReservationDAOSql.getReserv}")
    private String getReservSql;
    @Value("${hotelReservationDAOSql.getReservById")
    private String getReservByIdSql;
    @Value("${hotelReservationDAOSql.addReserv}")
    private String addReservSql;
    @Value("${hotelReservationDAOSql.updateReserv }")
    private String updateReservSql;
    @Value("${hotelReservationDAOSql.deleteReserv}")
    private String deleteReservSQql;
    @Value("${hotelReservationDAOSql.getHotel}")
    private String getHotelSql;
    @Value("${hotelReservationDAOSql.getHotelById")
    private String getHotelByIdSql;
    @Value("${hotelReservationDAOSql.getHotelByName}")
    private String getHotelByNameSql;
    @Value("${hotelReservationDAOSql.getRoom}")
    private String getRoomSql;
    @Value("${hotelReservationDAOSql.getRoomByPrice}")
    private  String getRoomByPriceSql;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public HotelReservationImpl(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public List<Hotel> getHotel() {
        return null;
    }

    @Override
    public Hotel getHotelById(Integer hotelId) {
        return null;
    }

    @Override
    public Hotel getHotelByName(String name) {
        return null;
    }

    @Override
    public List<Room> getRoom() {
        return null;
    }

    @Override
    public Room getRoomByPrice(Integer price) {
        return null;
    }

    @Override
    public List<Guest> getGuest() {
        return null;
    }

    @Override
    public Guest getGuestById(Integer guestId) {
        return null;
    }

    @Override
    public Guest getGuestByName(String fName, String sName) {
        return null;
    }

    @Override
    public Integer addGuest(Guest guest) {
        return null;
    }

    @Override
    public Integer updateGuest(Guest guest) {
        return null;
    }

    @Override
    public Integer deleteGuest(Integer guestId) {
        return null;
    }

    @Override
    public List<Reservation> getReserv() {
        return null;
    }

    @Override
    public Reservation getReservById(Integer reservId) {
        return null;
    }

    @Override
    public Integer addReserv(Reservation reservation) {
        return null;
    }

    @Override
    public Integer updateReserv(Reservation reservation) {
        return null;
    }

    @Override
    public Integer deleteReserv(Integer reservId) {
        return null;
    }
}
