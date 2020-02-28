/*
 * 
 */
package modelo.personajes;

import modelo.criaturas.Criatura;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccionesPersonajes.
 */
public interface AccionesPersonajes {

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
	public int atacar(Criatura objetivo);

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

	public boolean combatir(Criatura c);

}
