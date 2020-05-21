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
	@FXML private Button backToLogin;
	@FXML private ImageView creation;
	@FXML private Button character1;
	@FXML private Button borrarPersonaje;
	@FXML private Button character2;

	// Atributos locales
	private Personaje personaje;
	private ArrayList<Integer> stats;
	private ArrayList<Label> listaStats;

	@FXML
	void initialize() {

		visualizaPersonajes();

	}

	// Escogemos una raza y deshabilitamos las clases que no estén relacionadas
	public void setRace() {

		Image pj = null;
		String url = "/basico.png";

		rbguerrero.setDisable(true);
		rbmago.setDisable(true);
		rbasesino.setDisable(true);
		rbarquero.setDisable(true);
		rbchaman.setDisable(true);
		rbtanque.setDisable(true);

		if (rbhumano.isSelected()) {

			pj = new Image("/imagenes/humano" + url);

			rbguerrero.setDisable(false);
			rbmago.setDisable(false);
		}

		if (rbelfo.isSelected()) {

			pj = new Image("imagenes/elfo" + url);

			rbasesino.setDisable(false);
			rbarquero.setDisable(false);
		}

		if (rbogro.isSelected()) {

			pj = new Image("imagenes/orco" + url);

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

		stats = new ArrayList<Integer>();
		listaStats = new ArrayList<Label>();

		// Creamos una lista con los stats del personaje
		stats.add(personaje.getVida());
		stats.add(personaje.getDanio());
		stats.add(personaje.getDefensa());
		stats.add(personaje.getDestreza());
		stats.add(personaje.getInteligencia());
		stats.add(personaje.getNivel());

		// Almacenamos los Label en una lista
		listaStats.add(statVida);
		listaStats.add(statDanio);
		listaStats.add(statDefensa);
		listaStats.add(statHabilidad);
		listaStats.add(statDestreza);
		listaStats.add(statInteligencia);

		// Mostramos cada stat en su label correspondiente
		for (int i = 0; i < stats.size() - 1; i++) {

			this.listaStats.get(i).setText(Integer.toString(this.stats.get(i)));
		}
	}

	// Guardamos el nuevo personaje
	public void crearPersonaje(ActionEvent event) {

		DatabaseOperaciones.guardarPersonaje(stats, personaje);

		System.out.println(personaje.getClass().toString());

		compruebaPersonajes();
		visualizaPersonajes();
	}

	// Funcion para mostrar tu personaje actual (si tienes uno)
	private void visualizaPersonajes() {

		// Recogemos nuestro personaje y comprobamos su clase para mostrar una imagen u
		// otra.
		personaje = DatabaseOperaciones.getPersonaje();

		String clase = (personaje == null) ? null : personaje.getClass().toString().substring(24);
		String url = "/basico.png";

		if (clase != null) {

			if (clase.equals("Guerrero") || clase.equals("Mago")) {

				this.character1.setStyle(
						"-fx-background-image: url('imagenes/humano" + url + "'); " + "-fx-background-size: cover");
			}

			else if (clase.equals("Asesino") || clase.equals("Arquero")) {

				this.character1.setStyle(
						"-fx-background-image: url('imagenes/elfo" + url + "'); " + "-fx-background-size: cover");
			}

			else if (clase.equals("Chaman") || clase.equals("Tanke")) {

				this.character1.setStyle(
						"-fx-background-image: url('imagenes/orco" + url + "'); " + "-fx-background-size: cover");
			}
		}

		else {

			this.character1.setStyle("-fx-background-image: none')");
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
