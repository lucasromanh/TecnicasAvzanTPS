package com.hotel.model;

import java.time.LocalDate;
import java.util.List;

public abstract class HabitacionGeneral<T extends Comodidad> {
    private String nombre;
    private double precioBase;
    private List<T> comodidades;

    public HabitacionGeneral(String nombre, double precioBase, List<T> comodidades) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.comodidades = comodidades;
    }

    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        // Implementación de verificación de disponibilidad
        return true;
    }

    public List<T> getComodidades() {
        return comodidades;
    }

    public double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        double costoTotal = precioBase * dias;
        for (T comodidad : comodidades) {
            costoTotal += comodidad.calcularCosto(fechaInicio, fechaFin);
        }
        return costoTotal;
    }

    public String getNombre() {
        return nombre;
    }
}
