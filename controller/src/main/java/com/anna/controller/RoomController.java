package com.anna.controller;

import com.anna.model.RoomDetails;
import com.anna.service.api.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    @ResponseStatus(HttpStatus.OK)
    public List<RoomDetails> getRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/rooms/{roomId}")
    @ResponseStatus(HttpStatus.OK)
    public RoomDetails getRoomById(@PathVariable(value = "roomId") Integer roomId) {
        return roomService.getRoomById(roomId);
    }
}
