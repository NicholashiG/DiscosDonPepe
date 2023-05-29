package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Cancion;
import model.Usuario;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ControllerSeleccionarCancionUser implements Initializable {

	SingletonController control = SingletonController.getInstance();
	
	private ArrayList<Cancion> arrayCancionesSeleccionadas = new ArrayList<Cancion>();

	@FXML
	private Button btnVolver;
    @FXML
    private Button btnIzquierda;

    @FXML
    private ListView<Cancion> ListViewCanciones;
	@FXML
	private TextField txtAlbum;

	@FXML
	private TextField txtAnio;


	@FXML
	private Pane ventana;
	@FXML
	private TextField txtGenero;

	@FXML
	private TextField txtNombre;

    @FXML
    private Button btnDerecha;

    @FXML
    private Button guardar;

    @FXML
    private ListView<Cancion> ListViewSeleccionadas;

    @FXML
    void PasarIzquierda(ActionEvent event) {

    	Cancion select = ListViewSeleccionadas.getSelectionModel().getSelectedItem();
    	
    	if (select != null) {
    		
    		ListViewSeleccionadas.getItems().remove(select);
    		arrayCancionesSeleccionadas.remove(select);
    		ListViewCanciones.getItems().add(select);
    		
    	}
    	
    	
    	
    }

    @FXML
    void PasarDerecha(ActionEvent event) {

    	Cancion select = ListViewCanciones.getSelectionModel().getSelectedItem();
    	
    	if (select != null) {
    		ListViewCanciones.getItems().remove(select);
    		ListViewSeleccionadas.getItems().add(select);
    		arrayCancionesSeleccionadas.add(select);
    		
    	}
    	
    }

	@FXML
	void busquedaCancionesO() {
		String anio = "";
		if(txtAnio.getText().isEmpty()){
			anio = "0";
		}else{
			anio = txtAnio.getText();
		}
		try {
			if(!txtNombre.getText().isEmpty() || !txtAlbum.getText().isEmpty() || !txtAnio.getText().isEmpty() || !txtGenero.getText().isEmpty()) {
				ListViewSeleccionadas.getItems().setAll(control.busquedaCancionesO(txtNombre.getText(), txtAlbum.getText(), anio, txtGenero.getText()));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
    

    @FXML
    void Guardar(ActionEvent event) {  	
    	
        Stage stage = (Stage) this.guardar.getScene().getWindow();
        stage.close();
    }

	@FXML
	void limpiar(ActionEvent event) {

		txtNombre.setText("");
		txtAlbum.setText("");
		txtAnio.setText("");
		txtGenero.setText("");

	}



	@FXML
	void reproducirCancion(ActionEvent event) {
		if(!ListViewSeleccionadas.getSelectionModel().isEmpty()) {
			Cancion cSeleccionadaY = ListViewSeleccionadas.getSelectionModel().getSelectedItem();
			String linkYoutubeY = cSeleccionadaY.getURLYT();
			abrirCancion(linkYoutubeY);
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
		

		
		// Repopula la ListView con las canciones guardadas
		
		
		ListViewCanciones.getItems().addAll(0, control.getDiscos().getListaCanciones());
		btnVolver.setOnAction(e -> {
			// Cerrar el pane al presionar el botón
			ventana.getScene().getWindow().hide();
		});
		
	}
	
	public void cargarCancionesSeleccionadas(ArrayList<Cancion> canciones) {
		if (canciones != null) {
		ListViewSeleccionadas.getItems().addAll(0, canciones);
		setArrayCancionesSeleccionadas(canciones);
		}
		
	}

	public ArrayList<Cancion> getArrayCancionesSeleccionadas() {
		return arrayCancionesSeleccionadas;
	}

	public void setArrayCancionesSeleccionadas(ArrayList<Cancion> arrayCancionesSeleccionadas) {
		this.arrayCancionesSeleccionadas = arrayCancionesSeleccionadas;
	}


    
    
}
