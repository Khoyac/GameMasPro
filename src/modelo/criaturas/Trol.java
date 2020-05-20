/*
 * 
 */
package modelo.criaturas;

import java.util.Random;

import modelo.personajes.Personaje;

// TODO: Auto-generated Javadoc
/**
 * The Class Trol.
 */
public class Trol extends Criatura {

	int destreza;

	public Trol() {
		super("Trol");

		this.nombre = nombre;
		this.vida = r1.nextInt(20) + 1;
		this.danio = r1.nextInt(20) + 1;
		this.defensa = r1.nextInt(20) + 1;
		this.destreza = r1.nextInt(20) + 1;
		this.vidaMax = this.vida;

	}

	/**
	 * Defender.
	 *
	 * @return the int
	 */
	public int defender() {
		// TODO Auto-generated method stub
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
