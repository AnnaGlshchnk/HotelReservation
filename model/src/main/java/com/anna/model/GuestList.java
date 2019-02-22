package com.anna.model;

public class GuestList {

    private Guest guestId;
    private GuestData guestData;

    public GuestList(Guest guestId, GuestData guestData) {
        this.guestId = guestId;
        this.guestData = guestData;
    }

    public Guest getGuestId() {
        return guestId;
    }

    public void setGuestId(Guest guestId) {
        this.guestId = guestId;
    }

    public GuestData getGuestData() {
        return guestData;
    }

    public void setGuestData(GuestData guestData) {
        this.guestData = guestData;
    }
}
