package com.anna.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SaveReservation {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date startReservation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date finishReservation;
    @NotNull
    private Guest guest;
    @NotNull
    private SaveRoom room;

    public SaveReservation() {
    }

    public SaveReservation(Date startReservation, Date finishReservation, SaveRoom room, Guest guest) {
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

    public SaveRoom getRoom() {
        return room;
    }

    public void setRoom(SaveRoom room) {
        this.room = room;
    }
}
