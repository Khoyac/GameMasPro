/*
 * 
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

// TODO: Auto-generated Javadoc
/**
 * The Class generaPJControlador.
 */
public class generaPJControlador {

    /** The resources. */
    @FXML
    private ResourceBundle resources;

    /** The location. */
    @FXML
    private URL location;

    /** The Races. */
    @FXML
    private HBox Races;

    /** The raza. */
    @FXML
    private Label raza;

    /** The btn humano. */
    @FXML
    private Button btnHumano;

    /** The clase 2. */
    @FXML
    private Button clase2;

    /** The clase 1. */
    @FXML
    private Button clase1;

    /** The btn ogro. */
    @FXML
    private Button btnOgro;

    /** The btn personalizar. */
    @FXML
    private Button btnPersonalizar;

    /** The Menu. */
    @FXML
    private HBox Menu;

    /** The btn crear. */
    @FXML
    private Button btnCrear;

    /** The Clases humano. */
    @FXML
    private HBox ClasesHumano;

    /** The Clases elfo. */
    @FXML
    private HBox ClasesElfo;

    /** The Clases ogro. */
    @FXML
    private HBox ClasesOgro;

    /** The btn elfo. */
    @FXML
    private Button btnElfo;

    /** The clase. */
    @FXML
    private Label clase;

    /**
     * Show creation.
     *
     * @param event the event
     */
    @FXML
    void showCreation(ActionEvent event) {

    	Races.setVisible(true);
    }

    /**
     * Show custom.
     *
     * @param event the event
     */
    @FXML
    void showCustom(ActionEvent event) {

    }

    /**
     * Sets the race.
     *
     * @param event the new race
     */
    @FXML
    void setRace(ActionEvent event) {

    	ClasesHumano.setVisible(true);
    }

    /**
     * Sets the class.
     *
     * @param event the new class
     */
    @FXML
    void setClass(ActionEvent event) {

    }

    
    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        assert Races != null : "fx:id=\"Races\" was not injected: check your FXML file 'generaPJ.fxml'.";
        assert raza != null : "fx:id=\"raza\" was not injected: check your FXML file 'generaPJ.fxml'.";
        assert btnHumano != null : "fx:id=\"btnHumano\" was not injected: check your FXML file 'generaPJ.fxml'.";
        assert clase2 != null : "fx:id=\"clase2\" was not injected: check your FXML file 'generaPJ.fxml'.";
        assert clase1 != null : "fx:id=\"clase1\" was not injected: check your FXML file 'generaPJ.fxml'.";
        assert btnOgro != null : "fx:id=\"btnOgro\" was not injected: check your FXML file 'generaPJ.fxml'.";
        assert btnPersonalizar != null : "fx:id=\"btnPersonalizar\" was not injected: check your FXML file 'generaPJ.fxml'.";
        assert Menu != null : "fx:id=\"Menu\" was not injected: check your FXML file 'generaPJ.fxml'.";
        assert btnCrear != null : "fx:id=\"btnCrear\" was not injected: check your FXML file 'generaPJ.fxml'.";
        assert ClasesHumano != null : "fx:id=\"HumanClases\" was not injected: check your FXML file 'generaPJ.fxml'.";
        assert btnElfo != null : "fx:id=\"btnElfo\" was not injected: check your FXML file 'generaPJ.fxml'.";
        assert clase != null : "fx:id=\"clase\" was not injected: check your FXML file 'generaPJ.fxml'.";

    }
}
