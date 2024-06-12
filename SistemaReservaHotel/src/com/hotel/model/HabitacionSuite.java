package com.hotel.model;

import java.util.List;

public class HabitacionSuite extends HabitacionGeneral<ComodidadPremium> {
    public HabitacionSuite(String nombre, double precio, List<ComodidadPremium> comodidades) {
        super(nombre, precio, comodidades);
    }
}
