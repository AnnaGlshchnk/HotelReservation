package com.anna.model;

import java.util.List;

public class GuestDetails {

    private long guestId;
    private String firstName;
    private String surname;
    private List<ReservationData> reservation;
    private List<Room> room;

    public GuestDetails(long guestId) {
        this.guestId = guestId;
    }

    public GuestDetails(long guestId, String firstName, String surname, List<ReservationData> reservation, List<Room> room) {
        this.guestId = guestId;
        this.firstName = firstName;
        this.surname = surname;
        this.reservation = reservation;
        this.room = room;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<ReservationData> getReservation() {
        return reservation;
    }

    public void setReservation(List<ReservationData> reservation) {
        this.reservation = reservation;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }
}
