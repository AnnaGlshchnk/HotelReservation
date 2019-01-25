package com.anna.dao;

import com.anna.dto.Guest;
import com.anna.dto.Reservation;
import com.anna.dto.SaveGuest;
import com.anna.dto.SaveReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestReservationDaoImpl implements GuestReservationDao {

    private static String GUEST_ID="guestId";
    private static String FIRST_NAME="firstName";
    private static String SURNAME="surname";

    private static String RESERVATION_ID="reservationId";
    private static String START_RESERVATION="startReservation";
    private static String END_RESERVATION="endReservation";
    private static String ROOM_ID="roomId";

    @Value("${hotelreservation.getGuests}")
    private String getGuestsSql;
    @Value("${hotelreservation.getGuestById}")
    private String getGuestByIdSql;
    @Value("${hotelreservation.addGuest}")
    private String addGuestSql;
    @Value("${hotelreservation.updateGuest}")
    private String updateGuestSql;
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
    public GuestReservationDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Guest> getGuests() {
        return null;
    }

    public Guest getGuestById(Integer guestId) {
        return null;
    }

    public Integer addGuest(SaveGuest guest) {
        return null;
    }

    public Integer updateGuest(Integer guestId, SaveGuest guest) {
        return null;
    }

    public List<Reservation> getReservations() {
        return null;
    }

    public Reservation getReservationById(Integer reservationId) {
        return null;
    }

    public Integer addReservation(SaveReservation reservation) {
        return null;
    }

    public Integer updateReservation(Integer reservationId, SaveReservation reservation) {
        return null;
    }

    public Integer deleteReservation(Integer reservationId) {
        return null;
    }
}
