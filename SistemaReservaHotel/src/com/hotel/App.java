package com.hotel;

import com.hotel.model.*;
import com.hotel.service.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static class ReservaInfo {
        private Cliente cliente;
        private HabitacionGeneral<?> habitacion;
        private LocalDate fechaInicio;
        private LocalDate fechaFin;

        public ReservaInfo(Cliente cliente, HabitacionGeneral<?> habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
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

        public long getDias() {
            return java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        }
    }

    public static void main(String[] args) {
        List<ComodidadBasica> comodidadesBasicas = new ArrayList<>();
        comodidadesBasicas.add(new ComodidadBasica("WiFi", 10));
        comodidadesBasicas.add(new ComodidadBasica("Desayuno", 15));
        comodidadesBasicas.add(new ComodidadBasica("Tv", 10));
        comodidadesBasicas.add(new ComodidadBasica("Aire", 15));

        List<ComodidadPremium> comodidadesPremium = new ArrayList<>();
        comodidadesPremium.add(new ComodidadPremium("Spa", 50));
        comodidadesPremium.add(new ComodidadPremium("Masajes", 30));
        comodidadesPremium.add(new ComodidadPremium("Cabalgatas", 30));

        HabitacionSimple habitacionSimple = new HabitacionSimple("Habitacion Simple", 100, comodidadesBasicas);
        HabitacionDoble habitacionDoble = new HabitacionDoble("Habitacion Doble", 150, comodidadesPremium);
        HabitacionSuite habitacionSuite = new HabitacionSuite("Habitacion Suite", 200, comodidadesPremium);

        List<Reserva> reservas = new ArrayList<>();
        List<HabitacionGeneral<?>> habitaciones = new ArrayList<>();
        habitaciones.add(habitacionSimple);
        habitaciones.add(habitacionDoble);
        habitaciones.add(habitacionSuite);

        GestorDisponibilidad gestorDisponibilidad = new GestorDisponibilidad(habitaciones, reservas);
        GestorReservas gestorReservas = new GestorReservas(gestorDisponibilidad, reservas);

        Cliente cliente1 = new Cliente("Lucas Roman");
        Cliente cliente2 = new Cliente("Ariel Vargas");
        Cliente cliente3 = new Cliente("Nahuel Cococcia");

        ReservaInfo reservaInfo1 = new ReservaInfo(cliente1, habitacionSuite, LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 10));
        ReservaInfo reservaInfo2 = new ReservaInfo(cliente2, habitacionDoble, LocalDate.of(2023, 6, 5), LocalDate.of(2023, 6, 15));
        ReservaInfo reservaInfo3 = new ReservaInfo(cliente3, habitacionSimple, LocalDate.of(2023, 6, 9), LocalDate.of(2023, 6, 12));
        ReservaInfo reservaInfo4 = new ReservaInfo(cliente1, habitacionSuite, LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 20)); // 19 días (20% de descuento)

        List<ReservaInfo> reservasInfo = List.of(reservaInfo1, reservaInfo2, reservaInfo3, reservaInfo4);

        for (ReservaInfo reservaInfo : reservasInfo) {
            System.out.println("Realizando reserva para " + reservaInfo.getCliente().getNombre());
            if (gestorReservas.realizarReserva(reservaInfo.getCliente(), reservaInfo.getHabitacion(), reservaInfo.getFechaInicio(), reservaInfo.getFechaFin())) {
                System.out.println("Reserva realizada con éxito por " + reservaInfo.getDias() + " días");
            } else {
                System.out.println("No se pudo realizar la reserva, la habitación está ocupada en esas fechas");
            }
        }

        for (Reserva reserva : reservas) {
            double costo = gestorReservas.calcularCostoReserva(reserva);
            boolean tieneDescuento = reserva.getHabitacion() instanceof HabitacionSuite && reservaInfo4.getDias() > 5;
            System.out.println("Costo de la reserva para " + reserva.getCliente().getNombre() + ": " + costo + (tieneDescuento ? " (con descuento)" : ""));
        }
    }
}
