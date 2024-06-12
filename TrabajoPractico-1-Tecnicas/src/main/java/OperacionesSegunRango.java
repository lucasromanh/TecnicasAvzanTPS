import java.util.Scanner;

public class OperacionesSegunRango {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un número:");
        int numero = scanner.nextInt();

        if (numero >= 0 && numero <= 20) {
            int cuadrado = numero * numero;
            System.out.println("El cuadrado de " + numero + " es " + cuadrado + ".");
        } else if (numero >= 21 && numero <= 40) {
            double raiz = Math.sqrt(numero);
            System.out.println("La raíz cuadrada de " + numero + " es " + String.format("%.2f", raiz) + ".");
        } else if (numero >= 41 && numero <= 60) {
            if (numero % 2 == 0) {
                System.out.println("El número " + numero + " es par.");
            } else {
                System.out.println("El número " + numero + " es impar.");
            }
        } else if (numero >= 61 && numero <= 80) {
            int digito1 = numero % 10;
            int digito2 = numero / 10;
            int nuevoNumero = digito1 * 10 + digito2;
            System.out.println("El número cambió sus dígitos a " + nuevoNumero + ".");
        } else if (numero >= 81 && numero <= 99) {
            int resultado = numero - 45;
            int sumaDigitos = (resultado / 10) + (resultado % 10);
            if (sumaDigitos <= 10) {
                System.out.println("Mas despues (xD) de restar 45 a " + numero + " tenemos " + resultado + " y sumando sus dígitos nos da " + sumaDigitos + ".");
            } else {
                System.out.println("despues de restar 45 a " + numero + " sacamos " + resultado + ".");
            }
        } else {
            System.out.println("El número está fuera del rango mi rey, ponete las pilas siempre lo mismo.");
        }
        scanner.close();
    }
}

