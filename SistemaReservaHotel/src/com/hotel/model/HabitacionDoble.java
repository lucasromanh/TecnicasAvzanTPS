package com.hotel.model;

import java.util.List;

public class HabitacionDoble extends HabitacionGeneral<ComodidadPremium> {
    public HabitacionDoble(String nombre, double precio, List<ComodidadPremium> comodidades) {
        super(nombre, precio, comodidades);
    }
}
