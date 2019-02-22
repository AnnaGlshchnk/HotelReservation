package com.anna.dao.impl;

import com.anna.dao.api.GuestDao;
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
import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestDaoImpl implements GuestDao {

    private static String GUEST_ID = "guestId";
    private static String FIRST_NAME = "firstName";
    private static String SURNAME = "surname";

    @Value("${hotelreservation.getGuests}")
    private String getGuestsSql;
    @Value("${hotelreservation.getGuestById}")
    private String getGuestByIdSql;
    @Value("${hotelreservation.addGuest}")
    private String addGuestSql;
    @Value("${hotelreservation.updateGuest}")
    private String updateGuestSql;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public GuestDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<GuestList> getGuests() {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.query(getGuestsSql, mapSqlParameterSource, new GuestMapper());
    }

    @Override
    public GuestDetails getGuestById(Integer guestId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource(GUEST_ID, guestId);
        return namedParameterJdbcTemplate.queryForObject(getGuestByIdSql, mapSqlParameterSource, new GuestWithDetailsMapper());
    }

    @Override
    public Integer addGuest(SaveGuest guest) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(FIRST_NAME, guest.getFirstName());
        mapSqlParameterSource.addValue(SURNAME, guest.getSurname());

        namedParameterJdbcTemplate.update(addGuestSql, mapSqlParameterSource, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public Integer updateGuest(Integer guestId, SaveGuest guest) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(GUEST_ID, guestId);
        mapSqlParameterSource.addValue(FIRST_NAME, guest.getFirstName());
        mapSqlParameterSource.addValue(SURNAME, guest.getSurname());

        return namedParameterJdbcTemplate.update(updateGuestSql, mapSqlParameterSource);
    }

    private class GuestMapper implements RowMapper<GuestList> {
        @Override
        public GuestList mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new GuestList(new Guest(rs.getLong("guest_id")),
                    new GuestData(rs.getString("first_name"),
                    (rs.getString("surname"))));
        }
    }

    private class GuestWithDetailsMapper implements RowMapper<GuestDetails> {
        @Override
        public GuestDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            GuestDetails guestDetails =  new GuestDetails(rs.getLong("guest_id"),
                    rs.getString("first_name"),
                    rs.getString("surname"),
                    new ArrayList<>(),
                    new ArrayList<>());

            do {
                guestDetails.getReservation().add(new ReservationData(rs.getLong("reservation_id"),
                        rs.getDate("start_reservation"),
                        rs.getDate("end_reservation")));
                guestDetails.getRoom().add(new Room(rs.getInt("room_number")));
            } while (rs.next());

            return guestDetails;
        }
    }
}
