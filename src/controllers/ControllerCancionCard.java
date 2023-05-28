package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.Cancion;

public class ControllerCancionCard {

    @FXML
    private Label txtNombre;

    @FXML
    private Label txtAlbum;

    @FXML
    private ImageView imgCover;

    
    @FXML
    void test(ActionEvent event) {

    }
    
    
    public void setData(Cancion c) {
    	Image img = new Image("file:"+c.getURLAlbum());
    	imgCover.setImage(img);
    	txtNombre.setText(c.getNombreCancion());
    	txtAlbum.setText(c.getNombreAlbum());
    }

}
