package com.anna.controller;

import com.anna.config.ControllerMockTestConfig;
import com.anna.model.GuestDetails;
import com.anna.model.GuestList;
import com.anna.service.impl.GuestServiceImpl;
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
public class GuestControllerTest {
    private static final Logger LOGGER = LogManager.getLogger(GuestControllerTest.class);

    @InjectMocks
    private GuestController guestController;

    @Mock
    private GuestServiceImpl mockGuestService;

    private MockMvc mockMvc;


    public GuestControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void init() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(guestController).build();
    }

    @After
    public void after() {
        Mockito.reset(mockGuestService);
    }

    @Test
    public void getGuestsTest() throws Exception {
        LOGGER.debug("service: getGuestsTest");

        List<GuestList> guests = new ArrayList<>();
        Mockito.when(mockGuestService.getGuests()).thenReturn(guests);

        mockMvc.perform(get("/guests")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        Mockito.verify(mockGuestService).getGuests();
    }

    @Test
    public void getGuestByIdTest() throws Exception {
        LOGGER.debug("service: getGuestByIdTest");

        GuestDetails guest = new GuestDetails(1);
        Mockito.when(mockGuestService.getGuestById(1)).thenReturn(guest);

        mockMvc.perform(get("/guests/1")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        Mockito.verify(mockGuestService).getGuestById(1);
    }

    @Test
    public void addGuestTest() throws Exception {
        LOGGER.debug("service: addGuestTest");

        Mockito.when(mockGuestService.addGuest(Mockito.any())).thenReturn(5);

        String str = "{ \"firstName\": \"Klaus\",  \"surname\": \"Schmidt\"}";
        mockMvc.perform(post("/guests")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(str))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateGuestTest() throws Exception {
        LOGGER.debug("service: updateGuestTest");

        Mockito.when(mockGuestService.updateGuest(Mockito.any(), Mockito.any())).thenReturn(1);

        String str = " { \"guestId\": 1, \"firstName\": \"KlausNew\",  \"surname\": \"Schmidt\"}";
        mockMvc.perform(put("/guests/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(str))
                .andExpect(status().isAccepted());
    }
}