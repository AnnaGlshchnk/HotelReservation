package com.anna.dao;


import com.anna.entity.*;
import com.anna.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelReservationImpl implements HotelReservationDao{

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public HotelReservationImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Hotel> showHotel() {
        String sql = "select * from hotel";
        return jdbcTemplate.query(sql, new HotelMapper());
    }

    public List<Room> showRoom() {
        String sql = "select * from room where room.hotel_id=hotel.hotel_id";
        return jdbcTemplate.query(sql, new RoomMapper());
    }

    public void save(Hotel hotel) {
        String sql = "insert into hotel (hotel, room_id) values (?,?)";
        jdbcTemplate.update(sql, hotel.getHotel(), hotel.getRoomId());
    }

    public Hotel getHotelByID(int hotelId) {
        String sql = "SELECT * FROM hotel WHERE hotel_id=?";
        return jdbcTemplate.queryForObject(sql, new HotelMapper(), hotelId);
    }

    public void update(Hotel hotel) {
        String sql = "update hotel set hotel=?, room_id=? where hotel_id=?";
        jdbcTemplate.update(sql, hotel.getHotelId(), hotel.getHotel(), hotel.getRoomId());
    }

    public void delete(int hotelId) {
        String sql="delete from hotel where hotel_id=?";
        jdbcTemplate.update(sql, hotelId);
    }
}
