package com.hotel.service;
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
        for (Reserva reservaExistente : reservas) {
            if (reservaExistente.getCliente().equals(cliente) &&
                    reservaExistente.getHabitacion().equals(habitacion) &&
                    reservaExistente.getFechaInicio().equals(fechaInicio) &&
                    reservaExistente.getFechaFin().equals(fechaFin)) {
                return false;
            }
        }
        if (gestorDisponibilidad.estaDisponible(habitacion, fechaInicio, fechaFin)) {
            Reserva reserva = new Reserva(cliente, habitacion, fechaInicio, fechaFin) {
                @Override
                public void cancelarReserva() {
                    reservas.remove(this);
                    cliente.eliminarReserva(this);
                }
                @Override
                public void modificarFechas(LocalDate fechaInicio, LocalDate fechaFin) {
                    this.setFechaInicio(fechaInicio);
                    this.setFechaFin(fechaFin);
                }
            };
            reservas.add(reserva);
            cliente.agregarReserva(reserva);
            return true;
        }
        return false;
    }
    public double calcularCostoReserva(Reserva reservaInfo) {
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