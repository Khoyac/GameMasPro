/*
 * 
 */
package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import controlador.CiudadControlador;
import controlador.CombateControlador;
import controlador.MazmorraControlador;
import controlador.MensajeControlador;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.entidades.criaturas.Criatura;
import modelo.entidades.personajes.Personaje;
import utilidades.I18N;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;

/**
 * The Class Login.
 */
public class Main_App extends Application {

	private static AudioClip audio;
	private static AudioClip audio2;
	private static String cssFile;
	private static FXMLLoader loader;
	private static Locale locale;
	private static Pane ventana;
	private static Scene scene;
	private static Stage primaryStage;
	private static ResourceBundle bundle;
	static MazmorraControlador ctrlMazmorra = null;
	private static Stage newWindow = new Stage();

	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		musica();

		Main_App.primaryStage = primaryStage;

		showLoginView();

		newWindow.initStyle(StageStyle.UNDECORATED);
		newWindow.initOwner(primaryStage);
		newWindow.initModality(Modality.APPLICATION_MODAL);
		newWindow.initStyle(StageStyle.TRANSPARENT);
		newWindow.setTitle("Configuracion");


		// Nombre n1 = new Nombre();

		// System.out.println(n1.getNombre("ent", 2));
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Stage to log in or register
	 * 
	 * @throws IOException
	 */

	public static void showLoginView() throws IOException {

		loader = new FXMLLoader();
		loader.setLocation(Main_App.class.getResource("/vista/login.fxml"));

		cssFile = "/vista/main.css";

		setStage(null, null, null);
	}

	/**
	 * Stage to create your character and play
	 * 
	 * @throws IOException
	 */
	public static void showCharactersView() throws IOException {

		loader = new FXMLLoader();
		loader.setLocation(Main_App.class.getResource("/vista/generaPJ.fxml"));

//		cssFile = "/vista/generaPJ.css";

		setStage(null, null, null);
	}

	/**
	 * Stage for fights
	 * 
	 * @param p Player character
	 * @param c Creature to defeat
	 * 
	 * @throws IOException
	 */

	public static void showCombateView(Personaje p, Criatura c) throws IOException {

		loader = new FXMLLoader();
		loader.setLocation(Main_App.class.getResource("/vista/combate.fxml"));

//		cssFile = "/vista/combate.css";

		setStage("combate", p, c);
	}

	/**
	 * Stage for Dungeons
	 * 
	 * @throws IOException
	 */

	public static void showMazmorraView(Personaje p) throws IOException {

		loader = new FXMLLoader();
		loader.setLocation(Main_App.class.getResource("/vista/mazmorra.fxml"));

//		cssFile = "/vista/mazmorra.css";

		setStage("mazmorra", p, null);
	}

	public static void showCiudadView(Personaje p) throws IOException {

		loader = new FXMLLoader();
		loader.setLocation(Main_App.class.getResource("/vista/vistaCiudad.fxml"));

//		cssFile = "/vista/ciudad.css";

		setStage("ciudad", p, null);
	}

	public static void setStage(String s, Personaje p, Criatura c) throws IOException {

		Configuracion C1 = new Configuracion();
		setIdioma();

		loader.setResources(bundle);

		// Cargo la ventana
		ventana = (Pane) loader.load();

		if (s != null) {

			switch (s) {
			case "combate":

				// Pasamos la criatura enemiga al controlador
				CombateControlador ctrlCombate = loader.<CombateControlador>getController();
				ctrlCombate.setPersonaje(p);
				ctrlCombate.setCriatura(c);

				break;

			case "mazmorra":

				// Pasamos la criatura enemiga al controlador
				ctrlMazmorra = loader.<MazmorraControlador>getController();
				ctrlMazmorra.setPersonaje(p);

				break;

			case "ciudad":

				// Pasamos la criatura enemiga al controlador
				CiudadControlador ctrlCiudad = loader.<CiudadControlador>getController();
				ctrlCiudad.setPersonaje(p);

				break;

			default:
				break;
			}
		}

		// Cargo el scene
		scene = new Scene(ventana);
		scene.getStylesheets().add(cssFile);

		// Seteo la scene y la muestro
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				String file = loader.getLocation().getFile();
				String[] actualFileArray = new String[9];
				actualFileArray = file.split("/");

				String actualFile = actualFileArray[actualFileArray.length - 1];

				if (actualFile.equals("mazmorra.fxml")) {

					switch (event.getCode()) {
					case UP:
					case W:
						ctrlMazmorra.moverNorte();
						break;
					case DOWN:
					case S:
						ctrlMazmorra.moverSur();
						break;
					case LEFT:
					case A:
						ctrlMazmorra.moverOeste();
						break;
					case RIGHT:
					case D:
						ctrlMazmorra.moverEste();
						break;
					default:
						break;
					}
				}
			}
		});

	}

	private void musica() {

		audio = new AudioClip(getClass().getResource("/media/menu.mp3").toExternalForm());
		audio2 = new AudioClip(getClass().getResource("/media/mazmorra.mp3").toExternalForm());
		audio.setCycleCount(AudioClip.INDEFINITE);
		audio2.setCycleCount(AudioClip.INDEFINITE);
		audio.setVolume(0.5f);
		audio2.setVolume(0.5f);
		audio.play();
	}

	public static void setCastellano() {

		I18N.setLocale(new Locale("es"));
		Configuracion.cambiarConfiguracion("ln", "es");
	}

	public static void setIngles() {

		I18N.setLocale(new Locale("en"));
		Configuracion.cambiarConfiguracion("ln", "en");
	}

	public void abrirVentanaCombate(Personaje pj1, Criatura c1) throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/vista/combate.fxml"));
//		cssFile = "/vista/combate.css";

		Pane panel = (Pane) loader.load();
		CombateControlador ctrlCombate = loader.<CombateControlador>getController();
		ctrlCombate.setPersonaje(pj1);
		ctrlCombate.setCriatura(c1);
		Scene escenaCustom = new Scene(panel);

		newWindow.setTitle("Combate");
		newWindow.setScene(escenaCustom);

		// Set position of second window, related to primary window.
		newWindow.setX(primaryStage.getX() + 3);
		newWindow.setY(primaryStage.getY() + 26);

		// newWindow.show();

		newWindow.showAndWait();

	}

	public void abrirVentanaMensaje(int n) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/vista/vistaMensaje.fxml"));
//		cssFile = "/vista/combate.css";

		Pane panel;
		try {
			panel = (Pane) loader.load();
			Scene escenaCustom = new Scene(panel);

			panel.setBackground(Background.EMPTY);
			escenaCustom.setFill(Color.TRANSPARENT);
			newWindow.setScene(escenaCustom);

			MensajeControlador ctrlMensaje = loader.<MensajeControlador>getController();
			ctrlMensaje.mostrarMensaje(n);
			// Set position of second window, related to primary window.
			newWindow.setX(primaryStage.getX() + 250);
			newWindow.setY(primaryStage.getY() + 150);

			// newWindow.show();

			newWindow.showAndWait();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	public void abrirVentanaConfiguracion() {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/vista/config.fxml"));
		cssFile = "/vista/main.css";
		
		Pane panel;
		try {
			panel = (Pane) loader.load();
			Scene escenaCustom = new Scene(panel);
			
			panel.setBackground(Background.EMPTY);
			escenaCustom.setFill(Color.TRANSPARENT);
			newWindow.setScene(escenaCustom);
			
			// Set position of second window, related to primary window.
			newWindow.setX(primaryStage.getX() + 150);
			newWindow.setY(primaryStage.getY() + 150);
			
			// newWindow.show();
			
			newWindow.showAndWait();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

//####################### SAMPLE PARA HACER INVISIBLE FONDOS ##############	
//	Scene scene = new Scene(ap,500,500);
//	scene.setFill(Color.TRANSPARENT);
//	ap.setBackground(Background.EMPTY);
//	primaryStage.initStyle(StageStyle.TRANSPARENT);
//	primaryStage.setScene(scene);

	public static void cerrarVentana() {

		newWindow.close();

	}

	public static void asignarMovimientos() {

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				String file = loader.getLocation().getFile();
				String[] actualFileArray = new String[9];
				actualFileArray = file.split("/");

				String actualFile = actualFileArray[actualFileArray.length - 1];

				if (actualFile.equals("mazmorra.fxml")) {

					switch (event.getCode()) {
					case UP:
					case W:
						ctrlMazmorra.moverNorte();
						break;
					case DOWN:
					case S:
						ctrlMazmorra.moverSur();
						break;
					case LEFT:
					case A:
						ctrlMazmorra.moverOeste();
						break;
					case RIGHT:
					case D:
						ctrlMazmorra.moverEste();
						break;
					default:
						break;
					}
				}
			}
		});

	}

	public static void actualizarInfo(Personaje pj1) {
		ctrlMazmorra.setPersonaje(pj1);
		ctrlMazmorra.setStats();
		ctrlMazmorra.ocultarPaneles();
		ctrlMazmorra.mostrarInfoCasilla();
		ctrlMazmorra.checkMuertes();
	}

	public static void restarMuerte() {

		ctrlMazmorra.getCasillaActual().setRequisitoMuertes(ctrlMazmorra.getCasillaActual().getRequisitoMuertes() - 1);

	}

	public static void setIdioma() {
		// I18N
		locale = new Locale("es");
		bundle = ResourceBundle.getBundle("strings", locale);

		String ln = Configuracion.getConfig().get("ln");
		switch (ln) {
		case "en":
			setIngles();
			break;
		default:
			break;
		}
	}
	
	public static void mutedMusica() {
		audio2.stop();
	}

	public static void changeMusic(int x) {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				if (x == 0) {

					audio2.play();

					try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}

					audio.stop();
				}

				else if (x == 1) {

					audio.play();

					try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}

					audio2.stop();
				}

			}
		});

		t.start();

	}

}
