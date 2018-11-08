package com.anna.mapper;

import com.anna.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RoomMapper implements RowMapper{

    public Room mapRow(ResultSet resultSet, int i) throws SQLException {

        Room room = new Room();
        room.setRoomId(resultSet.getInt("room_id"));
        room.setPrice(resultSet.getInt("price"));
        room.setHotelId(resultSet.getInt("hotel_id"));
        return room;
    }
}
