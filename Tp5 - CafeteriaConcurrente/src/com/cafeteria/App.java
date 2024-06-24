package com.cafeteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final List<MaquinaCafe> maquinas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        inicializarMaquinas();

        while (true) {
            System.out.println("1. Pedir café\n2. Mejor no , chau");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    pedirCafe();
                    break;
                case "2":
                    System.out.println("Saliending del sistem beibi...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Esa OCsion no Esiste pue, pedi bien o ite.");
                    break;
            }
        }
    }

    private static void inicializarMaquinas() {
        maquinas.add(new MaquinaCafe("Esclavo 1"));
        maquinas.add(new MaquinaCafe("Esclavo 2"));
        maquinas.add(new MaquinaCafe("Esclavo 3"));
    }

    private static void pedirCafe() {
        System.out.println("Mave, que va a pedi escibime (Espresso, Capuchino, Latte, Americano, Cortado):");
        String tipo = scanner.nextLine();
        Cafe cafe = new Cafe(tipo);

        boolean maquinaAsignada = false;
        for (int i = 0; i < maquinas.size() && !maquinaAsignada; i++) {
            if (!maquinas.get(i).isAlive()) {
                maquinas.set(i, new MaquinaCafe("Esclavo " + (i + 1)));
                maquinas.get(i).asignarCafe(cafe);
                maquinaAsignada = true;
            }
        }

        if (!maquinaAsignada) {
            System.out.println("Tamos a full ahora chango, banca un toque no seas ansioso, solo tengo 3 esclavos.");
        }
    }
}

