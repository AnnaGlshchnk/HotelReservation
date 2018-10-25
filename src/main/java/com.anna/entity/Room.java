package com.anna.entity;

public class Room {

    private Integer  roomId;
    private Integer price;
    private Hotel hotel;
    private Reservation reservation;

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

    public Reservation getReserv() { return reservation; }

    public void setReserv(Reservation reservation) {
        this.reservation = reservation;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
