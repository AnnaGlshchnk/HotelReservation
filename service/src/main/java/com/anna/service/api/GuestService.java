package com.anna.service.api;

import com.anna.model.Guest;
import com.anna.model.SaveGuest;
import com.anna.service.exception.OperationFailedException;

import java.util.List;

public interface GuestService {

    List<Guest> getGuests() throws OperationFailedException;

    Guest getGuestById(Integer guestId) throws OperationFailedException;

    Integer addGuest(SaveGuest guest) throws OperationFailedException;

    Integer updateGuest(Integer guestId, SaveGuest guest) throws OperationFailedException;
}
