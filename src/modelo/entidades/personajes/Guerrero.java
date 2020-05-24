/*
 * 
 */
package modelo.entidades.personajes;

import java.io.IOException;
import java.util.Random;

import modelo.entidades.criaturas.Criatura;

// TODO: Auto-generated Javadoc
/**
 * The Class Guerrero.
 */
public class Guerrero extends Humano {

	// Atributos

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

		// TODO aplicar dado
		Random r1 = new Random();
		int randomDefensa = r1.nextInt(20) + 1;

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
	@Override
	public int lanzarHabilidad() {

		// Aumenta en 1 el minimo del dado de Defensa
		this.imprimirDadoDefensa();
		this.cambiarMinimoDadoDefensa(1);
		this.imprimirDadoDefensa();
		return 0;
	}

	/**
	 * Mover.
	 *
	 * @return the int
	 */
	@Override
	public int mover() {
		// TODO Auto-generated method stub
		return 0;
	}

}
