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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Artista;
import model.Nacionalidades;

public class ControllerArtistas implements Initializable {

	SingletonController control = SingletonController.getInstance();

	@FXML
	private Button btnAtras;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnEliminar;

	@FXML
	private Button btnEscogerCanciones;

	@FXML
	private Button btnGuardarCambios;

	@FXML
	private Button btnNuevo;

	@FXML
	private ChoiceBox<Nacionalidades> choiceTipo;

	@FXML
	private ListView<Artista> listViewArtistas;

	@FXML
	private RadioButton radioBtnArtista;

	@FXML
	private RadioButton radioBtnGrupo;

	// mauskherramienta que nos servira mas tarde (initialize)
	private ToggleGroup toggleGroup = new ToggleGroup();
	
	@FXML
	private TextField txtNombre;

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
	void guardarCambios(ActionEvent event) {
		serializar();
	}
	
	@FXML
	void escogerCancion(ActionEvent event) {

	}

	@FXML
	void nuevo(ActionEvent event) {
		Artista a = crearArtista();
		listViewArtistas.getItems().add(a);
		control.addArtista(a);
	}
	
	
	private Artista crearArtista() {
		Artista a = new Artista(txtNombre.getText(),
								choiceTipo.getValue().toString(),
								isGroup(),
								null);
		return a;
	}
	
	private boolean isGroup() {
		if (radioBtnGrupo.isSelected())return true;
		return false;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	
		// Carga la clase principal en el Singleton
		// No retorna la clase principal, solo actualiza
		// el valor de la clase (control.getDiscos) con el nuevo.
		try {control.cargarDIscosDonPepeBinario();} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Cargamos nuevamente el control, pero ahora, con la clase principla
		// cargada,
		control = SingletonController.getInstance();	
		
		
		// Popula el listView
		
		listViewArtistas.getItems().addAll(control.getDiscos().getArbolArtistas().toArray());
		
		
		// Añado ambos radioBtn a un toggleGroup para que solo se pueda
		// seleccionar 1.
		radioBtnArtista.setToggleGroup(toggleGroup);
		radioBtnGrupo.setToggleGroup(toggleGroup);
		
		// AÃ±ade los elementos de las enumeraciones al choicebox
		for (Nacionalidades nacionalidad : Nacionalidades.values()) {
			choiceTipo.getItems().add(nacionalidad);
		}
	
	}
	

	// Manda al Singleton la instruccion de serializar la clase principal.
	private void serializar() {
		try {
			control.guardarDiscosDonPepeBinario(control.discos);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
