package com.anna.service.api;

import com.anna.model.Reservation;
import com.anna.model.ReservationDetails;
import com.anna.model.SaveReservation;
import com.anna.service.exception.OperationFailedException;

import java.util.List;

public interface ReservationService {

    List<Reservation> getReservations() throws OperationFailedException;

    ReservationDetails getReservationById(Integer reservationId) throws OperationFailedException;

    Integer addReservation(SaveReservation reservation) throws OperationFailedException;

    Integer updateReservation(Integer reservationId, SaveReservation reservation) throws OperationFailedException;

    Integer deleteReservation(Integer reservationId) throws OperationFailedException;
}
