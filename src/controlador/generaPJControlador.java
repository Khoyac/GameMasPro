package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.personajes.Arquero;
import modelo.personajes.Asesino;
import modelo.personajes.Chaman;
import modelo.personajes.Guerrero;
import modelo.personajes.Mago;
import modelo.personajes.Personaje;
import modelo.personajes.Tanke;


public class generaPJControlador {

	@FXML private ResourceBundle resources;
	@FXML private URL location;
	@FXML private Label statVida;
	@FXML private Label statDanio;
	@FXML private Label statDefensa;
	@FXML private Label statHabilidad;
	@FXML private Label statDestreza;
	@FXML private Label statInteligencia;
	@FXML private RadioButton rbhumano;
	@FXML private ToggleGroup races;
	@FXML private RadioButton rbelfo;
	@FXML private RadioButton rbogro;
	@FXML private RadioButton rbguerrero;
	@FXML private ToggleGroup classes;
	@FXML private RadioButton rbmago;
	@FXML private RadioButton rbtanque;
	@FXML private RadioButton rbchaman;
	@FXML private RadioButton rbasesino;
	@FXML private RadioButton rbarquero;
	@FXML private Button crearPersonaje;
    @FXML private ImageView creation;
    @FXML private Button character1;
    @FXML private Button character2;

	// Variable sobre la que trabajamos
	public Personaje clase;
	
	
	// Escogemos una raza y deshabilitamos las clases que no estén relacionadas
	public void setRace() {
		
		Image pj = null;
		String url = "/0_Golem_Idle_000.png";
		
		rbguerrero.setDisable(true);
		rbmago.setDisable(true);
		rbasesino.setDisable(true);
		rbarquero.setDisable(true);
		rbchaman.setDisable(true);
		rbtanque.setDisable(true);

		if(rbhumano.isSelected()) {

			pj = new Image("/imagenes/humano" + url);
			
			rbguerrero.setDisable(false);
			rbmago.setDisable(false);
		}

		if(rbelfo.isSelected()) {

			pj = new Image("imagenes/elfo" + url);
			
			rbasesino.setDisable(false);
			rbarquero.setDisable(false);
		}

		if(rbogro.isSelected()) {

			pj = new Image("imagenes/orco" + url);
			
			rbchaman.setDisable(false);
			rbtanque.setDisable(false);
		}

		this.creation.setImage(pj);
	}
	
	
	// Escogemos una clase según la raza y muestra los stats base
	public void setClass() {

		if (rbguerrero.isSelected()) { clase = new Guerrero(); }
		
		else if (rbmago.isSelected()) { clase = new Mago(); }
			
		else if (rbasesino.isSelected()) { clase = new Asesino(); }
		
		else if (rbarquero.isSelected()) { clase = new Arquero(); }
		
		else if (rbchaman.isSelected()) { clase = new Chaman(); }
		
		else if (rbtanque.isSelected()) { clase = new Tanke(); }
		
		
		showStats(clase);
		crearPersonaje.setDisable(false);
	}

	// Método que muestra los stats
	public void showStats(Personaje clase) {

//		statVida.setText(Integer.toString(clase.getVida()));
//		statDanio.setText(Integer.toString(clase.getDanio()));
//		statDefensa.setText(Integer.toString(clase.getDefensa()));
//		statHabilidad.setText(Integer.toString(clase.getHabilidad()));
//		statDestreza.setText(Integer.toString(clase.getDestreza()));
//		statInteligencia.setText(Integer.toString(clase.getInteligencia()));
	}

	// Confirma que la clase escogida se ha aplicado
	public void crearPersonaje(ActionEvent event) {

		System.out.println(clase.getClass());
	}

}
