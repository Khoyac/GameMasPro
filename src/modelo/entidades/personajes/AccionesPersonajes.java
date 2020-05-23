/*
 * 
 */
package modelo.entidades.personajes;

import java.io.IOException;

import modelo.entidades.criaturas.Criatura;

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

	public void combatir(Criatura c) throws IOException;
	public void combatir(Personaje p, Criatura c) throws IOException;

}
