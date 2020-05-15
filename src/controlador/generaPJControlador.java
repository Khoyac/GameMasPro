package controlador;

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
	private Personaje personaje;


	private ArrayList<Integer> stats;
	private ArrayList<Label> listaStats;
	
	@FXML
	void initialize(){

		visualizaPersonajes();
		
	}


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


		if (rbguerrero.isSelected()) { personaje = new Guerrero(); }

		else if (rbmago.isSelected()) { personaje = new Mago(); }

		else if (rbasesino.isSelected()) { personaje = new Asesino(); }

		else if (rbarquero.isSelected()) { personaje = new Arquero(); }

		else if (rbchaman.isSelected()) { personaje = new Chaman(); }

		else if (rbtanque.isSelected()) { personaje = new Tanke(); }

		setStats(personaje);

		if( !DatabaseOperaciones.compruebaPersonajes() ) {

			crearPersonaje.setDisable(false);
		}

		else { crearPersonaje.setDisable(true); }
	}

	private void setStats(Personaje personaje) {
		
		stats = new ArrayList<Integer>();
		listaStats = new ArrayList<Label>();

		// Creamos una lista con los stats del personaje
		stats.add(personaje.getVida());
		stats.add(personaje.getDanio());
		stats.add(personaje.getDefensa());
		stats.add(personaje.getHabilidad());
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

			this.listaStats.get(i).setText( Integer.toString(this.stats.get(i)) );
		}
	}


	// Confirma que la clase escogida se ha aplicado
	public void crearPersonaje(ActionEvent event) {

		DatabaseOperaciones.guardarPersonaje(stats, personaje);

		System.out.println(personaje.getClass().toString());
	}


	private void visualizaPersonajes() {
		

		String p = DatabaseOperaciones.getPersonaje();
		
		System.out.println(p);
		
		String url = "/0_Golem_Idle_000.png";
		
		if(p.equals("Guerrero") || p.equals("Mago")) {

			this.character1.setStyle("-fx-background-image: url('imagenes/humano" + url + "')");
		}
		
		else if(p.equals("Asesiono") || p.equals("Arquero")) {

			this.character1.setStyle("-fx-background-image: url('imagenes/elfo" + url + "')");
		}
		
		else if(p.equals("Chaman") || p.equals("Tanke")) {

			this.character1.setStyle("-fx-background-image: url('imagenes/orco" + url + "')");
		}
	}

}
