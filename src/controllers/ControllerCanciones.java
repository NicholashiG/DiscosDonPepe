package controllers;

import java.io.File;
import java.io.FileNotFoundException;
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
import model.Cancion;
import model.Generos;
import services.FilePicker;

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
	private ChoiceBox<Generos> choiceGenero;

	@FXML
	private ListView<Cancion> listViewCanciones;

	@FXML
	private TextField txtAnio;

	@FXML
	private TextField txtDuracion;

	@FXML
	private TextField txtNombreAlbum;

	@FXML
	private TextField txtNombreCancion;

	@FXML
	private Label txtRutaArchivo;

	@FXML
	private TextField txtURLYT;

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
    private void escogerImagen() throws Exception {

        // método que crea un filePicker para que el usuario pueda escoger
        // la imagen
        FilePicker filePicker = new FilePicker();
        try {
            File direccion = filePicker.getDireccionArchivo();
            if (direccion == null) {
                txtRutaArchivo.setText("Seleccione un archivo");
                throw new FileNotFoundException("Seleccione un archivo válido");
            } else {
                txtRutaArchivo.setText(direccion.getAbsolutePath());
                btnEscogerImg.setText(direccion.getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
	@FXML
	void guardarCambios(ActionEvent event) {

	}

	@FXML
	void nuevo(ActionEvent event) {

	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// Añade los elementos de las enumeraciones al choicebox
		for (Generos genero: Generos.values()) {
			choiceGenero.getItems().add(genero);
		}
		
		// Serializa todo Discos Don Pepe
		try {
			control.guardarDiscosDonPepeBinario(control.discos);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
