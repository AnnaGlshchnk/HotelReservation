package com.anna.service;

import com.anna.config.TestConfig;
import com.anna.entity.Hotel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class HotelReservationServiceImplTest {

    @Autowired
    private HotelReservationService hotelReservationService;

    @Test
    public void showHotel() {

        List<Hotel> hotels = hotelReservationService.showHotel();
        assertEquals(3, hotels.size());
    }

    @Test
    public void showRoom() {

        List rooms = hotelReservationService.showRoom(2);
        assertEquals(2, rooms.size());
    }

    @Test
    public void showReservation() {
        List reservations = hotelReservationService.showReservation(2);
        assertEquals(1, reservations.size());
    }


}