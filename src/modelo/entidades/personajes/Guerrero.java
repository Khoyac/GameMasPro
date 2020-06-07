/*
 * 
 */
package modelo.entidades.personajes;

import java.util.Random;

import modelo.entidades.Entidad;


/**
 * The Class Guerrero.
 */
public class Guerrero extends Humano {

	// Atributos
	int defensaExtra;

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
		int randomDefensa = this.obtenerValorDadoDefensa(r1.nextInt(this.obtenerLongitudDadoDefensa() / 2));

		this.setDefensa(this.getDefensa() + randomDefensa);

		System.out.printf("Tu defensa ha aumentado en %d puntos\n", randomDefensa);
		System.out.printf("Tu defensa %d\n", this.getDefensa());
		return randomDefensa;

	}

	/**
	 * Lanzar habilidad.
	 *
	 * @return the int
	 */

	public int lanzarHabilidad(Entidad e) {

		// Aumenta en 1 el minimo del dado de Defensa durante el combate
		e.cambiarMinimoDadoDefensa(1);
		return this.obtenerValorMinimoDefensa();
	}

	public int getDefensaExtra() {
		return defensaExtra;
	}

	public void setDefensaExtra(int defensaExtra) {
		this.defensaExtra = defensaExtra;
	}

}
