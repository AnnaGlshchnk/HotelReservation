package com.anna.dao;

import com.anna.config.DaoTestConfig;
import com.anna.dao.api.GuestDao;
import com.anna.model.Guest;
import com.anna.model.SaveGuest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoTestConfig.class)
@Transactional
public class GuestDaoImplTest {
    private static final Logger LOGGER = LogManager.getLogger(GuestDaoImplTest.class);

    @Autowired
    private GuestDao guestDao;

    @Test
    public void getGuestsTest() {
        LOGGER.debug("service: getGuestsTest");

        List<Guest> guests = guestDao.getGuests();
        Assert.assertEquals(guests.size(), 4);
    }

    @Test
    public void getGuestByIdTest() {
        LOGGER.debug("service: getGuestByIdTest");

        Guest guest = guestDao.getGuestById(1);
        Assert.assertNotNull(guest);
        Assert.assertEquals(guest.getGuestId(), 1);
        Assert.assertEquals(guest.getFirstName(), "Klaus");
        Assert.assertEquals(guest.getSurname(), "Schmidt");
    }

    @Test
    public void addGuestTest() {
        LOGGER.debug("service: addGuestTest");

        SaveGuest guest = new SaveGuest("Alan", "Lods");
        guestDao.addGuest(guest);
        Guest newGuest = guestDao.getGuestById(5);
        Assert.assertNotNull(newGuest);
    }

    @Test
    public void updateGuestTest() {
        LOGGER.debug("service: updateGuestTest");

        SaveGuest guest = new SaveGuest("Hilary", "Willis");
        guest.setFirstName("Hillary");
        guestDao.updateGuest(2, guest);
        Guest newGuest = guestDao.getGuestById(2);
        Assert.assertEquals(newGuest.getFirstName(), "Hillary");
    }
}