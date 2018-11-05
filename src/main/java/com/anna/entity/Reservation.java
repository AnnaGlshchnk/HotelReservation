package com.anna.entity;

public class Reservation {

    private int reservId;
    private String startReserv;
    private String endReserv;
    private int roomId;
    private int guestId;

    public Reservation() {
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

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }
}
