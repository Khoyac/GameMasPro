package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modelo.Main_App;
import modelo.entidades.criaturas.Basilisco;
import modelo.entidades.criaturas.Criatura;
import modelo.entidades.personajes.Personaje;

public class CiudadControlador {

	@FXML
	private Pane imgCiudad;
	@FXML
	private Button misiones;
	@FXML
	private Button tienda;
	@FXML
	private Button entrenar;
	@FXML
	private Button meditar;
	@FXML
	private Button mazmorras;
	@FXML
	private Button jugar;
	@FXML
	private Button explorar;
	@FXML
	private Button salir;
	@FXML
	private Pane panelEntrenador;
	@FXML
	private Pane panelMercader;
	@FXML
	private Pane panelMisiones;
	@FXML
	private Pane panelMazmorras;
	@FXML
	private ImageView showPersonaje;
	@FXML
	private Label vidaPJ;
	@FXML
	private Label healthAlert;
	@FXML
	private Label defensaPJ;
	@FXML
	private Label danioPJ;
	@FXML
	private Label destrezaPJ;
	@FXML
	private Label inteligenciaPJ;

	private Personaje personaje;
	private String mercader = "imagenes/assets/mercader.png";
	private String entrenador = "imagenes/assets/";
	Image img;

	@FXML
	void initialize() {
				
		
		Platform.runLater(() -> {

			img = new Image( this.personaje.getAspecto() );
			this.showPersonaje.setImage(img);

			setStats();


			ocultarPaneles();
			this.panelMisiones.setVisible(true);
		});
	}

	@FXML
	void comprarVender(ActionEvent event) {

		ocultarPaneles();

		this.panelMercader.setVisible(true);

		img = new Image(this.mercader);
		this.showPersonaje.setImage(img);
	}

	@FXML
	void entrenar(ActionEvent event) {

		ocultarPaneles();

		this.panelEntrenador.setVisible(true);

		String clase = personaje.getClass().getSimpleName();
		String e = "";
		
		if (clase.equals("Guerrero"))
			e = this.entrenador + "guerrero.png";
		
		else if (clase.equals("Mago"))
			e = this.entrenador + "mago.png";

		img = new Image(e);
		this.showPersonaje.setImage(img);
	}

	@FXML
	void restaurarSalud(ActionEvent event) {
		
		int actual = this.personaje.getVida();
		int max = this.personaje.getVidaMax();
		
		if(this.personaje.getVida() + 5 > this.personaje.getVidaMax()) {

			this.personaje.setVida( actual + (max - actual) );
		}
		
		else this.personaje.setVida( actual + 5);
		
		setStats();
		
	}

	@FXML
	void mazmorras(ActionEvent event) {

		ocultarPaneles();

		this.panelMazmorras.setVisible(true);

		img = new Image(this.personaje.getAspecto());
		this.showPersonaje.setImage(img);
	}

	@FXML
	void misiones(ActionEvent event) {

		ocultarPaneles();

		this.panelMisiones.setVisible(true);

		img = new Image(this.personaje.getAspecto());
		this.showPersonaje.setImage(img);
	}

	@FXML
	void luchar(ActionEvent event) throws IOException {

		Criatura c = new Basilisco();
		this.personaje.combatir(this.personaje, c);
	}

	@FXML
	void explorarMazmorra(ActionEvent event) throws IOException {

		Main_App.showMazmorraView( this.personaje );
	}

	@FXML
	void cerrarJuego(ActionEvent event) throws IOException {

		Main_App.showLoginView();
	}

	private void ocultarPaneles() {

		this.panelEntrenador.setVisible(false);
		this.panelMazmorras.setVisible(false);
		this.panelMercader.setVisible(false);
		this.panelMisiones.setVisible(false);
		
		if( this.healthAlert.isVisible() ) {
			
			this.jugar.setDisable(true);
			this.explorar.setDisable(true);
		}
		else {
			
			this.jugar.setDisable(false);
			this.explorar.setDisable(false);
		}
	}

	public void setPersonaje(Personaje p) {

		this.personaje = p;
	}
	
	public void setStats() {
		
		this.vidaPJ.setText(Integer.toString(this.personaje.getVida()));
		this.defensaPJ.setText(Integer.toString(this.personaje.getDefensa()));
		this.danioPJ.setText(Integer.toString(this.personaje.getDanio()));
		this.destrezaPJ.setText(Integer.toString(this.personaje.getDestreza()));
		this.inteligenciaPJ.setText(Integer.toString(this.personaje.getInteligencia()));
		
		if (Integer.parseInt( this.vidaPJ.getText() ) <= 1) this.healthAlert.setVisible(true);
		else this.healthAlert.setVisible(false);
	}
}
