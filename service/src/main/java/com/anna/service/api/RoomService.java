package com.anna.service.api;

import com.anna.model.Room;
import com.anna.service.exception.OperationFailedException;

import java.util.List;

public interface RoomService {

    List<Room> getRooms() throws OperationFailedException;

    Room getRoomById(Integer roomId) throws OperationFailedException;
}
