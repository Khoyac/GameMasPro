package modelo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Mapa {

	String tamanyo;
	String id;
	String nombre;
	File file;
	Mazmorra mazmorra;

	public Mapa(String tamanyo, String id) {
		super();
		this.tamanyo = "n=" + tamanyo;
		this.id = "id=" + id;
		this.nombre = this.id.substring(3, this.id.length());

		this.descargar_crear_XML();
		this.leerInformacionXML();
	}

	public void descargar_crear_XML() {

		try {

			URL crearMazmorra = new URL("http://khoyac.es/JuegoMolon/testImagen.php?" + this.tamanyo + "&" + this.id);

			HttpURLConnection con = (HttpURLConnection) crearMazmorra.openConnection();

			try {

				InputStream in = new BufferedInputStream(con.getInputStream());
			} finally {
				con.disconnect();
			}

			// Inciar URL donde se encuentra el fichero a leer
			URL url = new URL("http://khoyac.es/JuegoMolon/xml/" + this.nombre + ".xml");

			// Utilizar el scanner con el fichero especificado en la URL
			Scanner s = new Scanner(url.openStream());

			// Crear fichero local donde guardar la información
			String directorio = "TMP";
			String fichero = "TMP/mazmorra" + this.nombre + ".xml";
			File carpeta = new File(directorio);
			File file = new File(fichero);
			this.file = file;
			carpeta.mkdir();
			PrintWriter pw = new PrintWriter(file);

			String linea;

			// Leer del scanner
			while (s.hasNext()) {

				// Leer linea del fichero de Internet
				linea = s.nextLine();

				// Escribir linea en el fichero Local
				pw.println(linea);
			}

			pw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void leerInformacionXML() {

		try {
			File fXmlFile = new File("TMP/mazmorra" + this.nombre + ".xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			Mazmorra mazmorra = new Mazmorra();

			// Recuperar una lista con los elementos id, nivel, inicio y casillas

			String valorId = doc.getElementsByTagName("id").item(0).getTextContent();
			int valorNivel = Integer.parseInt(doc.getElementsByTagName("nivel").item(0).getTextContent());
			int valorInicio = Integer.parseInt(doc.getElementsByTagName("inicio").item(0).getTextContent());

			mazmorra.setId(valorId);
			mazmorra.setNivel(valorNivel);
			mazmorra.setInicio(valorInicio);

			NodeList listaCasilla = doc.getElementsByTagName("casilla");

			// Recorrer lista de los elementos casillas
			for (int i = 0; i < listaCasilla.getLength(); i++) {

				// Lista de todos los casillas
				Node nodoCasilla = listaCasilla.item(i);
				Element elementoCasilla = (Element) nodoCasilla;

				Casilla c1 = new Casilla();

				int valorNumero = Integer.parseInt(elementoCasilla.getAttribute("numero"));
				boolean valorCofre;
				boolean valorBoss;
				boolean valorMiniBoss;
				boolean valorNorte;
				boolean valorSur;
				boolean valorEste;
				boolean valorOeste;

				valorCofre = (elementoCasilla.getElementsByTagName("cofre").item(0).getTextContent().equals("1")) ? true
						: false;
				valorMiniBoss = (elementoCasilla.getElementsByTagName("poke").item(0).getTextContent().equals("1"))
						? true
						: false;
				valorBoss = (elementoCasilla.getElementsByTagName("boss").item(0).getTextContent().equals("1")) ? true
						: false;
				valorNorte = (elementoCasilla.getElementsByTagName("N").item(0).getTextContent().equals("1")) ? true
						: false;
				valorSur = (elementoCasilla.getElementsByTagName("S").item(0).getTextContent().equals("1")) ? true
						: false;
				valorEste = (elementoCasilla.getElementsByTagName("E").item(0).getTextContent().equals("1")) ? true
						: false;
				valorOeste = (elementoCasilla.getElementsByTagName("O").item(0).getTextContent().equals("1")) ? true
						: false;

				c1.setNumero(valorNumero);
				c1.setBoss(valorBoss);
				c1.setCofre(valorCofre);
				c1.setMiniBoss(valorMiniBoss);
				c1.setN(valorNorte);
				c1.setS(valorSur);
				c1.setE(valorEste);
				c1.setO(valorOeste);
				mazmorra.anyadirCasilla(c1);

			}

			this.mazmorra = mazmorra;

			// Borra el fichero al terminar de leerlo
//			this.file.delete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getIdMazmorra() {
		return this.mazmorra.getId();
	}

	public int getNivelMazmorra() {
		return this.mazmorra.getNivel();
	}

	public int getInicioMazmorra() {
		return this.mazmorra.getInicio();
	}

	public boolean getCofre(int casilla) {

		return this.mazmorra.getCasilla(casilla).isCofre();

	}

	public boolean getBoss(int casilla) {

		return this.mazmorra.getCasilla(casilla).isBoss();

	}

	public boolean getMiniBoss(int casilla) {

		return this.mazmorra.getCasilla(casilla).isMiniBoss();

	}

	public Mazmorra getMazmorra() {

		return this.mazmorra;
	}

	public void borrarMapa() {

		this.file.delete();
	}

}
