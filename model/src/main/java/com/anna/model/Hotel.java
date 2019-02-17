package com.anna.model;

import java.util.List;

public class Hotel {

    private long hotelId;
    private String hotelName;
    private int countOfRoom;
    private List<Room> rooms;

    public Hotel() {
    }

    public Hotel(long hotelId) {
        this.hotelId = hotelId;
    }

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
    }

    public Hotel(long hotelId, String hotelName, int countOfRoom) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.countOfRoom = countOfRoom;
    }

    public Hotel(long hotelId, String hotelName, List<Room> rooms) {
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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getCountOfRoom() {
        return countOfRoom;
    }

    public void setCountOfRoom(int countOfRoom) {
        this.countOfRoom = countOfRoom;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
