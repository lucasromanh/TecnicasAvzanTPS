import java.util.Random;
import java.util.Scanner;


public class AdivinarNumero {
    public static void main(String[] args) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(91) + 10;
        Scanner scanner = new Scanner(System.in);
        int intentos = 0;

        System.out.println("Se ha creado un número aleatorio entre 10 y 100. Adivina cuál es brodis:");

        while (true) {
            int intento = scanner.nextInt();
            intentos++;

            if (intento == numeroAleatorio) {
                System.out.println("¡Genial mi Rey! Sacaste  el número en " + intentos + " intentos.");
                break;
            } else if (intento < numeroAleatorio) {
                System.out.println("El número es más alto, mi rey.");
            } else {
                System.out.println("El número es más bajo, mi rey.");
            }

            // Verificar la proximidad del intento
            int diferencia = Math.abs(numeroAleatorio - intento);
            if (diferencia <= 10) {
                System.out.println("Estás cerquita loco, no te vayas tanto!.");
            }
        }

        scanner.close();
    }
}

