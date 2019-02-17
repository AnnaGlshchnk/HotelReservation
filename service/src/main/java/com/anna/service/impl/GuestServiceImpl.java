package com.anna.service.impl;

import com.anna.dao.api.GuestDao;
import com.anna.model.Guest;
import com.anna.model.SaveGuest;
import com.anna.service.api.GuestService;
import com.anna.service.exception.OperationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    private GuestDao guestDao;

    @Autowired
    public GuestServiceImpl(GuestDao guestDao) {
        this.guestDao = guestDao;
    }

    @Override
    public List<Guest> getGuests() throws OperationFailedException {
        return guestDao.getGuests();
    }

    @Override
    public Guest getGuestById(Integer guestId) throws OperationFailedException {
        return guestDao.getGuestById(guestId);
    }

    @Override
    public Integer addGuest(SaveGuest guest) throws OperationFailedException {
        return guestDao.addGuest(guest);
    }

    @Override
    public Integer updateGuest(Integer guestId, SaveGuest guest) throws OperationFailedException {
        return guestDao.updateGuest(guestId, guest);
    }
}
