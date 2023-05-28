package controllers;

import java.io.IOException;
import java.net.URL;
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
import model.Cancion;
import javafx.scene.control.Button;


public class ControllerBusquedas implements Initializable {
    SingletonController control = SingletonController.getInstance();
    @FXML
    private TextField txtArtistas;
    @FXML
    private ListView<Cancion> listViewY;

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

    public ControllerBusquedas() {
    }

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
    void buscarArtista() {


    }

    private void cargarCancionesArtista() {

        // no se ha hecho el metodo xdddddddddd

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

	
