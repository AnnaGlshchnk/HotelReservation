package com.anna.DAO;

import com.anna.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelReservationImpl implements hotelReservationDAO {

    private static final String HOTEL_ID = "hotelId";
    private static final String GUEST_ID = "guestId";
    private static final String FIRST_NAME = "firstName";
    private static final String SURNAME = "surname";
    private static final String RESERV_ID = "reservId";
    private static final String START_RESERV = "startReserv";
    private static final String END_RESERV = "endReserv";

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
    public Hotel getHotelById(Integer hotelId) { return null;}

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
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(FIRST_NAME, guest.getFName());
        parameterSource.addValue(SURNAME, guest.getSName());
        namedParameterJdbcTemplate.update(addGuestSql, parameterSource, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public Integer updateGuest(Guest guest) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(GUEST_ID, guest.getGuestId());
        parameterSource.addValue(FIRST_NAME, guest.getFName());
        parameterSource.addValue(SURNAME, guest.getSName());
        return namedParameterJdbcTemplate.update(updateGuestSql, parameterSource);
    }

    @Override
    public Integer deleteGuest(Integer guestId) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource(GUEST_ID, guestId);
        return namedParameterJdbcTemplate.update(deleteGuestSql, parameterSource);

    }

    @Override
    public List<Reservation> getReserv() {
        return namedParameterJdbcTemplate.query(getReservSql, new ReservationRoomRowMapper());
    }

    @Override
    public Reservation getReservById(Integer reservId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(RESERV_ID, reservId);
        return  namedParameterJdbcTemplate.queryForObject(getReservByIdSql, parameterSource, new ReservationRowMapper());
    }

    @Override
    public Integer addReserv(Reservation reservation) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(START_RESERV, reservation.getStartReserv());
        parameterSource.addValue(END_RESERV, reservation.getEndReserv());
        namedParameterJdbcTemplate.update(addReservSql, parameterSource, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public Integer updateReserv(Reservation reservation) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(RESERV_ID, reservation.getReservId());
        parameterSource.addValue(START_RESERV, reservation.getStartReserv());
        parameterSource.addValue(END_RESERV, reservation.getEndReserv());
        return namedParameterJdbcTemplate.update(updateReservSql, parameterSource);
    }

    @Override
    public Integer deleteReserv(Integer reservId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(RESERV_ID, reservId);
        return namedParameterJdbcTemplate.update(deleteReservSQql, parameterSource);
    }

    private class ReservationRowMapper implements RowMapper<Reservation> {

        public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {

            Reservation reservation = new Reservation(resultSet.getInt("reserv_id"),
                    resultSet.getString("start_reserv"), resultSet.getString("end_reserv"));
            return reservation;
        }
    }

    private  class ReservationRoomRowMapper implements  RowMapper<Reservation>{

        public Reservation mapRow(ResultSet resultSet, int i) throws SQLException{
            Reservation reservation = new Reservation(resultSet.getInt("reserv_id"),
                    resultSet.getString("start_reserv"), resultSet.getString("end_reserv"));
                    Room room = new Room(resultSet.getInt("room_Id"), resultSet.getInt("price"));
                    return  reservation, room;
        }

    }

}
