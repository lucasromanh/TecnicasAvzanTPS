package com.hotel.model;

import java.time.LocalDate;

public class ComodidadBasica extends Comodidad {
    public ComodidadBasica(String nombre, double precioPorDia) {
        super(nombre, precioPorDia);
    }

    @Override
    public double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        return getPrecioPorDia() * dias;
    }
}
