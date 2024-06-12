package com.hotel.service;
import com.hotel.model.HabitacionGeneral;
import com.hotel.model.Reserva;
import java.time.LocalDate;
import java.util.List;

public class GestorDisponibilidad {
    private List<HabitacionGeneral<?>> habitaciones;
    private List<Reserva> reservas;
    public GestorDisponibilidad(List<HabitacionGeneral<?>> habitaciones, List<Reserva> reservas) {
        this.habitaciones = habitaciones;
        this.reservas = reservas;
    }
    public boolean estaDisponible(HabitacionGeneral<?> habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion) &&
                    !(fechaFin.isBefore(reserva.getFechaInicio()) || fechaInicio.isAfter(reserva.getFechaFin()))) {
                return false;
            }
        }
        return true;
    }
}
