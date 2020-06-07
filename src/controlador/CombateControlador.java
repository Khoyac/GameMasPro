package controlador;

import java.awt.Color;
import java.awt.ScrollPane;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import modelo.DatabaseOperaciones;
import modelo.Main_App;
import modelo.entidades.criaturas.Criatura;
import modelo.entidades.personajes.Personaje;

public class CombateControlador {

	@FXML
	private ImageView enemyDraw;
	@FXML
	private ImageView characterDraw;
	@FXML
	private ImageView fondoCombate;
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
	@FXML
	private AnchorPane panelCombate;
	private Personaje personaje;
	private Criatura criatura;
	@FXML
	private TextFlow logCombate;
//	
	private ArrayList<Image> fondos;
	@FXML
	private ScrollPane scrollText;

	@FXML
	void initialize() {

		setFondos();

		/*
		 * Ejecutar cosas en último lugar
		 * 
		 * Necesario para que la criatura pasada como parametro en Personaje.combatir()
		 * pueda ser procesada correctamente.
		 */

		Platform.runLater(() -> {
			//TODO Borrar cuando los botones hagan cosas
			this.action2.setDisable(true);
			this.action3.setDisable(true);
			
			this.vidaPersonaje.setText(Integer.toString(this.personaje.getVida()));
			this.vidaCriatura.setText(Integer.toString(this.criatura.getVida()));
			this.ataqueC.setText(Integer.toString(this.criatura.getDanio()));
			this.defensaC.setText(Integer.toString(this.criatura.getDefensa()));
			this.setPersonajes();
			this.actualizarVida();
		});
	}

	private void setFondos() {

		this.fondos = new ArrayList<Image>();
		Image image;

		for (int i = 1; i < 4; i++) {

			image = new Image("/imagenes/assets/combate" + i + ".png");
			this.fondos.add(image);
		}

		image = new Image("/imagenes/assets/combate4.jpg");
		this.fondos.add(image);

		Random r1 = new Random();

		this.fondoCombate.setImage(this.fondos.get(r1.nextInt(4)));
	}

	@FXML
	private void atacar(ActionEvent event) throws InterruptedException {

		atacaPj();

		if (this.criatura.getVida() > 0) {

			atacaCriatura();

		}

		this.actualizarVida();

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
		if (this.criatura.getVida() <= 0) {
			Main_App.restarMuerte();
			int exp = 5;
			DatabaseOperaciones.subirExperiencia(exp);
			this.personaje.recibirExperiencia(exp);
		}
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

	private void atacaPj() {
		int dmg = this.personaje.atacar(this.criatura);

		Text textPJ = new Text();
		textPJ.setStyle("-fx-fill: green");

		if (dmg > 0) {

			textPJ.setText(String.format("Has inflingido %d de daño a la criatura\n", dmg));

		} else {

			textPJ.setText("Has fallado\n");

		}

		this.logCombate.getChildren().add(textPJ);

		this.vidaCriatura.setText(Integer.toString(this.criatura.getVida()));

	}

	private void atacaCriatura() throws InterruptedException {

		int dmg = this.criatura.atacar(this.personaje);

		Text textCriatura = new Text();
		textCriatura.setStyle("-fx-fill: orange");

		if (dmg > 0) {

			textCriatura.setText(String.format("Has inflingido %d de daño a la criatura\n", dmg));

		} else {

			textCriatura.setText("La criatura ha fallado\n");

		}

		this.logCombate.getChildren().add(textCriatura);

		this.vidaPersonaje.setText(Integer.toString(this.personaje.getVida()));
	}

	private void actualizarVida() {

		this.progressPJ.setMaxWidth((this.personaje.getVida() * 264) / this.personaje.getVidaMax());
		this.progressCriatura.setMaxWidth((this.criatura.getVida() * 264) / this.criatura.getVidaMax());

	}

}
