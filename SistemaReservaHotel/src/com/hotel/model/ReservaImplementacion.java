package com.hotel.model;

import java.time.LocalDate;

public class ReservaImplementacion extends Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean cancelada;

    public ReservaImplementacion(Cliente cliente, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        super(cliente, (HabitacionGeneral<?>) habitacion, fechaInicio, fechaFin);
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cancelada = false;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public HabitacionGeneral<?> getHabitacion() {
        return (HabitacionGeneral<?>) habitacion;
    }

    @Override
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    @Override
    public double calcularCosto() {
        return habitacion.calcularPrecioTotal(fechaInicio, fechaFin);
    }

    @Override
    public void cancelarReserva() {
        this.cancelada = true;
    }

    @Override
    public void modificarFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
