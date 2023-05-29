package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Cancion;
import model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ControllerSeleccionarCancionUser implements Initializable {
	
	

	
	SingletonController control = SingletonController.getInstance();
	
	private ArrayList<Cancion> arrayCancionesSeleccionadas = new ArrayList<Cancion>();
	
    @FXML
    private Button btnIzquierda;

    @FXML
    private ListView<Cancion> ListViewCanciones;

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
    void Guardar(ActionEvent event) {  	
    	
        Stage stage = (Stage) this.guardar.getScene().getWindow();
        stage.close();
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
