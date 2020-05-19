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

	int vidaMax;

	String nombre;

	int nivel;

	public Criatura(String nombre) {
		super();
		this.nombre = nombre;

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

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

}
