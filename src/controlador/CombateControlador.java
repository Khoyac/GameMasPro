package controlador;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import modelo.Main_App;
import modelo.entidades.criaturas.Criatura;
import modelo.entidades.personajes.Personaje;

public class CombateControlador {

	@FXML
	private ImageView enemyDraw;
	@FXML
	private ImageView characterDraw;
	@FXML
	private Button action1;
	@FXML
	private Button action2;
	@FXML
	private Button action3;
	@FXML
	private Button action4;
	@FXML
	private Label vidaPersonaje;
	@FXML
	private Label vidaCriatura;
	@FXML
	private Label ataqueC;
	@FXML
	private Label defensaC;
	@FXML
	private Pane barraPJ;
	@FXML
	private Pane barraCriatura;
	@FXML
	private GridPane progressCriatura;
	@FXML
	private GridPane progressPJ;
	private AnchorPane panelCombate;
	private Personaje personaje;
	private Criatura criatura;
	private MazmorraControlador mazmorra;
	
	@FXML
	private TextArea logCombate;

	@FXML
	void initialize() {

		/*
		 * Ejecutar cosas en último lugar
		 * 
		 * Necesario para que la criatura pasada como parametro en Personaje.combatir()
		 * pueda ser procesada correctamente.
		 */

		Platform.runLater(() -> {

			this.vidaPersonaje.setText(Integer.toString(this.personaje.getVida()));
			this.vidaCriatura.setText(Integer.toString(this.criatura.getVida()));
			this.ataqueC.setText(Integer.toString(this.criatura.getDanio()));
			this.defensaC.setText(Integer.toString(this.criatura.getDefensa()));
			this.setPersonajes();
		});
	}

	@FXML
	private void atacar(ActionEvent event) {

		int dmg = this.personaje.atacar(this.criatura);

		if (dmg > 0) {

			this.progressCriatura.setMaxWidth((this.criatura.getVida() * 264) / this.criatura.getVidaMax());
		}

		dmg = this.criatura.atacar(this.personaje);

		if (dmg > 0) {

			this.progressPJ.setMaxWidth((this.personaje.getVida() * 264) / this.personaje.getVidaMax());
		}

		this.vidaCriatura.setText(Integer.toString(this.criatura.getVida()));
		this.vidaPersonaje.setText(Integer.toString(this.personaje.getVida()));
		
		this.logCombate.insertText(this.logCombate.getLength(), " "+ dmg);
		checkFinal();
	}

	@FXML
	private void defender(ActionEvent event) {

		checkFinal();
	}

	@FXML
	private void habilidad(ActionEvent event) {

		checkFinal();
	}

	@FXML
	private void huir(ActionEvent event) throws IOException {
		Main_App.cerrarVentana();
		Main_App.asignarMovimientos();
		Main_App.actualizarInfo(this.personaje);

	}

	private void setPersonajes() {

		// Capturamos la clase de nuestro personaje
		String clase = (this.personaje == null) ? null : personaje.getClass().getSimpleName();
		String url = this.personaje.getAspecto();
		Image pj;

		pj = new Image(url);
		this.characterDraw.setImage(pj);

		// Capturamos la clase del monstruo
		clase = (this.criatura == null) ? null : criatura.getClass().getSimpleName();

		// Aplicamos la imagen del monstruo

		url = "imagenes/assets/" + this.criatura.getTipo() + ".png";

		pj = new Image(url);
		this.enemyDraw.setImage(pj);
	}

	public void setCriatura(Criatura c) {

		this.criatura = c;
	}

	public void setPersonaje(Personaje p) {

		this.personaje = p;
	}

	private void checkFinal() {

		if (this.personaje.getVida() <= 0 || this.criatura.getVida() <= 0) {

			this.action1.setDisable(true);
			this.action2.setDisable(true);
			this.action3.setDisable(true);
			this.action4.setText("Salir");

		}

	}

	public void ocultarCombate() {

		this.panelCombate.setVisible(false);

	}

	public void mostrarCombate() {
		this.panelCombate.setVisible(true);

	}

	public void setMazmorra(MazmorraControlador mazmorra) {
		this.mazmorra = mazmorra;
	}

}
