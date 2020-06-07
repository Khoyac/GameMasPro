package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import modelo.Main_App;
import utilidades.I18N;

public class ConfiguracionControlador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button salir;

    @FXML
    private Button mute;

    @FXML
    private CheckBox chekanimaciones;

    @FXML
    private ColumnConstraints listLn;

    @FXML
    private Label lblingles;

    @FXML
    private Label lblcaste;

    @FXML
    private Label lblln;


    @FXML
    void initialize() {
    	
    	lblingles.textProperty().bind(I18N.createStringBinding("ln.ing"));
    	lblcaste.textProperty().bind(I18N.createStringBinding("ln.cast"));
    	lblln.textProperty().bind(I18N.createStringBinding("lbl.ln"));
    	salir.textProperty().bind(I18N.createStringBinding("btn.salir"));
    	chekanimaciones.textProperty().bind(I18N.createStringBinding("check.anim"));
    	
    	
        assert salir != null : "fx:id=\"salir\" was not injected: check your FXML file 'configuracion.fxml'.";
        assert mute != null : "fx:id=\"mute\" was not injected: check your FXML file 'configuracion.fxml'.";
        assert chekanimaciones != null : "fx:id=\"chekanimaciones\" was not injected: check your FXML file 'configuracion.fxml'.";
        assert listLn != null : "fx:id=\"listLn\" was not injected: check your FXML file 'configuracion.fxml'.";
        assert lblingles != null : "fx:id=\"lblingles\" was not injected: check your FXML file 'configuracion.fxml'.";
        assert lblcaste != null : "fx:id=\"lblingles1\" was not injected: check your FXML file 'configuracion.fxml'.";

    }
    

    @FXML
    void idiomaIngles(MouseEvent event) {
    	Main_App.setIngles();
    }
    
    @FXML
    void idiomaCaste(MouseEvent event) {
    	Main_App.setCastellano();
    }

    @FXML
    void mute(ActionEvent event) {
    	Main_App.mutedMusica();
    }

    @FXML
    void salir(ActionEvent event) {
    	Main_App.cerrarVentana();
    }
}
