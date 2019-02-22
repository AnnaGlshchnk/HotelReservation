package com.anna.model;


import java.util.List;

public class HotelDetails {

    private long hotelId;
    private Hotel hotelName;
    private List<Room> rooms;

    public HotelDetails(long hotelId) {
        this.hotelId = hotelId;
    }

    public HotelDetails(long hotelId, Hotel hotelName, List<Room> rooms) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.rooms = rooms;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Hotel getHotelName() {
        return hotelName;
    }

    public void setHotelName(Hotel hotelName) {
        this.hotelName = hotelName;
    }
}
