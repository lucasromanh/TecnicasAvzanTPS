public class Memoria extends Componente {
    private int capacidad;
    private int velocidad;
    private float porcentajeDeUso;

    public Memoria(String nombre, String fechaDeFabricacion, String nSerie, int capacidad, int velocidad, float porcentajeDeUso) {
        super(nombre, fechaDeFabricacion, nSerie);
        this.capacidad = capacidad;
        this.velocidad = velocidad;
        this.porcentajeDeUso = porcentajeDeUso;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public float getPorcentajeDeUso() {
        return porcentajeDeUso;
    }

    public void aumentarPorcentajeDeUso(float porcentaje) {
        this.porcentajeDeUso += porcentaje;
    }

    public void disminuirPorcentajeDeUso(float porcentaje) {
        this.porcentajeDeUso -= porcentaje;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCapacidad: " + capacidad + "\nVelocidad: " + velocidad + "\n% de uso: " + porcentajeDeUso;
    }
}

