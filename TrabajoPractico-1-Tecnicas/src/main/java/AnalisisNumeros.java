import java.util.Scanner;

public class AnalisisNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minimo = Integer.MAX_VALUE;
        int maximo = Integer.MIN_VALUE;
        int sumaImpares = 0;
        int productoPares = 1;
        int cantidadNumeros = 0;

        while (true) {
            System.out.println("Ingresa un número (manda -1 para terminar):");
            int numero = scanner.nextInt();
            if (numero == -1) {
                break;
            }
            if (numero > 100) {
                System.out.println("El numero ingresado es mayor a 100, no vale, no cuenta.");
                continue;
            }

            if (numero < minimo) {
                minimo = numero;
            }
            if (numero > maximo) {
                maximo = numero;
            }
            if (numero % 2 != 0) {
                sumaImpares += numero;
            } else {
                productoPares *= numero;
            }
            cantidadNumeros++;
        }

        System.out.println("Número mínimo: " + minimo);
        System.out.println("Número máximo: " + maximo);
        System.out.println("Suma de números impares: " + sumaImpares);
        System.out.println("Producto de números pares: " + productoPares);
        System.out.println("Cantidad de números ingresados: " + cantidadNumeros);

        scanner.close();
    }
}

