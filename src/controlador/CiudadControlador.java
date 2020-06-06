package controlador;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import modelo.Main_App;
import modelo.entidades.criaturas.Criatura;
import modelo.entidades.criaturas.Golem;
import modelo.entidades.personajes.Personaje;
import utilidades.I18N;

public class CiudadControlador {

	@FXML
	private Pane imgCiudad;
	@FXML
	private Button misiones;
	@FXML
	private Button tienda;
	@FXML
	private Button comprar;
	@FXML
	private Button vender;
	@FXML
	private Button entrenar;
	@FXML
	private Button aprender;
	@FXML
	private Button meditar;
	@FXML
	private Button mazmorras;
	@FXML
	private Button jugarMision;
	@FXML
	private Button explorar;
	@FXML
	private Button salir;
	@FXML
	private Button btnCerrarVentana;
	@FXML
	private Pane panelEntrenador;
	@FXML
	private Pane panelMercader;
	@FXML
	private Pane panelMisiones;
	@FXML
	private Pane panelMazmorras;
	@FXML
	private Pane paneMensaje;
	@FXML
	private ImageView showPersonaje;
	@FXML
	private Label vidaPJ;
	@FXML
	private Label defensaPJ;
	@FXML
	private Label danioPJ;
	@FXML
	private Label destrezaPJ;
	@FXML
	private Label inteligenciaPJ;
	@FXML
	private Label lbl_textoMision;
	@FXML
	private Label lbl_textoTemplo;
	@FXML
	private Label lbl_storeText1;
	@FXML
	private Label lbl_storeText2;
	@FXML
	private Label lbl_textoDungeon;
	@FXML
	private Label lbl_hp;
	@FXML
	private Label lbl_dmg;
	@FXML
	private Label lbl_def;
	@FXML
	private Label lbl_skill;
	@FXML
	private Label lbl_iq;
	@FXML
	private Text mensajeVentana;

	private Personaje personaje;
	private String mercader = "imagenes/assets/mercader.png";
	private String entrenador = "imagenes/assets/";
	Image img;

	@FXML
	void initialize() {

		
		salir.textProperty().bind(I18N.createStringBinding("button.exit"));
		misiones.textProperty().bind(I18N.createStringBinding("button.mission"));
		jugarMision.textProperty().bind(I18N.createStringBinding("button.playMission"));
		lbl_textoMision.textProperty().bind(I18N.createStringBinding("label.missionText"));
		tienda.textProperty().bind(I18N.createStringBinding("button.store"));
		lbl_storeText1.textProperty().bind(I18N.createStringBinding("label.store1"));
		lbl_storeText2.textProperty().bind(I18N.createStringBinding("label.store2"));
		comprar.textProperty().bind(I18N.createStringBinding("button.buy"));
		vender.textProperty().bind(I18N.createStringBinding("button.sell"));
		lbl_textoTemplo.textProperty().bind(I18N.createStringBinding("label.templeText"));
		aprender.textProperty().bind(I18N.createStringBinding("button.aprender"));
		meditar.textProperty().bind(I18N.createStringBinding("button.meditar"));
		entrenar.textProperty().bind(I18N.createStringBinding("button.temple"));
		mazmorras.textProperty().bind(I18N.createStringBinding("button.dungeon"));
		lbl_textoDungeon.textProperty().bind(I18N.createStringBinding("label.dungeonText"));
		explorar.textProperty().bind(I18N.createStringBinding("button.exploreDungeon"));
		lbl_hp.textProperty().bind(I18N.createStringBinding("label.hp"));
		lbl_dmg.textProperty().bind(I18N.createStringBinding("label.dmg"));
		lbl_def.textProperty().bind(I18N.createStringBinding("label.def"));
		lbl_skill.textProperty().bind(I18N.createStringBinding("label.skill"));
		lbl_iq.textProperty().bind(I18N.createStringBinding("label.iq"));
		btnCerrarVentana.textProperty().bind(I18N.createStringBinding("btn.ventana"));

		Platform.runLater(() -> {

			img = new Image(this.personaje.getAspecto());
			this.showPersonaje.setImage(img);

			setStats();

			ocultarPaneles();
			this.panelMisiones.setVisible(true);
			System.out.println(this.personaje.getNivel());
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
		String e = this.entrenador;

		switch (clase) {
		case "Guerrero":

			e += "guerrero.png";
			break;

		case "Mago":

			e += "mago.png";
			break;

		case "Asesino":

			e += "asesino.png";
			break;

		case "Arquero":

			e += "arquera.png";
			break;

		case "Chaman":

			e += "chaman.png";
			break;

		case "Tanke":

			e += "tanke.png";
			break;

		default:
			break;
		}

		img = new Image(e);
		this.showPersonaje.setImage(img);
	}

	@FXML
	void restaurarSalud(ActionEvent event) {

		int actual = this.personaje.getVida();
		int max = this.personaje.getVidaMax();

		if (this.personaje.getVida() + 5 > this.personaje.getVidaMax()) {

			this.personaje.setVida(actual + (max - actual));
		}

		else
			this.personaje.setVida(actual + 5);

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

		Criatura c = new Golem();
		this.personaje.combatir(this.personaje, c);
	}

	@FXML
	void explorarMazmorra(ActionEvent event) throws IOException {

		Main_App.showMazmorraView(this.personaje);
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

		if (this.personaje.getVida() <= 0) {

			this.jugarMision.setDisable(true);
			this.explorar.setDisable(true);
		} else {

			this.jugarMision.setDisable(false);
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

		if (Integer.parseInt(this.vidaPJ.getText()) <= 1) {

		}

		else {

		}
	}

	public void cerrarVentana(ActionEvent event) {
		paneMensaje.setVisible(false);
	}
}
