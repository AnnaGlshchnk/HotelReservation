package com.anna.model;

import java.util.List;

public class Hotel {

    private int hotelId;
    private String hotelName;
    private int countOfRoom;
    private List<Room> rooms;

    public Hotel() {
    }

    public Hotel(int hotelId) {
        this.hotelId = hotelId;
    }

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
    }

    public Hotel(int hotelId, String hotelName, int countOfRoom) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.countOfRoom = countOfRoom;
    }

    public Hotel(int hotelId, String hotelName, List<Room> rooms) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.rooms = rooms;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
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
