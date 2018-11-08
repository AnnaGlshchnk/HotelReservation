package com.anna.mapper;

import com.anna.entity.Guest;
import com.anna.entity.Reservation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationMapper implements RowMapper {

    public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {

        Reservation reservation = new Reservation();
        reservation.setReservId(resultSet.getInt("reserv_id"));
        reservation.setStartReserv(resultSet.getString("start_reserv"));
        reservation.setEndReserv(resultSet.getString("end_reserv"));
        reservation.setRoomId(resultSet.getInt("room_id"));
        reservation.setGuest(new Guest(resultSet.getInt("guest_id"), resultSet.getString("first_name"),
                                        resultSet.getString("surname")));

        return reservation;
    }
}

