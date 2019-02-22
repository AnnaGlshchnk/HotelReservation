package com.anna.dao;

import com.anna.config.DaoTestConfig;
import com.anna.dao.api.ReservationDao;
import com.anna.model.*;
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

        ReservationDetails reservation = reservationDao.getReservationById(1);
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

        SaveReservation reservation = new SaveReservation(start, end, new SaveRoom(1L), new Guest(4));
        reservationDao.addReservation(reservation);
        ReservationDetails newReservation = reservationDao.getReservationById(5);
        Assert.assertNotNull(newReservation);
    }

    @Test
    public void updateReservationTest() throws ParseException {
        LOGGER.debug("service: updateReservationTest");

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date start = simpleDateFormat.parse("2019-09-01");
        Date end = simpleDateFormat.parse("2019-09-06");
        Date newEnd = simpleDateFormat.parse("2019-09-05");

        SaveReservation reservation = new SaveReservation(start, end, new SaveRoom(1L), new Guest(4));
        reservation.setFinishReservation(newEnd);
        reservationDao.updateReservation(2, reservation);
        ReservationDetails newReservation = reservationDao.getReservationById(2);
        Assert.assertEquals(newEnd, newReservation.getFinishReservation());
    }

    @Test
    public void deleteReservationTest() {
        LOGGER.debug("service: deleteReservationTest");

        reservationDao.deleteReservation(1);
        List<Reservation> groups = reservationDao.getReservations();
        Assert.assertEquals(3, groups.size());
    }
}