package com.anna.dao;

import com.anna.model.Guest;
import com.anna.model.SaveGuest;

import java.util.List;

public interface GuestDao {

    List<Guest> getGuests();

    Guest getGuestById(Integer guestId);

    Integer addGuest(SaveGuest guest);

    Integer updateGuest(Integer guestId, SaveGuest guest);

}
