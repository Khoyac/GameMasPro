/*
 * 
 */
package modelo;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.Event;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
public class Login extends Application {

	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	@Override
	public void start(Stage primaryStage) {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Login.class.getResource("/vista/login.fxml"));
			// Cargo la ventana
			Pane ventana = (Pane) loader.load();

			// Cargo el scene
			Scene scene = new Scene(ventana);

			// Seteo la scene y la muestro
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
