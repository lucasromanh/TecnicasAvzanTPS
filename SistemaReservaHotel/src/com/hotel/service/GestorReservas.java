package com.hotel.service;

import com.hotel.App;
import com.hotel.model.Cliente;
import com.hotel.model.HabitacionGeneral;
import com.hotel.model.Reserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class GestorReservas {
    private GestorDisponibilidad gestorDisponibilidad;
    private List<Reserva> reservas;

    public GestorReservas(GestorDisponibilidad gestorDisponibilidad, List<Reserva> reservas) {
        this.gestorDisponibilidad = gestorDisponibilidad;
        this.reservas = reservas;
    }

    public boolean realizarReserva(Cliente cliente, HabitacionGeneral<?> habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        if (gestorDisponibilidad.estaDisponible(habitacion, fechaInicio, fechaFin)) {
            Reserva reserva = new Reserva(cliente, habitacion, fechaInicio, fechaFin) {
                @Override
                public void cancelarReserva() {

                }

                @Override
                public void modificarFechas(LocalDate fechaInicio, LocalDate fechaFin) {

                }
            };
            reservas.add(reserva);
            cliente.agregarReserva(reserva);
            return true;
        }
        return false;
    }

    public double calcularCostoReserva(App.ReservaInfo reservaInfo) {
        long dias = ChronoUnit.DAYS.between(reservaInfo.getFechaInicio(), reservaInfo.getFechaFin());
        double costoBase = reservaInfo.getHabitacion().calcularCosto(reservaInfo.getFechaInicio(), reservaInfo.getFechaFin());
        double descuento = 0.0;

        if (dias > 2 && dias <= 4) {
            descuento = 0.1;
        } else if (dias > 4) {
            descuento = 0.2;
        }

        return costoBase * (1 - descuento);
    }
}
