package com.anna.service.mock;

import com.anna.config.ServiceTestConfig;
import com.anna.dao.api.HotelDao;
import com.anna.model.HotelData;
import com.anna.model.HotelDetails;
import com.anna.service.impl.HotelServiceImpl;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
public class HotelServiceImplMockTest {
    private static final Logger LOGGER = LogManager.getLogger(HotelServiceImplMockTest.class);

    @InjectMocks
    private HotelServiceImpl hotelService;

    @Mock
    private HotelDao mockHotelDao;

    public HotelServiceImplMockTest() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void after() {
        Mockito.reset(mockHotelDao);
    }

    @Test
    public void getHotelsTest() {
        LOGGER.debug("service: getHotelsTest");

        List<HotelData> hotels = new ArrayList<>();
        Mockito.when(mockHotelDao.getHotels()).thenReturn(hotels);

        hotels = hotelService.getHotels();
        Assert.assertEquals(0, hotels.size());
    }

    @Test
    public void getHotelByIdTest() {
        LOGGER.debug("service: getHotelByIdTest");

        Mockito.when(mockHotelDao.getHotelById(1)).thenReturn(new HotelDetails(1));

        HotelDetails hotel = hotelService.getHotelById(1);
        Assert.assertEquals(1, hotel.getHotelId());
    }
}
