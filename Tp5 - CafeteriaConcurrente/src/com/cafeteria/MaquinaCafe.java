package com.cafeteria;
import java.util.Random;

public class MaquinaCafe extends Thread {
    private Cafe cafe;
    private final String nombreMaquina;
    private static final Random random = new Random();

    public MaquinaCafe(String nombreMaquina) {
        this.nombreMaquina = nombreMaquina;
    }

    public void asignarCafe(Cafe cafe) {
        this.cafe = cafe;
        start();
    }

    @Override
    public void run() {
        try {
            System.out.println("El " + nombreMaquina + " está preparando un " + cafe.getTipo() + " Si sale mal lo devolvemos a su pais");
            Thread.sleep(cafe.getTiempoDePreparacion() * 1000L);
            realizarOperacionAdicional();
        } catch (InterruptedException e) {
            System.out.println(nombreMaquina + ": La preparación fue interrumpida, dice que tiene necesidades basicas el empleau.");
        }
    }

    private void realizarOperacionAdicional() {
        String[] mensajes = {"Disfruta tu café", "Perfecto para un día como hoy", "Preparado con amor", "Si no le gusta no le diga al jefe por que sino nos pega"};
        String mensaje = mensajes[random.nextInt(mensajes.length)];
        System.out.println(nombreMaquina + ": " + mensaje);
    }
}

