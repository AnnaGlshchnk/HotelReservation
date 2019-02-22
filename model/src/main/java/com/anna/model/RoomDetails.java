package com.anna.model;

public class RoomDetails {

    private long roomId;
    private Room roomNumber;
    private Hotel hotelName;

    public RoomDetails(long roomId) {
        this.roomId = roomId;
    }

    public RoomDetails(long roomId, Room roomNumber, Hotel hotelName) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.hotelName = hotelName;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public Hotel getHotelName() {
        return hotelName;
    }

    public void setHotelName(Hotel hotelName) {
        this.hotelName = hotelName;
    }

    public Room getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Room roomNumber) {
        this.roomNumber = roomNumber;
    }
}
