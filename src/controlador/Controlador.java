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
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class Controlador.
 */
public class Controlador {

    /** The resources. */
    @FXML
    private ResourceBundle resources;

    /** The location. */
    @FXML
    private URL location;

    /** The new game. */
    @FXML
    private Button newGame;

    /**
     * New game.
     *
     * @param event the event
     */
    @FXML
    void newGame(ActionEvent event) {
    	
    	
    	try {
    		
        	Parent loader = FXMLLoader.load(getClass().getResource("/vista/newWindow.fxml"));
    		Scene scene = new Scene(loader);
			Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow();
			
			stage.setScene(scene);
			stage.show(); //this line may be unnecessary since you are using the same stage.

			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        assert newGame != null : "fx:id=\"newGame\" was not injected: check your FXML file 'vista.fxml'.";

    }
}
