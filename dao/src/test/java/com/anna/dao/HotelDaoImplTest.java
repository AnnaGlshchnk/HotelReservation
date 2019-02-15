package com.anna.dao;

import com.anna.config.DaoTestConfig;
import com.anna.model.Hotel;
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
public class HotelDaoImplTest {
    private static final Logger LOGGER = LogManager.getLogger(HotelDaoImplTest.class);

    @Autowired
    private HotelDao hotelDao;

    @Test
    public void getHotelsTest() {
        LOGGER.debug("service: getHotelsTest");

        List<Hotel> hotels = hotelDao.getHotels();
        Assert.assertEquals(hotels.size(), 3);
    }

    @Test
    public void getHotelByIdTest() {
        LOGGER.debug("service: getHotelByIdTest");

        Hotel hotel = hotelDao.getHotelById(1);
        Assert.assertNotNull(hotel);
        Assert.assertEquals(hotel.getHotelId(), 1);
        Assert.assertEquals(hotel.getHotelName(), "Hilton");

    }
}