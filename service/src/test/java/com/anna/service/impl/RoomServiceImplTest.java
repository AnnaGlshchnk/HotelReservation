package com.anna.service.impl;

import com.anna.config.ServiceTestConfig;
import com.anna.model.Room;
import com.anna.service.api.RoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
@Transactional
public class RoomServiceImplTest {
    private static final Logger LOGGER = LogManager.getLogger(HotelServiceImplTest.class);

    @Autowired
    RoomService roomService;

    @Test
    public void getRooms() {
        LOGGER.debug("service: getRoomsTest");

        List<Room> rooms = roomService.getRooms();
        Assert.assertEquals(rooms.size(), 6);
    }

    @Test
    public void getRoomById() {
        LOGGER.debug("service: getRoomByIdTest");

        Room room = roomService.getRoomById(1);
        Assert.assertNotNull(room);
        Assert.assertEquals(room.getRoomNumber(), 1);
    }
}