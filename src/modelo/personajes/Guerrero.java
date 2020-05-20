/*
 * 
 */
package modelo.personajes;

import java.util.Random;

import modelo.criaturas.Criatura;

// TODO: Auto-generated Javadoc
/**
 * The Class Guerrero.
 */
public class Guerrero extends Humano {

	// Atributos

	// Constructores

	/**
	 * Instantiates a new guerrero.
	 */
	public Guerrero() {

	}

	/**
	 * Defender.
	 *
	 * @return the int
	 */
	@Override
	public void defender() {

		this.barrera += (this.defensa + this.inteligencia) / this.vida;

	}

	/**
	 * Lanzar habilidad.
	 *
	 * @return the int
	 */
	@Override
	public int lanzarHabilidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Mover.
	 *
	 * @return the int
	 */
	@Override
	public int mover() {
		// TODO Auto-generated method stub
		return 0;
	}

}
