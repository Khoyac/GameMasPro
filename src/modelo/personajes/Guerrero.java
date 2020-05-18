/*
 * 
 */
package modelo.personajes;

import java.util.Random;

import modelo.criaturas.Criatura;

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

		// genero stadisticas aleatorias * max min
		this.vida = (int) (Math.random() * 11 + 4);
		this.danio = (int) (Math.random() * 10 + 5);
		this.defensa = (int) (Math.random() * 7 + 8);
		this.habilidad = (int) (Math.random() * 15);
		this.destreza = (int) (Math.random() * 14 + 1);
		this.inteligencia = (int) (Math.random() * 15);
	}

	/**
	 * Atacar.
	 *
	 * @return the int
	 */
	@Override
	public int atacar(Criatura objetivo) {

		// TODO Añadir daño de arma y/o equipamiento mas adelante

		int dmg;
		Random r1 = new Random();
		int random = r1.nextInt(4) + 1;

		dmg = (this.inteligencia / random) * this.danio;
		if (random == 1) {
			System.out.println("El golpe ha sido Critico!");
		}
		return dmg;
	}

	/**
	 * Defender.
	 *
	 * @return the int
	 */
	@Override
	public void defender() {

		this.barrera += (this.defensa + this.inteligencia) / this.vida;

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
