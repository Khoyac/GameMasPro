/*
 * 
 */
package modelo.entidades.personajes;

import java.util.Random;

import modelo.entidades.criaturas.Criatura;

/**
 * The Class Mago.
 */
public class Mago extends Humano {

	// Atributos

	// Constructores

	/**
	 * Instantiates a new mago.
	 */
	public Mago() {

	}

	/*
	 * 
	 * /** Defender.
	 *
	 * @return the int
	 */
	@Override
	public int defender() {

		// Obtiene la barrera del valor de un indice de la primera mitad de la longitug
		// del array

		Random r1 = new Random();
		int randomBarrera = this.obtenerValorDadoDefensa(r1.nextInt(this.obtenerLongitudDadoDefensa() / 2));

		this.barrera += randomBarrera;

		return randomBarrera;

	}

	/**
	 * Lanzar habilidad.
	 *
	 * @return the int
	 */
	@Override
	public int lanzarHabilidad() {
		return 0;
	}

	/**
	 * Mover.
	 *
	 * @return the int
	 */
	@Override
	public int mover() {
		return 0;
	}

}
