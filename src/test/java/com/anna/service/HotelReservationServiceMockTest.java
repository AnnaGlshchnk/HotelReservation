package com.anna.service;


import com.anna.config.ServiceImplMockTestConfig;
import com.anna.entity.Hotel;
import com.anna.entity.Reservation;
import com.anna.entity.Room;
import com.anna.test.HotelReservationDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

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
    public void showHotel() {

        List<Hotel> hotelList = new ArrayList<Hotel>();
        hotelList.add(new Hotel(1, "Abc"));
        hotelList.add(new Hotel(2, "Ter"));
        hotelList.add(new Hotel(3,"Mir"));
        expect(hotelReservationMockDao.showHotel()).andReturn(hotelList);
        replay(hotelReservationMockDao);

        List<Hotel> hotels = hotelReservationService.showHotel();
        Integer size = hotels.size();
        assertEquals(size, (Integer) 3 );
    }

    @Test
    public void showRoom() {

        List<Room> roomList = new ArrayList<Room>();
        roomList.add(new Room(1, 200, 2));
        roomList.add(new Room(2, 300, 2));
        expect(hotelReservationMockDao.showRoom(2)).andReturn(roomList);
        replay(hotelReservationMockDao);

        List rooms = hotelReservationService.showRoom(2);
        assertEquals(2, rooms.size());
    }

    @Test
    public void showReservation() {

        List<Reservation> reservationList = new ArrayList<Reservation>();
        reservationList.add(new Reservation());
        expect(hotelReservationMockDao.showReservation(2)).andReturn(reservationList);
        replay(hotelReservationMockDao);

        List reservations = hotelReservationService.showReservation(2);
        assertEquals(1, reservations.size());
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

        Reservation reservation = new Reservation(1, "000", "111", 1 ,2);
        expect(hotelReservationMockDao.updateReservation(anyObject(Reservation.class))).andReturn(1);
        replay(hotelReservationMockDao);

        Integer id = hotelReservationService.updateReservation(reservation);
        Assert.assertEquals(id, (Integer) 1);
    }

    @Test
    public void deleteReservation() {

        expect(hotelReservationMockDao.deleteReservation(1)).andReturn(0);
        replay(hotelReservationMockDao);

        Integer id = hotelReservationService.deleteReservation(1);
        Assert.assertEquals(id, (Integer) 0);



    }
}
