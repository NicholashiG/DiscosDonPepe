package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControllerArtistas implements Initializable{
	
    SingletonController control = SingletonController.getInstance();

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnAtras1;

    @FXML
    private Button btnAtras2;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnEditar1;

    @FXML
    private Button btnEditar2;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnEliminar1;

    @FXML
    private Button btnEliminar2;

    @FXML
    private Button btnEscogerImg;

    @FXML
    private Button btnEscogerImg1;

    @FXML
    private Button btnEscogerImg2;

    @FXML
    private Button btnGuardarCambios;

    @FXML
    private Button btnGuardarCambios1;

    @FXML
    private Button btnGuardarCambios2;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnNuevo1;

    @FXML
    private Button btnNuevo2;

    @FXML
    private ChoiceBox<?> choiceTipo;

    @FXML
    private ChoiceBox<?> choiceTipo1;

    @FXML
    private ChoiceBox<?> choiceTipo2;

    @FXML
    private ListView<?> listViewArticulos;

    @FXML
    private ListView<?> listViewArticulos1;

    @FXML
    private ListView<?> listViewArticulos2;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtDescripcion1;

    @FXML
    private TextField txtDescripcion2;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNombre1;

    @FXML
    private TextField txtNombre2;

    @FXML
    private Label txtRutaArchivo;

    @FXML
    private Label txtRutaArchivo1;

    @FXML
    private Label txtRutaArchivo2;

    @FXML
    void atras(ActionEvent event) {

    }

    @FXML
    void editar(ActionEvent event) {

    }

    @FXML
    void eliminar(ActionEvent event) {

    }

    @FXML
    void escogerImagen(ActionEvent event) {

    }

    @FXML
    void guardarCambios(ActionEvent event) {

    }

    @FXML
    void nuevo(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
            control.guardarCasaSubastasBinario(control.discos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}

}
