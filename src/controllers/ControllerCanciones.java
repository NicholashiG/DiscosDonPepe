package controllers;

import java.io.File;
import java.io.FileNotFoundException;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Cancion;
import model.Generos;
import services.FilePicker;

import javax.swing.*;

public class ControllerCanciones implements Initializable {

    SingletonController control = SingletonController.getInstance();

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnLimpiar;

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

    // Ganoso de cambiar el ListView a una tableView para
    // tener cada dato de la cancion separados por columnas
    // en lugar de un solo String con toda la informacion.

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

    // Agregar Canciones.
    @FXML
    void nuevo(ActionEvent event) {
            if(validar()==true) {
                Cancion c = crearCancion();
                listViewCanciones.getItems().add(c);
                control.addCancion(c);
            }else {
                JOptionPane.showMessageDialog(null, "Hay campos sin rellenar o rellenados de forma incorrecta");
            }
    }
    @FXML
    void editar(ActionEvent event) {

            Cancion cSeleccionada = listViewCanciones.getSelectionModel().getSelectedItem();
            Cancion cNueva = crearCancion();
            control.replaceCancion(cSeleccionada.getCodigo(), cNueva);


            // reemplazar en la listView:

            for (Cancion cancion : listViewCanciones.getItems()) {
                if (cancion.getCodigo().equals(cSeleccionada.getCodigo()))
                    listViewCanciones.getItems().set(listViewCanciones.getItems().indexOf(cancion), cNueva);
            }
        }



    @FXML
    void eliminar(ActionEvent event) {

        Cancion c = listViewCanciones.getSelectionModel().getSelectedItem();
        listViewCanciones.getItems().remove(c);
        control.removeCancion(c);


    }

    @FXML
    void guardarCambios(ActionEvent event) {
        serializar();
        JOptionPane.showMessageDialog(null, "Guardado con exito");
    }


    public boolean validar(){
        if (txtNombreCancion.getText().isEmpty() == false &&
                txtNombreAlbum.getText().isEmpty() == false &&
                choiceGenero.getValue() != null &&
                isNumeric(txtAnio) == true &&
                isNumeric(txtDuracion) == true &&
                txtURLYT.getText().isEmpty() == false &&
                txtRutaArchivo.getText().isEmpty() == false) {
            return true;
        }else {
            return false;
        }


    }
    public boolean isNumeric(TextField textField) {
        String contenido = textField.getText();

        // Verificar si el contenido está vacío
        if (contenido.isEmpty()) {
            return false;
        }

        // Verificar si todos los caracteres son dígitos
        for (char c : contenido.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
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

            stage.setOnCloseRequest(e -> controlador.closeWindow("view/Canciones.fmxl"));
            Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void limpiar(ActionEvent event) {
        // Vacia los fields
        txtNombreCancion.setText("");
        txtNombreAlbum.setText("");
        txtRutaArchivo.setText("");
        txtAnio.setText("");
        txtDuracion.setText("");
        choiceGenero.setValue(null);
        txtURLYT.setText("");
    }


    @FXML
    void select(MouseEvent arg0) {
        // Esto verifica si la accion enviada es un doble click, en ese caso,
        // ejecuta.
        if (arg0.getButton().equals(MouseButton.PRIMARY) && arg0.getClickCount() == 2) {
            Cancion c = listViewCanciones.getSelectionModel().getSelectedItem();
            if (c != null) {
                txtNombreCancion.setText(c.getNombreCancion());
                txtNombreAlbum.setText(c.getNombreAlbum());
                txtRutaArchivo.setText(c.getURLAlbum());
                txtAnio.setText("" + c.getAnio());
                txtDuracion.setText("" + c.getDuracion());
                choiceGenero.setValue(c.getGenero());
                txtURLYT.setText(c.getURLYT());
            }

        }
    }


    @FXML
    // Ganoso de copiar las imagenes locales a el proyecto
    // para que se vean en cualquier pc.
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



    private Cancion crearCancion() {

        Double duracion;
        if (txtDuracion.getText().contains(":")) {
            String s[] = txtDuracion.getText().split(":");
            duracion = (Double.parseDouble(s[0]) * 60 + Double.parseDouble(s[1]));
        } else duracion = Double.parseDouble(txtDuracion.getText());

        Cancion c = new Cancion(txtNombreCancion.getText(),
                txtNombreAlbum.getText(),
                txtRutaArchivo.getText(),
                Integer.parseInt(txtAnio.getText()),
                duracion,
                choiceGenero.getValue(),
                txtURLYT.getText());
        return c;
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        // Carga la clase principal en el Singleton
        // No retorna la clase principal, solo actualiza
        // el valor de la clase (control.getDiscos) con el nuevo.
        try {
            control.cargarDIscosDonPepeBinario();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cargamos nuevamente el control, pero ahora, con la clase principla
        // cargada,
        control = SingletonController.getInstance();


        // Repopula la ListView con las canciones guardadas
        listViewCanciones.getItems().addAll(0, control.getDiscos().getListaCanciones());


        // Añade los elementos de las enumeraciones al choicebox
        for (Generos genero : Generos.values()) {
            choiceGenero.getItems().add(genero);
        }


        // Serializa todo Discos Don Pepe

        // Solo es util si esta ventana se acaba de abrir
        // de tal forma que al cerrarse la anterior y cargarse esta
        // se guardan los datos.

        // Buscar mejor solucion (e.g: Al cerrar la aplicacion)

        serializar();
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
