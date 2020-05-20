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
	public int defender() {

		Random r1 = new Random();
		int randomDefensa = r1.nextInt(20) + 1;

		this.defensa += randomDefensa;

		System.out.printf("Tu defensa ha aumentado en %d puntos\n", randomDefensa);
		System.out.printf("Tu defensa %d\n", this.getDefensa());
		return randomDefensa;

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
