/*
 * 
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class NewWindowControlador.
 */
public class NewWindowControlador {

    /** The resources. */
    @FXML
    private ResourceBundle resources;

    /** The location. */
    @FXML
    private URL location;

    /** The new game. */
    @FXML
    private Button newGame;

    /** The back. */
    @FXML
    private Button back;

    /**
     * Go back.
     *
     * @param event the event
     */
    @FXML
    void goBack(ActionEvent event) {
    	
    	Stage stage = (Stage) this.back.getScene().getWindow();
    	stage.close();
    }

    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'newWindow.fxml'.";

    }
}
