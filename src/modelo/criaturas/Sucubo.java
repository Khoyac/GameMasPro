/*
 * 
 */
package modelo.criaturas;

import modelo.personajes.Personaje;

// TODO: Auto-generated Javadoc
/**
 * The Class Sucubo.
 */
public class Sucubo extends Criatura {

	int inteligencia;

	public Sucubo() {
		super("Sucubo");

	}

	public int defender(Personaje pj1) {

		// Charm, Seduce por 1 turno, y evita el daño recibido de el personaje seducido

		pj1.setSeducido(true);

		return 0;
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
