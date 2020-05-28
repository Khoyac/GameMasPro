package modelo;

import java.util.ArrayList;

public class Mazmorra {

	String id;
	int nivel;
	int inicio;
	ArrayList<Casilla> listaCasillas;

	public Mazmorra() {
		super();

		listaCasillas = new ArrayList<Casilla>();
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

	public ArrayList<Casilla> getListaCasillas() {

		return this.listaCasillas;
	}

	public Casilla getCasilla(int casilla) {

		return listaCasillas.get(casilla);
	}

	public void anyadirCasilla(Casilla c1) {
		this.listaCasillas.add(c1);
	}

}
