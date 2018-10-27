package com.anna.entity;

public class Hotel {
    private Integer hotelId;
    private String name;
    private Room room;

    public Hotel() {

    }

    public Hotel(String name) {
        this.name = name;
    }

    public Hotel(Integer hotelId, String name) {
        this.name = name;
        this.hotelId = hotelId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


}

