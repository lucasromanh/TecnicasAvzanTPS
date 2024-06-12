import java.util.Scanner;

public class ContarApariciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa una cadena de texto:");
        String cadena = scanner.nextLine();
        System.out.println("Ingresa un carácter para contar las veces que aparece (si esta en mayusucla no cuenta loco):");
        char caracter = scanner.next().charAt(0);

        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == caracter) {
                contador++;
            }
        }

        System.out.println("El carácter '" + caracter + "' esta " + contador + " veces en la cadena.");

        scanner.close();
    }
}

