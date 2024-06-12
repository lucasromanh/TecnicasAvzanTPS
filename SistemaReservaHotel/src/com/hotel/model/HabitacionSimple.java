package com.hotel.model;

import java.util.List;

public class HabitacionSimple extends HabitacionGeneral<ComodidadBasica> {
    public HabitacionSimple(String nombre, double precio, List<ComodidadBasica> comodidades) {
        super(nombre, precio, comodidades);
    }
}
