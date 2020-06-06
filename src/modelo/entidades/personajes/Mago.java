/*
 * 
 */
package modelo.entidades.personajes;

import java.util.Random;

import modelo.entidades.Dado;
import modelo.entidades.Entidad;

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

		this.setBarrera(this.getBarrera() + randomBarrera);

		return randomBarrera;

	}

	/**
	 * Lanzar habilidad.
	 *
	 * @return the int
	 */
	@Override
	public int lanzarHabilidad(Entidad e) {

		// Borra un indice aleatorio de un dado aleatorio del objetivo

		Dado dado = e.obtenerDadoAleatorio();
		int valorBorrado = dado.borrarIndiceRandom();
		System.out.printf("Has cambiado el dado de %s y le has quitado el valor %d\n", dado.getTipo(), valorBorrado);

		return valorBorrado;

	}

}
