public class Procesador extends Componente {
    private int nucleos;
    private int temperaturaMaxima;
    private int temperaturaActual;
    private double velocidad;

    public Procesador(String nombre, String fechaDeFabricacion, String nSerie, double velocidad, int nucleos, int temperaturaMaxima, int temperaturaActual) {
        super(nombre, fechaDeFabricacion, nSerie);
        this.nucleos = nucleos;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaActual = temperaturaActual;
        this.velocidad = velocidad;
    }

    public int getNucleos() {
        return nucleos;
    }

    public int getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public int getTemperaturaActual() {
        return temperaturaActual;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void aumentarTemperatura(int temperatura) {
        this.temperaturaActual += temperatura;
    }

    public void disminuirTemperatura(int temperatura) {
        this.temperaturaActual -= temperatura;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNúcleos: " + nucleos + "\nTemperatura máxima: " + temperaturaMaxima + "\nTemperatura actual: " + temperaturaActual + "\nVelocidad: " + velocidad;
    }
}
