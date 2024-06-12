import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AnalisisMusical {

    private static final ArrayList<ArrayList<String>> canciones = new ArrayList<>();
    private static final ArrayList<Integer> consistencias = new ArrayList<>();
    private static final ArrayList<String> acordes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion = leerOpcion(scanner);

            try {
                switch (opcion) {
                    case 1:
                        cargarCancion(scanner);
                        break;
                    case 2:
                        detectarConsistencia();
                        break;
                    case 3:
                        analizarAcordes();
                        break;
                    case 4:
                        mostrarConsistencias();
                        break;
                    case 5:
                        mostrarAcordes();
                        break;
                    case 6:
                        salirPrograma(scanner);
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Cargar canción");
        System.out.println("2. Analizar consistencia melódica");
        System.out.println("3. Analizar acordes");
        System.out.println("4. Mostrar consistencias melódicas");
        System.out.println("5. Mostrar acordes");
        System.out.println("6. Salir");
        System.out.print("Elija una opción: ");
    }

    private static int leerOpcion(Scanner scanner) {
        while (true) {
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                return opcion;
            } catch (InputMismatchException e) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
        }
    }

    private static void cargarCancion(Scanner scanner) {
        ArrayList<String> cancion = new ArrayList<>();
        System.out.println("Ingrese las notas de la canción separadas por espacio (mínimo 9 notas):");
        String[] notas = scanner.nextLine().split(" ");

        if (notas.length < 9) {
            System.out.println("La canción debe tener al menos 9 notas.");
            return;
        }

        for (String nota : notas) {
            cancion.add(nota);
        }

        canciones.add(cancion);
        System.out.println("Canción cargada con éxito.");
    }

    private static void detectarConsistencia() {
        if (canciones.isEmpty()) {
            throw new IllegalStateException("No hay canciones cargadas para analizar.");
        }

        consistencias.clear();
        for (ArrayList<String> cancion : canciones) {
            for (int i = 0; i < cancion.size() - 1; i++) {
                if (esConsistente(cancion.get(i), cancion.get(i + 1))) {
                    consistencias.add(i);
                }
            }
        }

        if (consistencias.isEmpty()) {
            System.out.println("No se encontraron consistencias melódicas.");
        } else {
            System.out.println("Análisis de consistencia melódica completado.");
        }
    }

    private static boolean esConsistente(String nota1, String nota2) {
        String notas = "ABCDEFG";
        int pos1 = notas.indexOf(nota1);
        int pos2 = notas.indexOf(nota2);
        return Math.abs(pos1 - pos2) == 1 || Math.abs(pos1 - pos2) == 6;
    }

    private static void analizarAcordes() {
        if (canciones.isEmpty()) {
            throw new IllegalStateException("No hay canciones cargadas para analizar.");
        }

        acordes.clear();
        for (ArrayList<String> cancion : canciones) {
            for (int i = 0; i < cancion.size() - 2; i++) {
                String acorde = identificarAcorde(cancion.get(i), cancion.get(i + 1), cancion.get(i + 2));
                if (acorde != null) {
                    acordes.add(acorde);
                }
            }
        }

        if (acordes.isEmpty()) {
            System.out.println("No se encontraron acordes.");
        } else {
            System.out.println("Análisis de acordes completado.");
        }
    }

    private static String identificarAcorde(String nota1, String nota2, String nota3) {
        if (nota1.equals("C") && nota2.equals("E") && nota3.equals("G")) return "Do mayor";
        if (nota1.equals("D") && nota2.equals("F") && nota3.equals("A")) return "Re menor";
        if (nota1.equals("E") && nota2.equals("G") && nota3.equals("B")) return "Mi menor";
        if (nota1.equals("F") && nota2.equals("A") && nota3.equals("C")) return "Fa mayor";
        if (nota1.equals("G") && nota2.equals("B") && nota3.equals("D")) return "Sol mayor";
        if (nota1.equals("A") && nota2.equals("C") && nota3.equals("E")) return "La menor";
        return null;
    }

    private static void mostrarConsistencias() {
        if (consistencias.isEmpty()) {
            System.out.println("No hay consistencias melódicas para mostrar.");
        } else {
            System.out.println("Consistencias melódicas:");
            for (Integer consistencia : consistencias) {
                System.out.println("Consistencia en índice: " + consistencia);
            }
        }
    }

    private static void mostrarAcordes() {
        if (acordes.isEmpty()) {
            System.out.println("No hay acordes reconocidos para mostrar.");
        } else {
            System.out.println("Acordes reconocidos:");
            for (String acorde : acordes) {
                System.out.println("Acorde: " + acorde);
            }
        }
    }

    private static void salirPrograma(Scanner scanner) {
        System.out.println("Saliendo del programa.");
        scanner.close();
    }
}


