package com.anna.controller;

import com.anna.config.ControllerTestConfig;
import com.anna.entity.Guest;
import com.anna.entity.Hotel;
import com.anna.entity.Reservation;
import com.anna.entity.Room;
import com.anna.service.HotelReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ControllerTestConfig.class)
@WebAppConfiguration
public class HotelReservationControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    private HotelReservationService hotelReservationService;

    @After
    public void tearDown() {
        verify(hotelReservationService);
        reset(hotelReservationService);
    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAllHotel() throws Exception {
        List<Hotel> hotelList = new ArrayList<Hotel>();
        hotelList.add(new Hotel(1, "jh"));
        hotelList.add(new Hotel(2, "jk"));
        hotelList.add(new Hotel(3, "jl"));
        expect(hotelReservationService.showHotel()).andReturn(hotelList);
        replay(hotelReservationService);

        mockMvc.perform(
                get("/hotels").accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("hotelsList"));
    }

    @Test
    public void getAllRoom() throws Exception {

        List<Room> roomList = new ArrayList<>();
        roomList.add(new Room(1, 250, 1));
        roomList.add(new Room(2, 520, 1));

        expect(hotelReservationService.showRoom(anyInt())).andReturn(roomList);
        replay(hotelReservationService);

        mockMvc.perform(
                get("/hotel/1").accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("showRoom"));
    }

    @Test
    public void getAllReservation() throws Exception {
        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add(new Reservation(1, "852", "852", 1, new Guest(1, "asd", "dsa")));
        reservationList.add(new Reservation(2, "852", "852", 1, new Guest(2, "qaz", "zaq")));


        expect(hotelReservationService.showReservation(anyInt())).andReturn(reservationList);
        replay(hotelReservationService);

        mockMvc.perform(
                get("/room/1").accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("showReservation"));
    }


    @Test
    public void addResrvation() throws Exception {

        expect(hotelReservationService.addReservation(anyObject(Reservation.class))).andReturn(5);
        replay(hotelReservationService);

        String reservation = new ObjectMapper().writeValueAsString(new Reservation("7789", "852", 1, 1));
        mockMvc.perform(
                post("/addReservation")
                        .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                        .content(reservation)).andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/hotels"));

    }


    @Test
    public void updateResrvation() throws Exception {

        expect(hotelReservationService.updateReservation((anyObject(Reservation.class)))).andReturn(1);
        replay(hotelReservationService);

        String reservation = new ObjectMapper().writeValueAsString(new Reservation(1, "7789", "852", 1, 1));
        mockMvc.perform(
                post("/updateReservation")
                        .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                        .content(reservation)).andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/hotels"));

    }

    @Test
    public void delete() throws Exception {

        Reservation reservation = new Reservation(1, "742", "258", 1, 1);

        expect(hotelReservationService.deleteReservation(anyInt())).andReturn(0);
        replay(hotelReservationService);

        mockMvc.perform(
                get("/delete/1").accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/hotels"));
    }
}