package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class generaPJControlador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox Races;

    @FXML
    private Label raza;

    @FXML
    private Button btnHumano;

    @FXML
    private Button clase2;

    @FXML
    private Button clase1;

    @FXML
    private Button btnOgro;

    @FXML
    private Button btnPersonalizar;

    @FXML
    private HBox Menu;

    @FXML
    private Button btnCrear;

    @FXML
    private HBox ClasesHumano;

    @FXML
    private HBox ClasesElfo;

    @FXML
    private HBox ClasesOgro;

    @FXML
    private Button btnElfo;

    @FXML
    private Label clase;

    @FXML
    void showCreation(ActionEvent event) {

    	Races.setVisible(true);
    }

    @FXML
    void showCustom(ActionEvent event) {

    }

    @FXML
    void setRace(ActionEvent event) {

    	ClasesHumano.setVisible(true);
    }

    @FXML
    void setClass(ActionEvent event) {

    }

    
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
