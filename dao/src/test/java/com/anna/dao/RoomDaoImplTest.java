package com.anna.dao;

import com.anna.config.DaoTestConfig;
import com.anna.dao.api.RoomDao;
import com.anna.model.Room;
import com.anna.model.RoomDetails;
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
@ContextConfiguration(classes = DaoTestConfig.class)
@Transactional
public class RoomDaoImplTest {
    private static final Logger LOGGER = LogManager.getLogger(GuestDaoImplTest.class);

    @Autowired
    private RoomDao roomDao;

    @Test
    public void getRoomsTest() {
        LOGGER.debug("service: getRoomsTest");

        List<RoomDetails> rooms = roomDao.getRooms();
        Assert.assertEquals(rooms.size(), 6);
    }

    @Test
    public void getRoomByIdTest() {
        LOGGER.debug("service: getRoomByIdTest");

        RoomDetails room = roomDao.getRoomById(1);
        Assert.assertNotNull(room);
        Assert.assertEquals(room.getRoomId(), 1);
    }
}