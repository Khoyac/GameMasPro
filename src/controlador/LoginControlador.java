package controlador;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import modelo.DatabaseOperaciones;
import modelo.Main_App;
import utilidades.I18N;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginControlador.
 */
public class LoginControlador {

	@FXML private TextField usernameInput;
	@FXML private PasswordField passInput;
	@FXML private Button login;
	@FXML private Button signup;
	@FXML private VBox form;
	@FXML private Button showForm;
	@FXML private TextField emailRegister;
	@FXML private TextField userRegister;
	@FXML private PasswordField passRegister;
	@FXML private CheckBox conditions;
	@FXML private Label lbl_bienvenida;
	@FXML private Label lbl_textoInicio;
	@FXML private Label lbl_user;
	@FXML private Label lbl_pass;
	@FXML private Label lbl_email;
	@FXML private Label lbl_username;
	@FXML private Label lbl_password;
	@FXML private Label lbl_termsText;
	@FXML private Label signUpTitle;
	@FXML private Label warningTerms;
	@FXML private Button btn_castellano;
	@FXML private Button btn_ingles;

	private boolean registerInfo;

	
	
	@FXML
	void initialize() {
		
    	lbl_bienvenida.textProperty().bind(I18N.createStringBinding("label.bienvenida"));
    	lbl_textoInicio.textProperty().bind(I18N.createStringBinding("label.textoInicio"));
    	lbl_user.textProperty().bind(I18N.createStringBinding("label.user"));
    	lbl_pass.textProperty().bind(I18N.createStringBinding("label.pass"));
    	btn_castellano.textProperty().bind(I18N.createStringBinding("btn.languaje1"));
    	btn_ingles.textProperty().bind(I18N.createStringBinding("btn.languaje2"));
    	showForm.textProperty().bind(I18N.createStringBinding("btn.signup"));
    	login.textProperty().bind(I18N.createStringBinding("btn.login"));
    	signUpTitle.textProperty().bind(I18N.createStringBinding("label.signUpTitle"));
    	lbl_email.textProperty().bind(I18N.createStringBinding("label.email"));
    	lbl_username.textProperty().bind(I18N.createStringBinding("label.username"));
    	lbl_password.textProperty().bind(I18N.createStringBinding("label.password"));
    	lbl_termsText.textProperty().bind(I18N.createStringBinding("label.termsText"));;
    	conditions.textProperty().bind(I18N.createStringBinding("chk.termsConditions"));
    	signup.textProperty().bind(I18N.createStringBinding("btn.completeSignUp"));
		
		
	}
	

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

		Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
		Matcher m = p.matcher(pass);

		if(m.find() && m.group().equals(pass)) {

			return true;
		}
		else {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Validación de contraseña");
			alert.setHeaderText(null);
			alert.setContentText("La contraseña debe cumplir los requisitos:"
					+ "\n - Letras Mayúsculas y Minúsculas."
					+ "\n - Al menos un Número."
					+ "\n - 8 o más caracteres (sin espacios).");
			alert.showAndWait();

			return false;
		}

	}
	
	/**
	 * Do login.
	 *
	 * @param event the event
	 */
	@FXML
	void goLogin(KeyEvent event) {				
		
		if (event.getCode() == KeyCode.ENTER){

			this.login.fire();
		}   		
	}
	
	
	
	@FXML
	void doLogin(ActionEvent event) throws IOException{

		
		String user = usernameInput.getText(); 
		String pass = passInput.getText().toString();

		if ( DatabaseOperaciones.doLogin(user, pass) ) {

			Main_App.showCharactersView();
		}
		
		else {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Login erróneo");
			alert.setHeaderText(null);
			alert.setContentText("Comprueba tu usuario o contraseña!");
			alert.showAndWait();
			
		}
	}
	
	@FXML
	void setCastellano(ActionEvent e) {
		
		Main_App.setCastellano();
	}
	
	@FXML
	void setIngles(ActionEvent e) {
		
		Main_App.setIngles();
	}


}
