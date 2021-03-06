/*
 * 
 */
package modelo.entidades.criaturas;

import modelo.entidades.Entidad;
import modelo.entidades.personajes.Personaje;


/**
 * The Class Trol.
 */
public class Trol extends Criatura {


	public Trol() {
		super("Trol");

		this.destreza = this.obtenerRandom(20, 1);
	}

	public Trol(int nivel) {
		this();
		this.nivel = nivel;
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
	public int lanzarHabilidad(Entidad e) {
		
		return 0;
	}

}
