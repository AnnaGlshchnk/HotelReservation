package com.anna.model;

public class Room {

    private long roomId;
    private int roomNumber;
    private Hotel hotel;

    public Room() {
    }

    public Room(long roomId) {
        this.roomId = roomId;
    }

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Room(long roomId, int roomNumber, Hotel hotel) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.hotel = hotel;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
