package com.anna.model;

import java.util.Date;

public class SaveReservation {

    private Date startReservation;
    private Date finishReservation;
    private Guest guest;
    private Room room;

    public SaveReservation() {
    }

    public SaveReservation(Date startReservation, Date finishReservation, Room room, Guest guest) {
        this.startReservation = startReservation;
        this.finishReservation = finishReservation;
        this.room = room;
        this.guest = guest;
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
}