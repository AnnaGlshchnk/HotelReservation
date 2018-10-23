package com.anna.entity;

public class Reservation {

    private Integer  reservId;
    private String  startReserv;
    private String   endReserv;
    private Integer  roomId;

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

    public void setreservId(Integer reservId) {
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}
