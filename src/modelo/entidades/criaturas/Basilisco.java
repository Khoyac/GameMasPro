/*
 * 
 */
package modelo.entidades.criaturas;

import java.util.Random;

import modelo.entidades.personajes.Personaje;

/**
 * The Class Basilisco.
 */
public class Basilisco extends Criatura {
	Random r1 = new Random();

	public Basilisco() {
		super("Basilisco");
		this.setDefensa(this.getDefensa() + r1.nextInt(5) + 1);
	}

	// El Basilisco no se Defiende, Cuenta con defensa base mejorada

	@Override
	public int lanzarHabilidad() {
		// TODO Auto-generated method stub
		return 0;
	}

}
