public class GeneradorJugador implements Runnable {
    private final SistemaJuego sistemaJuego;
    private final int jugadoresTotales;

    public GeneradorJugador(SistemaJuego sistemaJuego, int jugadoresTotales) {
        this.sistemaJuego = sistemaJuego;
        this.jugadoresTotales = jugadoresTotales;
    }

    @Override
    public void run() {
        for (int i = 1; i <= jugadoresTotales; i++) {
            try {
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int ranking = 1000 + (int) (Math.random() * 23001);
            Jugador jugador = new Jugador(i, ranking);
            sistemaJuego.agregarJugador(jugador);
            System.out.println("El Jugador " + jugador.getId() + " (Ranking: " + jugador.getRanking() + ") se unió a la cola de espera.");
        }
        sistemaJuego.setGenerandoJugadores(false);
        System.out.println("Se terminaron de generar los jugadores.");
    }
}


