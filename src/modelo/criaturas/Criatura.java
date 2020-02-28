/*
 * 
 */
package modelo.criaturas;

import modelo.Acciones;

// TODO: Auto-generated Javadoc
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

	String nombre;

	public Criatura(String nombre) {
		super();
		this.nombre = nombre;
		this.vida = 10;
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
	
	

}
