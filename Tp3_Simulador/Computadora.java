import java.util.ArrayList;
import java.util.Random;

public class Computadora {
    private final ArrayList<Memoria> memorias;
    private final Procesador procesador;

    public Computadora(Procesador procesador, ArrayList<Memoria> memorias) {
        this.procesador = procesador;
        this.memorias = memorias;
    }

    public void analizarOfimatica() {
        Random random = new Random();
        int tareas = random.nextInt(15) + 1;
        int memoriaTotal = 0;
        int memoriaUsada = 0;

        for (Memoria memoria : memorias) {
            memoriaTotal += memoria.getCapacidad() * 1000;
        }

        System.out.println("=== Análisis de 'Ofimática' , (horrible palabra) ===");
        System.out.println("Procesador: " + procesador);
        System.out.println("Memorias: ");

        for (Memoria memoria : memorias) {
            System.out.println(memoria);
            memoriaUsada += (int) (memoria.getPorcentajeDeUso() * memoria.getCapacidad() * 1000);
        }

        System.out.println("Tareas: " + tareas);
        System.out.println("Memoria total: " + memoriaTotal + " MB");
        System.out.println("Memoria usada antes de las tareas: " + memoriaUsada + " MB");
        for (int i = 0; i < tareas; i++) {
            int tarea = random.nextInt(3) + 1;
            if (tarea == 1) {
                int memoriaIndex = random.nextInt(memorias.size());
                Memoria memoria = memorias.get(memoriaIndex);
                memoria.aumentarPorcentajeDeUso(random.nextFloat());
                System.out.println("Aumentando % de uso de " + memoria.getNombre());
            } else if (tarea == 2) {
                int memoriaIndex = random.nextInt(memorias.size());
                Memoria memoria = memorias.get(memoriaIndex);
                memoria.disminuirPorcentajeDeUso(random.nextFloat());
                System.out.println("Bajando % de uso de " + memoria.getNombre());
            } else {
                procesador.aumentarTemperatura(random.nextInt(10));
                System.out.println("La temperatura se aumentó en el procesador");
            }
        }

        memoriaUsada = 0;
        for (Memoria memoria : memorias) {
            memoriaUsada += (int) (memoria.getPorcentajeDeUso() * memoria.getCapacidad() * 1000);
        }

        float memoriaLibre = (float) (memoriaTotal - memoriaUsada) / memoriaTotal;
        System.out.println("Memoria usada DESPUES de las tareas: " + memoriaUsada + " MB");
        System.out.println("Memoria libre: " + memoriaLibre * 100 + "%");
        if (memoriaLibre >= 0.40) {
            System.out.println("Memoria suficiente, prueba Pasada");
        } else if (memoriaLibre >= 0.20) {
            System.out.println("Memoria insuficiente, F en el chat");
        } else {
            System.out.println("Memoria AL LIMITE, Va a hacer pum");
        }
    }

    public void analizarRenderizado() {
        Random random = new Random();
        int tiempoRenderizado = random.nextInt(31) + 20;

        System.out.println("=== Análisis de Renderizado ===");
        System.out.println("Procesador: " + procesador);
        System.out.println("Memorias: ");
        for (Memoria memoria : memorias) {
            System.out.println(memoria);
        }

        System.out.println("Tiempo de renderizado: " + tiempoRenderizado + " segundos");
        for (int i = 0; i < tiempoRenderizado; i++) {
            int tarea = random.nextInt(3) + 1;
            if (tarea == 1) {
                int memoriaIndex = random.nextInt(memorias.size());
                Memoria memoria = memorias.get(memoriaIndex);
                memoria.aumentarPorcentajeDeUso(random.nextFloat());
                System.out.println("Aumentando % de uso de " + memoria.getNombre());
            } else if (tarea == 2) {
                int memoriaIndex = random.nextInt(memorias.size());
                Memoria memoria = memorias.get(memoriaIndex);
                memoria.disminuirPorcentajeDeUso(random.nextFloat());
                System.out.println("Bajando % de uso de " + memoria.getNombre());
            } else {
                procesador.aumentarTemperatura(random.nextInt(10));
                System.out.println("La temperatura se aumentó en el procesador");
            }
        }

        boolean disminuirTemperatura = random.nextDouble() < 0.20;
        if (disminuirTemperatura) {
            procesador.disminuirTemperatura(random.nextInt(10));
            System.out.println("Bajando temperatura del procesador");
        }

        if (procesador.getTemperaturaActual() >= procesador.getTemperaturaMaxima()) {
            System.out.println("El procesador está en la temperatura máxima, pal loby, prueba Fallida");
        } else {
            System.out.println("El procesador está piola, se mantiene chill el guacho, EXITO al estilo OPENINGLISH");
        }

    }
}
