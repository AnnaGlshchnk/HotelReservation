package com.anna.mapper;

import com.anna.entity.Hotel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelMapper implements RowMapper<Hotel> {
    
    public Hotel mapRow(ResultSet resultSet, int i) throws SQLException {

        Hotel hotel = new Hotel();
        hotel.setHotelId(resultSet.getInt("hotel_id"));
        hotel.setHotel(resultSet.getString("hotel"));

        return hotel;
    }
}
