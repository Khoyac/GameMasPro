/*
 * 
 */
package modelo.entidades.criaturas;

import java.util.Random;

import modelo.entidades.Entidad;

/**
 * The Class Basilisco.
 */
public class Golem extends Criatura {
	Random r1 = new Random();

	public Golem() {
		super("Golem");
		this.setDefensa(this.getDefensa() + r1.nextInt(5) + 1);
	}
	
	public Golem(int nivel) {
		this();
		this.nivel = nivel;
	}

	// El Basilisco no se Defiende, Cuenta con defensa base mejorada

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
