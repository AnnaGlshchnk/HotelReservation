package com.anna.entity;

public class ReservationAndGuest {

    private int reservId;
    private String startReserv;
    private String endReserv;
    private int roomId;
    private String firstName;
    private String surname;

    public ReservationAndGuest() {
    }

    public int getReservId() {
        return reservId;
    }

    public void setReservId(int reservId) {
        this.reservId = reservId;
    }

    public String getStartReserv() {
        return startReserv;
    }

    public void setStartReserv(String startReserv) {
        this.startReserv = startReserv;
    }

    public String getEndReserv() {
        return endReserv;
    }

    public void setEndReserv(String endReserv) {
        this.endReserv = endReserv;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
