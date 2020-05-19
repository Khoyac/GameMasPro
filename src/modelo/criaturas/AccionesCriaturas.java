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
	 * Lanzar hechizo.
	 *
	 * @return the int
	 */
	public int lanzarHabilidad();

}
