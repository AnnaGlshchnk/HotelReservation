package com.anna.service.mock;

import com.anna.config.ServiceTestConfig;
import com.anna.dao.api.ReservationDao;
import com.anna.model.*;
import com.anna.service.impl.ReservationServiceImpl;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
public class ReservationServiceImplMockTest {
    private static final Logger LOGGER = LogManager.getLogger(ReservationServiceImplMockTest.class);

    @InjectMocks
    private ReservationServiceImpl reservationService;

    @Mock
    private ReservationDao mockReservationDao;

    public ReservationServiceImplMockTest() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void after() {
        Mockito.reset(mockReservationDao);
    }

    @Test
    public void getReservationsTest() {
        LOGGER.debug("service: getReservationsTest");

        List<Reservation> reservations = new ArrayList<>();
        Mockito.when(mockReservationDao.getReservations()).thenReturn(reservations);

        reservations = reservationService.getReservations();
        Assert.assertEquals(0, reservations.size());
    }

    @Test
    public void getReservationByIdTest() {
        LOGGER.debug("service: getReservationByIdTest");

        Mockito.when(mockReservationDao.getReservationById(1)).thenReturn(new ReservationDetails(1));

        ReservationDetails reservation = reservationService.getReservationById(1);
        Assert.assertEquals(1, reservation.getReservationId());
    }

    @Test
    public void addReservationTest() throws ParseException {
        LOGGER.debug("service: addReservationTest");

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date start = simpleDateFormat.parse("2019-09-01");
        Date end = simpleDateFormat.parse("2019-09-06");

        SaveReservation reservation = new SaveReservation(start, end, new SaveRoom(1L), new Guest(4));
        Mockito.when(mockReservationDao.addReservation(reservation)).thenReturn(5);

        Integer reservationId = reservationService.addReservation(reservation);
        Assert.assertEquals(Integer.valueOf(5), reservationId);
    }

    @Test
    public void updateReservationTest() throws ParseException {
        LOGGER.debug("service: updateReservationTest");

        Mockito.when(mockReservationDao.updateReservation(Mockito.any(), Mockito.any())).thenReturn(1);

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date start = simpleDateFormat.parse("2019-09-01");
        Date end = simpleDateFormat.parse("2019-09-06");
        Date newEnd = simpleDateFormat.parse("2019-09-05");

        SaveReservation reservation = new SaveReservation(start, end, new SaveRoom(1L), new Guest(4));
        reservation.setFinishReservation(newEnd);
        Integer guestId = reservationService.updateReservation(1, reservation);
        Assert.assertEquals(Integer.valueOf(1), guestId);
    }

    @Test
    public void deleteReservationTest() {
        LOGGER.debug("service: deleteReservationTest");

        Mockito.when(mockReservationDao.deleteReservation(Mockito.any())).thenReturn(1);

        Integer id = reservationService.deleteReservation(1);
        Assert.assertEquals(id, Integer.valueOf(1));
    }
}
