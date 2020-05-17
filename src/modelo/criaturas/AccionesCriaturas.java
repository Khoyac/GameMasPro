/*
 * 
 */
package modelo.criaturas;

import modelo.personajes.Personaje;

/**
 * The Interface AccionesCriaturas.
 */
public interface AccionesCriaturas {

	/**
	 * Mover.
	 *
	 * @return the int
	 */
	public int mover();

	/**
	 * Atacar.
	 *
	 * @return the int
	 */
	public int atacar(Personaje objetivo);

	/**
	 * Defender.
	 *
	 * @return the int
	 */
	public int defender();

	/**
	 * Lanzar hechizo.
	 *
	 * @return the int
	 */
	public int lanzarHabilidad();

}
