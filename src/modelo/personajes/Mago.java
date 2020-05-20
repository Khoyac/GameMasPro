/*
 * 
 */
package modelo.personajes;

import java.util.Random;

import modelo.criaturas.Criatura;

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
		this.barrera = 0;

	}

	@Override
	public int atacar(Criatura objetivo) {

		// TODO Añadir daño de arma y/o equipamiento mas adelante

		int dmg;
		Random r1 = new Random();
		// Random entre 0 y 20, + 1
		int random = r1.nextInt(21) + 1;

		dmg = this.inteligencia + random - objetivo.getDefensa();

		objetivo.setVida(objetivo.getVida() - dmg);

		return dmg;
	}

	/*
	 * 
	 * /** Defender.
	 *
	 * @return the int
	 */
	@Override
	public void defender() {

		Random r1 = new Random();
		int random = r1.nextInt(4) + 1;

		this.barrera += (this.inteligencia / this.vida) + this.nivel;
		System.out.printf("Has conseguido %d de barrera\n", this.getBarrera());

	}

	/**
	 * Lanzar habilidad.
	 *
	 * @return the int
	 */
	@Override
	public int lanzarHabilidad() {
		int dmg = 0;

		// Descarga de Pirofrio
		// Solo se podra usar al tener suficientes puntos de critico

		// TODO Quitar condicion mas adelante cuando el boton se pueda activar o
		// desactivar
		// segun los puntos

		if (this.puntosCritico >= 3) {

//			dmg = this.inteligencia

		} else {
			System.out.println("Puntos insuficientes, pierdes el turno al distraerte");
		}

		return dmg;
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

}
