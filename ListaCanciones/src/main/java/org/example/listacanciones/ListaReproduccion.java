package org.example.listacanciones;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListaReproduccion {
    private String nombre;
    private ObservableList<HelloController.Cancion> canciones;

    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.canciones = FXCollections.observableArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public ObservableList<HelloController.Cancion> getCanciones() {
        return canciones;
    }

    public void agregarCancion(HelloController.Cancion cancion) {
        canciones.add(cancion);
    }

    // Sobreescribe el método toString para devolver el nombre de la lista
    @Override
    public String toString() {
        return nombre;
    }
}
