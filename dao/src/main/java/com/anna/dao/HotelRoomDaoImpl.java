package com.anna.dao;

import com.anna.dto.Hotel;
import com.anna.dto.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelRoomDaoImpl implements HotelRoomDao {

    private static String HOTEL_ID="hotelId";
    private static String HOTEL_NAME="hotelName";
    private static String COUNT_OF_ROOMS="countOfRooms";
    private static String ROOM_ID="roomId";
    private static String ROOM_NUMBER="roomNumber";

    @Value("${hotelreservation.getHotels}")
    private String getHotelsSql;
    @Value("${hotelreservation.getHotelById}")
    private String getHotelByIdSql;
    @Value("${hotelreservation.getRooms}")
    private String getRoomsSql;
    @Value("${hotelreservation.getRoomById}")
    private String getRoomByIdSql;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public HotelRoomDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Hotel> getHotels() {
        return null;
    }

    public Hotel getHotelById(Integer hotelId) {
        return null;
    }

    public List<Room> getRooms() {
        return null;
    }

    public Room getRoomById(Integer roomId) {
        return null;
    }
}
