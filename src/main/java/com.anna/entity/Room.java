package com.anna.entity;

public class Room {

    private Integer  roomId;
    private Integer price;

    public Room() {

    }

    public Room(Integer price) {
        this.price = price;
    }
    public Room(Integer roomId, Integer price) {
        this.price = price;
        this.roomId = roomId;
    }

    public int getId() {
        return roomId;
    }

    public void setId(Integer roomId) {
        this.roomId = roomId;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

}
