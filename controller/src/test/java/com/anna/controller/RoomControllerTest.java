package com.anna.controller;

import com.anna.config.ControllerMockTestConfig;
import com.anna.model.Hotel;
import com.anna.model.Room;
import com.anna.model.RoomDetails;
import com.anna.service.impl.RoomServiceImpl;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ControllerMockTestConfig.class)
@WebAppConfiguration
public class RoomControllerTest {
    private static final Logger LOGGER = LogManager.getLogger(RoomControllerTest.class);

    @InjectMocks
    private RoomController roomController;

    @Mock
    private RoomServiceImpl mockRoomService;

    private MockMvc mockMvc;


    public RoomControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void init() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(roomController).build();
    }

    @After
    public void after() {
        Mockito.reset(mockRoomService);
    }


    @Test
    public void getRoomsTest() throws java.lang.Exception {
        LOGGER.debug("service: getRoomsTest");

        List<RoomDetails> rooms = new ArrayList<>();
        Mockito.when(mockRoomService.getRooms()).thenReturn(rooms);

        mockMvc.perform(get("/rooms")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        Mockito.verify(mockRoomService).getRooms();
    }

    @Test
    public void getRoomByIdTest() throws java.lang.Exception {
        LOGGER.debug("service: getRoomByIdTest");

        RoomDetails room = new RoomDetails(1, new Room(2), new Hotel("Hilton"));
        Mockito.when(mockRoomService.getRoomById(Mockito.anyInt())).thenReturn(room);

        mockMvc.perform(get("/rooms/1")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        Mockito.verify(mockRoomService).getRoomById(1);
    }
}