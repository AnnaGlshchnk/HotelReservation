package com.anna.service.mock;

import com.anna.config.ServiceTestConfig;
import com.anna.dao.api.GuestDao;
import com.anna.model.Guest;
import com.anna.model.GuestDetails;
import com.anna.model.GuestList;
import com.anna.model.SaveGuest;
import com.anna.service.impl.GuestServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
public class GuestServiceImplMockTest {
    private static final Logger LOGGER = LogManager.getLogger(GuestServiceImplMockTest.class);

    @InjectMocks
    private GuestServiceImpl guestService;

    @Mock
    private GuestDao mockGuestDao;

    public GuestServiceImplMockTest() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void after() {
        Mockito.reset(mockGuestDao);
    }

    @Test
    public void getGuestsTest() {
        LOGGER.debug("service: getGuestsTest");

        List<GuestList> guests = new ArrayList<>();
        Mockito.when(mockGuestDao.getGuests()).thenReturn(guests);

        guests = guestService.getGuests();
        Assert.assertEquals(0, guests.size());
    }

    @Test
    public void getGuestByIdTest() {
        LOGGER.debug("service: getGuestByIdTest");

        Mockito.when(mockGuestDao.getGuestById(1)).thenReturn(new GuestDetails(1));

        GuestDetails guest = guestService.getGuestById(1);
        Assert.assertEquals(1, guest.getGuestId());
    }

    @Test
    public void addGuestTest() {
        LOGGER.debug("service: getGuestByIdTest");

        SaveGuest guest = new SaveGuest("Alan", "Lods");
        Mockito.when(mockGuestDao.addGuest(guest)).thenReturn(5);

        Integer guestId = guestService.addGuest(guest);
        Assert.assertEquals(Integer.valueOf(5), guestId);
    }

    @Test
    public void updateGuestTest() {
        LOGGER.debug("service: updateGuestTest");

        Mockito.when(mockGuestDao.updateGuest(Mockito.any(), Mockito.any())).thenReturn(1);
        SaveGuest guest = new SaveGuest("Hilary", "Willis");
        guest.setFirstName("Hillary");

        Integer guestId = guestService.updateGuest(1, guest);
        Assert.assertEquals(Integer.valueOf(1), guestId);
    }

}
