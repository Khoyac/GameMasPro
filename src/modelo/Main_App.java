/*
 * 
 */
package modelo;

import java.io.IOException;
import java.nio.file.Paths;

import controlador.CiudadControlador;
import controlador.CombateControlador;
import controlador.MazmorraControlador;
import javafx.application.Application;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.Undefined;
import modelo.entidades.criaturas.Criatura;
import modelo.entidades.personajes.Personaje;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXMLLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
public class Main_App extends Application {

	MediaPlayer player;

	private static Stage primaryStage;

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

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_App.class.getResource("/vista/login.fxml"));
		// Cargo la ventana
		Pane ventana = (Pane) loader.load();

		// Cargo el scene
		Scene scene = new Scene(ventana);
		scene.getStylesheets().add("/vista/main.css");

		// Seteo la scene y la muestro
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Stage to create your character and play
	 * 
	 * @throws IOException
	 */
	public static void showCharactersView() throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_App.class.getResource("/vista/generaPJ.fxml"));
		// Cargo la ventana
		Pane ventana = (Pane) loader.load();

		// Cargo el scene
		Scene scene = new Scene(ventana);
		scene.getStylesheets().add("/vista/generaPJ.css");

		// Seteo la scene y la muestro
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
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

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_App.class.getResource("/vista/combate.fxml"));
		// Cargo la ventana
		Pane ventana = (Pane) loader.load();

		// Pasamos la criatura enemiga al controlador
		CombateControlador controller = loader.<CombateControlador>getController();
		controller.setPersonaje(p);
		controller.setCriatura(c);

		// Cargo el scene
		Scene scene = new Scene(ventana);
		scene.getStylesheets().add("/vista/combate.css");

		// Seteo la scene y la muestro
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Stage for Dungeons
	 * 
	 * @throws IOException
	 */

	public static void showMazmorraView(Personaje p) throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_App.class.getResource("/vista/mazmorra.fxml"));
		// Cargo la ventana
		Pane ventana = (Pane) loader.load();

		// Pasamos la criatura enemiga al controlador
		MazmorraControlador controller = loader.<MazmorraControlador>getController();
		controller.setPersonaje(p);

		// Cargo el scene
		Scene scene = new Scene(ventana);
		scene.getStylesheets().add("/vista/mazmorra.css");

		// Seteo la scene y la muestro
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void showCiudadView(Personaje p) throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_App.class.getResource("/vista/vistaCiudad.fxml"));
		// Cargo la ventana
		Pane ventana = (Pane) loader.load();

		// Pasamos la criatura enemiga al controlador
		CiudadControlador controller = loader.<CiudadControlador>getController();
		controller.setPersonaje(p);

		// Cargo el scene
		Scene scene = new Scene(ventana);
		scene.getStylesheets().add("/vista/ciudad.css");

		// Seteo la scene y la muestro
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void musica() {

		AudioClip audio = new AudioClip(getClass().getResource("/media/menu.mp3").toExternalForm());
		audio.setVolume(0.5f);
		audio.setCycleCount(player.INDEFINITE);
		audio.play();
	}

}
