package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.DatabaseOperaciones;
import modelo.Main_App;
import modelo.criaturas.Basilisco;
import modelo.criaturas.Criatura;
import modelo.personajes.Arquero;
import modelo.personajes.Asesino;
import modelo.personajes.Chaman;
import modelo.personajes.Guerrero;
import modelo.personajes.Mago;
import modelo.personajes.Personaje;
import modelo.personajes.Tanke;

public class GeneraPJControlador {

	@FXML private ResourceBundle resources;
	@FXML private URL location;
	@FXML private Label statVida;
	@FXML private Label statDanio;
	@FXML private Label statDefensa;
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
	@FXML private Button backToLogin;
	@FXML private ImageView creation;
	@FXML private Button character1;
	@FXML private Button borrarPersonaje;
	@FXML private Button character2;
    @FXML private Button nextChar;
    @FXML private Button prevChar;

	// Atributos locales
	private Personaje personaje;
	private ArrayList<Long> stats;
	private ArrayList<Label> listaStats;
	private ArrayList<String> hum, elf, gol;
	private String url;
	private int count = 0;

	@FXML
	void initialize() {
		
		prevChar.setOnAction(e-> {
			
			if(this.count == 0) this.count = 2;
			else this.count--;
			
			setRace();
		});
		
        nextChar.setOnAction(e-> {
			
			if(this.count == 2) this.count = 0;
			else this.count++;
			
			setRace();
		});

		hum = new ArrayList<String>();
		elf = new ArrayList<String>();
		gol = new ArrayList<String>();
		
		rellenaArrays();
		
		visualizaPersonajes();

	}	
	
	private void rellenaArrays(){
		
		String tipo = "";
		
		for (int c = 0; c < 3; c++) {
			
			if (c == 0) tipo = "humano";
			else if (c == 1) tipo = "elfo";
			else if (c == 2) tipo = "golem";
			
			for (int j = 0; j < 3; j++) {
	
				url = "imagenes/" + tipo + "/" + tipo + (j + 1) + ".png";

				if (c == 0) this.hum.add(url);
				else if (c == 1) this.elf.add(url);
				else if (c == 2) this.gol.add(url);
			}
		}
		
	}
	

	// Escogemos una raza y deshabilitamos las clases que no estén relacionadas
	public void setRace() {

		Image pj = null;
		

		rbguerrero.setDisable(true);
		rbmago.setDisable(true);
		rbasesino.setDisable(true);
		rbarquero.setDisable(true);
		rbchaman.setDisable(true);
		rbtanque.setDisable(true);

		if (rbhumano.isSelected()) {

			this.url = hum.get(this.count);
			pj = new Image(url);
			

			rbguerrero.setDisable(false);
			rbmago.setDisable(false);
		}

		if (rbelfo.isSelected()) {

			this.url = elf.get(this.count);
			pj = new Image(url);

			rbasesino.setDisable(false);
			rbarquero.setDisable(false);
		}

		if (rbogro.isSelected()) {

			this.url = gol.get(this.count);
			pj = new Image(url);

			rbchaman.setDisable(false);
			rbtanque.setDisable(false);
		}

		this.creation.setImage(pj);
	}

	// Escogemos una clase según la raza
	public void setClass() {

		if (rbguerrero.isSelected()) {
			personaje = new Guerrero();
		}

		else if (rbmago.isSelected()) {
			personaje = new Mago();
		}

		else if (rbasesino.isSelected()) {
			personaje = new Asesino();
		}

		else if (rbarquero.isSelected()) {
			personaje = new Arquero();
		}

		else if (rbchaman.isSelected()) {
			personaje = new Chaman();
		}

		else if (rbtanque.isSelected()) {
			personaje = new Tanke();
		}

		setStats(personaje);
		compruebaPersonajes();
	}

	// Visualizar stats de nuevos personajes
	private void setStats(Personaje personaje) {

		stats = new ArrayList<Long>();
		listaStats = new ArrayList<Label>();

		// Creamos una lista con los stats del personaje
		stats.add((long)personaje.getVida());
		stats.add((long)personaje.getDanio());
		stats.add((long)personaje.getDefensa());
		stats.add((long)personaje.getDestreza());
		stats.add((long)personaje.getInteligencia());
		stats.add(personaje.getExp());
		stats.add(personaje.getExpNecesaria());
		stats.add((long)personaje.getNivel());

		// Almacenamos los Label en una lista
		listaStats.add(statVida);
		listaStats.add(statDanio);
		listaStats.add(statDefensa);
		listaStats.add(statDestreza);
		listaStats.add(statInteligencia);

		// Mostramos cada stat en su label correspondiente
		for (int i = 0; i < 5; i++) {

			this.listaStats.get(i).setText(Long.toString(this.stats.get(i)));
		}
	}

	// Guardamos el nuevo personaje
	public void crearPersonaje(ActionEvent event) {

		this.personaje.setAspecto(url);
		
		DatabaseOperaciones.guardarPersonaje(stats, personaje);

		compruebaPersonajes();
		visualizaPersonajes();
	}
	

	// Funcion para mostrar tu personaje actual (si tienes uno)
	private void visualizaPersonajes() {

		// Recogemos nuestro personaje y comprobamos su personaje para mostrar una imagen u
		// otra.
		this.personaje = DatabaseOperaciones.getPersonaje();

		String clase = (personaje == null) ? null : personaje.getClass().toString().substring(24);

		if (clase != null) {

			this.character1.setStyle( 
									  "visibility: visible;" + 
									  "-fx-background-image: url('" + this.personaje.getAspecto() + "'); " +
									  "-fx-background-size: cover;"
									);
			
		}

		else {

			this.character1.setStyle( "visibility: hidden;" );
		}
	}    
    

	// Lanzamos la comprobación de personajes
	private boolean compruebaPersonajes() {

		// Si el usuario ya tiene un personaje se bloquea la creación de estos
		if (DatabaseOperaciones.compruebaPersonajes()) {

			crearPersonaje.setDisable(true);
			return true;
		}

		else {

			crearPersonaje.setDisable(false);
			return false;
		}
	}

	@FXML
	private void jugar(ActionEvent event) throws IOException {

		Criatura c = new Basilisco();
		this.personaje.combatir(this.personaje, c);
		
	}

	// Eliminar personaje
	@FXML
	private void borrarPersonaje() {

		if (compruebaPersonajes()) {

			DatabaseOperaciones.borraPersonaje();
			visualizaPersonajes();
		}
	}

	// Volver a la ventana de login
	@FXML
	private void volverLogin(ActionEvent event) throws IOException {

		Main_App.showLoginView();
	}

}
