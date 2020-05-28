package controlador;

import java.io.IOException;
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
	static int idMapa;
	Random r1;
	String nivelMapa;
	private int casillaActual;

	@FXML
	void initialize() {

		// Creo la ID del mapa, autoincremental
		crearNombreMapa();

		r1 = new Random();

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
			n = new Mapa(this.nivelMapa, Integer.toString(this.idMapa));

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

	private void crearNombreMapa() {
		idMapa++;
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
		
		Image image = new Image("http://khoyac.es/JuegoMolon/img/"+m.getId()+".png");
		mazmorraMap.setImage(image);
		
		
		//imagenMapa.setStyle("-fx-background-image: url(\"http://khoyac.es/JuegoMolon/img/"+m.getId()+".png \")");
		//imagenMapa.setStyle("-fx-background-size: cover");

		
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

}
