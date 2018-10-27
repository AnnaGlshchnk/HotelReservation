package com.anna.service;

import com.anna.DAO.HotelReservationImpl;
import com.anna.entity.*;
import com.anna.service.exception.OperationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Transactional
public class HotelReservationServiceImpl implements HotelReservationService {

    private HotelReservationImpl hotelReservation;

    @Autowired
    public HotelReservationServiceImpl(HotelReservationImpl hotelReservation) {
        this.hotelReservation = hotelReservation;
    }

    @Override
    public List<HotelWithRoom> getHotel() {
        return hotelReservation.getHotel();
    }

    @Override
    public Hotel getHotelByName(String name) {
        Assert.notNull(name, "name should not be empty");
        return hotelReservation.getHotelByName(name);
    }

    @Override
    public List<RoomWithReservation> getRoom() {
        return hotelReservation.getRoom();
    }

    @Override
    public Room getRoomByPrice(Integer price) {
        Assert.notNull(price, "price should not be empty");
        return hotelReservation.getRoomByPrice(price);
    }

    @Override
    public List<Guest> getGuest() {
        return hotelReservation.getGuest();
    }

    @Override
    public Guest getGuestById(Integer guestId) {
        Assert.notNull(guestId, "guestId should not be empty");
        return hotelReservation.getGuestById(guestId);
    }

    @Override
    public Guest getGuestByName(String fName, String sName) {
        Assert.notNull(fName, "fName should not be empty");
        Assert.notNull(sName,"sName should not be empty");
        return hotelReservation.getGuestByName(fName, sName);
    }

    @Override
    public Integer addGuest(Guest guest) {
        Assert.notNull(guest, "guest should not be null");
        Assert.isNull(guest.getGuestId(), "Guest ID should be null");
        Assert.hasText(guest.getFName(), "Guest should  have a name");
        Assert.hasText(guest.getSName(), "Guest should  have a surname");
        return hotelReservation.addGuest(guest);
    }

    @Override
    public void updateGuest(Guest guest) {
        Assert.notNull(guest, "guest should not be null");
        Assert.isNull(guest.getGuestId(), "Guest ID should be null");
        Assert.hasText(guest.getFName(), "Guest should  have a name");
        Assert.hasText(guest.getSName(), "Guest should  have a surname");

        if(hotelReservation.updateGuest(guest)!=1){
            throw new OperationFailedException("Operation Failed");
        }
    }

    @Override
    public void deleteGuest(Integer guestId) {
        Assert.notNull(guestId, "Guest Id should not be empty");
        if(hotelReservation.deleteGuest(guestId)!=1){
            throw new OperationFailedException("Operation Failed");
        }
    }

    @Override
    public List<ReservationWithRoom> getReserv() {
        return hotelReservation.getReserv();
    }

    @Override
    public Reservation getReservById(Integer reservId) {
        Assert.notNull(reservId, "reservId should not be empty");
        return hotelReservation.getReservById(reservId);
    }

    @Override
    public Integer addReserv(Reservation reservation) {
        Assert.notNull(reservation, "reservation should not be null");
        Assert.isNull(reservation.getReservId(), "Reservation ID should be null");
        Assert.hasText(reservation.getStartReserv(), "Reservation should  have start");
        Assert.hasText(reservation.getEndReserv(), "Reservation should  have end");
        return hotelReservation.addReserv(reservation);
    }

    @Override
    public void updateReserv(Reservation reservation) {
        Assert.notNull(reservation, "reservation should not be null");
        Assert.isNull(reservation.getReservId(), "Reservation ID should be null");
        Assert.hasText(reservation.getStartReserv(), "Reservation should  have start");
        Assert.hasText(reservation.getEndReserv(), "Reservation should  have end");

        if(hotelReservation.updateReserv(reservation)!=1){
            throw new OperationFailedException("Operation Failed");
        }
    }

    @Override
    public void deleteReserv(Integer reservId) {
        Assert.notNull(reservId, "reservation ID should not be empty");
        if(hotelReservation.deleteGuest(reservId)!=1){
            throw new OperationFailedException("Operation Failed");
        }
    }
}
