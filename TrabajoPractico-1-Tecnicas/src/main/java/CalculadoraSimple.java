import java.util.Scanner;

public class CalculadoraSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el primer número:");
        double num1 = scanner.nextDouble();
        System.out.println("Ingresa el segundo número:");
        double num2 = scanner.nextDouble();

        System.out.println("Selecciona la operación que te pinta hacer:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        int opcion = scanner.nextInt();

        double resultado = 0;
        switch (opcion) {
            case 1:
                resultado = num1 + num2;
                break;
            case 2:
                resultado = num1 - num2;
                break;
            case 3:
                resultado = num1 * num2;
                break;
            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Error: No se puede dividir por cero pue, no seas asi.");
                    return;
                }
                break;
            default:
                System.out.println("Opción inválida, mi rey, por eso el shampoo viene con instrucciones.");
                return;
        }

        System.out.println("El resultado de la operación es: " + resultado);

        scanner.close();
    }
}
