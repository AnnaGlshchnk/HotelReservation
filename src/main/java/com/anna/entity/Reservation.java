package com.anna.entity;

import java.util.List;

public class Reservation {

    private int reservId;
    private String startReserv;
    private String endReserv;
    private int roomId;
    private  int guestId;
    private Guest guest;


    public Reservation() {
    }

    public Reservation(String startReserv, String endReserv, int roomId, int guestId) {
        this.startReserv = startReserv;
        this.endReserv = endReserv;
        this.roomId = roomId;
        this.guestId = guestId;
    }

    public Reservation(int reservId, String startReserv, String endReserv, int roomId, int guestId) {
        this.reservId = reservId;
        this.startReserv = startReserv;
        this.endReserv = endReserv;
        this.roomId = roomId;
        this.guestId = guestId;
    }

    public Reservation(int reservId, String startReserv, String endReserv, int roomId, Guest guest) {
        this.reservId = reservId;
        this.startReserv = startReserv;
        this.endReserv = endReserv;
        this.roomId = roomId;
        this.guest = guest;
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

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

}
