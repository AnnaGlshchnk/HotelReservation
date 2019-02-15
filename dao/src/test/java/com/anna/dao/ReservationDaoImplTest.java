package com.anna.dao;

import com.anna.config.DaoTestConfig;
import com.anna.model.Guest;
import com.anna.model.Reservation;
import com.anna.model.Room;
import com.anna.model.SaveReservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoTestConfig.class)
@Transactional
public class ReservationDaoImplTest {
    private static final Logger LOGGER = LogManager.getLogger(GuestDaoImplTest.class);

    @Autowired
    private ReservationDao reservationDao;

    @Test
    public void getReservationsTest() {
        LOGGER.debug("service: getReservationsTest");

        List<Reservation> reservations = reservationDao.getReservations();
        Assert.assertEquals(reservations.size(), 4);
    }

    @Test
    public void getReservationByIdTest() {
        LOGGER.debug("service: getReservationByIdTest");

        Reservation reservation = reservationDao.getReservationById(1);
        Assert.assertNotNull(reservation);
        Assert.assertEquals(reservation.getReservationId(), 1);
        Assert.assertEquals(reservation.getGuest().getFirstName(), "Klaus");
    }

    @Test
    public void addReservationTest() throws ParseException {
        LOGGER.debug("service: addReservationTest");

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date start = simpleDateFormat.parse("2019-09-01");
        Date end = simpleDateFormat.parse("2019-09-06");

        SaveReservation reservation = new SaveReservation(start, end, new Guest(4), new Room(1));
    }

    @Test
    public void updateReservationTest() {
        LOGGER.debug("service: updateReservationTest");
    }

    @Test
    public void deleteReservationTest() {
        LOGGER.debug("service: deleteReservationTest");
    }
}