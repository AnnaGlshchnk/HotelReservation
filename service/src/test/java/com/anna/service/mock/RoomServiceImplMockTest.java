package com.anna.service.mock;

import com.anna.config.ServiceTestConfig;
import com.anna.dao.api.RoomDao;
import com.anna.model.Room;
import com.anna.service.impl.RoomServiceImpl;
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
public class RoomServiceImplMockTest {
    private static final Logger LOGGER = LogManager.getLogger(RoomServiceImplMockTest.class);

    @InjectMocks
    private RoomServiceImpl roomService;

    @Mock
    private RoomDao mockRoomDao;

    public RoomServiceImplMockTest() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void after() {
        Mockito.reset(mockRoomDao);
    }

    @Test
    public void getRooms() {
        LOGGER.debug("service: getRoomsTest");

        List<Room> rooms = new ArrayList<>();
        Mockito.when(mockRoomDao.getRooms()).thenReturn(rooms);

        rooms = roomService.getRooms();
        Assert.assertEquals(0, rooms.size());
    }

    @Test
    public void getRoomById() {
        LOGGER.debug("service: getRoomByIdTest");

        Mockito.when(mockRoomDao.getRoomById(1)).thenReturn(new Room(1L));

        Room room = roomService.getRoomById(1);
        Assert.assertEquals(1, room.getRoomId());
    }

}
