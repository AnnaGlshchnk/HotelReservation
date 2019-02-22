package com.anna.dao.api;

import com.anna.model.Guest;
import com.anna.model.GuestDetails;
import com.anna.model.GuestList;
import com.anna.model.SaveGuest;

import java.util.List;

public interface GuestDao {

    List<GuestList> getGuests();

    GuestDetails getGuestById(Integer guestId);

    Integer addGuest(SaveGuest guest);

    Integer updateGuest(Integer guestId, SaveGuest guest);

}
