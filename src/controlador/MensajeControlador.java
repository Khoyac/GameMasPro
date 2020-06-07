package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.TextFlow;
import modelo.Main_App;
import modelo.mensaje;

public class MensajeControlador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane paneMensaje;

    @FXML
    private Button btnCerrarVentana;

    @FXML
    private TextFlow mensajeVentana;

    @FXML
    void cerrarVentana(ActionEvent event) {
		Main_App.cerrarVentana();
    }

    @FXML
    void initialize() {
        assert paneMensaje != null : "fx:id=\"paneMensaje\" was not injected: check your FXML file 'vistaMensaje.fxml'.";
        assert btnCerrarVentana != null : "fx:id=\"btnCerrarVentana\" was not injected: check your FXML file 'vistaMensaje.fxml'.";
        assert mensajeVentana != null : "fx:id=\"mensajeVentana\" was not injected: check your FXML file 'vistaMensaje.fxml'.";
        
        paneMensaje.setBackground(Background.EMPTY);
    }
    

	public void mostrarMensaje(int n) {
		mensaje m1 = new mensaje();
		paneMensaje.setVisible(true);
		mensajeVentana.getChildren().add(m1.gestionarMensaje(n));
		
	}
    
    
}
