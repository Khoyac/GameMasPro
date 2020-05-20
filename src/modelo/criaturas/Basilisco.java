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

	public Basilisco() {
		super("Basilisco");
		this.vida = 35;
		this.vidaMax = this.vida;
		this.danio = 5;
		this.defensa = 10;
		this.nivel = 1;
	}

	@Override
	public int atacar(Personaje objetivo) {

		// TODO Añadir daño de arma y/o equipamiento mas adelante
		int dmgInflingido;
		int dmg;
		Random r1 = new Random();
		int random = r1.nextInt(4) + 1;
		int barreraObjetivo = objetivo.getBarrera();

		dmg = (this.danio + this.defensa) / random;
		dmgInflingido = dmg;
		// Si el objetivo tiene barrera, el daño le afecta primero a esta

		if (barreraObjetivo >= 1) {

			dmg -= barreraObjetivo;

			// Si el daño se queda en negativo despues de golpear
			// El daño pasa a ser la barrera restante y asestara un golpe de 0
			if (dmg <= 0) {

				objetivo.setBarrera(dmg * -1);
				dmg = 0;
			} else {
				objetivo.setBarrera(0);
				barreraObjetivo = objetivo.getBarrera();
			}
		}

		// Si el objetivo no tiene barrera, golpea
		if (barreraObjetivo == 0) {

			objetivo.setVida(objetivo.getVida() - (int) dmg);

		}

		return dmgInflingido;
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
