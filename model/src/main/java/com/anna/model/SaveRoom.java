package com.anna.model;

public class SaveRoom {

    private long roomId;

    public SaveRoom() {
    }

    public SaveRoom(long roomId) {
        this.roomId = roomId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}
