package com.anna.test;

import com.anna.config.TestConfig;
import com.anna.entity.Hotel;
import com.anna.entity.Reservation;
import com.anna.entity.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class HotelReservationImplTest {


    @Autowired
    HotelReservationDao hotelReservationDao;

    private static final Logger LOGGER = LogManager.getLogger(HotelReservationImplTest.class);

    @Test
    public void showHotel() {

        List<Hotel> hotels = hotelReservationDao.showHotel();
        Assert.assertEquals(3, hotels.size());
    }

    @Test
    public void showRoom() {

        List rooms = hotelReservationDao.showRoom(1);
        Assert.assertEquals(2, rooms.size());

    }

    @Test
    public void showReservation() {

        List reservations = hotelReservationDao.showReservation(1);
        Assert.assertEquals(2, reservations.size());
    }

    @Test
    public void addReservation() {

        Reservation reservation = new Reservation("258", "852", 1, 1);
        Integer reservationId = hotelReservationDao.addReservation(reservation);
        List reservations = hotelReservationDao.showReservation(1);
        Assert.assertEquals(3, reservations.size());
    }

    @Test
    public void updateReservation() {

        Reservation reservation = new Reservation(1, "31", "432", 1 ,1);
        reservation.setStartReserv("753");
        reservation.setEndReserv("951");
        hotelReservationDao.updateReservation(reservation);
        List reservations = hotelReservationDao.showReservation(1);
        Assert.assertEquals(2, reservations.size());
        Assert.assertSame("753", reservation.getStartReserv());


    }

    @Test
    public void deleteReservation() {

        Integer reservationId = hotelReservationDao.deleteReservation(2);
        List reservations = hotelReservationDao.showReservation(2);
        Assert.assertEquals(0, reservations.size());

    }
}