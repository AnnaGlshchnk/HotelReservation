package com.anna.dao;

import com.anna.model.Guest;
import com.anna.model.Reservation;
import com.anna.model.Room;
import com.anna.model.SaveGuest;
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
public class GuestDaoImpl implements GuestDao {

    private static String GUEST_ID="guestId";
    private static String FIRST_NAME="firstName";
    private static String SURNAME="surname";

    @Value("${hotelreservation.getGuests}")
    private String getGuestsSql;
    @Value("${hotelreservation.getGuestById}")
    private String getGuestByIdSql;
    @Value("${hotelreservation.addGuest}")
    private String addGuestSql;
    @Value("${hotelreservation.updateGuest}")
    private String updateGuestSql;
    @Value("${hotelreservation.getReservations}")

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public GuestDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Guest> getGuests() {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.query(getGuestsSql, mapSqlParameterSource, new GuestMapper());
    }

    @Override
    public Guest getGuestById(Integer guestId) {
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

    private class GuestMapper implements RowMapper<Guest> {
        @Override
        public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Guest(rs.getInt("guest_id"),
                             rs.getString("first_name"),
                             rs.getString("surname"));
        }
    }

    private class GuestWithDetailsMapper implements RowMapper<Guest> {
        @Override
        public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Guest(rs.getInt("guest_id"),
                    rs.getString("first_name"),
                    rs.getString("surname"),
                    new Reservation(rs.getInt("reservation_id"),
                            new Room(rs.getInt("room_id")),
                                    rs.getDate("start_reservation"),
                                    rs.getDate("end_reservation")));
        }
    }
}
