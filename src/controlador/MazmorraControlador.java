package controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.sun.prism.paint.Color;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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


	private Personaje personaje;
	private Criatura criatura;
	Mapa n;
	Random r1;
	String nivelMapa;
	Date time;
	private int casillaActual;

	@FXML
	void initialize() {

		// Creo la ID del mapa, autoincremental

		r1 = new Random();
		time = new Date();
		/*
		 * Ejecutar cosas en último lugar
		 * 
		 * Necesario para que la criatura pasada como parametro en Personaje.combatir()
		 * pueda ser procesada correctamente.
		 */

		Platform.runLater(() -> {

			this.setStats();

			// El nivel del mapa sera minimo del nivel del personaje, y aleatoriamente
			// podria ser 1 o 2 niveles mayor que el
//			this.nivelMapa = Integer.toString(this.personaje.getNivel() + r1.nextInt(3));
			this.nivelMapa = Integer.toString(50 + r1.nextInt(3));

			// Creo el mapa, parametros Nivel del mapa e ID.
			n = new Mapa(this.nivelMapa, cambiarFechaString(this.time));

			this.setMazmorra();

			this.casillaActual = this.n.getMazmorra().getInicio();

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

		Mazmorra m = this.n.getMazmorra();
		ArrayList<Casilla> casillas = m.getListaCasillas();
		ArrayList<Integer> ocupado = new ArrayList<Integer>();
		Casilla cas;

		Image image = new Image("http://khoyac.es/JuegoMolon/img/" + m.getId() + ".png");
		mazmorraMap.setImage(image);
		
		Image ninotet = new Image("/imagenes/assets/ninotet.png");
		
		ArrayList<ImageView> ListaCasillas = new ArrayList<ImageView>();
		
		ListaCasillas.add(c1);
		ListaCasillas.add(c1);
		ListaCasillas.add(2, c2);
		ListaCasillas.add(3, c3);
		ListaCasillas.add(4, c4);
		ListaCasillas.add(5, c5);
		ListaCasillas.add(6, c6);
		ListaCasillas.add(7, c7);
		ListaCasillas.add(8, c8);
		ListaCasillas.add(9, c9);
		ListaCasillas.add(10, c10);
		ListaCasillas.add(11, c11);
		ListaCasillas.add(12, c12);
		ListaCasillas.add(13, c13);
		ListaCasillas.add(14, c14);
		ListaCasillas.add(15, c15);
		ListaCasillas.add(16, c16);
		ListaCasillas.add(17, c17);
		ListaCasillas.add(18, c18);
		ListaCasillas.add(19, c19);
		ListaCasillas.add(20, c20);
		ListaCasillas.add(21, c21);
		ListaCasillas.add(22, c22);
		ListaCasillas.add(23, c23);
		ListaCasillas.add(24, c24);
		ListaCasillas.add(25, c25);
		ListaCasillas.add(26, c26);
		ListaCasillas.add(27, c27);
		ListaCasillas.add(28, c28);
		ListaCasillas.add(29, c29);
		ListaCasillas.add(30, c30);
		ListaCasillas.add(31, c31);
		ListaCasillas.add(32, c32);
		ListaCasillas.add(33, c33);
		ListaCasillas.add(34, c34);
		ListaCasillas.add(35, c35);
		ListaCasillas.add(36, c36);
		ListaCasillas.add(37, c37);
		ListaCasillas.add(38, c38);
		ListaCasillas.add(39, c39);
		ListaCasillas.add(40, c40);
		ListaCasillas.add(41, c41);
		ListaCasillas.add(42, c42);
		ListaCasillas.add(43, c43);
		ListaCasillas.add(44, c44);
		ListaCasillas.add(45, c45);
		ListaCasillas.add(46, c46);
		ListaCasillas.add(47, c47);
		ListaCasillas.add(48, c48);
		ListaCasillas.add(49, c49);
		ListaCasillas.add(50, c50);
		ListaCasillas.add(51, c51);
		ListaCasillas.add(52, c52);
		ListaCasillas.add(53, c53);
		ListaCasillas.add(54, c54);
		ListaCasillas.add(55, c55);
		ListaCasillas.add(56, c56);
		ListaCasillas.add(57, c57);
		ListaCasillas.add(58, c58);
		ListaCasillas.add(59, c59);
		ListaCasillas.add(60, c60);
		ListaCasillas.add(61, c61);
		ListaCasillas.add(62, c62);
		ListaCasillas.add(63, c63);
		ListaCasillas.add(64, c64);
		ListaCasillas.add(65, c65);
		ListaCasillas.add(66, c66);
		ListaCasillas.add(67, c67);
		ListaCasillas.add(68, c68);
		ListaCasillas.add(69, c69);
		ListaCasillas.add(70, c70);
		ListaCasillas.add(71, c71);
		ListaCasillas.add(72, c72);
		ListaCasillas.add(73, c73);
		ListaCasillas.add(74, c74);
		ListaCasillas.add(75, c75);
		ListaCasillas.add(76, c76);
		ListaCasillas.add(77, c77);
		ListaCasillas.add(78, c78);
		ListaCasillas.add(79, c79);
		ListaCasillas.add(80, c80);
		ListaCasillas.add(81, c81);
		ListaCasillas.add(82, c82);
		ListaCasillas.add(83, c83);
		ListaCasillas.add(84, c84);
		ListaCasillas.add(85, c85);
		ListaCasillas.add(86, c86);
		ListaCasillas.add(87, c87);
		ListaCasillas.add(88, c88);
		ListaCasillas.add(89, c89);
		ListaCasillas.add(90, c90);
		ListaCasillas.add(91, c91);
		ListaCasillas.add(92, c92);
		ListaCasillas.add(93, c93);
		ListaCasillas.add(94, c94);
		ListaCasillas.add(95, c95);
		ListaCasillas.add(96, c96);
		ListaCasillas.add(97, c97);
		ListaCasillas.add(98, c98);
		ListaCasillas.add(99, c99);
		ListaCasillas.add(100, c100);
		
		ListaCasillas.get(m.getInicio()).setImage(ninotet);
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

	public void comprobarPuertas(Button p1, Button p2, Button p3, Button p4) {

		if (this.n.getMazmorra().getCasilla(this.casillaActual).isN()) {
			p1.setVisible(true);
		} else {
			p1.setVisible(false);

		}

		if (this.n.getMazmorra().getCasilla(this.casillaActual).isS()) {
			p1.setVisible(true);
		} else {
			p1.setVisible(false);

		}

		if (this.n.getMazmorra().getCasilla(this.casillaActual).isE()) {
			p1.setVisible(true);
		} else {
			p1.setVisible(false);

		}

		if (this.n.getMazmorra().getCasilla(this.casillaActual).isO()) {
			p1.setVisible(true);
		} else {
			p1.setVisible(false);

		}

	}

	private String cambiarFechaString(Date fecha) {

		DateFormat dateFormat = new SimpleDateFormat("SZ");

		return dateFormat.format(fecha).replace("+", "");

	}

}
