package com.anna.mapper;

import com.anna.entity.Reservation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservMapper implements RowMapper {

    public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {

        Reservation reservation = new Reservation();
        reservation.setReservId(resultSet.getInt("reserv_id"));
        reservation.setStartReserv(resultSet.getString("start_reserv"));
        reservation.setEndReserv(resultSet.getString("end_reserv"));
        reservation.setRoomId(resultSet.getInt("room_id"));
        reservation.setGuestId(resultSet.getInt("guest_id"));
        return reservation;
    }
}

