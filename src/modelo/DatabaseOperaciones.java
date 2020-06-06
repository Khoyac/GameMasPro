package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.entidades.personajes.Arquero;
import modelo.entidades.personajes.Asesino;
import modelo.entidades.personajes.Chaman;
import modelo.entidades.personajes.Guerrero;
import modelo.entidades.personajes.Mago;
import modelo.entidades.personajes.Personaje;
import modelo.entidades.personajes.Tanke;
import javafx.scene.control.ButtonType;

public class DatabaseOperaciones {

	private static Connection con;
	private static PreparedStatement pst;
	private static String sql;
	private static String usuario;
	private static Personaje personaje;

	// Iniciamos la conexión con la llamada de esta funcion en Login o Registro
	private static void inicializa() {

		try {

			con = DriverManager.getConnection("jdbc:mysql://khoyac.es/Gamepro?serverTimezone=Europe/Madrid", "testpro",
					"SONlZH9twur57UBW");

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

			if (rs.next()) {
				reg = false;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		if (reg) {

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
			alert.setContentText(
					"El nombre de usuario ya esta en uso.\n\n Por favor, intentalo de nuevo con otro nombre");
			alert.showAndWait();
		}
	}

	// Validamos el Login
	public static boolean doLogin(String user, String pass) {

		inicializa();

		String check = "";

		usuario = user;

		ResultSet rs = null;

		try {

			Statement stm = con.createStatement();
			sql = "SELECT Password FROM usuarios WHERE Username='" + user + "' ";
			rs = stm.executeQuery(sql);

			if (rs.next())
				check = rs.getString("Password");

			return (pass.equals(check)) ? true : false;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	// Guardamos el personaje en la Base de Datos
	public static void guardarPersonaje(ArrayList<Long> stats, Personaje pj) {

		try {

			sql = "INSERT INTO personajes (user, vida, vidaMax, danio, defensa, destreza, inteligencia, exp, expMax, nivel, clase, aspecto) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

			pst = con.prepareStatement(sql);

			pst.setString(1, usuario);

			for (int i = 0; i < stats.size() + 1; i++) {

				if (i >= 1) {

					pst.setLong(i + 2, stats.get(i - 1));
				}

				else {

					pst.setLong(i + 2, stats.get(i));
				}
			}

			String p = pj.getClass().getSimpleName();

			pst.setString(11, p);
			pst.setString(12, pj.getAspecto());
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

			if (rs.next())
				return true;
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	// Recogemos información del personaje del usuario
	public static Personaje getPersonaje() {

		ResultSet rs = null;
		personaje = null;

		try {

			Statement stm = con.createStatement();
			sql = "SELECT * FROM personajes WHERE user LIKE '" + usuario + "'";
			rs = stm.executeQuery(sql);

			// Si el usuario tiene personaje recogemos todos sus stats.
			// Si no tiene personaje devolvemos null
			if (rs.next()) {

				String clase = (rs.getString("clase"));
				String aspecto = (rs.getString("aspecto"));
				int vida = (rs.getInt("vida"));
				int vidaMax = (rs.getInt("vidaMax"));
				int def = (rs.getInt("defensa"));
				int dan = (rs.getInt("danio"));
				int des = (rs.getInt("destreza"));
				int iq = (rs.getInt("inteligencia"));
				long exp = (rs.getInt("exp"));
				String msg = (rs.getString("mensaje"));

				if (clase.equals("Guerrero")) {
					personaje = new Guerrero();
				} else if (clase.equals("Mago")) {
					personaje = new Mago();
				} else if (clase.equals("Asesino")) {
					personaje = new Asesino();
				} else if (clase.equals("Arquero")) {
					personaje = new Arquero();
				} else if (clase.equals("Chaman")) {
					personaje = new Chaman();
				} else if (clase.equals("Tanke")) {
					personaje = new Tanke();
				}

				String[] mensajes = msg.split(" ");
				for (int i = 0; i < mensajes.length; i++) {
					personaje.addMensaje(Integer.parseInt(mensajes[i]));
				}

				personaje.setVida(vida);
				personaje.setVidaMax(vidaMax);
				personaje.setDefensa(def);
				personaje.setDanio(dan);
				personaje.setDestreza(des);
				personaje.setInteligencia(iq);
				personaje.setExp(exp);
				personaje.setAspecto(aspecto);
				personaje.recibirExperiencia(exp);

				

			}

			return personaje;
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public static void borraPersonaje() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Borrar personaje");
		alert.setHeaderText(null);
		alert.setContentText("Estas seguro de querer acabar con esta vida?");
		Optional<ButtonType> res = alert.showAndWait();

		if (res.get() == ButtonType.OK) {

			try {

				Statement stm = con.createStatement();
				sql = "DELETE FROM personajes WHERE user LIKE '" + usuario + "'";
				stm.executeUpdate(sql);
			}

			catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
}
