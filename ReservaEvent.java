package com.hotel.service;

import com.hotel.model.Reserva;

public class ReservaEvent extends Event {
    private Reserva reserva;

    public ReservaEvent(String message, Reserva reserva) {
        super(message);
        this.reserva = reserva;
    }

    public Reserva getReserva() {
        return reserva;
    }
}
