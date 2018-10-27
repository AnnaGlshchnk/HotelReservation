package com.anna.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.anna.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class HotelReservationImpl implements hotelReservationDAO {

    private static final String HOTEL_Name = "hotelName";
    private static final String GUEST_ID = "guestId";
    private static final String FIRST_NAME = "firstName";
    private static final String SURNAME = "surname";
    private static final String RESERV_ID = "reservId";
    private static final String START_RESERV = "startReserv";
    private static final String END_RESERV = "endReserv";
    private static final String ROOM_ID = "roomId";
    private static final String PRICE = "price";

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
    @Value("${hotelReservationDAOSql.getReservById}")
    private String getReservByIdSql;
    @Value("${hotelReservationDAOSql.addReserv}")
    private String addReservSql;
    @Value("${hotelReservationDAOSql.updateReserv}")
    private String updateReservSql;
    @Value("${hotelReservationDAOSql.deleteReserv}")
    private String deleteReservSQql;
    @Value("${hotelReservationDAOSql.getHotel}")
    private String getHotelSql;
    @Value("${hotelReservationDAOSql.getHotelByName}")
    private String getHotelByNameSql;
    @Value("${hotelReservationDAOSql.getRoom}")
    private String getRoomSql;
    @Value("${hotelReservationDAOSql.getRoomByPrice}")
    private String getRoomByPriceSql;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public HotelReservationImpl(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<HotelWithRoom> getHotel() {
        return namedParameterJdbcTemplate.query(getHotelSql, new HotelWithRoomRowMapper());
    }


    @Override
    public Hotel getHotelByName(String name) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(HOTEL_Name, name);

        return namedParameterJdbcTemplate.queryForObject(getHotelByNameSql, parameterSource, new HotelRowMapper());
    }

    @Override
    public List<RoomWithReservation> getRoom() {
        return namedParameterJdbcTemplate.query(getRoomSql, new RoomWithReservationRowMapper());
    }

    @Override
    public Room getRoomByPrice(Integer price) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(PRICE, price);

        return namedParameterJdbcTemplate.queryForObject(getRoomByPriceSql, parameterSource, new RoomRowMapper());
    }

    @Override
    public List<Guest> getGuest() {
        return namedParameterJdbcTemplate.query(getGuestSql, new GuestRowMapper());

    }

    @Override
    public Guest getGuestById(Integer guestId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(GUEST_ID, guestId);

        return namedParameterJdbcTemplate.queryForObject(getGuestByIdSql, parameterSource, new GuestRowMapper());
    }

    @Override
    public Guest getGuestByName(String fName, String sName) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(FIRST_NAME, fName);
        parameterSource.addValue(SURNAME, sName);

        return namedParameterJdbcTemplate.queryForObject(getGuestByNameSql, parameterSource, new GuestRowMapper());
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
    public List<ReservationWithRoom> getReserv() {
        return namedParameterJdbcTemplate.query(getReservSql, new ReservationWithRoomRowMapper());
    }

    @Override
    public Reservation getReservById(Integer reservId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(RESERV_ID, reservId);

        return namedParameterJdbcTemplate.queryForObject(getReservByIdSql, parameterSource, new ReservationRowMapper());
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
            return new Reservation(
                    resultSet.getInt("reserv_id"),
                    resultSet.getString("start_reserv"),
                    resultSet.getString("end_reserv"));
        }
    }

    private class ReservationWithRoomRowMapper implements RowMapper<ReservationWithRoom> {

        public ReservationWithRoom mapRow(ResultSet resultSet, int i) throws SQLException {
            ReservationWithRoom reservationWithRoom = new ReservationWithRoom(resultSet.getInt("reserv_id"),
                    resultSet.getString("start_reserv"), resultSet.getString("end_reserv"),
                    resultSet.getInt("room_Id"), resultSet.getInt("price"));
            return reservationWithRoom;
        }

    }

    private class GuestRowMapper implements RowMapper<Guest> {

        public Guest mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Guest(
                    resultSet.getInt("guest_id"),
                    resultSet.getString("fName"),
                    resultSet.getString("sName"));
        }
    }

    private class RoomRowMapper implements RowMapper<Room> {

        public Room mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Room(
                    resultSet.getInt("roomId"),
                    resultSet.getInt("price"));
        }
    }

    private class RoomWithReservationRowMapper implements RowMapper<RoomWithReservation> {

        public RoomWithReservation mapRow(ResultSet resultSet, int i) throws SQLException {
            RoomWithReservation roomWithReservation = new RoomWithReservation(resultSet.getInt("roomId"),
                    resultSet.getInt("reservId"), resultSet.getString("start_reserv"),
                    resultSet.getString("end_reserv"));
            return roomWithReservation;
        }

    }

    private class HotelRowMapper implements RowMapper<Hotel> {
        public Hotel mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Hotel(
                    resultSet.getInt("hotelId"),
                    resultSet.getString("name"));
        }
    }

    private class HotelWithRoomRowMapper implements RowMapper<HotelWithRoom> {

        public HotelWithRoom mapRow(ResultSet resultSet, int i) throws SQLException {
            HotelWithRoom hotelWithRoom = new HotelWithRoom(resultSet.getInt("hotelId"),
                    resultSet.getString("name"), resultSet.getInt("roomId"),
                    resultSet.getInt("price"));
            return hotelWithRoom;
        }
    }
}