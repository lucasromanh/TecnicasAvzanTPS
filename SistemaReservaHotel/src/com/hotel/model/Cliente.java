package com.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Reserva> reservas;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }
    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }
}
