public class Main {
    public static void main(String[] args) {
        SistemaJuego sistemaJuego = new SistemaJuego();
        Thread hiloSistema = new Thread(sistemaJuego);
        hiloSistema.start();

        int cantidadJugadores = 20;
        GeneradorJugador generadorJugador = new GeneradorJugador(sistemaJuego, cantidadJugadores);
        Thread hiloGenerador = new Thread(generadorJugador);
        hiloGenerador.start();

        try {
            hiloGenerador.join();
            hiloSistema.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fin del programa.");
    }
}





