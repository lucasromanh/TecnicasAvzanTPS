import java.util.Scanner;

public class DescuentoProductoRefactorizado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el precio original del producto:");
        double precioOriginal = scanner.nextDouble();

        System.out.println("Ingresa el código del producto (que es de 8 dígitos):");
        String codigo = scanner.next();

        System.out.println("Ingresa la edad del cliente:");
        int edad = scanner.nextInt();

        double descuento = 0;

        switch (codigo.substring(0, 2)) {
            case "37":
                descuento = 0.12;
                break;
            case "16":
                descuento = 0.15;
                break;
            case "29":
                descuento = 0.19;
                break;
        }

        if (edad >= 60) {
            descuento += 0.15;
        } else if (edad >= 30) {
            descuento += 0.10;
        }

        if (descuento > 0.30) {
            descuento = 0.30;
        }

        double precioFinal = precioOriginal * (1 - descuento);

        System.out.println("El precio final con el descuento aplicado según la edad es: $" + String.format("%.2f", precioFinal));

        scanner.close();
    }
}