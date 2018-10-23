package com.anna.entity;

public class Room {

    private Integer  roomId;
    private Integer price;
    private Integer  hotelId;
    private Integer  reservId;

    public Room() {

    }

    public Room(Integer price) {
        this.price = price;
    }
    public Room(Integer roomId, Integer price) {
        this.price = price;
        this.roomId = roomId;
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

    public int getReservId() {
        return reservId;
    }

    public void setReservId(Integer reservId) {
        this.reservId = reservId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

}
