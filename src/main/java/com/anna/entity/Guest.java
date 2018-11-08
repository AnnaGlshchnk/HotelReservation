package com.anna.entity;

public class Guest {

    private  int guestId;
    private  String firstName;
    private String surname;

    public Guest(int guestId, String firstName, String surname) {
        this.guestId = guestId;
        this.firstName = firstName;
        this.surname = surname;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
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
}
