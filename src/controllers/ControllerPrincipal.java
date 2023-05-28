package controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Cancion;

public class ControllerPrincipal implements Initializable{

	SingletonController control = SingletonController.getInstance();
	@FXML
	private Label lblBuscar;
    @FXML
    private HBox cardLayout;
	@FXML
	private Button btnCrudArtistas;

	@FXML
	private Button btnCrudCanciones;
    
    private ArrayList<Cancion> recientes;
     

    @FXML
    void ee8d8d(ActionEvent event) {

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
		
		recientes = control.getDiscos().getListaCanciones();
		
		
		for (Cancion c : recientes) {
			try {
				// Creamos un objeto FXMLLoader
				FXMLLoader fxmlLoader = new FXMLLoader();
				// Lo cargamos con el FXML de el cover art de las canciones
				fxmlLoader.setLocation(getClass().getResource("/view/CancionCard.fxml"));
				// Creamos un HBox con la informacion del fxmloader
				VBox cancionBox = fxmlLoader.load();
				// Creamos un controlador con la informacion del fxmloader que cargamos
				ControllerCancionCard controller = fxmlLoader.getController();
				// Cargamos el controlador con los datos de la cancion iterada.
				controller.setData(c);
				// Le agregamos el HBox recien creado al HBox que lo va a contener (cardLayout)
				cardLayout.getChildren().add(cancionBox);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@FXML
	public void crudCanciones() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Canciones.fxml"));

			Parent root = loader.load();

			ControllerCanciones controlador = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

			stage.setOnCloseRequest(e -> controlador.closeWindow());
			Stage myStage = (Stage) this.btnCrudCanciones.getScene().getWindow();
			myStage.close();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@FXML
	public void crudArtistas() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Artistas.fxml"));

			Parent root = loader.load();

			ControllerArtistas controlador = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

			stage.setOnCloseRequest(e -> controlador.closeWindow());
			Stage myStage = (Stage) this.btnCrudArtistas.getScene().getWindow();
			myStage.close();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@FXML
	public void buscar() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Busquedas.fxml"));

			Parent root = loader.load();

			ControllerBusquedas controlador = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

			stage.setOnCloseRequest(e -> controlador.closeWindow());
			Stage myStage = (Stage) this.lblBuscar.getScene().getWindow();
			myStage.close();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public void closeWindow(String recurso) {

	}
}
