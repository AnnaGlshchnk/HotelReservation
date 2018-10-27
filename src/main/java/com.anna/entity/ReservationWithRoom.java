package com.anna.entity;

public class ReservationWithRoom {

    private Integer reservId;
    private String startReserv;
    private String endReserv;
    private Integer roomId;
    private Integer price;

    public ReservationWithRoom(Integer reservId, String startReserv, String endReserv, Integer roomId, Integer price) {
        this.reservId = reservId;
        this.startReserv = startReserv;
        this.endReserv = endReserv;
        this.price = price;
        this.roomId = roomId;
    }

    public int getReservId() {
        return reservId;
    }

    public void setReservId(Integer reservId) {
        this.reservId = reservId;
    }

    public void setStartReserv(String startReserv) {
        this.startReserv = startReserv;
    }

    public String getStartReserv() {
        return startReserv;
    }

    public void setEndReserv(String endReserv) {
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

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
