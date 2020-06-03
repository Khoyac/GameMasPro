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

import controlador.CiudadControlador;
import controlador.CombateControlador;
import controlador.MazmorraControlador;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import modelo.entidades.criaturas.Criatura;
import modelo.entidades.personajes.Personaje;
import utilidades.I18N;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.fxml.FXMLLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
public class Main_App extends Application {

//	private static MediaPlayer player;
	private static String cssFile;

	private static FXMLLoader loader;
	private static Locale locale;
	private static Pane ventana;
	private static Scene scene;
	private static Stage primaryStage;
	private static ResourceBundle bundle;
	static MazmorraControlador ctrlMazmorra = null;

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

		cssFile = "/vista/generaPJ.css";

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

		cssFile = "/vista/combate.css";

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

		cssFile = "/vista/mazmorra.css";

		setStage("mazmorra", p, null);
	}

	public static void showCiudadView(Personaje p) throws IOException {

		loader = new FXMLLoader();
		loader.setLocation(Main_App.class.getResource("/vista/vistaCiudad.fxml"));

		cssFile = "/vista/ciudad.css";

		setStage("ciudad", p, null);
	}

	private static void setStage(String s, Personaje p, Criatura c) throws IOException {

		// I18N
		locale = new Locale("es");
		bundle = ResourceBundle.getBundle("strings", locale);
		
		try
		{
			Scanner scanner = new Scanner( new File("src/txt/conf.txt"));
				String linea = scanner.nextLine();
			
				switch (linea) {
				case "en":
					setIngles(); 
					break;
				default:
					break;
				}
			scanner.close();
		}
		catch (FileNotFoundException ex) {
			System.err.println("El fichero no existe. " + ex);
		}
		

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

		AudioClip audio = new AudioClip(getClass().getResource("/media/menu.mp3").toExternalForm());
		audio.setVolume(0.5f);
		audio.setCycleCount(AudioClip.INDEFINITE);
		audio.play();
	}

	public static void setCastellano() {

		I18N.setLocale(new Locale("es"));
		guardarIdioma("es");
	}

	public static void setIngles() {

		I18N.setLocale(new Locale("en"));
		guardarIdioma("en");
	}
	
	public static void guardarIdioma(String ln) {
		String fichero = "src/txt/conf.txt";
		try
		{
			PrintWriter pw = new PrintWriter(new File(fichero));
			pw.println(ln );
			pw.close();
		} catch (FileNotFoundException e) {
			System.err.println("Problemas al abrir el fichero");
		}
	}

}
