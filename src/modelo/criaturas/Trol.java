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

		this.vida = 30;
		this.vidaMax = this.vida;
		this.danio = 7;
		this.defensa = 7;
		this.nivel = 1;
		this.destreza = 8;
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

	@Override
	public int atacar(Personaje objetivo) {

		// TODO Añadir daño de arma y/o equipamiento mas adelante
		int dmgInflingido;
		int dmg;
		Random r1 = new Random();
		int random = r1.nextInt(4) + 1;
		int barreraObjetivo = objetivo.getBarrera();

		dmg = (this.danio + this.destreza) / random;
		dmgInflingido = dmg;
		// Si el objetivo tiene barrera, el daño le afecta primero a esta

		if (barreraObjetivo >= 1) {

			dmg -= barreraObjetivo;

			// Si el daño se queda en negativo despues de golpear
			// El daño pasa a ser la barrera restante y asestara un golpe de 0
			if (dmg <= 0) {

				objetivo.setBarrera((int) dmg * -1);
				dmg = 0;
			}
		}

		// Si el objetivo no tiene barrera, golpea
		if (barreraObjetivo == 0) {

			objetivo.setVida(objetivo.getVida() - (int) dmg);

		}

		return dmgInflingido;
	}

}
