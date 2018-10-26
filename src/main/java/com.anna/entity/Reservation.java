package com.anna.entity;

import java.awt.*;


public class Reservation {

    private Integer  reservId;
    private String  startReserv;
    private String   endReserv;
    private Room room;
    private  Guest guest;
    //private List<Room> room;

    public Reservation() {

    }

    public Reservation(String  startReserv, String   endReserv) {
        this.startReserv = startReserv;
        this.endReserv = endReserv;
    }
    public Reservation(Integer reservId, String  startReserv, String   endReserv){
        this.reservId = reservId;
        this.startReserv = startReserv;
        this.endReserv = endReserv;
    }


    public int getReservId() {
        return reservId;
    }

    public void setReservId(Integer reservId) {
        this.reservId = reservId;
    }

    public void setStartReserv(String  startReserv) {
        this.startReserv = startReserv;
    }

    public String getStartReserv() {
        return startReserv;
    }

    public void setEndReserv(String  endReserv) {
        this.endReserv = endReserv;
    }

    public String getEndReserv() {
        return endReserv;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
