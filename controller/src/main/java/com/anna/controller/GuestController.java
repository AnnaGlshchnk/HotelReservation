package com.anna.controller;

import com.anna.model.Guest;
import com.anna.model.GuestDetails;
import com.anna.model.GuestList;
import com.anna.model.SaveGuest;
import com.anna.service.api.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class GuestController {

    private GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/guests")
    @ResponseStatus(HttpStatus.OK)
    public List<GuestList> getGuests() {
        return guestService.getGuests();
    }

    @GetMapping("/guests/{guestId}")
    @ResponseStatus(HttpStatus.OK)
    public GuestDetails getGuestById(@PathVariable(value = "guestId") Integer guestId) {
        return guestService.getGuestById(guestId);
    }

    @PostMapping("/guests")
    public ResponseEntity<Void> addGuest(@Valid @RequestBody SaveGuest guest, UriComponentsBuilder builder) {
        Integer createdId = guestService.addGuest(guest);
        UriComponents uriComponents = builder.path("/guests/{guestId}").buildAndExpand(createdId);
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/guests/{guestId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateGuest(@Valid @RequestBody SaveGuest guest, @PathVariable("guestId") Integer guestId) {
        guestService.updateGuest(guestId, guest);
    }
}
