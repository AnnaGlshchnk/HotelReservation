package com.anna.service.impl;

import com.anna.dao.api.RoomDao;
import com.anna.model.Room;
import com.anna.model.RoomDetails;
import com.anna.service.api.RoomService;
import com.anna.service.exception.OperationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomDao roomDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public List<RoomDetails> getRooms() throws OperationFailedException {
        return roomDao.getRooms();
    }

    @Override
    public RoomDetails getRoomById(Integer roomId) throws OperationFailedException {
        return roomDao.getRoomById(roomId);
    }
}
