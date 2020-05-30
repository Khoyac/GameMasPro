package modelo.escenarios;

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

	public int getCasillaNumeroActual(int numeroBuscado) {

		int casillaBuscada = 0;

		for (int i = 0; i < this.listaCasillas.size(); i++) {

			if (this.listaCasillas.get(i).getNumero() == numeroBuscado) {

				casillaBuscada = i;

			}

		}

		return casillaBuscada;
	}

}
