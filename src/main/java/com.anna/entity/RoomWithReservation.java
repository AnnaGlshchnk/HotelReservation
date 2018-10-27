package com.anna.entity;

import org.springframework.jdbc.core.RowCallbackHandler;

public class RoomWithReservation {

    private Integer roomId;
    private Integer reservId;
    private String startReserv;
    private String endReserv;

    public RoomWithReservation(Integer roomId, Integer reservId, String startReserv, String endReserv) {
        this.reservId = reservId;
        this.startReserv = startReserv;
        this.endReserv = endReserv;
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
}
