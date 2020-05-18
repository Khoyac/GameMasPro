package controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.DatabaseOperaciones;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginControlador.
 */
public class LoginControlador {

	/** The username input. */
	@FXML private TextField usernameInput;

	/** The pass input. */
	@FXML private PasswordField passInput;

	/** The login. */
	@FXML private Button login;

	/** Register Pane. */
	@FXML private VBox form;

	/** The register window. */
	@FXML private Button showForm;


	@FXML private TextField emailRegister;


	@FXML private TextField userRegister;


	@FXML private PasswordField passRegister;


	@FXML private CheckBox conditions;


	@FXML private Label warningTerms;

	/** The register button. */
	@FXML private Button register;

	private boolean registerInfo;


	/**
	 * Do register.
	 *
	 * @param event the event
	 */
	@FXML
	void showRegister(ActionEvent event) {

		if(this.form.isVisible()) { this.form.setVisible(false); }

		else this.form.setVisible(true);
	}

	/**
	 * Do register.
	 *
	 * @param event the event
	 */
	@FXML
	void doRegister(ActionEvent event) {

		String email = emailRegister.getText();
		String usuario = userRegister.getText();
		String contrasenia = passRegister.getText();

		this.registerInfo = false;

		// Comprobamos que los datos son válidos
		if( !userRegister.getText().equals("") && validatePassword( passRegister.getText() ) && validateEmail(email) ) {

			this.registerInfo = true;
		}

		// Si son validos procedemos al registro
		if( this.registerInfo && this.conditions.isSelected()) {

			this.warningTerms.setVisible(false);

			DatabaseOperaciones.register(usuario, contrasenia, email);
		}

		// Si no son validos
		else {

			if(!this.conditions.isSelected()) {

				this.warningTerms.setVisible(true);
			}


		}
	}

	/**
	 * Do login.
	 *
	 * @param event the event
	 */
	@FXML
	void doLogin(ActionEvent event) {

		String user = usernameInput.getText(); 
		String pass = passInput.getText().toString();

		if ( DatabaseOperaciones.doLogin(user, pass) ) {

			try {

				Parent loader = FXMLLoader.load(getClass().getResource("/vista/generaPJ.fxml"));
				Scene scene = new Scene(loader);

				Stage stage = (Stage) ( (Node) event.getSource()).getScene().getWindow();
				scene.getStylesheets().add("/vista/main.css");
				stage.setScene(scene);
				stage.show();

			} catch (Exception e){

				e.printStackTrace();
			}
		}
		
		else {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Login erróneo");
			alert.setHeaderText(null);
			alert.setContentText("Comprueba tu usuario o contraseña!");
			alert.showAndWait();
			
		}
	}


	// Método para validar el formato de correo electronico

	public boolean validateEmail(String email) {

		Pattern p = Pattern.compile("[a-zA-Z0-9]+[a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+");
		Matcher m = p.matcher(email);

		if(m.find() && m.group().equals(email)) {

			return true;
		}

		else {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Validación de email");
			alert.setHeaderText(null);
			alert.setContentText("Por favor, revisa tu email");
			alert.showAndWait();

			return false;
		}

	}


	// Método para validar el formato de contraseña

	public boolean validatePassword(String pass) {

		Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
		Matcher m = p.matcher(pass);

		if(m.find() && m.group().equals(pass)) {

			return true;
		}
		else {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Validación de contraseña");
			alert.setHeaderText(null);
			alert.setContentText("La contraseña debe cumplir los requisitos:"
					+ "\nLetras Mayúsculas y Minúsculas."
					+ "\nAl menos un Número y un Símbolo."
					+ "\n8 o más caracteres (sin espacios).");
			alert.showAndWait();

			return false;
		}

	}


}
