/*
 * 
 */
package modelo;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
public class Main_App extends Application {


	private static Stage primaryStage;

	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception{

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

	public static void showLoginView() throws IOException{

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

	public static void showCharactersView() throws IOException{

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_App.class.getResource("/vista/generaPJ.fxml"));
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

	public static void showCombateView() throws IOException{

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_App.class.getResource("/vista/combate.fxml"));
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


}
