import java.util.Scanner;

public class IdentificarAcordes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa las tres notas musicales en formato inglés (por ejemplo, para MI es E, para SOL es G) separadas por espacios.");
        System.out.println("Opciones de notas disponibles: E, F, G, A, B, C, D");
        System.out.println("Por favor, ingresa las notas para formar el acorde:");

        String nota1 = scanner.next();
        String nota2 = scanner.next();
        String nota3 = scanner.next();

        String acorde = "";

        if ((nota1.equals("C") && nota2.equals("E") && nota3.equals("F")) ||
                (nota1.equals("E") && nota2.equals("F") && nota3.equals("C")) ||
                (nota1.equals("F") && nota2.equals("C") && nota3.equals("E"))) {
            acorde = "Do mayor";
        } else if ((nota1.equals("D") && nota2.equals("F") && nota3.equals("A")) ||
                (nota1.equals("F") && nota2.equals("A") && nota3.equals("D")) ||
                (nota1.equals("A") && nota2.equals("D") && nota3.equals("F"))) {
            acorde = "Re menor";
        } else if ((nota1.equals("E") && nota2.equals("G") && nota3.equals("B")) ||
                (nota1.equals("G") && nota2.equals("B") && nota3.equals("E")) ||
                (nota1.equals("B") && nota2.equals("E") && nota3.equals("G"))) {
            acorde = "Mi menor";
        } else if ((nota1.equals("F") && nota2.equals("A") && nota3.equals("C")) ||
                (nota1.equals("A") && nota2.equals("C") && nota3.equals("F")) ||
                (nota1.equals("C") && nota2.equals("F") && nota3.equals("A"))) {
            acorde = "Fa mayor";
        } else if ((nota1.equals("G") && nota2.equals("B") && nota3.equals("D")) ||
                (nota1.equals("B") && nota2.equals("D") && nota3.equals("G")) ||
                (nota1.equals("D") && nota2.equals("G") && nota3.equals("B"))) {
            acorde = "Sol mayor";
        } else if ((nota1.equals("A") && nota2.equals("C") && nota3.equals("E")) ||
                (nota1.equals("C") && nota2.equals("E") && nota3.equals("A")) ||
                (nota1.equals("E") && nota2.equals("A") && nota3.equals("C"))) {
            acorde = "La menor";
        } else if ((nota1.equals("B") && nota2.equals("D") && nota3.equals("F")) ||
                (nota1.equals("D") && nota2.equals("F") && nota3.equals("B")) ||
                (nota1.equals("F") && nota2.equals("B") && nota3.equals("D"))) {
            acorde = "Si disminuido";
        }

        if (!acorde.equals("")) {
            System.out.println("Bien ahi loco! esas son las notas para: " + acorde);
        } else {
            System.out.println("Esta bien que no sepas de musica, pero eso no hace un acorde mi Rey.");
        }

        scanner.close();
    }
}

