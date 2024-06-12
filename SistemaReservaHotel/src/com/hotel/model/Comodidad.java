package com.hotel.model;

import java.time.LocalDate;

public abstract class Comodidad {
    private String nombre;
    private double precioPorDia;
    public Comodidad(String nombre, double precioPorDia) {
        this.nombre = nombre;
        this.precioPorDia = precioPorDia;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecioPorDia() {
        return precioPorDia;
    }
    public abstract double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin);
}
