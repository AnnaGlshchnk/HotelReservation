package com.anna.dao;

import com.anna.model.Hotel;
import com.anna.model.Room;

import java.util.List;

public interface RoomDao {

    List<Room> getRooms();

    Room getRoomById(Integer roomId);


}
