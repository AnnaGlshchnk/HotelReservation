package com.anna.dao;

import com.anna.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReservationDaoImpl implements ReservationDao {

    private static String RESERVATION_ID = "reservationId";
    private static String START_RESERVATION = "startReservation";
    private static String END_RESERVATION = "endReservation";
    private static String ROOM_ID = "roomId";

    @Value("${hotelreservation.getReservations}")
    private String getReservationSql;
    @Value("${hotelreservation.getReservationById}")
    private String getReservationByIdSql;
    @Value("${hotelreservation.addReservation}")
    private String addReservationSql;
    @Value("${hotelreservation.updateReservation}")
    private String updateReservationSql;
    @Value("${hotelreservation.deleteReservation}")
    private String deleteReservationSql;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ReservationDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Reservation> getReservations() {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        return namedParameterJdbcTemplate.query(getReservationSql, mapSqlParameterSource, new ReservationMapper());
    }

    public Reservation getReservationById(Integer reservationId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource(RESERVATION_ID, reservationId);

        return namedParameterJdbcTemplate.queryForObject(getReservationByIdSql, mapSqlParameterSource, new ReservationDetailsMapper());
    }

    public Integer addReservation(SaveReservation reservation) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(START_RESERVATION, reservation.getStartReservation());
        mapSqlParameterSource.addValue(END_RESERVATION, reservation.getFinishReservation());
        mapSqlParameterSource.addValue(ROOM_ID, reservation.getRoom().getRoomId());

        namedParameterJdbcTemplate.update(updateReservationSql, mapSqlParameterSource, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Integer updateReservation(Integer reservationId, SaveReservation reservation) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(RESERVATION_ID, reservationId);
        mapSqlParameterSource.addValue(START_RESERVATION, reservation.getStartReservation());
        mapSqlParameterSource.addValue(END_RESERVATION, reservation.getFinishReservation());
        mapSqlParameterSource.addValue(ROOM_ID, reservation.getRoom().getRoomId());

        return namedParameterJdbcTemplate.update(updateReservationSql, mapSqlParameterSource);
    }

    public Integer deleteReservation(Integer reservationId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(RESERVATION_ID, reservationId);

        return namedParameterJdbcTemplate.update(deleteReservationSql, mapSqlParameterSource);
    }

    private class ReservationMapper implements RowMapper<Reservation> {
        @Override
        public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Reservation(rs.getInt("reservation_id"),
                    rs.getDate("srart_reservation"),
                    rs.getDate("end_reservation"),
                    new Room(rs.getInt("room_id")),
                    new Guest(rs.getInt("guest_id")));
        }
    }

    private class ReservationDetailsMapper implements RowMapper<Reservation> {
        @Override
        public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Reservation(rs.getInt("reservation_id"),
                    rs.getDate("srart_reservation"),
                    rs.getDate("end_reservation"),
                    new Room(rs.getInt("room_number")),
                    new Hotel(rs.getString("hotel_name")),
                    new Guest(rs.getString("first_name"),
                            rs.getString("surname")));
        }
    }
}
