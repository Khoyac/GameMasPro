/*
 * 
 */
package modelo.criaturas;

import modelo.Acciones;

/**
 * The Class Criatura.
 */
public abstract class Criatura implements Acciones, AccionesCriaturas {

	/** The vida. */
	int vida;

	/** The danio. */
	int danio;

	/** The defensa. */
	int defensa;

	/** The habilidad. */
	int habilidad;

	/** The destreza. */
	int destreza;

	/** The inteligencia. */
	int inteligencia;

	int vidaMax;
	String nombre;

	public Criatura(String nombre) {
		super();
		this.nombre = nombre;
		this.vida = 1000;
		this.vidaMax = this.vida;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getVida() {
		return this.vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVidaMax() {
		return vidaMax;
	}

}
