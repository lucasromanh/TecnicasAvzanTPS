public class Componente {
    private String nombre;
    private String fechaDeFabricacion;
    private String nSerie;

    public Componente(String nombre, String fechaDeFabricacion, String nSerie) {
        this.nombre = nombre;
        this.fechaDeFabricacion = fechaDeFabricacion;
        this.nSerie = nSerie;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaDeFabricacion() {
        return fechaDeFabricacion;
    }

    public String getNSerie() {
        return nSerie;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nFecha de fabricación: " + fechaDeFabricacion + "\nNúmero de serie: " + nSerie;
    }
}

