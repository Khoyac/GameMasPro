package controlador;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginControlador {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField usernameInput;

	@FXML
	private Button login;

	@FXML
	private TextField passInput;

	@FXML
	private Button register;

	@FXML
	void doRegister(ActionEvent event) {

	}

	@FXML
	void doLogin(ActionEvent event) {

		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://www.khoyac.es/Gamepro", "testpro", "1234");
			Statement stm = con.createStatement();
			String sql = "SELECT * FROM Usuarios WHERE Username='" + usernameInput.getText() + "' and Password='" + passInput.getText().toString() + "'";
			ResultSet rs = stm.executeQuery(sql);
			
			if (rs.next()) {
				
				try {

					Parent loader = FXMLLoader.load(getClass().getResource("/vista/generaPJ.fxml"));
					Scene scene = new Scene(loader);
					Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow();

					stage.setScene(scene);
					stage.show();

				} catch (Exception e){

					e.printStackTrace();
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		
	}

	@FXML
	void initialize() {
		assert usernameInput != null : "fx:id=\"usernameInput\" was not injected: check your FXML file 'login.fxml'.";
		assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'login.fxml'.";
		assert passInput != null : "fx:id=\"passInput\" was not injected: check your FXML file 'login.fxml'.";
		assert register != null : "fx:id=\"register\" was not injected: check your FXML file 'login.fxml'.";

	}
}
