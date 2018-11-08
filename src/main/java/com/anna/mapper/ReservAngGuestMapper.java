package com.anna.mapper;

import com.anna.entity.ReservationAndGuest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservAngGuestMapper implements RowMapper {

    public ReservationAndGuest mapRow(ResultSet resultSet, int i) throws SQLException {

        ReservationAndGuest reservationAndGuest = new ReservationAndGuest();
        reservationAndGuest.setReservId(resultSet.getInt("reserv_id"));
        reservationAndGuest.setStartReserv(resultSet.getString("start_reserv"));
        reservationAndGuest.setEndReserv(resultSet.getString("end_reserv"));
        reservationAndGuest.setRoomId(resultSet.getInt("room_id"));
        reservationAndGuest.setFirstName(resultSet.getString("first_name"));
        reservationAndGuest.setSurname(resultSet.getString("surname"));

        return reservationAndGuest;
    }
}

