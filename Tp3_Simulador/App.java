import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Procesador procesador = new Procesador("Procesador Intel I7 12700K", "10-10-2021", "07365489", 4.5, 8, 105, 36);
        Memoria memoria1 = new Memoria("Memoria RAM Corsair", "15-06-2022", "12345678", 3200, 8, 0.2f);
        Memoria memoria2 = new Memoria("Memoria RAM Kingston", "20-07-2022", "87654321", 3200, 8, 0.2f);
        ArrayList<Memoria> memorias = new ArrayList<>();
        memorias.add(memoria1);memorias.add(memoria2);
        Computadora computadora = new Computadora(procesador, memorias);
        computadora.analizarOfimatica();
        System.out.println();
        computadora.analizarRenderizado();
        System.out.println();
    }
}

