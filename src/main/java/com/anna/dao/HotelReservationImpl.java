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

    public List<Room> showRoom(int hotelId){
        String sql = "select room.room_id,room.price,room.hotel_id,room.reserv_id,hotel.hotel_id from room right join hotel on room.hotel_id=hotel.hotel_id where room.hotel_id=?";
        return jdbcTemplate.query(sql, new RoomMapper(), hotelId);
    }


    public Room getHotelByID(int hotelId) {
        String sql ="select * from room where hotel_id=1";
        return (Room) jdbcTemplate.query(sql, new RoomMapper(), hotelId);
    }


}
