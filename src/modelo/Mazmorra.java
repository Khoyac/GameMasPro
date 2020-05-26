package modelo;

import java.util.ArrayList;

public class Mazmorra {

	String id;
	int nivel;
	int inicio;
	ArrayList<Casilla> casillas;

	public Mazmorra() {
		super();

		casillas = new ArrayList<Casilla>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public Casilla obtenerCasilla(int casilla) {

		return casillas.get(casilla);

	}

	public void anyadirCasilla(Casilla c1) {
		this.casillas.add(c1);
	}

}
