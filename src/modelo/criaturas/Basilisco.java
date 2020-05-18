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

		this.danio = 2;

	}

	@Override
	public int mover() {
		// TODO Auto-generated method stub
		return 0;
	}
//
//	@Override
//	public int atacar(Personaje objetivo) {
//
//		int dmg;
//		Random r1 = new Random();
//		int random = r1.nextInt(4) + 1;
//
//		dmg = (this.danio / random);
//		if (random == 1) {
//			System.out.println("El golpe ha sido Critico!");
//		}
//
//		objetivo.setVida(objetivo.getVida() - dmg);
//		return dmg;
//
//	}

	@Override
	public double atacar(Personaje objetivo) {

		// TODO Añadir daño de arma y/o equipamiento mas adelante
		double dmgInflingido;
		double dmg;
		Random r1 = new Random();
		int random = r1.nextInt(4) + 1;
		int barreraObjetivo = objetivo.getBarrera();

		dmg = (this.danio / random);
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

	@Override
	public int defender() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lanzarHabilidad() {
		// TODO Auto-generated method stub
		return 0;
	}

}
