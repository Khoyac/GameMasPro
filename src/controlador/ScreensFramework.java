package controlador;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreensFramework extends Application {

	public static String screen1ID = "mazmorra";
	public static String screen1File = "/vista/mazmorra.fxml";
	public static String screen2ID = "combate";
	public static String screen2File = "/vista/combate.fxml";
	public static String screen3ID = "screen1";
	public static String screen3File = "/vista/Screen1.fxml";

	@Override
	public void start(Stage primaryStage) {

		ScreensController mainContainer = new ScreensController();
//		mainContainer.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screen1File);
//		mainContainer.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);
		mainContainer.loadScreen(ScreensFramework.screen3ID, ScreensFramework.screen3File);

		mainContainer.setScreen(ScreensFramework.screen3ID);

		Group root = new Group();
		root.getChildren().addAll(mainContainer);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * The main() method is ignored in correctly deployed JavaFX application. main()
	 * serves only as fallback in case the application can not be launched through
	 * deployment artifacts, e.g., in IDEs with limited FX support. NetBeans ignores
	 * main().
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
