package com.anna.dao.api;

import com.anna.model.RoomDetails;

import java.util.List;

public interface RoomDao {

    List<RoomDetails> getRooms();

    RoomDetails getRoomById(Integer roomId);
}
