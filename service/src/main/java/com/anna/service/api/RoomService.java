package com.anna.service.api;

import com.anna.model.RoomDetails;
import com.anna.service.exception.OperationFailedException;

import java.util.List;

public interface RoomService {

    List<RoomDetails> getRooms() throws OperationFailedException;

    RoomDetails getRoomById(Integer roomId) throws OperationFailedException;
}
