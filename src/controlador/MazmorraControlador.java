package controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.Main_App;
import modelo.entidades.criaturas.Criatura;
import modelo.entidades.personajes.Personaje;
import modelo.escenarios.Casilla;
import modelo.escenarios.Mapa;
import modelo.escenarios.Mazmorra;

public class MazmorraControlador {
	@FXML
	private Button huir;
	@FXML
	private Button combatir;
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
	private VBox infoCasilla;
	@FXML
	private VBox panelCriatura;
	@FXML
	private VBox panelCofre;
	@FXML
	private VBox panelLlave;
	@FXML
	private Pane barraCriatura;
	@FXML
	private GridPane progressCriatura;
	@FXML
	private Label vidaCriatura;
	@FXML
	private Label defensaCriatura;
	@FXML
	private Label danioCriatura;
	@FXML
	private Label extraCriatura;
	@FXML
	private Label extraCriaturaTexto;
	@FXML
	private Button abrirCofre;
	@FXML
	private Button cogerLlave;
	@FXML
	private Pane imagenMapa;
	@FXML
	private GridPane gridMovimiento;
	@FXML
	private ImageView mazmorraMap;
	@FXML
	private ImageView imgCriatura;
	@FXML
	private ImageView imgCofre;
	@FXML
	private ImageView imgLlave;
	@FXML
	private ImageView c91;
	@FXML
	private ImageView c2;
	@FXML
	private ImageView c3;
	@FXML
	private ImageView c4;
	@FXML
	private ImageView c5;
	@FXML
	private ImageView c6;
	@FXML
	private ImageView c7;
	@FXML
	private ImageView c8;
	@FXML
	private ImageView c9;
	@FXML
	private ImageView c10;
	@FXML
	private ImageView c12;
	@FXML
	private ImageView c11;
	@FXML
	private ImageView c13;
	@FXML
	private ImageView c14;
	@FXML
	private ImageView c15;
	@FXML
	private ImageView c16;
	@FXML
	private ImageView c17;
	@FXML
	private ImageView c18;
	@FXML
	private ImageView c19;
	@FXML
	private ImageView c20;
	@FXML
	private ImageView c21;
	@FXML
	private ImageView c22;
	@FXML
	private ImageView c23;
	@FXML
	private ImageView c24;
	@FXML
	private ImageView c25;
	@FXML
	private ImageView c26;
	@FXML
	private ImageView c27;
	@FXML
	private ImageView c28;
	@FXML
	private ImageView c29;
	@FXML
	private ImageView c30;
	@FXML
	private ImageView c32;
	@FXML
	private ImageView c31;
	@FXML
	private ImageView c81;
	@FXML
	private ImageView c71;
	@FXML
	private ImageView c61;
	@FXML
	private ImageView c51;
	@FXML
	private ImageView c44;
	@FXML
	private ImageView c43;
	@FXML
	private ImageView c42;
	@FXML
	private ImageView c41;
	@FXML
	private ImageView c33;
	@FXML
	private ImageView c75;
	@FXML
	private ImageView c65;
	@FXML
	private ImageView c54;
	@FXML
	private ImageView c64;
	@FXML
	private ImageView c74;
	@FXML
	private ImageView c84;
	@FXML
	private ImageView c83;
	@FXML
	private ImageView c73;
	@FXML
	private ImageView c63;
	@FXML
	private ImageView c53;
	@FXML
	private ImageView c82;
	@FXML
	private ImageView c72;
	@FXML
	private ImageView c62;
	@FXML
	private ImageView c52;
	@FXML
	private ImageView c46;
	@FXML
	private ImageView c45;
	@FXML
	private ImageView c55;
	@FXML
	private ImageView c35;
	@FXML
	private ImageView c94;
	@FXML
	private ImageView c93;
	@FXML
	private ImageView c92;
	@FXML
	private ImageView c34;
	@FXML
	private ImageView c69;
	@FXML
	private ImageView c59;
	@FXML
	private ImageView c78;
	@FXML
	private ImageView c76;
	@FXML
	private ImageView c67;
	@FXML
	private ImageView c66;
	@FXML
	private ImageView c57;
	@FXML
	private ImageView c47;
	@FXML
	private ImageView c37;
	@FXML
	private ImageView c36;
	@FXML
	private ImageView c56;
	@FXML
	private ImageView c97;
	@FXML
	private ImageView c96;
	@FXML
	private ImageView c95;
	@FXML
	private ImageView c87;
	@FXML
	private ImageView c86;
	@FXML
	private ImageView c85;
	@FXML
	private ImageView c77;
	@FXML
	private ImageView c68;
	@FXML
	private ImageView c58;
	@FXML
	private ImageView c49;
	@FXML
	private ImageView c48;
	@FXML
	private ImageView c40;
	@FXML
	private ImageView c39;
	@FXML
	private ImageView c38;
	@FXML
	private ImageView c79;
	@FXML
	private ImageView c60;
	@FXML
	private ImageView c50;
	@FXML
	private ImageView c70;
	@FXML
	private ImageView c88;
	@FXML
	private ImageView c99;
	@FXML
	private ImageView c100;
	@FXML
	private ImageView c90;
	@FXML
	private ImageView c89;
	@FXML
	private ImageView c80;
	@FXML
	private ImageView c1;
	@FXML
	private ImageView c98;
	@FXML
	private ImageView este;
	@FXML
	private ImageView oeste;
	@FXML
	private ImageView sur;
	@FXML
	private ImageView norte;
	@FXML
	private ImageView imgDefensaPJ;
	@FXML
	private ImageView imgAtaquePJ;
	@FXML
	private ImageView imgInteligenciaPJ;
	@FXML
	private ImageView imgDestrezaPJ;
	@FXML
	private ImageView imgAtaqueCriatura;
	@FXML
	private ImageView imgDefensaCriatura;
	@FXML
	private ImageView imgExtraCriatura;
	@FXML
	private ImageView imgLlaveEncontrada;
	@FXML
	private HBox cosasEncontradas;

	ArrayList<listaContenidoCasillaController> listaLabels;
	@FXML
	listaContenidoCasillaController infoCasilla1Controller;
	@FXML
	listaContenidoCasillaController infoCasilla2Controller;
	@FXML
	listaContenidoCasillaController infoCasilla3Controller;
	@FXML
	listaContenidoCasillaController infoCasilla4Controller;
	@FXML
	listaContenidoCasillaController infoCasilla5Controller;
	@FXML
	listaContenidoCasillaController infoCasilla6Controller;
	@FXML
	listaContenidoCasillaController infoCasilla7Controller;
	@FXML
	listaContenidoCasillaController infoCasilla8Controller;
	private Personaje personaje;
	private Criatura criatura;
	Mapa n;
	Random r1;
	String nivelMapa;
	Date time;
	Casilla casillaActual;
	Mazmorra m;
	private ArrayList<ImageView> listaImagenesCasillas = new ArrayList<ImageView>();

	@FXML
	void initialize() {
		r1 = new Random();
		listaLabels = new ArrayList<listaContenidoCasillaController>();
		/*
		 * La ID del mapa sera el los milisegundos actuales + la zona horaria
		 */

		time = new Date();

		/*
		 * Ejecutar cosas en último lugar
		 * 
		 * Necesario para que la criatura pasada como parametro en Personaje.combatir()
		 * pueda ser procesada correctamente.
		 */

		Platform.runLater(() -> {
			this.rellenarArray();
			this.setStats();
			/*
			 * El nivel del mapa sera minimo del nivel del personaje, y aleatoriamente
			 * podria ser 1 o 2 niveles mayor que el
			 */
			// TODO Acordarnos de descomentar esta linea para que se generen del nivel del
			// PJ
//			this.nivelMapa = Integer.toString(this.personaje.getNivel() + r1.nextInt(3));
			this.nivelMapa = Integer.toString(50 + r1.nextInt(3));

			// Creo el mapa, parametros Nivel del mapa e ID.
			n = new Mapa(this.nivelMapa, cambiarFechaString(this.time));

			m = this.n.getMazmorra();
			this.casillaActual = this.n.getMazmorra().getListaCasillas().get(0);
			iniciarlizarLabels();
			comprobarPuertas(norte, sur, este, oeste);
			crearNinotet();
			resetLabels();
			asignarTooltips();
			mostrarInfoCasilla();
			ocultarPaneles();
			checkLabels();

		});
	}

	// TODO Borrar o implementar el ataque en esta escena

//	@FXML
//	void atacar(ActionEvent event) {
//
//		this.personaje.atacar(this.criatura);
//		this.vidaCriatura.setText(Integer.toString(this.criatura.getVida()));
//
//		this.criatura.atacar(this.personaje);
//		this.vidaPJ.setText(Integer.toString(this.personaje.getVida()));
//
//		if (this.personaje.getVida() <= 0)
//			huir(event);
//	}

	@FXML
	void huir(ActionEvent event) {

		this.n.borrarMapa();
		try {

			Main_App.showCiudadView(this.personaje);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setCriatura(Criatura c) {

		this.criatura = c;
	}

	public void setPersonaje(Personaje p) {

		this.personaje = p;
	}

	private void setStats() {

		this.vidaPJ.setText(Integer.toString(this.personaje.getVida()));
		this.defensaPJ.setText(Integer.toString(this.personaje.getDefensa()));
		this.danioPJ.setText(Integer.toString(this.personaje.getDanio()));
		this.destrezaPJ.setText(Integer.toString(this.personaje.getDestreza()));
		this.inteligenciaPJ.setText(Integer.toString(this.personaje.getInteligencia()));

	}

	public void comprobarPuertas() {
		comprobarPuertas(norte, sur, este, oeste);
	}

	public void comprobarPuertas(ImageView p1, ImageView p2, ImageView p3, ImageView p4) {

		if (this.casillaActual.isN()) {
			p1.setVisible(true);
		} else {
			p1.setVisible(false);

		}

		if (this.casillaActual.isS()) {
			p2.setVisible(true);
		} else {
			p2.setVisible(false);

		}

		if (this.casillaActual.isE()) {
			p3.setVisible(true);
		} else {
			p3.setVisible(false);

		}

		if (this.casillaActual.isO()) {
			p4.setVisible(true);
		} else {
			p4.setVisible(false);

		}

	}

	private String cambiarFechaString(Date fecha) {

		DateFormat dateFormat = new SimpleDateFormat("SZ");

		return dateFormat.format(fecha).replace("+", "");

	}

	private void rellenarArray() {
		listaImagenesCasillas.add(c1);
		listaImagenesCasillas.add(c1);
		listaImagenesCasillas.add(2, c2);
		listaImagenesCasillas.add(3, c3);
		listaImagenesCasillas.add(4, c4);
		listaImagenesCasillas.add(5, c5);
		listaImagenesCasillas.add(6, c6);
		listaImagenesCasillas.add(7, c7);
		listaImagenesCasillas.add(8, c8);
		listaImagenesCasillas.add(9, c9);
		listaImagenesCasillas.add(10, c10);
		listaImagenesCasillas.add(11, c11);
		listaImagenesCasillas.add(12, c12);
		listaImagenesCasillas.add(13, c13);
		listaImagenesCasillas.add(14, c14);
		listaImagenesCasillas.add(15, c15);
		listaImagenesCasillas.add(16, c16);
		listaImagenesCasillas.add(17, c17);
		listaImagenesCasillas.add(18, c18);
		listaImagenesCasillas.add(19, c19);
		listaImagenesCasillas.add(20, c20);
		listaImagenesCasillas.add(21, c21);
		listaImagenesCasillas.add(22, c22);
		listaImagenesCasillas.add(23, c23);
		listaImagenesCasillas.add(24, c24);
		listaImagenesCasillas.add(25, c25);
		listaImagenesCasillas.add(26, c26);
		listaImagenesCasillas.add(27, c27);
		listaImagenesCasillas.add(28, c28);
		listaImagenesCasillas.add(29, c29);
		listaImagenesCasillas.add(30, c30);
		listaImagenesCasillas.add(31, c31);
		listaImagenesCasillas.add(32, c32);
		listaImagenesCasillas.add(33, c33);
		listaImagenesCasillas.add(34, c34);
		listaImagenesCasillas.add(35, c35);
		listaImagenesCasillas.add(36, c36);
		listaImagenesCasillas.add(37, c37);
		listaImagenesCasillas.add(38, c38);
		listaImagenesCasillas.add(39, c39);
		listaImagenesCasillas.add(40, c40);
		listaImagenesCasillas.add(41, c41);
		listaImagenesCasillas.add(42, c42);
		listaImagenesCasillas.add(43, c43);
		listaImagenesCasillas.add(44, c44);
		listaImagenesCasillas.add(45, c45);
		listaImagenesCasillas.add(46, c46);
		listaImagenesCasillas.add(47, c47);
		listaImagenesCasillas.add(48, c48);
		listaImagenesCasillas.add(49, c49);
		listaImagenesCasillas.add(50, c50);
		listaImagenesCasillas.add(51, c51);
		listaImagenesCasillas.add(52, c52);
		listaImagenesCasillas.add(53, c53);
		listaImagenesCasillas.add(54, c54);
		listaImagenesCasillas.add(55, c55);
		listaImagenesCasillas.add(56, c56);
		listaImagenesCasillas.add(57, c57);
		listaImagenesCasillas.add(58, c58);
		listaImagenesCasillas.add(59, c59);
		listaImagenesCasillas.add(60, c60);
		listaImagenesCasillas.add(61, c61);
		listaImagenesCasillas.add(62, c62);
		listaImagenesCasillas.add(63, c63);
		listaImagenesCasillas.add(64, c64);
		listaImagenesCasillas.add(65, c65);
		listaImagenesCasillas.add(66, c66);
		listaImagenesCasillas.add(67, c67);
		listaImagenesCasillas.add(68, c68);
		listaImagenesCasillas.add(69, c69);
		listaImagenesCasillas.add(70, c70);
		listaImagenesCasillas.add(71, c71);
		listaImagenesCasillas.add(72, c72);
		listaImagenesCasillas.add(73, c73);
		listaImagenesCasillas.add(74, c74);
		listaImagenesCasillas.add(75, c75);
		listaImagenesCasillas.add(76, c76);
		listaImagenesCasillas.add(77, c77);
		listaImagenesCasillas.add(78, c78);
		listaImagenesCasillas.add(79, c79);
		listaImagenesCasillas.add(80, c80);
		listaImagenesCasillas.add(81, c81);
		listaImagenesCasillas.add(82, c82);
		listaImagenesCasillas.add(83, c83);
		listaImagenesCasillas.add(84, c84);
		listaImagenesCasillas.add(85, c85);
		listaImagenesCasillas.add(86, c86);
		listaImagenesCasillas.add(87, c87);
		listaImagenesCasillas.add(88, c88);
		listaImagenesCasillas.add(89, c89);
		listaImagenesCasillas.add(90, c90);
		listaImagenesCasillas.add(91, c91);
		listaImagenesCasillas.add(92, c92);
		listaImagenesCasillas.add(93, c93);
		listaImagenesCasillas.add(94, c94);
		listaImagenesCasillas.add(95, c95);
		listaImagenesCasillas.add(96, c96);
		listaImagenesCasillas.add(97, c97);
		listaImagenesCasillas.add(98, c98);
		listaImagenesCasillas.add(99, c99);
		listaImagenesCasillas.add(100, c100);
	}

	public void moverPersonaje(String direccion) {

		// TODO Preguntar a jose porque cojones no funciona con el SETnumero,
		// Cambia el numero de los dos objetos, this.casillaActual y la casilla a la que
		// se mueve.
		// Mirar linea comentada abajo

		int numeroCasilla = this.casillaActual.getNumero();

		borrarNinotet();

		switch (direccion) {
		case "arriba":
//			---> NO DESCOMENTAR <--- this.casillaActual.setNumero(numeroCasilla);
			numeroCasilla -= 10;
			break;
		case "abajo":
			numeroCasilla += 10;
			break;
		case "derecha":
			numeroCasilla += 1;
			break;
		case "izquierda":
			numeroCasilla -= 1;
			break;
		default:
			break;
		}

		this.casillaActual = this.m.getListaCasillas().get(this.m.getCasillaNumeroActual(numeroCasilla));

		this.panelCriatura.setVisible(false);

		if (this.casillaActual.isBoss()) {
			infoCasilla8Controller.setNumeroLabel(7);
		}
		if (this.casillaActual.isKey()) {
			infoCasilla8Controller.setNumeroLabel(8);
		}

		comprobarPuertas();
		crearNinotet();
		resetLabels();
		mostrarInfoCasilla();
		checkLabels();
		ocultarPaneles();
	}

	private void crearNinotet() {
		Image image = new Image("http://khoyac.es/JuegoMolon/img/" + this.m.getId() + ".png");
		mazmorraMap.setImage(image);

		Image ninotet = new Image("/imagenes/assets/ninotet.png");

		listaImagenesCasillas.get(this.casillaActual.getNumero()).setImage(ninotet);
		listaImagenesCasillas.get(this.casillaActual.getNumero()).setVisible(true);

	}

	public void mostrarInfoCasilla() {

		for (int i = 0; i < this.casillaActual.getCriaturas().size(); i++) {
			this.listaLabels.get(i).setLabelText(i);
			this.listaLabels.get(i).setLabelVisible();

		}

		if (this.casillaActual.getCofre() != null) {
			this.listaLabels.get(5).setLabelText(5);
			this.listaLabels.get(5).setLabelVisible();
			this.listaLabels.get(5).crearLabelCofre();
			// Estas lineas son lo que hace que aparezca la imagen de cofre.

//			this.listaLabels.get(5).setStyle("-fx-background-color: red");
//			this.listaLabels.get(5).setVisible(true);

		} else {

		}

		if (this.casillaActual.isMiniBoss()) {
			this.listaLabels.get(6).setLabelText(6);
			this.listaLabels.get(6).setLabelVisible();
		}

		if (this.casillaActual.isBoss()) {
			this.listaLabels.get(7).setLabelText(7);
			this.listaLabels.get(7).setLabelVisible();
		}
		if (this.casillaActual.isKey()) {
			this.listaLabels.get(7).setLabelText(8);
			this.listaLabels.get(7).setLabelVisible();

		}

	}

	public void mostrarInfoLabelExtendida(int numeroLabel) {

		ocultarPaneles();

		switch (numeroLabel) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			this.panelCriatura.setVisible(true);
			this.criatura = this.casillaActual.getCriaturas().get(numeroLabel);
			mostrarInfoCriatura(this.criatura);
			break;
		case 5:
			this.panelCofre.setVisible(true);
			mostrarInfoCofre();
			break;
		case 6:
			mostrarInfoMiniBoss();
			break;
		case 7:
			mostrarInfoBoss();
			break;
		case 8:
			this.panelLlave.setVisible(true);
			mostrarInfoLlave();
			break;

		default:
			break;
		}

	}

	private void mostrarInfoCriatura(Criatura criatura) {

		Image imgCriatura;

		// TODO o cambiar el como se llama al tipo (Ahora nombre) o cambiar los ifs para
		// usar este string o dejarlo tal cual, xD
		String tipo = criatura.getTipo();

		imgCriatura = new Image("/imagenes/assets/" + tipo + ".png");
		this.imgCriatura.setImage(imgCriatura);
		this.vidaCriatura.setText(Integer.toString(this.criatura.getVida()));
		this.defensaCriatura.setText(Integer.toString(this.criatura.getDefensa()));
		this.danioCriatura.setText(Integer.toString(this.criatura.getDanio()));

		this.extraCriaturaTexto.setVisible(true);
		this.extraCriatura.setVisible(true);
		this.imgExtraCriatura.setVisible(true);

		if (criatura.getTipo().equals("Ent")) {

			this.extraCriaturaTexto.setText("Inteligencia");
			Image img = new Image("/imagenes/assets/int.png");
			this.imgExtraCriatura.setImage(img);
			this.extraCriatura.setText(Integer.toString(criatura.getInteligencia()));
			Tooltip.install(this.imgExtraCriatura, this.crearTooltip("Inteligencia"));
			// this.extraCriaturaTexto.setVisible(true);
			// this.extraCriatura.setVisible(true);

		} else if (criatura.getTipo().equals("Trol")) {

			this.extraCriaturaTexto.setText("Destreza");
			Image img = new Image("/imagenes/assets/des.png");
			this.imgExtraCriatura.setImage(img);
			this.extraCriatura.setText(Integer.toString(criatura.getDestreza()));
			Tooltip.install(this.imgExtraCriatura, this.crearTooltip("Destreza"));

		} else {

			this.extraCriaturaTexto.setVisible(false);
			this.extraCriatura.setVisible(false);
			this.imgExtraCriatura.setVisible(false);

		}

	}

	private void mostrarInfoCofre() {
		Image cofre = new Image("/imagenes/assets/cofrelvl1.png");
		this.imgCofre.setImage(cofre);

	}

	private void mostrarInfoMiniBoss() {

	}

	private void mostrarInfoBoss() {

		// TODO Condicion para poder luchar contra el boss solo cuando tengas la llave

		if (this.m.isLlaveEncontrada()) {
			// activar boton, mostrar mensaje de conseguir llave
		} else {
			// Desactivar boton, mostrar info boss
		}

	}

	private void mostrarInfoLlave() {

//		Image llave = new Image("/imagenes/assets/loquesea.png");
		// TODO Descomentar y añadir imagen
//		this.imgLlave.setImage(llave);

	}

	@FXML
	private void llaveEncontrada() {
		this.m.setLlaveEncontrada(true);
		this.imgLlaveEncontrada.setVisible(true);
	}

	public void ocultarPaneles() {
		this.panelCriatura.setVisible(false);
		this.panelCofre.setVisible(false);
		this.panelLlave.setVisible(false);

	}

	public void resetLabels() {

		for (int i = 0; i < this.listaLabels.size(); i++) {

			this.listaLabels.get(i).setLabelInvisible();
			this.listaLabels.get(i).setCasillaActual(this.casillaActual);
		}

	}

	public void checkLabels() {

		for (int i = this.listaLabels.size() - 1; i >= 0; i--) {
			this.listaLabels.get(i).checkLabel();
		}

	}

	private void iniciarlizarLabels() {

		listaLabels.add(infoCasilla1Controller);
		listaLabels.add(infoCasilla2Controller);
		listaLabels.add(infoCasilla3Controller);
		listaLabels.add(infoCasilla4Controller);
		listaLabels.add(infoCasilla5Controller);
		listaLabels.add(infoCasilla6Controller);
		listaLabels.add(infoCasilla7Controller);
		listaLabels.add(infoCasilla8Controller);

		for (int i = 0; i < this.listaLabels.size(); i++) {

			this.listaLabels.get(i).setLabelActual(this, i);

			infoCasilla.getChildren().add(this.listaLabels.get(i));

		}

	}

	private void borrarNinotet() {

		listaImagenesCasillas.get(this.casillaActual.getNumero()).setVisible(false);

	}

	@FXML
	public void moverNorte() {

		if (norte.isVisible()) {

			moverPersonaje("arriba");
		}

	}

	@FXML
	void moverNorteOnClick(MouseEvent event) {

		moverNorte();
	}

	@FXML
	public void moverSur() {

		if (sur.isVisible()) {

			moverPersonaje("abajo");
		}

	}

	@FXML
	void moverSurOnClick(MouseEvent event) {

		moverSur();

	}

	@FXML
	public void moverEste() {

		if (este.isVisible()) {

			moverPersonaje("derecha");
		}

	}

	@FXML
	void moverEsteOnClick(MouseEvent event) {

		moverEste();

	}

	@FXML
	public void moverOeste() {

		if (oeste.isVisible()) {

			moverPersonaje("izquierda");
		}

	}

	@FXML
	void moverOesteOnClick(MouseEvent event) {

		moverOeste();

	}

	private void asignarTooltips() {

		Tooltip.install(this.imgAtaquePJ, this.crearTooltip("Ataque"));
		Tooltip.install(this.imgDefensaPJ, this.crearTooltip("Defensa"));
		Tooltip.install(this.imgInteligenciaPJ, this.crearTooltip("Inteligencia"));
		Tooltip.install(this.imgDestrezaPJ, this.crearTooltip("Destreza"));
		Tooltip.install(this.imgAtaqueCriatura, this.crearTooltip("Ataque"));
		Tooltip.install(this.imgDefensaCriatura, this.crearTooltip("Defensa"));

	}

	private Tooltip crearTooltip(String tooltip) {

		Tooltip mensaje = new Tooltip(tooltip);
		return mensaje;
	}

	@FXML
	private void generarCombate() throws IOException {

		Main_App.abrirVentanaCombate(this.personaje, this.criatura);

	}

}
