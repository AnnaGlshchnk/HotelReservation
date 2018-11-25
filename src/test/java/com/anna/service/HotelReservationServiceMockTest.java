package com.anna.service;


import com.anna.config.ServiceImplMockTestConfig;
import com.anna.entity.Reservation;
import com.anna.test.HotelReservationDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.easymock.EasyMock.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceImplMockTestConfig.class)
public class HotelReservationServiceMockTest {

    @Autowired
    private HotelReservationService hotelReservationService;

    @Autowired
    private HotelReservationDao hotelReservationMockDao;

    @After
    public void clean() {
        verify();
    }

    @Before
    public void setUp() {
        reset(hotelReservationMockDao);
    }


    @Test
    public void addReservation() {

        Reservation reservation = new Reservation("1507", "741", 1, 1);
        expect(hotelReservationMockDao.addReservation(anyObject(Reservation.class))).andReturn(5);
        replay(hotelReservationMockDao);

        Integer id = hotelReservationService.addReservation(reservation);
        Assert.assertEquals(id, (Integer) 5);
    }

    @Test
    public void updateReservation() {
    }

    @Test
    public void deleteReservation() {

        expect(hotelReservationMockDao.deleteReservation(1)).andReturn(0);
        replay(hotelReservationMockDao);

        hotelReservationService.deleteReservation(1);



    }
}
