package com.anna.controller;

import com.anna.config.ControllerMockTestConfig;
import com.anna.model.HotelData;
import com.anna.model.HotelDetails;
import com.anna.service.impl.HotelServiceImpl;
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
public class HotelControllerTest {
    private static final Logger LOGGER = LogManager.getLogger(HotelControllerTest.class);


    @InjectMocks
    private HotelController hotelController;

    @Mock
    private HotelServiceImpl mockHotelService;

    private MockMvc mockMvc;


    public HotelControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void init() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(hotelController).build();
    }

    @After
    public void after() {
        Mockito.reset(mockHotelService);
    }


    @Test
    public void getHotelsTest() throws Exception {
        LOGGER.debug("service: getHotelsTest");

        List<HotelData> hotels = new ArrayList<>();
        Mockito.when(mockHotelService.getHotels()).thenReturn(hotels);

        mockMvc.perform(get("/hotels")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        Mockito.verify(mockHotelService).getHotels();
    }

    @Test
    public void getHotelByIdTest() throws Exception {
        LOGGER.debug("service: getHotelByIdTest");

        HotelDetails hotel = new HotelDetails(1);
        Mockito.when(mockHotelService.getHotelById(Mockito.anyInt())).thenReturn(hotel);

        mockMvc.perform(get("/hotels/1")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        Mockito.verify(mockHotelService).getHotelById(1);
    }
}