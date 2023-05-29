package controllers;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;
import javafx.scene.control.Button;

import javax.swing.*;


public class ControllerBusquedas implements Initializable {
    SingletonController control = SingletonController.getInstance();
    @FXML
    private TextField txtArtistas;
    @FXML
    private ListView<Cancion> listViewY;
    @FXML
    private ListView<String> listViewArtistas;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnVolver;


    @FXML
    private TextField txtAnio;

    @FXML
    private ListView<Cancion> listViewO;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtAlbum;



    @FXML
    void busquedaO() {
        try {
            listViewO.getItems().setAll(control.busquedaO(txtNombre.getText(), txtAlbum.getText()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void busquedaY() throws InterruptedException {

        listViewY.getItems().setAll(control.busquedaY(txtAnio.getText(), txtGenero.getText()));
    }

    @FXML
    public void buscarArtista() {
        ArbolBinarioArtistas arbolArtistas = new ArbolBinarioArtistas();
        String nombreArtista = txtArtistas.getText();
        System.out.println(nombreArtista);
        if (!nombreArtista.isEmpty()) {
            NodoArtista nodoArtista = arbolArtistas.buscar(nombreArtista);
            
            if (nodoArtista != null) {
                Artista artista = nodoArtista.getArtista();
                if (artista != null) {
                    listarCancionesArtista(artista);
                } else {
                    listViewArtistas.getItems().clear();
                    JOptionPane.showMessageDialog(null,"No se encontraron canciones para el artista: " + nombreArtista);
                }
            } else {
                listViewArtistas.getItems().clear();
                JOptionPane.showMessageDialog(null,"Artista no encontrado: " + nombreArtista);
            }
        }
    }

    // Método para listar las canciones de un artista en el ListView
    private void listarCancionesArtista(Artista artista) {
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada<>();
        ArrayList<Cancion> array = new ArrayList<Cancion>();
        array = lista.listaToArray(artista.getCanciones());
        listViewArtistas.getItems().clear();
        for (Cancion cancion : array) {
            listViewArtistas.getItems().add(cancion.getNombreCancion());
        }
    }



    @FXML
    void limpiar(ActionEvent event) {
        // Vacia los fields, cambiar luego, no se donde ponerlo xd
        // a cada rato con esos valores ahi puestos q mam3ra
        txtNombre.setText("");
        txtGenero.setText("");
        txtAlbum.setText("");
        txtAnio.setText("");
        txtArtistas.setText("");
        listViewO.getItems().clear();
        listViewY.getItems().clear();
    }
    @FXML
    void reproducirCancion(ActionEvent event) {
        if(!listViewY.getSelectionModel().isEmpty()) {
            Cancion cSeleccionadaY = listViewY.getSelectionModel().getSelectedItem();
            String linkYoutubeY = cSeleccionadaY.getURLYT();
            abrirCancion(linkYoutubeY);
        }
        if(!listViewO.getSelectionModel().isEmpty()) {
            Cancion cSeleccionada0 = listViewO.getSelectionModel().getSelectedItem();
            String linkYoutube0 = cSeleccionada0.getURLYT();
            abrirCancion(linkYoutube0);
        }


    }

    private void abrirCancion(String link) {
        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Carga la clase principal en el Singleton
        // No retorna la clase principal, solo actualiza
        // el valor de la clase (control.getDiscos) con el nuevo.
        try {
            control.cargarDIscosDonPepeBinario();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cargamos nuevamente el control, pero ahora, con la clase principla
        // cargada,
        control = SingletonController.getInstance();


    }

    @FXML
    void volver() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Principal.fxml"));

            Parent root = loader.load();

            ControllerPrincipal controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> controlador.closeWindow("/view/Artistas.fxml"));
            Stage myStage = (Stage) this.btnVolver.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void closeWindow() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Principal.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

	
