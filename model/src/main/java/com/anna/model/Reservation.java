package com.anna.model;

import java.util.Date;

public class Reservation {

    private int reservationId;
    private Date startReservation;
    private Date finishReservation;
    private Guest guest;
    private Room room;
    private Hotel hotel;

    public Reservation() {
    }

    public Reservation(int reservationId, Room room, Date startReservation, Date finishReservation) {
        this.reservationId = reservationId;
        this.room = room;
        this.startReservation = startReservation;
        this.finishReservation = finishReservation;
    }

    public Reservation(int reservationId, Date startReservation, Date finishReservation, Room room, Guest guest) {
        this.reservationId = reservationId;
        this.startReservation = startReservation;
        this.finishReservation = finishReservation;
        this.room = room;
        this.guest = guest;
    }

    public Reservation(int reservationId, Date startReservation, Date finishReservation,  Room room, Hotel hotel, Guest guest) {
        this.reservationId = reservationId;
        this.startReservation = startReservation;
        this.finishReservation = finishReservation;
        this.guest = guest;
        this.room = room;
        this.hotel = hotel;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
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

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
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
