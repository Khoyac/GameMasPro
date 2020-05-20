/*
 * 
 */
package modelo.personajes;

import java.util.Random;

import modelo.criaturas.Criatura;

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

		Random r1 = new Random();
		int random = r1.nextInt(6) + 1;

		this.barrera += this.inteligencia + random;
		System.out.printf("Has conseguido %d de barrera\n", this.inteligencia + random);
		return this.inteligencia + random;
	}

	/**
	 * Lanzar habilidad.
	 *
	 * @return the int
	 */
	@Override
	public int lanzarHabilidad() {
		int dmg = 0;

		// Descarga de Pirofrio

//			dmg = this.inteligencia

		System.out.println("Puntos insuficientes, pierdes el turno al distraerte");

		return dmg;
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
