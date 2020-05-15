package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import modelo.personajes.Personaje;

public class DatabaseOperaciones {

	private static Connection con;
	private static PreparedStatement pst;
	private static String sql;
	private static String usuario;

	// Iniciamos la conexión con la llamada de esta funcion en Login o Registro
	private static void inicializa() {

		try {

			con = DriverManager.getConnection("jdbc:mysql://khoyac.es/Gamepro", "testpro", "SONlZH9twur57UBW");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	// Registro de Usuarios
	public static void register(String user, String pass, String email) {

		inicializa();

		boolean reg = true;

		try {

			Statement stm = con.createStatement();
			sql = "SELECT Username FROM usuarios WHERE Username LIKE '" + user + "' ";
			ResultSet rs = stm.executeQuery(sql);

			if(rs.next()) { reg = false; }

		} catch (Exception e) {

			e.printStackTrace();
		}

		if(reg) {
			
			sql = "INSERT INTO usuarios (Username, Password, email) VALUES (?, ?, ?) ";

			try {

				pst = con.prepareStatement(sql);
				pst.setString(1, user);
				pst.setString(2, pass);
				pst.setString(3, email);
				pst.executeUpdate();

			} catch (Exception e) {

				e.printStackTrace();
			}
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Registro de usuario");
			alert.setHeaderText(null);
			alert.setContentText("Se ha registrado correctamente!");
			alert.showAndWait();
		}
		
		else {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error al registrarse");
			alert.setHeaderText(null);
			alert.setContentText("El nombre de usuario ya esta en uso.\n\n Por favor, intentalo de nuevo con otro nombre");
			alert.showAndWait();
		}
	}


	// Validamos el Login
	public static boolean doLogin(String user, String pass) {

		inicializa();

		usuario = user;

		ResultSet rs = null;

		try {

			Statement stm = con.createStatement();
			sql = "SELECT * FROM usuarios WHERE Username='" + user + "' and Password='" + pass + "'";
			rs = stm.executeQuery(sql);

			if(rs.next()) return true;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}


	// Guardamos el personaje en la Base de Datos
	public static void guardarPersonaje(ArrayList<Integer> stats, Personaje pj) {

		try {

			sql = "INSERT INTO personajes (user, vida, danio, defensa, habilidad, destreza, inteligencia, nivel, clase) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

			pst = con.prepareStatement(sql);

			pst.setString(1, usuario);

			for (int i = 0; i < stats.size(); i++) {

				pst.setInt(i + 2, stats.get(i));
			}

			String p =  pj.getClass().toString();

			pst.setString(9, p.substring(24, p.length()));
			pst.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	
	// Comprobamos si el usuario actual tiene personajes
	public static boolean compruebaPersonajes() {

		ResultSet rs = null;

		try {

			Statement stm = con.createStatement();
			sql = "SELECT user FROM personajes WHERE user LIKE '" + usuario + "'";
			rs = stm.executeQuery(sql);

			if(rs.next()) return true;
		}

		catch(Exception e) {

			e.printStackTrace();
		}

		return false;
	}


	//Recogemos información del personaje del usuario
	public static String getPersonaje() {

		ResultSet rs = null;

		try {

			Statement stm = con.createStatement();
			sql = "SELECT clase FROM personajes WHERE user LIKE '" + usuario + "'";
			rs = stm.executeQuery(sql);

			if(rs.next()) {
				return (rs.getString("clase"));
			}
		}

		catch(Exception e) {

			e.printStackTrace();
		}

		return "";
	}



	public static void borraPersonaje() {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Borrar personaje");
		alert.setHeaderText(null);
		alert.setContentText("Estas seguro de querer acabar con esta vida?");
		Optional<ButtonType> res = alert.showAndWait();
		
		if(res.get() == ButtonType.OK) { 
			
			try {

				Statement stm = con.createStatement();
				sql = "DELETE FROM personajes WHERE user LIKE '" + usuario + "'";
				stm.executeUpdate(sql);
			}

			catch(Exception e) {

				e.printStackTrace();
			} 
		}
	}
}
