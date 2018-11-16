package com.anna.dao;


import com.anna.entity.*;
import com.anna.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelReservationImpl implements HotelReservationDao{

    private static final String HOTEL_ID = "hotelId";
    private static final String ROOM_ID = "roomId";
    private static final String START_RESERVATION = "startReserv";
    private static final String END_RESERVATION = "endReserv";
    private static final String GUEST_ID = "guestId";
    private static final String RESERV_ID = "reservId";

    @Value("${HotelReservationDaoSql.showHotel}")
    private String showHotelSql;
    @Value("${HotelReservationDaoSql.showRoom}")
    private String showRoomSql;
    @Value("${HotelReservationDaoSql.showReservation}")
    private String showReservationSql;
    @Value("${HotelReservationDaoSql.addReservation}")
    private String addReservationSql;
    @Value("${HotelReservationDaoSql.updateReservation}")
    private String updateReservationSql;
    @Value("${HotelReservationDaoSql.deleteReservation}")
    private String deleteReservationSql;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public HotelReservationImpl(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Hotel> showHotel() {
        return jdbcTemplate.query(showHotelSql, new HotelMapper());
    }

    public List showRoom(int hotelId){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource(HOTEL_ID, hotelId);
        return  jdbcTemplate.query(showRoomSql, parameterSource, new RoomMapper());
    }

    public List showReservation(int roomId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource(ROOM_ID, roomId);
        return jdbcTemplate.query(showReservationSql, parameterSource,new ReservationMapper());
    }

    public int addReservation(Reservation reservation) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(START_RESERVATION, reservation.getStartReserv());
        parameterSource.addValue(END_RESERVATION, reservation.getEndReserv());
        parameterSource.addValue(ROOM_ID, reservation.getRoomId());
        parameterSource.addValue(GUEST_ID, reservation.getGuestId());
        jdbcTemplate.update(addReservationSql, parameterSource, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public int updateReservation(Reservation reservation) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(START_RESERVATION, reservation.getStartReserv());
        parameterSource.addValue(END_RESERVATION, reservation.getEndReserv());
        parameterSource.addValue(ROOM_ID, reservation.getRoomId());
        parameterSource.addValue(GUEST_ID, reservation.getGuestId());
        parameterSource.addValue(RESERV_ID, reservation.getReservId());
        return jdbcTemplate.update(updateReservationSql, parameterSource);


    }

    public int deleteReservation(int reservId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource(RESERV_ID, reservId);
        return jdbcTemplate.update(deleteReservationSql,parameterSource);

    }
}