package controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Cancion;


public class ControllerBusquedas implements Initializable {
		SingletonController control = SingletonController.getInstance();

	    @FXML
	    private ListView<Cancion> listViewY;
	
	    @FXML
	    private TextField txtNombre;
	
	    @FXML
	    private ListView<Cancion> listViewArtistas;
	
	    @FXML
	    private TextField txtO1;
	
	    @FXML
	    private TextField txtAnio;
	
	    @FXML
	    private TextField txtO;
	
	    @FXML
	    private ListView<Cancion> listViewO;
	
	    @FXML
	    private TextField txtArtistas;
	
	    @FXML
	    private TextField txtGenero;

	    @FXML
	    private TextField txtAlbum;
	    
	    @FXML
	    void busquedaO(ActionEvent event) {
	    		try {
					listViewO.getItems().setAll(control.busquedaO(txtNombre.getText(), txtAlbum.getText()));
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
	    	
	    }

	    @FXML
	    void busquedaY(ActionEvent event) {

	    	
	    }
	    
	    
	    @FXML
	    void buscarArtista(ActionEvent event) {

	    	
	    }
	    
	    private void cargarCancionesArtista(String nombre) {
	    	
	    	// no se ha hecho el metodo xdddddddddd
	    	
	    }
	    
	    
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// Carga la clase principal en el Singleton
			// No retorna la clase principal, solo actualiza
			// el valor de la clase (control.getDiscos) con el nuevo.
			try {control.cargarDIscosDonPepeBinario();} catch (IOException e) {
				e.printStackTrace();
			}
			
			// Cargamos nuevamente el control, pero ahora, con la clase principla
			// cargada,
			control = SingletonController.getInstance();	
			
			
		}
	    
	    
	    
}

	
