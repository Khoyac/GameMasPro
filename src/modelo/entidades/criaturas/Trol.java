/*
 * 
 */
package modelo.entidades.criaturas;

import modelo.entidades.personajes.Personaje;

// TODO: Auto-generated Javadoc
/**
 * The Class Trol.
 */
public class Trol extends Criatura {

	int destreza;

	public Trol() {
		super("Trol");

		this.destreza = this.obtenerRandom(20, 1);
	}

	@Override
	public String toString() {
		return super.toString() + String.format("Destreza - %d\n", this.destreza);

	}

	/**
	 * Defender.
	 *
	 * @return the int
	 */
	public void defender(Personaje objetivo) {
		// Lanza baba de trol para defenderse, modifica el dado de ataque del enemigo y
		// le pone un maximo de 15 valores.

		objetivo.anyadirEstadoDefensa("Pringoso");

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

	@Override
	public int mover() {
		// TODO Auto-generated method stub
		return 0;
	}

}
