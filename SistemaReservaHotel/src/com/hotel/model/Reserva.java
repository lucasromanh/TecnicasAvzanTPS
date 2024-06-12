package com.hotel.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Reserva {
    private Cliente cliente;
    private HabitacionGeneral<?> habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva(Cliente cliente, HabitacionGeneral<?> habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public HabitacionGeneral<?> getHabitacion() {
        return habitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public double calcularCosto() {
        return habitacion.calcularCosto(fechaInicio, fechaFin);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", habitacion=" + habitacion +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setHabitacion(HabitacionGeneral<?> habitacion) {
        this.habitacion = habitacion;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reserva reserva = (Reserva) o;

        if (!Objects.equals(cliente, reserva.cliente)) return false;
        if (!Objects.equals(habitacion, reserva.habitacion)) return false;
        if (!Objects.equals(fechaInicio, reserva.fechaInicio)) return false;
        return Objects.equals(fechaFin, reserva.fechaFin);
    }

    public int hashCode() {
        int result = cliente != null ? cliente.hashCode() : 0;
        result = 31 * result + (habitacion != null ? habitacion.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        return result;
    }


    public void finalize(Cliente cliente) {
        System.out.println("Reserva eliminada");
    }

    public void finalize(HabitacionGeneral<?> habitacion) {
        System.out.println("Reserva eliminada");
    }


    public void finalize(Cliente cliente, HabitacionGeneral<?> habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        System.out.println("Reserva eliminada");
    }

    public void finalize(Cliente cliente, HabitacionGeneral<?> habitacion) {
        System.out.println("Reserva eliminada");
    }


    public void finalize(HabitacionGeneral<?> habitacion, LocalDate fechaInicio) {
        System.out.println("Reserva eliminada");
    }

    public abstract void cancelarReserva();

    public abstract void modificarFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
