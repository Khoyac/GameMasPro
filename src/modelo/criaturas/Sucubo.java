/*
 * 
 */
package modelo.criaturas;

import java.util.Random;

import modelo.personajes.Personaje;

// TODO: Auto-generated Javadoc
/**
 * The Class Sucubo.
 */
public class Sucubo extends Criatura {

	int inteligencia;

	public Sucubo() {
		super("Sucubo");

		this.nombre = nombre;
		this.vida = r1.nextInt(20) + 1;
		this.danio = r1.nextInt(20) + 1;
		this.defensa = r1.nextInt(20) + 1;
		this.inteligencia = r1.nextInt(20) + 1;
		this.vidaMax = this.vida;

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
