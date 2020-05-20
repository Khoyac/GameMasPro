/*
 * 
 */
package modelo.criaturas;

import java.util.Random;

import modelo.personajes.Personaje;

/**
 * The Class Basilisco.
 */
public class Basilisco extends Criatura {
	Random r1 = new Random();

	public Basilisco() {
		super("Basilisco");
		this.defensa += r1.nextInt(10) + 1;
	}

	// El Basilisco no se Defiende, Cuenta con defensa base mejorada

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
