import java.util.Scanner;

public class VocalConsonante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un carácter:");
        char caracter = scanner.next().toLowerCase().charAt(0);

        if (caracter >= 'a' && caracter <= 'z') {
            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                System.out.println("El carácter ingresado es una vocal.");
            } else {
                System.out.println("El carácter ingresado es una consonante.");
            }
        } else {
            System.out.println("El carácter ingresado no es una letra del alfabeto pue, no seas golpiau, si la consiga ta clara.");
        }

        scanner.close();
    }
}

