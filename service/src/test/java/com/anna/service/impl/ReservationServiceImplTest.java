package com.anna.service.impl;

import com.anna.config.ServiceTestConfig;
import com.anna.model.Guest;
import com.anna.model.Reservation;
import com.anna.model.Room;
import com.anna.model.SaveReservation;
import com.anna.service.api.ReservationService;
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

import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
@Transactional
public class ReservationServiceImplTest {
    private static final Logger LOGGER = LogManager.getLogger(ReservationServiceImplTest.class);

    @Autowired
    ReservationService reservationService;

    @Test
    public void getReservationsTest() {
        LOGGER.debug("service: getReservationsTest");

        List<Reservation> reservations = reservationService.getReservations();
        Assert.assertEquals(4, reservations.size());
    }

    @Test
    public void getReservationByIdTest() throws ParseException {
        LOGGER.debug("service: getReservationByIdTest");

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date start = simpleDateFormat.parse("2018-07-12");
        Date end = simpleDateFormat.parse("2018-07-16");

        Reservation reservation = reservationService.getReservationById(1);
        Assert.assertThat(reservation, allOf(hasProperty("reservationId", equalTo(1L)),
                hasProperty("startReservation", equalTo(start)),
                hasProperty("finishReservation", equalTo(end))));
    }

    @Test
    public void addReservationTest() throws ParseException {
        LOGGER.debug("service: addReservationTest");

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date start = simpleDateFormat.parse("2019-09-01");
        Date end = simpleDateFormat.parse("2019-09-06");

        SaveReservation reservation = new SaveReservation(start, end, new Room(1L), new Guest(4));
        reservationService.addReservation(reservation);
        Reservation newReservation = reservationService.getReservationById(5);
        Assert.assertThat(newReservation, allOf(hasProperty("reservationId", equalTo(5L)),
                hasProperty("startReservation", equalTo(start)),
                hasProperty("finishReservation", equalTo(end))));
    }

    @Test
    public void updateReservationTest() throws ParseException {
        LOGGER.debug("service: updateReservationTest");

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date start = simpleDateFormat.parse("2019-09-01");
        Date end = simpleDateFormat.parse("2019-09-06");
        Date newEnd = simpleDateFormat.parse("2019-09-05");

        SaveReservation reservation = new SaveReservation(start, end, new Room(1L), new Guest(4));
        reservation.setFinishReservation(newEnd);
        reservationService.updateReservation(2, reservation);
        Reservation newReservation = reservationService.getReservationById(2);
        Assert.assertThat(newReservation, allOf(hasProperty("reservationId", equalTo(2L)),
                hasProperty("startReservation", equalTo(start)),
                hasProperty("finishReservation", equalTo(newEnd))));
    }

    @Test
    public void deleteReservationTest() {
        LOGGER.debug("service: deleteReservationTest");

        reservationService.deleteReservation(1);
        List<Reservation> groups = reservationService.getReservations();
        Assert.assertEquals(3, groups.size());
    }
}