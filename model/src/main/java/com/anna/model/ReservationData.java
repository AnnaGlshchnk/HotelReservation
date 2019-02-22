package com.anna.model;

import java.util.Date;

public class ReservationData {

    private long reservationId;
    private Date startReservation;
    private Date finishReservation;

    public ReservationData(long reservationId, Date startReservation, Date finishReservation) {
        this.reservationId = reservationId;
        this.startReservation = startReservation;
        this.finishReservation = finishReservation;
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getStartReservation() {
        return startReservation;
    }

    public void setStartReservation(Date startReservation) {
        this.startReservation = startReservation;
    }

    public Date getFinishReservation() {
        return finishReservation;
    }

    public void setFinishReservation(Date finishReservation) {
        this.finishReservation = finishReservation;
    }
}


