package org.example.listacanciones;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class HelloController {
    public static class Cancion {
        private String titulo;
        private String artista;

        public Cancion(String titulo, String artista) {
            this.titulo = titulo;
            this.artista = artista;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getArtista() {
            return artista;
        }

        @Override
        public String toString() {
            return titulo + " - " + artista;
        }
    }

    @FXML
    private ListView<ListaReproduccion> listViewListas;
    @FXML
    private ListView<Cancion> listViewCanciones;
    @FXML
    private TextField tituloField;
    @FXML
    private TextField artistaField;
    @FXML
    private Button agregarButton;
    @FXML
    private Button eliminarButton;
    @FXML
    private Button buscarButton;
    @FXML
    private Button nuevaListaButton;

    private ObservableList<ListaReproduccion> listas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listViewListas.setItems(listas);
        listViewListas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                listViewCanciones.setItems(newValue.getCanciones());
            }
        });
    }

    @FXML
    protected void onAgregarButtonClick() {
        String titulo = tituloField.getText();
        String artista = artistaField.getText();
        if (!titulo.isEmpty() && !artista.isEmpty()) {
            Cancion nuevaCancion = new Cancion(titulo, artista);
            ListaReproduccion listaSeleccionada = listViewListas.getSelectionModel().getSelectedItem();
            if (listaSeleccionada != null) {
                listaSeleccionada.agregarCancion(nuevaCancion);
            } else {
                mostrarMensajeError("Error", "Debe seleccionar una lista de reproducción.");
            }
            tituloField.clear();
            artistaField.clear();
        } else {
            mostrarMensajeError("Error", "Debe ingresar el título y el artista de la canción.");
        }
    }

    @FXML
    protected void onEliminarButtonClick() {
        ListaReproduccion listaSeleccionada = listViewListas.getSelectionModel().getSelectedItem();
        if (listaSeleccionada != null) {
            listas.remove(listaSeleccionada);
        } else {
            mostrarMensajeError("Error", "Debe seleccionar una lista de reproducción para eliminar.");
        }
    }

    @FXML
    protected void onBuscarButtonClick() {
        String titulo = tituloField.getText();
        if (!titulo.isEmpty()) {
            ListaReproduccion listaSeleccionada = listViewListas.getSelectionModel().getSelectedItem();
            if (listaSeleccionada != null) {
                ObservableList<Cancion> canciones = listaSeleccionada.getCanciones();
                for (Cancion cancion : canciones) {
                    if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                        listViewCanciones.getSelectionModel().select(cancion);
                        break;
                    }
                }
            } else {
                mostrarMensajeError("Error", "Debe seleccionar una lista de reproducción.");
            }
        } else {
            mostrarMensajeError("Error", "Ingrese el título de la canción a buscar.");
        }
    }


    @FXML
    protected void onNuevaListaButtonClick() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Nueva Lista de Reproducción");
        dialog.setHeaderText(null);
        dialog.setContentText("Ingrese el nombre de la nueva lista:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(this::crearNuevaLista);
    }

    private void crearNuevaLista(String nombreLista) {
        if (nombreLista != null && !nombreLista.isEmpty()) {
            ListaReproduccion nuevaLista = new ListaReproduccion(nombreLista);
            listas.add(nuevaLista);
        } else {
            mostrarMensajeError("Error", "El nombre de la lista no puede estar vacío.");
        }
    }

    private void mostrarMensajeError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
