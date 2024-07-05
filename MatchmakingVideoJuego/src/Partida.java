public class Partida implements Runnable {
    private final Jugador jugador1;
    private final Jugador jugador2;
    private final SistemaJuego sistemaJuego;

    public Partida(Jugador jugador1, Jugador jugador2, SistemaJuego sistemaJuego) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.sistemaJuego = sistemaJuego;
    }

    @Override
    public void run() {
        sistemaJuego.aumentarPartidasActivas();
        System.out.println("Comenzó una partida entre Jugador " + jugador1.getId() + " y Jugador " + jugador2.getId());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int puntaje1 = (int) (Math.random() * 6);
        int puntaje2 = (int) (Math.random() * 6);

        String resultado;
        if (puntaje1 > puntaje2) {
            resultado = "Victoria para Jugador " + jugador1.getId();
        } else if (puntaje1 < puntaje2) {
            resultado = "Victoria para Jugador " + jugador2.getId();
        } else {
            resultado = "Empate";
        }

        System.out.println("Resultado de la partida: Jugador " + jugador1.getId() + " (" + puntaje1 + ") vs Jugador " + jugador2.getId() + " (" + puntaje2 + ") - " + resultado);

        sistemaJuego.disminuirPartidasActivas();
    }
}



