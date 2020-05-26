/*
 * 
 */
package modelo.entidades.criaturas;

import java.util.Random;

import modelo.entidades.personajes.Personaje;

// TODO: Auto-generated Javadoc
/**
 * The Class Sucubo.
 */
public class Sucubo extends Criatura {

	int inteligencia;

	public Sucubo() {
		super("Sucubo");

		this.inteligencia = this.obtenerRandom(20, 1);

	}

	@Override
	public String toString() {
		return super.toString() + String.format("Inteligencia - %d\n", this.inteligencia);

	}

	public void defender(Personaje objetivo) {

		// Charm, Seduce por 1 turno, y evita el daño recibido del personaje seducido
		objetivo.anyadirEstadoAtaque("Seducido");
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

}
