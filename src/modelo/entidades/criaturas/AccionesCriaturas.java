/*
 * 
 */
package modelo.entidades.criaturas;

import modelo.entidades.personajes.Personaje;

/**
 * The Interface AccionesCriaturas.
 */
public interface AccionesCriaturas {

	/**
	 * Atacar.
	 *
	 * @return the int
	 * @throws InterruptedException
	 */
	public int atacar(Personaje objetivo) throws InterruptedException;

}
