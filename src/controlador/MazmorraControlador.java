package controlador;

import java.awt.Event;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modelo.Casilla;
import modelo.Main_App;
import modelo.Mapa;
import modelo.Mazmorra;
import modelo.entidades.criaturas.Criatura;
import modelo.entidades.personajes.Personaje;

public class MazmorraControlador {

	@FXML
	private Button action1;
	@FXML
	private Button action2;
	@FXML
	private Button action3;
	@FXML
	private Button action4;
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
	private VBox panelCriatura;
	@FXML
	private Label vidaCriatura;
	@FXML
	private Label defensaCriatura;
	@FXML
	private Label danioCriatura;
	@FXML
	private Pane imagenMapa;
	@FXML
	private GridPane gridMovimiento;
	@FXML
	private ImageView mazmorraMap;
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

			comprobarPuertas(norte, sur, este, oeste);
			crearNinotet();

		});
	}

	@FXML
	void atacar(ActionEvent event) {

		this.personaje.atacar(this.criatura);
		this.vidaCriatura.setText(Integer.toString(this.criatura.getVida()));

		this.criatura.atacar(this.personaje);
		this.vidaPJ.setText(Integer.toString(this.personaje.getVida()));

		if (this.personaje.getVida() <= 0)
			huir(event);
	}

	@FXML
	void defender(ActionEvent event) {

	}

	@FXML
	void habilidad(ActionEvent event) {

	}

	@FXML
	void huir(ActionEvent event) {

		this.n.borrarMapa();
		try {

			Main_App.showCiudadView(this.personaje);

		} catch (IOException e) {
			// TODO Auto-generated catch block
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

	private void setMazmorra() {

//		ArrayList<Casilla> casillas = m.getListaCasillas();
//		ArrayList<Integer> ocupado = new ArrayList<Integer>();
//		Casilla cas;

		// imagenMapa.setStyle("-fx-background-image:
		// url(\"http://khoyac.es/JuegoMolon/img/"+m.getId()+".png \")");
		// imagenMapa.setStyle("-fx-background-size: cover");

//		for (int i = 0; i < casillas.size(); i++) {
//
//			cas = m.getCasilla(i);
//			String numColumna = Integer.toString(cas.getNumero()).substring(1, 2);
//			String numFila = Integer.toString(cas.getNumero() / 10);
//
//			cas.setId("casilla");
//			cas.setPrefHeight(50);
//			cas.setPrefWidth(50);
//
//			ocupado.add(cas.getNumero());
//
//			this.gridMovimiento.add(cas, Integer.parseInt(numColumna), Integer.parseInt(numFila));
//			
//			
//		}

//		for (int i = 0; i < 100; i++) {
//			
//			String numColumna = Integer.toString(i);
//			String numFila = Integer.toString(i);
//			
//			cas = new Casilla();
//			
//			cas.setId("casilla");
//			cas.setPrefHeight(50);
//			cas.setPrefWidth(50);
//			
//			if( !ocupado.contains( i )) {
//				
//				this.gridMovimiento.add(cas, Integer.parseInt(numColumna), Integer.parseInt(numFila));		
//
//			}
//			
//		}

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

		comprobarPuertas();
		crearNinotet();

	}

	private void crearNinotet() {
		Image image = new Image("http://khoyac.es/JuegoMolon/img/" + this.m.getId() + ".png");
		mazmorraMap.setImage(image);

		Image ninotet = new Image("/imagenes/assets/ninotet.png");

		listaImagenesCasillas.get(this.casillaActual.getNumero()).setImage(ninotet);
		listaImagenesCasillas.get(this.casillaActual.getNumero()).setVisible(true);

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

}
