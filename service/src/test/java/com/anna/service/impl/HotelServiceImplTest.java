package com.anna.service.impl;

import com.anna.config.ServiceTestConfig;
import com.anna.model.Hotel;
import com.anna.service.api.HotelService;
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
public class HotelServiceImplTest {
    private static final Logger LOGGER = LogManager.getLogger(HotelServiceImplTest.class);

    @Autowired
    HotelService hotelService;

    @Test
    public void getHotelsTest() {
        LOGGER.debug("service: getHotelsTest");

        List<Hotel> hotels = hotelService.getHotels();
        Assert.assertEquals(3, hotels.size());
    }

    @Test
    public void getHotelByIdTest() {
        LOGGER.debug("service: getHotelByIdTest");

        Hotel hotel = hotelService.getHotelById(1);
        Assert.assertThat(hotel, allOf(hasProperty("hotelId", equalTo(1L)),
                hasProperty("hotelName", equalTo("Hilton"))));
    }
}