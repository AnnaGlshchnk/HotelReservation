package com.anna.service.impl;

import com.anna.dao.api.ReservationDao;
import com.anna.model.Reservation;
import com.anna.model.SaveReservation;
import com.anna.service.api.ReservationService;
import com.anna.service.exception.OperationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationDao reservationDao;

    @Autowired
    public ReservationServiceImpl(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    @Autowired

    @Override
    public List<Reservation> getReservations() throws OperationFailedException {
        return reservationDao.getReservations();
    }

    @Override
    public Reservation getReservationById(Integer reservationId) throws OperationFailedException {
        return reservationDao.getReservationById(reservationId);
    }

    @Override
    public Integer addReservation(SaveReservation reservation) throws OperationFailedException {
        return reservationDao.addReservation(reservation);
    }

    @Override
    public Integer updateReservation(Integer reservationId, SaveReservation reservation) throws OperationFailedException {
        return reservationDao.updateReservation(reservationId, reservation);
    }

    @Override
    public Integer deleteReservation(Integer reservationId) throws OperationFailedException {
        return reservationDao.deleteReservation(reservationId);
    }
}
