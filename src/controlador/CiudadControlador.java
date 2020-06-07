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
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import modelo.DatabaseOperaciones;
import modelo.Main_App;
import modelo.mensaje;
import modelo.entidades.criaturas.Criatura;
import modelo.entidades.criaturas.Golem;
import modelo.entidades.personajes.Personaje;
import utilidades.I18N;

public class CiudadControlador {

	@FXML
	private Pane imgCiudad;
	@FXML
	private Button dados;
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
	private Button verDados;
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
	private Pane panelDados;
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
	private Label nivelPj;
	@FXML
	private Label inteligenciaPJ;
	@FXML
	private Label lbl_textoDado;
	@FXML
	private Label lbl_textoTemplo;
	@FXML
	private Label lbl_storeText1;
	@FXML
	private Label lbl_storeText2;
	@FXML
	private Label lbl_textoDungeon;
	@FXML
	private Label lbl_nivel;
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
	private TextFlow mensajeVentana;

	private Personaje personaje;
	private String mercader = "imagenes/assets/mercader.png";
	private String entrenador = "imagenes/assets/";
	Image img;

	@FXML
	void initialize() {

		salir.textProperty().bind(I18N.createStringBinding("button.exit"));
		dados.textProperty().bind(I18N.createStringBinding("button.dado"));
		verDados.textProperty().bind(I18N.createStringBinding("button.verDado"));
		lbl_textoDado.textProperty().bind(I18N.createStringBinding("label.dadoText"));
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
		lbl_nivel.textProperty().bind(I18N.createStringBinding("label.nivel"));
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
			this.panelDados.setVisible(true);

			mostrarMensaje();
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
		System.out.println(this.personaje.getVidaMax());

		this.personaje.setVida(this.personaje.getVidaMax());

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

		this.panelDados.setVisible(true);

		img = new Image(this.personaje.getAspecto());
		this.showPersonaje.setImage(img);
	}

	@FXML
	void explorarMazmorra(ActionEvent event) throws IOException {

		Main_App.changeMusic(0);

		Main_App.showMazmorraView(this.personaje);
	}

	@FXML
	void cerrarJuego(ActionEvent event) throws IOException {

		Main_App.showCharactersView();
	}

	private void ocultarPaneles() {

		this.panelEntrenador.setVisible(false);
		this.panelMazmorras.setVisible(false);
		this.panelMercader.setVisible(false);
		this.panelDados.setVisible(false);
		this.paneMensaje.setVisible(false);

		if (this.personaje.getVida() <= 0) {

			this.explorar.setDisable(true);
			
		} else {

			this.explorar.setDisable(false);
		}
	}

	public void setPersonaje(Personaje p) {

		this.personaje = p;
	}

	public void setStats() {

		this.nivelPj.setText(Integer.toString(this.personaje.getNivel()));
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

	public void mostrarMensaje(int n) {
		if (!this.personaje.comprobarMensaje(n)) {
//			mensaje m1 = new mensaje();
//			paneMensaje.setVisible(true);
//			mensajeVentana.getChildren().add(m1.gestionarMensaje(n));
			DatabaseOperaciones.mensajeLeido(n);
			this.personaje.marcarLeido(n);
			Main_App main = new Main_App();

			main.abrirVentanaMensaje(n);
		}
	}
	
	public void mostrarMensaje() {
		if (this.personaje.getVida() <= 0) {
			mostrarMensajeSistema(2);
		}
		mostrarMensaje(1);
	}
	public void mostrarMensajeSistema(int n) {
		mensaje m1 = new mensaje();
		
		Main_App main = new Main_App();

		main.abrirVentanaMensaje(n);
		//paneMensaje.setVisible(true);
		//mensajeVentana.getChildren().add(m1.gestionarMensaje(n));
	}

	public void cerrarVentana(ActionEvent event) {
		paneMensaje.setVisible(false);
	}
}
