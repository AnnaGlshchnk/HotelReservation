package com.anna.model;

import java.util.Date;

public class ReservationDetails {

    private long reservationId;
    private Date startReservation;
    private Date finishReservation;
    private GuestData guest;
    private Room room;
    private Hotel hotel;

    public ReservationDetails(long reservationId) {
        this.reservationId = reservationId;
    }

    public ReservationDetails(long reservationId, Date startReservation, Date finishReservation, GuestData guest, Room room, Hotel hotel) {
        this.reservationId = reservationId;
        this.startReservation = startReservation;
        this.finishReservation = finishReservation;
        this.guest = guest;
        this.room = room;
        this.hotel = hotel;
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getStartReservation() {
        return startReservation;
    }

    public void setStartReservation(Date startReservation) {
        this.startReservation = startReservation;
    }

    public Date getFinishReservation() {
        return finishReservation;
    }

    public void setFinishReservation(Date finishReservation) {
        this.finishReservation = finishReservation;
    }

    public GuestData getGuest() {
        return guest;
    }

    public void setGuest(GuestData guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
