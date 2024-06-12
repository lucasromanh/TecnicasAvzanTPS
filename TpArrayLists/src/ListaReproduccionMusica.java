import java.util.ArrayList;
import java.util.Scanner;

public class ListaReproduccionMusica {

    static ArrayList<String> listasReproduccion = new ArrayList<>();
    static ArrayList<ArrayList<String>> cancionesPorLista = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarLista();
                    break;
                case 2:
                    agregarCancion();
                    break;
                case 3:
                    mostrarListasYCanciones();
                    break;
                case 4:
                    buscarCancion();
                    break;
                case 5:
                    eliminarCancion();
                    break;
                case 6:
                    System.out.println("Gracias por usar el programa. ¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("----- Menú -----");
        System.out.println("1. Agregar lista de reproducción");
        System.out.println("2. Agregar canción a lista de reproducción");
        System.out.println("3. Mostrar todas las listas y sus canciones");
        System.out.println("4. Buscar una canción por título");
        System.out.println("5. Eliminar una canción de una lista");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void agregarLista() {
        System.out.print("Ingrese el nombre de la lista de reproducción: ");
        String nombreLista = scanner.nextLine();
        if (listasReproduccion.contains(nombreLista)) {
            System.out.println("La lista de reproducción '" + nombreLista + "' ya existe.");
            System.out.print("¿Desea usar esta lista existente? (S/N): ");
            String opcion = scanner.nextLine();
            if (opcion.equalsIgnoreCase("S")) {
                System.out.println("Se usará la lista existente.");
                return;
            }
            while (listasReproduccion.contains(nombreLista)) {
                System.out.print("Ingrese otro nombre para la lista de reproducción: ");
                nombreLista = scanner.nextLine();
            }
        }
        listasReproduccion.add(nombreLista);
        cancionesPorLista.add(new ArrayList<>());
        System.out.println("Lista de reproducción '" + nombreLista + "' agregada correctamente.");
    }

    public static void agregarCancion() {
        if (listasReproduccion.isEmpty()) {
            System.out.println("No hay listas de reproducción creadas. Por favor, cree una lista primero.");
            return;
        }
        System.out.print("Ingrese el nombre de la lista de reproducción a la que desea agregar la canción: ");
        String nombreLista = scanner.nextLine();
        if (!listasReproduccion.contains(nombreLista)) {
            System.out.println("La lista de reproducción especificada no existe.");
            return;
        }
        System.out.print("Ingrese el nombre de la canción que desea agregar: ");
        String nombreCancion = scanner.nextLine();
        int index = listasReproduccion.indexOf(nombreLista);
        cancionesPorLista.get(index).add(nombreCancion);
        System.out.println("Canción '" + nombreCancion + "' agregada a la lista '" + nombreLista + "' correctamente.");
    }

    public static void mostrarListasYCanciones() {
        if (listasReproduccion.isEmpty()) {
            System.out.println("No hay listas de reproducción creadas.");
            return;
        }
        System.out.println("----- Listas de Reproducción y Canciones -----");
        for (int i = 0; i < listasReproduccion.size(); i++) {
            String lista = listasReproduccion.get(i);
            ArrayList<String> canciones = cancionesPorLista.get(i);
            System.out.println("Lista de reproducción: " + lista);
            if (canciones.isEmpty()) {
                System.out.println("    - Esta lista no tiene canciones aún.");
            } else {
                for (String cancion : canciones) {
                    System.out.println("    - " + cancion);
                }
            }
        }
    }

    public static void buscarCancion() {
        if (listasReproduccion.isEmpty()) {
            System.out.println("No hay listas de reproducción creadas.");
            return;
        }
        System.out.print("Ingrese el título de la canción que desea buscar: ");
        String titulo = scanner.nextLine();
        boolean encontrada = false;
        for (int i = 0; i < cancionesPorLista.size(); i++) {
            ArrayList<String> canciones = cancionesPorLista.get(i);
            for (String cancion : canciones) {
                if (cancion.equalsIgnoreCase(titulo)) {
                    encontrada = true;
                    System.out.println("La canción '" + titulo + "' se encuentra en la lista '" + listasReproduccion.get(i) + "'.");
                    break;
                }
            }
        }
        if (!encontrada) {
            System.out.println("La canción '" + titulo + "' no se encuentra en ninguna lista de reproducción.");
        }
    }

    public static void eliminarCancion() {
        if (listasReproduccion.isEmpty()) {
            System.out.println("No hay listas de reproducción creadas.");
            return;
        }
        System.out.print("Ingrese el nombre de la lista de reproducción de la que desea eliminar la canción: ");
        String nombreLista = scanner.nextLine();
        if (!listasReproduccion.contains(nombreLista)) {
            System.out.println("La lista de reproducción especificada no existe.");
            return;
        }
        int index = listasReproduccion.indexOf(nombreLista);
        ArrayList<String> canciones = cancionesPorLista.get(index);
        if (canciones.isEmpty()) {
            System.out.println("La lista de reproducción '" + nombreLista + "' no tiene canciones.");
            return;
        }
        System.out.print("Ingrese el título de la canción que desea eliminar: ");
        String titulo = scanner.nextLine();
        if (!canciones.contains(titulo)) {
            System.out.println("La canción especificada no existe en la lista de reproducción '" + nombreLista + "'.");
            return;
        }
        canciones.remove(titulo);
        System.out.println("Canción '" + titulo + "' eliminada de la lista '" + nombreLista + "' correctamente.");
    }
}

