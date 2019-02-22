package com.anna.service.impl;

import com.anna.config.ServiceTestConfig;
import com.anna.model.Guest;
import com.anna.model.GuestDetails;
import com.anna.model.GuestList;
import com.anna.model.SaveGuest;
import com.anna.service.api.GuestService;
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

import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
@Transactional
public class GuestServiceImplTest {

    private static final Logger LOGGER = LogManager.getLogger(GuestServiceImplTest.class);

    @Autowired
    GuestService guestService;

    @Test
    public void getGuestsTest() {
        LOGGER.debug("service: getGuestsTest");

        List<GuestList> guests = guestService.getGuests();
        Assert.assertEquals(4, guests.size());
    }

    @Test
    public void getGuestByIdTest() {
        LOGGER.debug("service: getGuestByIdTest");

        GuestDetails guest = guestService.getGuestById(1);
        Assert.assertThat(guest, allOf(hasProperty("guestId", equalTo(1L)),
                hasProperty("firstName", equalTo("Klaus")),
                hasProperty("surname", equalTo("Schmidt"))));
    }

    @Test
    public void addGuestTest() {
        LOGGER.debug("service: getGuestByIdTest");

        SaveGuest guest = new SaveGuest("Alan", "Lods");
        guestService.addGuest(guest);
        GuestDetails newGuest = guestService.getGuestById(5);
        Assert.assertThat(newGuest, allOf(hasProperty("guestId", equalTo(5L)),
                hasProperty("firstName", equalTo("Alan")),
                hasProperty("surname", equalTo("Lods"))));
    }

    @Test
    public void updateGuestTest() {
        LOGGER.debug("service: updateGuestTest");

        SaveGuest guest = new SaveGuest("Hilary", "Willis");
        guest.setFirstName("Hillary");
        guestService.updateGuest(2, guest);
        GuestDetails newGuest = guestService.getGuestById(2);
        Assert.assertEquals(newGuest.getFirstName(), "Hillary");
    }
}