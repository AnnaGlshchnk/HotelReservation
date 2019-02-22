package com.anna.model;

public class HotelData {

    private long hotelId;
    private int countOfRoom;
    private Hotel hotelName;

    public HotelData() {
    }

    public HotelData(long hotelId) {
        this.hotelId = hotelId;
    }

    public HotelData(long hotelId, Hotel hotelName, int countOfRoom) {
        this.hotelId = hotelId;
        this.countOfRoom = countOfRoom;
        this.hotelName = hotelName;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public int getCountOfRoom() {
        return countOfRoom;
    }

    public void setCountOfRoom(int countOfRoom) {
        this.countOfRoom = countOfRoom;
    }

    public Hotel getHotelName() {
        return hotelName;
    }

    public void setHotelName(Hotel hotelName) {
        this.hotelName = hotelName;
    }
}
