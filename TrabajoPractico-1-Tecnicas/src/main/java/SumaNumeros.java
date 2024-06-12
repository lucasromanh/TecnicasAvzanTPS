import java.util.Scanner;

public class SumaNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int suma = 0;
        while (true) {
            System.out.println("Ingrese un número (ingrese un número negativo para terminar):");
            int numero = scanner.nextInt();
            if (numero < 0) {
                break;
            }
            suma += numero;
        }
        System.out.println("La suma de los números ingresados es: " + suma);
        scanner.close();
    }
}

