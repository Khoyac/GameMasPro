/*
 * 
 */
package modelo.entidades.criaturas;

import modelo.entidades.personajes.Personaje;

// TODO: Auto-generated Javadoc
/**
 * The Class Sucubo.
 */
public class Sucubo extends Criatura {

	int inteligencia;

	public Sucubo() {
		super("Sucubo");

	}

	public void defender(Personaje objetivo) {

		// Charm, Seduce por 1 turno, y evita el daño recibido de el personaje seducido

		objetivo.anyadirEstado("Seducido");

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
