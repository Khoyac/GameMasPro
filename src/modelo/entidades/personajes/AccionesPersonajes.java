/*
 * 
 */
package modelo.entidades.personajes;

import java.io.IOException;

import modelo.entidades.criaturas.Criatura;


/**
 * The Interface AccionesPersonajes.
 */
public interface AccionesPersonajes {

	/**
	 * Atacar.
	 *
	 * @return the int
	 */
	public int atacar(Criatura objetivo);

	public void combatir(Personaje p, Criatura c) throws IOException;

}
