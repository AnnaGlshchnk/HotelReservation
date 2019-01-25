package com.anna.dao;

import com.anna.dto.Hotel;
import com.anna.dto.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.query(getHotelsSql, mapSqlParameterSource, new HotelMapper());
    }

    public Hotel getHotelById(Integer hotelId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource(HOTEL_ID, hotelId);
        return namedParameterJdbcTemplate.queryForObject(getHotelByIdSql, mapSqlParameterSource, new HotelDetailsMapper());
    }

    public List<Room> getRooms() {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.query(getRoomsSql, mapSqlParameterSource, new RoomMapper());
    }

    public Room getRoomById(Integer roomId) {
        return null;
    }

    private class HotelMapper implements RowMapper<Hotel> {
        @Override
        public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Hotel(rs.getInt("hotel_id"),
                    rs.getString("hotel_name"),
                    rs.getInt("countOfRooms"));
        }
    }

    private class HotelDetailsMapper implements RowMapper<Hotel> {
        @Override
        public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hotel hotel = new Hotel(rs.getInt("hotel_id"),
                    rs.getString("hotel_name"),
                    new ArrayList<>());

            do{
                hotel.getRooms().add(new Room(rs.getInt("room_number")));
            }while (rs.next());

            return hotel;
        }
    }

    private class RoomMapper implements RowMapper<Room> {
        @Override
        public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Room(rs.getInt("room_id"),
                    rs.getInt("room_number"),
                    new Hotel(rs.getInt("hotel_id")));
        }
    }
}
