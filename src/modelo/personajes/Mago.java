/*
 * 
 */
package modelo.personajes;

import java.util.Random;

import modelo.criaturas.Criatura;

// TODO: Auto-generated Javadoc
/**
 * The Class Mago.
 */
public class Mago extends Humano {

	// Atributos

	// Constructores

	/**
	 * Instantiates a new mago.
	 */
	public Mago() {

		// genero stadisticas aleatorias * max min
		this.vida = (int) (Math.random() * 14 + 1);
		this.danio = (int) (Math.random() * 13 + 2);
		this.defensa = (int) (Math.random() * 15);
		this.habilidad = (int) (Math.random() * 10 + 5);
		this.destreza = (int) (Math.random() * 11 + 4);
		this.inteligencia = (int) (Math.random() * 7 + 8);
		this.vidaMax = this.vida;

	}

	/**
	 * Mover.
	 *
	 * @return the int
	 */
	@Override
	public int mover() {
		return 0;
	}

	/**
	 * Atacar.
	 *
	 * @return the int
	 */
	@Override
	public int atacar(Criatura objetivo) {

		//TODO Añadir daño de arma y/o equipamiento mas adelante
		
		int dmg;
		Random r1 = new Random();
		int random = r1.nextInt(4) + 1;		
		
		dmg = (this.danio / random) * this.inteligencia;
		if (random == 1) {
			System.out.println("El golpe ha sido Critico!");
		}
		
		objetivo.setVida(objetivo.getVida() - dmg);
		System.out.println(objetivo.getVida());
		return dmg;
	}

	/**
	 * Defender.
	 *
	 * @return the int
	 */
	@Override
	public int defender() {
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

}
