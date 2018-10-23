package com.anna.entity;

public class Guest {

    private Integer guestId;
    private String fName;
    private  String sName;
    private Integer reservId;

    public Guest() {

    }

    public Guest(String fName, String sName) {
        this.fName = fName;
        this.sName = sName;
    }
    public Guest(Integer guestId, String fName, String sName) {
        this.guestId = guestId;
        this.fName = fName;
        this.sName = sName;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFName() {
        return fName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSName() {
        return sName;
    }

    public int getReservId() {
        return reservId;
    }

    public void setReservId(Integer reservId) {
        this.reservId = reservId;
    }
}
