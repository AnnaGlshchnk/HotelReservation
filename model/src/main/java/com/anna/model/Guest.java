package com.anna.model;

public class Guest {

    private long guestId;
    private String firstName;
    private String surname;
    private Reservation reservation;

    public Guest() {
    }

    public Guest(long guestId) {
        this.guestId = guestId;
    }

    public Guest(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public Guest(long guestId, String firstName, String surname) {
        this.guestId = guestId;
        this.firstName = firstName;
        this.surname = surname;
    }

    public Guest(long guestId, String firstName, String surname, Reservation reservation) {
        this.guestId = guestId;
        this.firstName = firstName;
        this.surname = surname;
        this.reservation = reservation;
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
