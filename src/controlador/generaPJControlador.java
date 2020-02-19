package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import modelo.Login;
import modelo.Personajes.Arquero;
import modelo.Personajes.Asesino;
import modelo.Personajes.Chaman;
import modelo.Personajes.Guerrero;
import modelo.Personajes.Mago;
import modelo.Personajes.Personaje;
import modelo.Personajes.Tanke;


public class generaPJControlador {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label statVida;

	@FXML
	private Label statDanio;

	@FXML
	private Label statDefensa;

	@FXML
	private Label statHabilidad;

	@FXML
	private Label statDestreza;

	@FXML
	private Label statInteligencia;

	@FXML
	private RadioButton rbhumano;

	@FXML
	private ToggleGroup races;

	@FXML
	private RadioButton rbelfo;

	@FXML
	private RadioButton rbogro;

	@FXML
	private RadioButton rbguerrero;

	@FXML
	private ToggleGroup classes;

	@FXML
	private RadioButton rbmago;

	@FXML
	private RadioButton rbtanque;

	@FXML
	private RadioButton rbchaman;

	@FXML
	private RadioButton rbasesino;

	@FXML
	private RadioButton rbarquero;

	@FXML
	private Button crearPersonaje;

	// Variable sobre la que trabajamos
	public Personaje clase;
	
	
	// Escogemos una raza y deshabilitamos las clases que no estén relacionadas
	public void setRace() {
		
		rbguerrero.setDisable(true);
		rbmago.setDisable(true);
		rbasesino.setDisable(true);
		rbarquero.setDisable(true);
		rbchaman.setDisable(true);
		rbtanque.setDisable(true);

		if(rbhumano.isSelected()) {

			rbguerrero.setDisable(false);
			rbmago.setDisable(false);
		}

		if(rbelfo.isSelected()) {

			rbasesino.setDisable(false);
			rbarquero.setDisable(false);
		}

		if(rbogro.isSelected()) {
			
			rbchaman.setDisable(false);
			rbtanque.setDisable(false);
		}

		crearPersonaje.setDisable(false);
	}
	
	
	// Escogemos una clase según la raza y muestra los stats base
	public void setClass() {

		if (rbguerrero.isSelected()) {
			
			clase = new Guerrero();
			showStats(clase);
		}
		
		else if (rbmago.isSelected()) {
			
			clase = new Mago();
			showStats(clase);
		}
			
		else if (rbasesino.isSelected()) {
			
			clase = new Asesino();
			showStats(clase);
		}
		
		else if (rbarquero.isSelected()) {
			
			clase = new Arquero();
			showStats(clase);
		}
		
		else if (rbchaman.isSelected()) {
			
			clase = new Chaman();
			showStats(clase);
		}
		
		else if (rbtanque.isSelected()) {
			
			clase = new Tanke();
			showStats(clase);
		}
	}

	// Método que muestra los stats
	public void showStats(Personaje clase) {

		statVida.setText(Integer.toString(clase.getVida()));
		statDanio.setText(Integer.toString(clase.getDanio()));
		statDefensa.setText(Integer.toString(clase.getDefensa()));
		statHabilidad.setText(Integer.toString(clase.getHabilidad()));
		statDestreza.setText(Integer.toString(clase.getDestreza()));
		statInteligencia.setText(Integer.toString(clase.getInteligencia()));
	}

	// Confirma que la clase escogida se ha aplicado
	public void crearPersonaje(ActionEvent event) {

		System.out.println(clase.getClass());
	}

	@FXML
	void initialize() {
		assert rbhumano != null : "fx:id=\"rbhumano\" was not injected: check your FXML file 'generaPJ.fxml'.";
		assert races != null : "fx:id=\"Race\" was not injected: check your FXML file 'generaPJ.fxml'.";
		assert rbelfo != null : "fx:id=\"rbelfo\" was not injected: check your FXML file 'generaPJ.fxml'.";
		assert rbogro != null : "fx:id=\"rbogro\" was not injected: check your FXML file 'generaPJ.fxml'.";
		assert rbguerrero != null : "fx:id=\"rbguerrero\" was not injected: check your FXML file 'generaPJ.fxml'.";
		assert classes != null : "fx:id=\"Class\" was not injected: check your FXML file 'generaPJ.fxml'.";
		assert rbmago != null : "fx:id=\"rbmago\" was not injected: check your FXML file 'generaPJ.fxml'.";
		assert rbtanque != null : "fx:id=\"rbtanque\" was not injected: check your FXML file 'generaPJ.fxml'.";
		assert rbchaman != null : "fx:id=\"rbchaman\" was not injected: check your FXML file 'generaPJ.fxml'.";
		assert rbasesino != null : "fx:id=\"rbasesino\" was not injected: check your FXML file 'generaPJ.fxml'.";
		assert rbarquero != null : "fx:id=\"rbarquero\" was not injected: check your FXML file 'generaPJ.fxml'.";

	}
}
