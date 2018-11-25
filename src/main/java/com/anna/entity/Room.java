package com.anna.entity;

import java.util.List;

public class Room {
    private int roomId;
    private int price;
    private int hotelId;


    public Room() {
    }

    public Room(int roomId, int price, int hotelId) {
        this.roomId = roomId;
        this.price = price;
        this.hotelId = hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

}

