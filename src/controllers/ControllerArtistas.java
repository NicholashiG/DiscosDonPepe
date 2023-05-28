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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
	private Button btnLimpiar;

	@FXML
	private ChoiceBox<Nacionalidades> choiceTipo;

	@FXML
	private ListView<Artista> listViewArtistas;

	@FXML
	private RadioButton radioBtnArtista;

	@FXML
	private RadioButton radioBtnGrupo;

	// mauskyherramienta que nos servira mas tarde (initialize)
	private ToggleGroup toggleGroup = new ToggleGroup();
	
	@FXML
	private TextField txtNombre;

	@FXML
	void atras(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Principal.fxml"));

			Parent root = loader.load();

			ControllerPrincipal controlador = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

			stage.setOnCloseRequest(e -> controlador.closeWindow("/view/Artistas.fxml"));
			Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
			myStage.close();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@FXML
	void editar(ActionEvent event) {

		Artista actual = listViewArtistas.getSelectionModel().getSelectedItem();
		Artista nuevo = crearArtista();
		control.replaceArtista(actual, nuevo);
		
		// reemplazar en la listView:
		for (Artista a : listViewArtistas.getItems()) {
			if (a.getNombre().equals(actual.getNombre())) {
				listViewArtistas.getItems().set(listViewArtistas.getItems().indexOf(a), nuevo);
				break;
			}
		}
		
		
	}

	@FXML
	void eliminar(ActionEvent event) {
		Artista a = listViewArtistas.getSelectionModel().getSelectedItem();
		listViewArtistas.getItems().remove(a);
		control.removeArtista(a);
		
	}
	
	@FXML
	void select(MouseEvent arg0) {
		 Artista a = listViewArtistas.getSelectionModel().getSelectedItem();
		// Esto verifica si la accion enviada es un doble click, en ese caso,
		// ejecuta.
		
		 if (arg0.getButton().equals(MouseButton.PRIMARY) && arg0.getClickCount() == 2 && a != null) {
			 txtNombre.setText(a.getNombre());
			 choiceTipo.setValue(Nacionalidades.valueOf(a.getNacionalidad()));
			 if (a.isGrupo()) {
				 radioBtnGrupo.setSelected(true);
			 } else radioBtnArtista.setSelected(true);
			 
			 // En esta parte se cargarian las canciones.
			 // ...
		 }
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
		
		
		// A�ado ambos radioBtn a un toggleGroup para que solo se pueda
		// seleccionar 1.
		radioBtnArtista.setToggleGroup(toggleGroup);
		radioBtnGrupo.setToggleGroup(toggleGroup);
		
		// Añade los elementos de las enumeraciones al choicebox
		for (Nacionalidades nacionalidad : Nacionalidades.values()) {
			choiceTipo.getItems().add(nacionalidad);
		}
	
	}
	@FXML
	void limpiar(ActionEvent event){
		// Vacia los fields, cambiar luego, no se donde ponerlo xd
		// a cada rato con esos valores ahi puestos q mam3ra
		txtNombre.setText("");
		choiceTipo.setValue(null);
		radioBtnArtista.setSelected(false);
		radioBtnGrupo.setSelected(false);

	}

	// Manda al Singleton la instruccion de serializar la clase principal.
	private void serializar() {
		try {
			control.guardarDiscosDonPepeBinario(control.discos);
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
