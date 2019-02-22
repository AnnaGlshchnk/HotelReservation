package com.anna.controller;

import com.anna.config.ControllerMockTestConfig;
import com.anna.model.Reservation;
import com.anna.model.ReservationDetails;
import com.anna.service.impl.ReservationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ControllerMockTestConfig.class)
@WebAppConfiguration
public class ReservationControllerTest {
    private static final Logger LOGGER = LogManager.getLogger(ReservationControllerTest.class);

    @InjectMocks
    private ReservationController reservationController;

    @Mock
    private ReservationServiceImpl mockReservationService;

    private MockMvc mockMvc;


    public ReservationControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void init() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(reservationController).build();
    }

    @After
    public void after() {
        Mockito.reset(mockReservationService);
    }

    @Test
    public void getReservationsTest() throws Exception {
        LOGGER.debug("service: getReservationsTest");

        List<Reservation> reservations = new ArrayList<>();
        Mockito.when(mockReservationService.getReservations()).thenReturn(reservations);

        mockMvc.perform(get("/reservations")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        Mockito.verify(mockReservationService).getReservations();
    }

    @Test
    public void getReservationByIdTest() throws Exception {
        LOGGER.debug("service: getReservationByIdTest");

        ReservationDetails reservation = new ReservationDetails(1);
        Mockito.when(mockReservationService.getReservationById(1)).thenReturn(reservation);

        mockMvc.perform(get("/reservations/1")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        Mockito.verify(mockReservationService).getReservationById(1);
    }

    @Test
    public void addReservationTest() throws Exception {
        LOGGER.debug("service: addReservationTest");

        Mockito.when(mockReservationService.addReservation(Mockito.any())).thenReturn(5);

        String str = "{ \"startReservation\": 1531342800000,  \"finishReservation\": 1531688400000, \"room\": {\"roomId\": 1 },\"guest\": { \"guestId\": 1 }}";
        mockMvc.perform(post("/reservations")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(str))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateReservationTest() throws Exception {
        LOGGER.debug("service: updateReservationTest");

        Mockito.when(mockReservationService.updateReservation(Mockito.anyInt(), Mockito.any())).thenReturn(1);

        String str = "{\"reservationId\": 1, \"startReservation\": 1531342800000,  \"finishReservation\": 1531688400000, \"room\": {\"roomId\": 1 },\"guest\": { \"guestId\": 1 }}";
        mockMvc.perform(put("/reservations/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(str))
                .andExpect(status().isAccepted());
    }

    @Test
    public void deleteReservationTest() throws Exception {
        LOGGER.debug("service: deleteReservationTest");

        Mockito.when(mockReservationService.deleteReservation(1)).thenReturn(1);

        mockMvc.perform(delete("/reservations/1")).andExpect(status().isOk());
        Mockito.verify(mockReservationService).deleteReservation(1);
    }
}