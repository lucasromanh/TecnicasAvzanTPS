package com.cafeteria;
import java.util.Random;

public class Cafe {
    private String tipo;
    private int tiempoDePreparacion;

    public Cafe(String tipo) {
        this.tipo = tipo;
        this.tiempoDePreparacion = calcularTiempoPreparacion(tipo);
    }

    private int calcularTiempoPreparacion(String tipo) {
        Random rand = new Random();
        switch (tipo.toLowerCase()) {
            case "espresso":
                return rand.nextInt(6) + 10;
            case "capuchino":
                return rand.nextInt(9) + 12;
            case "latte":
                return rand.nextInt(26) + 5;
            case "americano":
                return rand.nextInt(6) + 25;
            case "cortado":
                return rand.nextInt(11) + 10;
            default:
                return 15;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public int getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }
}
