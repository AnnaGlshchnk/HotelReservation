package com.anna.entity;

public class HotelWithRoom {

    private Integer hotelId;
    private String name;
    private Integer roomId;
    private Integer price;

    public HotelWithRoom(Integer hotelId, String name, Integer roomId, Integer price) {
        this.name = name;
        this.hotelId = hotelId;
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
}
