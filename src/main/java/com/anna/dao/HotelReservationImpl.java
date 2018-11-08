package com.anna.dao;


import com.anna.entity.*;
import com.anna.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelReservationImpl implements HotelReservationDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HotelReservationImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Hotel> showHotel() {
        String sql = "select * from hotel";
        return jdbcTemplate.query(sql, new HotelMapper());
    }

    public List<Room> showRoom(int hotelId){
        String sql = "select * from room where hotel_id=?";
        return jdbcTemplate.query(sql, new RoomMapper(), hotelId);
    }

    public List<ReservationAndGuest> showReservationAndGuest(int roomId) {
        String sql = "select reservation.reserv_id, reservation.start_reserv, reservation.end_reserv, reservation.room_id, guest.first_name, guest.surname from reservation left join guest on reservation.guest_id=guest.guest_id where room_id=?";
        return jdbcTemplate.query(sql, new ReservAngGuestMapper(), roomId);
    }

    public void addReservationAndGuest(ReservationAndGuest reservationAndGuest) {

        String sql = "insert into reservation";
        jdbcTemplate.update(sql, reservationAndGuest.getReservId(),reservationAndGuest.getStartReserv(),
                                 reservationAndGuest.getEndReserv(), reservationAndGuest.getFirstName(),
                                 reservationAndGuest.getSurname());
    }

    public void updateReservationAndGuest(ReservationAndGuest reservationAndGuest) {

    }

    public void deleteReservationAndGuest(ReservationAndGuest reservationAndGuest) {

    }


}