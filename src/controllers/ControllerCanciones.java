package controllers;

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

public class ControllerCanciones implements Initializable {

	SingletonController control = SingletonController.getInstance();

	@FXML
	private Button btnAtras;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnEliminar;

	@FXML
	private Button btnEscogerImg;

	@FXML
	private Button btnGuardarCambios;

	@FXML
	private Button btnNuevo;

	@FXML
	private ChoiceBox<?> choiceTipo;

	@FXML
	private ListView<?> listViewArticulos;

	@FXML
	private TextField txtDescripcion;

	@FXML
	private TextField txtNombre;

	@FXML
	private Label txtRutaArchivo;

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

	}

}
