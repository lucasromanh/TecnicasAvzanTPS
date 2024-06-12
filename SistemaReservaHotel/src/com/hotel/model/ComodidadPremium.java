package com.hotel.model;

import java.time.LocalDate;

public class ComodidadPremium extends Comodidad {
    private String tipo;
    public ComodidadPremium(String nombre, double precioPorDia) {
        super(nombre, precioPorDia);
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }
    @Override
    public double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        return getPrecioPorDia() * dias;
    }
}
