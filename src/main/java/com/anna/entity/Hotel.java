package com.anna.entity;

public class Hotel {

    private int hotelId;
    private String hotel;

    public Hotel() {
    }

    public Hotel(int hotelId, String hotel) {
        this.hotelId = hotelId;
        this.hotel = hotel;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }


}
